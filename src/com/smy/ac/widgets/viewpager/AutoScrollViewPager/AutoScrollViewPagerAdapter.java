package com.smy.ac.widgets.viewpager.AutoScrollViewPager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class AutoScrollViewPagerAdapter extends PagerAdapter{
	
	private Context mContext;
	private ImageView[] mImgs;
	private String[] mImgUrls;
	
	private boolean mIsInfiniteLoop;
	
	public boolean ismIsInfiniteLoop() {
		return mIsInfiniteLoop;
	}

	public void setmIsInfiniteLoop(boolean mIsInfiniteLoop) {
		this.mIsInfiniteLoop = mIsInfiniteLoop;
	}

	public AutoScrollViewPagerAdapter(Context mContext, ImageView[] mImgs, String[] mImgUrls) {
		super();
		this.mContext = mContext;
		this.mImgs = mImgs;
		this.mImgUrls = mImgUrls;
	}

	@Override
	public int getCount() {
		return mIsInfiniteLoop?Integer.MAX_VALUE:this.mImgs.length;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mImgs[getPosition(position)]);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		ImageView img = mImgs[getPosition(position)];
		container.addView(img);
		// π”√ImageLoaderº”‘ÿÕº∆¨
//		ImageLoader.getInstance().displayImage(mImgUrls[getPosition(position)], img);
		img.setBackgroundResource(Integer.parseInt(mImgUrls[getPosition(position)]));
		return img;
	}
	
	protected int getPosition(int pos){
		return mIsInfiniteLoop?pos%mImgs.length:pos;
	}

}
