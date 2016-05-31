package com.guoguoquan.guoguonews.Presenter.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 小段果果
 * @time 2016/5/23  19:28
 * @E-mail duanyikang@mumayi.com
 */

public class ImageUtil {

    private static ImageUtil mImageUtil=null;

    private ImageUtil()
    {}

    public static ImageUtil getInstance()
    {
        if(mImageUtil==null)
        {
            mImageUtil=new ImageUtil();
        }
        return mImageUtil;
    }



    public Bitmap decodeBitmapFromFile(String file,int reqWidth,int reqHeight)
    {
        final BitmapFactory.Options options= new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(file,options);
        options.inSampleSize=calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds=false;
        return  BitmapFactory.decodeFile(file, options);
    }
    public  Bitmap decodeBitmapFromResource(Resources resources,int resID, int reqWidth,int reqHeight)
    {
        final BitmapFactory.Options options= new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(resources, resID, options);
        options.inSampleSize=calculateInSampleSize(options,reqWidth,reqHeight);
        options.inJustDecodeBounds=false;
        return BitmapFactory.decodeResource(resources, resID, options);
    }
    public  int calculateInSampleSize(BitmapFactory.Options options,int reqWith,int reqHeight)
    {
        final int height=options.outHeight;
        final int widht=options.outWidth;
        int inSampleSize=1;
        if(height>reqHeight||widht>reqWith)
        {
            final int halfHeight=height/2;
            final int halfWidth=widht/2;
            while((halfHeight/inSampleSize)>=reqHeight&&(halfWidth/inSampleSize)>=reqWith)
                inSampleSize*=2;
        }
        return inSampleSize;
    }



    /**
     * 获取图片的旋转角度
     *
     * @param path 图片绝对路径
     * @return 图片的旋转角度
     */
    public int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 将图片按照指定的角度进行旋转
     *
     * @param bitmap 需要旋转的图片
     * @param degree 指定的旋转角度
     * @return 旋转后的图片
     */
    public  Bitmap rotateBitmapByDegree(Bitmap bitmap, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return newBitmap;
    }

    /**
     * 将bitmap 保存到本地
     * @param picName
     * @param bm
     */
    public void saveBitmap(String picName,Bitmap bm) {
        File f = new File(Constant.FILE_BASE, picName);
        if (f.exists()) {
            f.delete();
        }
        else
        {
           new File(Constant.FILE_BASE).mkdir();
        }

        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

