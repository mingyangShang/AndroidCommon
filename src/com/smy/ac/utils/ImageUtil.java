package com.smy.ac.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * ͼƬ��ش�����
 * @author smy
 */
public class ImageUtil {
	/**
	 * ��drawableת����bitmap
	 * @throws RuntimeException ��drawableΪ��ʱ�׳��쳣
	 * @param drawable Ҫת����drawable
	 * @param config ͼƬ�����ò���
	 * @return ת���ɵ�bitmap
	 */
	public static Bitmap drawableToBitmap(Drawable drawable,Config config){
		if(drawable == null){
			throw new RuntimeException("Ҫת����drawable��������Ϊ��");
		}
		if(drawable instanceof BitmapDrawable){
			return ((BitmapDrawable)(drawable)).getBitmap();
		}
		
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap bitmap = Bitmap.createBitmap(width, height, config);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0,0,width,height); //���ñ߿�
		drawable.draw(canvas);
		return bitmap;
	}
	
	/**@see drawableToBitmap(Drawable,Config)*/
	public static Bitmap drawBitmap(Drawable drawable){
		return drawableToBitmap(drawable, Config.ARGB_8888);
	}
	
	
}
