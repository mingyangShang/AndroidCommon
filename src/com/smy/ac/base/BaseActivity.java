package com.smy.ac.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	/**
	 * sub class can override this func not old onCreate to simpleify
	 * manipulation
	 */
	protected void onCreate(Bundle savedInstanceState, int resId) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置无标题栏
		setContentView(resId);
		/*
		 * getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		 * WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 */// 设置全屏
		init();
	}

	protected void onCreate(Bundle savedInstanceState, View view) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(view);
		init();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	protected abstract void initData(); // 鍒濆鍖栨暟鎹�

	protected abstract void initView(); // 鍒濆鍖栬鍥�

	protected void init() {
		initData();
		initView();
	}

	// ==findViewById()
	protected View getView(int resId) {
		return findViewById(resId);
	}

	protected void goTo(Class<? extends Activity> destActivity, Bundle bundle) {
		Intent intent = new Intent(this, destActivity);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	protected void goTo(Class<? extends Activity> destActivity) {
		goTo(destActivity, null);
	}

	protected Bundle getBundleFromUp() {
		return getIntent().getExtras();
	}

	/*** 获取当前应用程序的版本号*/
	private String getVersion() {
		PackageManager pm = getPackageManager();
		try {
			PackageInfo packinfo = pm.getPackageInfo(getPackageName(), 0);
			String version = packinfo.versionName;
			return version;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "0"; //0代表未能找到版本号
		}
	}
	
	/**弹出Toast，Toast的样式今后可以自定义，暂时使用默认*/
    protected void showMsg(String msg) {
    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();	
	}
    protected void showMsg(String msg,int duration){
    	Toast.makeText(this, msg, duration).show();
    }

}
