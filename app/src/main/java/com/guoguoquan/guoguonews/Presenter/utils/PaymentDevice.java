package com.guoguoquan.guoguonews.Presenter.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.List;

public class PaymentDevice
{
	private static String	error		= "error";
	private String			channelId	= "";
	
	private static String packageName = null;

	/**
	 * 获取设备相关信息：IP、网络类型、支付金额、提交时间、应用名、包名、版本、IMEI、MAC、
	 * 系统版本、运营商、手机型号、应用列表、支付运营商、SDK版本、支付状态、状态码
	 * 
	 * @author swm
	 * @date 2012-11-26 下午1:51:55
	 */
	public static String getMMYDeviceInfo(Context context, String orderId, String payType, String productName, String productPrice,
			String productDesc, String payecoStr)
	{
		if(packageName == null){
			packageName = context.getPackageName();
		}
		String result = null;
		JSONObject json = new JSONObject();
		try
		{
			String appName = "";
			String packageName = "";
			String versionName = "";
			int versionCode = -1;
			PackageInfo info;

			info = context.getPackageManager().getPackageInfo(PaymentDevice.packageName, 0);
			// 应用名
			appName = info.applicationInfo.loadLabel(context.getPackageManager()).toString();
			// 当前版本的包名
			packageName = info.packageName;
			// 当前应用的版本名称
			versionName = info.versionName;
			// 当前版本的版本号
			versionCode = info.versionCode;

			String channelId = "s1001";
			String netType = getNetType(context);
			String imei = getImei(context);
			String mac = getWlanMacAddress(context);
			String os = Build.VERSION.SDK;
			String simOperator = getSimOperator(context);
//TODO 上线时修改回来			String model = Build.MODEL;
			String model = "HM NOTE";
			String pkgList = getPackageList(context);
			String uid = "";

			json.put("channelId", channelId == null ? "" : channelId);
			json.put("productName", productName == null ? "" : productName);
			json.put("productDesc", productDesc == null ? "" : productDesc);
			json.put("nettype", netType == null ? "" : netType);
			json.put("appname", appName == null ? "" : appName);
			json.put("packagename", packageName == null ? "" : packageName);
			json.put("versionname", versionName == null ? "" : versionName);
			json.put("versioncode", versionCode == -1 ? "" : versionCode);
			json.put("imei", imei == null ? "" : imei);
			json.put("mac", mac == null ? "" : mac);
			json.put("os", os == null ? "" : os);
			json.put("operator", simOperator == null ? "" : simOperator);
			json.put("phonemodels", model == null ? "" : model);
			json.put("packagelist", pkgList == null ? "" : pkgList);
			json.put("sdkversion", "3.1");
			json.put("appkey", "42bc87ca29a772d0mBj6Pxj1GtUIDqPfZg3ubUjpWeefTB8RPjVThxu4cKa5sB0");
			json.put("paystatus", "success");
			json.put("orderid", orderId == null ? "" : orderId);
			json.put("paytype", payType == null ? "" : payType);
			json.put("money", productPrice == null ? "" : productPrice);
			json.put("xuid", uid);


			result = json.toString();
		} catch (Exception exception)
		{

			result = "jsonerror";
		}

		return result;
	}





	public static String getSimOperator(Context context)
	{
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String ProvidersName = telephonyManager.getNetworkOperatorName();
		String result = null;
		try
		{
			result = URLEncoder.encode(ProvidersName, "UTF-8");
		} catch (Exception e)
		{

			result = null;
		}
		return result;
	}

	public static String getNetType(Context context)
	{
		String netType = error;
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info != null)
		{
			if (info.getType() == ConnectivityManager.TYPE_WIFI)
			{
				netType = "WIFI";
			}
			else if (info.getType() == ConnectivityManager.TYPE_MOBILE)
			{
				TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
				switch (telephony.getNetworkType())
				{
					case TelephonyManager.NETWORK_TYPE_UMTS:
						netType = "USIM-WCDMA";
						break;
					case TelephonyManager.NETWORK_TYPE_GPRS:
						netType = "SIM-GPRS";
						break;
					case TelephonyManager.NETWORK_TYPE_EDGE:
						netType = "SIM-EDGE";
						break;
					default:
						netType = info.getSubtype() + "";
						break;
				}
			}
		}

		return netType;
	}


	/**
	 * 获取IMEI， 注意:模拟器的IMEI为0
	 * 
	 * @author swm
	 * @date 2012-11-26 上午11:48:04
	 */
	public static String getImei(Context context)
	{
		if (context != null)
		{
			TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			if (telephony.getDeviceId() == null)
			{
				return error;
			}
			else if (telephony.getDeviceId().length() == 0)
			{
				return error;
			}
			if (telephony.getDeviceId().toLowerCase().equals("000000000000000"))
			{
				return error;
			}
			// L("IMEI:"+telephony.getDeviceId());
			return telephony.getDeviceId();
		}
		else
		{
			Log.e("getIMEI", "PleaseInitializeGEDeviceClass");
			return error;
		}
	}

	/**
	 * 获取设备中的应用列表
	 * 
	 * @author swm
	 * @date 2012-11-26 上午11:36:58
	 */
	public static String getPackageList(Context context)
	{
		String pkgList = null;

		StringBuilder stringBuilder;
		try
		{
			List<PackageInfo> appPackage = context.getPackageManager().getInstalledPackages(0);
			stringBuilder = new StringBuilder();
			for (int i = 0; i < appPackage.size(); i++)
			{
				PackageInfo packageInfo = appPackage.get(i);
				if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)
				{
					stringBuilder.append(packageInfo.packageName + ",");
				}
			}
			pkgList = stringBuilder.toString();
		} catch (Exception e)
		{
			pkgList = null;
		}
		return pkgList;
	}

	/**
	 * 获取设备mac地址
	 * 
	 * @author swm
	 * @date 2012-11-26 下午4:56:22
	 */
	public static String getWlanMacAddress(Context context)
	{
		if (context != null)
		{
			WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			WifiInfo wifiInfo = wifiManager.getConnectionInfo();
			if (wifiInfo.getMacAddress() == null)
			{
				return error;
			}
			else if (wifiInfo.getMacAddress().length() == 0)
			{
				return error;
			}
			return wifiInfo.getMacAddress();
		}
		else
		{
			return error;
		}
	}

	/**
	 * 获得当前应用版本号
	 */
	public static String getVersionCode(Context context)
	{
		int versionCode = -1;
		String version = "";
		PackageInfo info;
		try
		{
			info = context.getPackageManager().getPackageInfo(packageName, 0);
			versionCode = info.versionCode;
			version = String.valueOf(versionCode);
		} catch (Exception e)
		{

			return error;
		}
		// 当前版本的版本号
		return version;
	}

	/**
	 * 获得当前应用版本名
	 */
	public static String getVersionName(Context context)
	{
		String versionName = null;
		PackageInfo info;
		try
		{
			info = context.getPackageManager().getPackageInfo(packageName, 0);
			versionName = String.valueOf(info.versionName);
		} catch (Exception e)
		{

			versionName = null;
		}
		return versionName;
	}
}
