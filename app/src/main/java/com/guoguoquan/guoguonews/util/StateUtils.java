package com.guoguoquan.guoguonews.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class StateUtils {

    public static boolean isNetworkAvailable(Context context) {
       if(context !=null){
           ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo info = cm.getActiveNetworkInfo();
           if(info !=null){
               return info.isAvailable();
           }
       }
        return false;
    }
}
