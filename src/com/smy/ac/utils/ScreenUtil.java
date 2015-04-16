package com.smy.ac.utils;

import android.content.Context;

/**
 * 屏幕相关工具类
 * @author smy
 */

public class ScreenUtil {
	/**
	 * 获取屏幕的宽度
	 * @param context 上下文对象，最好给application对象
	 * @return 屏幕宽度（px）
	 */
	public static int getScrrenWidthPixel(Context context){
		return context.getResources().getDisplayMetrics().widthPixels;
	}
}
