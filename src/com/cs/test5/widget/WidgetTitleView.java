package com.cs.test5.widget;

import com.example.test5.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class WidgetTitleView extends LinearLayout {
	protected Button mLeftBtn, mRightBtn; 
	protected TextView mTitleTxt;
	protected Context mContext;
	protected OnTitleClickListener mClickListener;

	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.left_button:
				if (mClickListener != null) {
					mClickListener.onLeftButtonClick();
				}
				//sendKeyBackEvent();
				break;
			case R.id.right_button:
				if (mClickListener != null) {
					mClickListener.onRightButtonClick();
				}
				break;
			}
		}

		
	};
	
	public WidgetTitleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setupView(context);
	}

	public WidgetTitleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setupView(context);
	}


	private void setupView(Context context) {
		this.mContext = context;
		View view = LayoutInflater.from(context).inflate(R.layout.title_view, null);
		mTitleTxt = (TextView) view.findViewById(R.id.title_text);
		mLeftBtn = (Button) view.findViewById(R.id.left_button);
		mRightBtn = (Button) view.findViewById(R.id.right_button);
		mLeftBtn.setOnClickListener(clickListener);
		mRightBtn.setOnClickListener(clickListener);
		this.addView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	public void setTitleText(String title) {
		mTitleTxt.setText(title);
	}

	public void setLeftBtnText(String left) {
		mLeftBtn.setText(left);
	}

	public void setRightBtnText(String right) {
		mRightBtn.setText(right);
	}
	

	public void setRightBtnVisiblity(int visible){
		mRightBtn.setVisibility(visible);
	}
	

	public void setLeftBtnVisiblity(int visible){
		mLeftBtn.setVisibility(visible);
	}
	
	public Button getRightBtn() {
		return mRightBtn;
	}
	
	public Button getLeftBtn() {
		return mLeftBtn;
	}
	
	public void setOnTitleClickListener(OnTitleClickListener onTitleClickListener){
		this.mClickListener  = onTitleClickListener;
	}

	public interface OnTitleClickListener {
		public void onLeftButtonClick();

		public void onRightButtonClick();
	}

}
