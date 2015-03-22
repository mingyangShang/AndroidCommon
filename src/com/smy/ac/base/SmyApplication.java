package com.smy.ac.base;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;

public class SmyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
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

}
