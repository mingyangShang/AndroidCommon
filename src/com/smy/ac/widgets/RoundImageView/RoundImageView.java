package com.smy.ac.widgets.RoundImageView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends ImageView {
	
	private final Xfermode mFermode = new PorterDuffXfermode(Mode.DST_IN); //显示相交的原来图片的部分
	private Paint mMaskPaint;
	private Paint mImgPaint;
	
	private Rect mMaskRect,mImgRect;

	public RoundImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mMaskPaint = new Paint();
		mMaskPaint.setAntiAlias(true);
		mMaskPaint.setColor(Color.parseColor("#ff0000"));
		
		
		mImgPaint = new Paint();
		mImgPaint.setAntiAlias(true);
		mImgPaint.setColor(Color.parseColor("#00ff00"));
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}


	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mMaskRect = new Rect(0,0,getWidth(),getHeight());
		
		mImgPaint.setXfermode(mFermode);
		canvas.drawRect(mMaskRect, mMaskPaint);
		mImgPaint.setXfermode(null);
		mImgPaint.setColor(Color.parseColor("#0000ff"));
		canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2, mImgPaint);
		
	}
	
	
	
	

}
