package com.smy.ac.base;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;

public class SmyApplication extends Application {

	private static SmyApplication singleton;
	
	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		init();
	}

	private void init() {
		initUIL();
	}

	/*≈‰÷√ImageLoader**/
	private void initUIL() {
		ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
		ImageLoader.getInstance().init(configuration);
	}
	
	public static Application getSingleton(){
		return singleton;
	}

}
