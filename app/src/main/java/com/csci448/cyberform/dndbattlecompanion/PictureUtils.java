package com.csci448.cyberform.dndbattlecompanion;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by johnhonan on 3/10/18.
 */

public class PictureUtils
{
    public static Bitmap getScailedBitmap(String path, int destWidth, int destHeight) {
        //Read the dimentions of the image on the disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        // Figure out how much to scale down by
        int inSampleSize = 1;
//        if(srcHeight > destHeight || srcWidth > destWidth) {
//            float hightScale = srcHeight/destHeight;
//            float widthScale = srcWidth/destWidth;
//
//            inSampleSize = Math.round(hightScale > widthScale ? hightScale : widthScale);
//        }
//
//        else {
//            float hightScale = destHeight/srcHeight;
//            float widthScale = destWidth/srcWidth;
//
//            inSampleSize = Math.round(hightScale > widthScale ? hightScale : widthScale);
//        }

        float hightScale = srcHeight/destHeight;
        float widthScale = srcWidth/destWidth;

        inSampleSize = Math.round(hightScale > widthScale ? hightScale : widthScale);

        options = new BitmapFactory.Options();
        options.inSampleSize = inSampleSize;

        //Read in and create the final bitmap
        return BitmapFactory.decodeFile(path, options);
    }

    public static Bitmap getScailedBitmap(String path, Activity activity)
    {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScailedBitmap(path, size.x, size.y);
    }
}
