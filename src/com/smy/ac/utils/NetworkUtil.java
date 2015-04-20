package com.smy.ac.utils;

import com.smy.ac.base.SmyApplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * ����״̬������
 * @author smy
 * @create on 2015/04/20
 */
public class NetworkUtil {
	
	/**
	 * �ж����������Ƿ����
	 */
	public static boolean isNetworkAvailable(Context context){
		if(context!=null){
			final ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			final NetworkInfo networkInfo = manager.getActiveNetworkInfo();
			if(networkInfo!=null){
				return networkInfo.isAvailable();
			}
		}
		return false;
	}
	/**
	 *@see {isNetworkAvailable(Context)} 
	 */
	public static boolean isNetworkAvailable(){
		return isNetworkAvailable(SmyApplication.getSingleton());
	}
	
	

}
