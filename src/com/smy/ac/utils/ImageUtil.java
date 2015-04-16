package com.smy.ac.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * 图片相关处理类
 * @author smy
 */
public class ImageUtil {
	/**
	 * 将drawable转化成bitmap
	 * @throws RuntimeException 当drawable为空时抛出异常
	 * @param drawable 要转换的drawable
	 * @param config 图片的配置参数
	 * @return 转换成的bitmap
	 */
	public static Bitmap drawableToBitmap(Drawable drawable,Config config){
		if(drawable == null){
			throw new RuntimeException("要转换的drawable参数不能为空");
		}
		if(drawable instanceof BitmapDrawable){
			return ((BitmapDrawable)(drawable)).getBitmap();
		}
		
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, config);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0,0,width,height); //设置边框
		drawable.draw(canvas);
		return bitmap;
	}
	
	/**@see drawableToBitmap(Drawable,Config)*/
	public static Bitmap drawBitmap(Drawable drawable){
		return drawableToBitmap(drawable, Config.ARGB_8888);
	}
	
	
}
