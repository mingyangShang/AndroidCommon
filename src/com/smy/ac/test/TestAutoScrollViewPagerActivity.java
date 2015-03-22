package com.smy.ac.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.smy.ac.widgets.viewpager.AutoScrollViewPager.AutoScrollViewPager;
import com.smy.ac.widgets.viewpager.AutoScrollViewPager.AutoScrollViewPagerAdapter;
import com.smy.ac.widgets.viewpager.PagerIndicator.CirclePageIndicator;
import com.smy.androidcommon.R;

/**
 * 带指示器的自动轮播Demo
 * 使用时需要注意以下几点：
 * 1.首先设置好ViewPager的Adapter然后再设置Indicator
 * 2.加载网络图片和大图片的话使用ImageLoader，配置在SmyApplication中
 * 3.adapter的setInfinateLoop和indicator不能同时使用
 * 4.使用需要的文件：AutoScrollViewPager包下的类，PagerIndicator中的类（捡需要的拿），
 * res中的values下的pager_attr,pager_colors,pager_defaults
 * @author smy
 *
 */
public class TestAutoScrollViewPagerActivity extends Activity{
	private String[] mImgUrls;
	private ImageView[] mImgs;
	
	private AutoScrollViewPager mViewPager;
	private AutoScrollViewPagerAdapter mPagerAdapter;
	private CirclePageIndicator mPagerIndicator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_auto_scroll_view_pager);
		
		initViewPager();
	}

	private void initViewPager() {
		//加载图片的url
		//网络图片
	/*	mImgUrls = new String[]{
				 "http://a0.att.hudong.com/63/02/01300000633474126798026185945.jpg",
			     "http://images.cms.yidaba.com/industry/fdcjczx/hyyw/images/picisdr5r6y.jpg",
			     "http://wj-life.wjimg.cn/upload_files/article/13/3_20101204091204_dz2md.jpg",
			     "http://pic4.nipic.com/20090914/1841899_213629046468_2.jpg"
		};*/
		//本地图片
		mImgUrls = new String[]{
			""+R.drawable.car,
			""+R.drawable.car1,
			""+R.drawable.car2,
			""+R.drawable.car3
		};
		mImgs = new ImageView[mImgUrls.length];
		for(int i=0,size=mImgs.length;i<size;++i){
			ImageView img = new ImageView(this);
			mImgs[i] = img;
		}
		
		mViewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
		mPagerAdapter = new AutoScrollViewPagerAdapter(this,mImgs,mImgUrls);
		mPagerAdapter.setmIsInfiniteLoop(false);
		
		mViewPager.setAdapter(mPagerAdapter);
//		mViewPager.setOnPageChangeListener(null);
		
		mPagerIndicator = (CirclePageIndicator) findViewById(R.id.view_pager_indicator);
		mPagerIndicator.setViewPager(mViewPager);
	}

	@Override
	protected void onResume() {
		super.onResume(); 
		mViewPager.startAutoScroll(); //开始自动轮播
	}

	@Override
	protected void onPause() {
		super.onPause();
		mViewPager.stopAutoScroll(); //停止自动轮播
	}
}
