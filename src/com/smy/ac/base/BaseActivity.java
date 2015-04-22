package com.smy.ac.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	/**sub class can override this func not old onCreate to simpleify manipulation*/
	protected void onCreate(Bundle savedInstanceState,int resId){
		super.onCreate(savedInstanceState);
		setContentView(resId);
		init();
	}
	protected void onCreate(Bundle savedInstanceState,View view){
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
	
	protected abstract void initData(); //鍒濆鍖栨暟鎹�
	protected abstract void initView(); //鍒濆鍖栬鍥�
	protected void init() {
		initData();
		initView();
	}
	// ==findViewById()
	protected View getView(int resId){
		return findViewById(resId);
	}
	
	protected void goTo(Class<? extends Activity> destActivity,Bundle bundle) {
		Intent intent = new Intent(this,destActivity);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	protected void goTo(Class<? extends Activity> destActivity){
		goTo(destActivity,null);
	}
	protected Bundle getBundleFromUp(){
		return getIntent().getExtras();
	}
	

}
