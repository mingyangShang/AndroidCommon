package com.smy.ac.utils;

import android.content.Context;

/**
 * ��Ļ��ع�����
 * @author smy
 */

public class ScreenUtil {
	/**
	 * ��ȡ��Ļ�Ŀ��
	 * @param context �����Ķ�����ø�application����
	 * @return ��Ļ��ȣ�px��
	 */
	public static int getScrrenWidthPixel(Context context) {
		return context.getResources().getDisplayMetrics().widthPixels;
	}

	public static int getScreenHeightPixel(Context context) {
		return context.getResources().getDisplayMetrics().heightPixels;
	}
	
	/**
	 * ��pxֵת��Ϊdip��dpֵ����֤�ߴ��С����
	 * @param pxValue
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * ��dip��dpֵת��Ϊpxֵ����֤�ߴ��С����
	 * @param dipValue
	 * @return
	 */
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * ��pxֵת��Ϊspֵ����֤���ִ�С����
	 * @param pxValue
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * ��spֵת��Ϊpxֵ����֤���ִ�С����
	 * @param spValue
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

}
