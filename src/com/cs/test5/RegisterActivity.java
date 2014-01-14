package com.cs.test5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.cs.test5.widget.WidgetTitleView;
import com.cs.test5.widget.WidgetTitleView.OnTitleClickListener;
import com.example.test5.R;

public class RegisterActivity extends Activity {

	private WidgetTitleView titleView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		
		titleView = (WidgetTitleView) findViewById(R.id.title_view);
		titleView.setOnTitleClickListener(new OnTitleClickListener() {
			
			@Override
			public void onRightButtonClick() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLeftButtonClick() {
				// TODO Auto-generated method stub
				finish();
				//overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				//overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
				//overridePendingTransition(R.anim.fade, R.anim.hold);
				overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
		return true;
	}

}
