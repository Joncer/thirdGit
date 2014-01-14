package com.cs.test5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener; 
import android.widget.Button;
import android.widget.TextView;
//这一行注释只是为了测试主分支和开发分支的合并
import com.example.test5.R;

public class LoginActivity extends Activity {

	private TextView text_account, text_forget;
	private Button btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btnLogin = (Button) findViewById(R.id.btn_login);
		text_account = (TextView) findViewById(R.id.text_account);
		text_forget = (TextView) findViewById(R.id.text_forget);
		text_account.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
				//overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
				//overridePendingTransition(R.anim.fade, R.anim.hold);
				//overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);  
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			}
		});
		text_forget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(LoginActivity.this, ForgetActivity.class));
				overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			}
		});
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
				overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
