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
	public static int getScrrenWidthPixel(Context context){
		return context.getResources().getDisplayMetrics().widthPixels;
	}
}
