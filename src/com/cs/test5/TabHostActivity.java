package com.cs.test5;

import com.example.test5.R;
import android.os.Bundle;
import android.app.TabActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		TabHost tabHost = getTabHost();
		
		//设置TabHost布局
		LayoutInflater.from(this).inflate(R.layout.activity_tab_host, tabHost.getTabContentView());
		//setContentView(R.layout.activity_main);
		//添加第一个标签页
		tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("已接电话").setContent(R.id.tab01));
		//添加第二个标签页
		tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("已接电话").setContent(R.id.tab02));
		//添加第三个标签页
		tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("已接电话").setContent(R.id.tab03));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_host, menu);
		return true;
	}

}
