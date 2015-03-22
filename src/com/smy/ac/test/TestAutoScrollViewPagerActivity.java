package com.smy.ac.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.smy.ac.widgets.viewpager.AutoScrollViewPager.AutoScrollViewPager;
import com.smy.ac.widgets.viewpager.AutoScrollViewPager.AutoScrollViewPagerAdapter;
import com.smy.ac.widgets.viewpager.PagerIndicator.CirclePageIndicator;
import com.smy.androidcommon.R;

/**
 * ��ָʾ�����Զ��ֲ�Demo
 * ʹ��ʱ��Ҫע�����¼��㣺
 * 1.�������ú�ViewPager��AdapterȻ��������Indicator
 * 2.��������ͼƬ�ʹ�ͼƬ�Ļ�ʹ��ImageLoader��������SmyApplication��
 * 3.adapter��setInfinateLoop��indicator����ͬʱʹ��
 * 4.ʹ����Ҫ���ļ���AutoScrollViewPager���µ��࣬PagerIndicator�е��ࣨ����Ҫ���ã���
 * res�е�values�µ�pager_attr,pager_colors,pager_defaults
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
		//����ͼƬ��url
		//����ͼƬ
	/*	mImgUrls = new String[]{
				 "http://a0.att.hudong.com/63/02/01300000633474126798026185945.jpg",
			     "http://images.cms.yidaba.com/industry/fdcjczx/hyyw/images/picisdr5r6y.jpg",
			     "http://wj-life.wjimg.cn/upload_files/article/13/3_20101204091204_dz2md.jpg",
			     "http://pic4.nipic.com/20090914/1841899_213629046468_2.jpg"
		};*/
		//����ͼƬ
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
		mViewPager.startAutoScroll(); //��ʼ�Զ��ֲ�
	}

	@Override
	protected void onPause() {
		super.onPause();
		mViewPager.stopAutoScroll(); //ֹͣ�Զ��ֲ�
	}
}
