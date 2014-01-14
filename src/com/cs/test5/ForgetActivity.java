package com.cs.test5;

import com.cs.test5.widget.WidgetTitleView;
import com.cs.test5.widget.WidgetTitleView.OnTitleClickListener;
import com.example.test5.R;
import com.example.test5.R.layout;
import com.example.test5.R.menu;

import android.os.Bundle;
import android.app.Activity; 
import android.view.Menu; 

public class ForgetActivity extends Activity {

	private WidgetTitleView titleView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget);
		
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
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.forget, menu);
		return true;
	}

}
