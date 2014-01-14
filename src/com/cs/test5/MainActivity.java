package com.cs.test5;

import java.util.ArrayList;

import com.cs.test5.data.ImageManager;
import com.cs.test5.widget.WidgetTitleView;
import com.cs.test5.widget.WidgetTitleView.OnTitleClickListener;
import com.cs.test5.widget.XListView.IXListViewListener;
import com.cs.test5.widget.XListView;
import com.example.test5.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements IXListViewListener, OnItemClickListener{

	private WidgetTitleView titleView;
	// 列表框
	private XListView listView;
	private View[] contentView;
	private ArrayList<String> datas;
	private ImageManager manager;
	private ListAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//加载图片
		manager = ImageManager.from(MainActivity.this);
		
		datas = new ArrayList<String>();
		for(int i = 0; i < 5; i++){
			
			datas.add("hahha");
		}
		
		adapter = new ListAdapter();
		listView = (XListView) findViewById(R.id.list);
		contentView = new View[200];
		listView.setPullLoadEnable(true);
		listView.setPullRefreshEnable(true);
		listView.setXListViewListener(this);
		listView.setOnItemClickListener(this);
		listView.setAdapter(adapter);
		
		titleView = (WidgetTitleView) findViewById(R.id.title_view);
		titleView.setLeftBtnVisiblity(View.VISIBLE);
		titleView.setRightBtnVisiblity(View.VISIBLE);
		titleView.setLeftBtnText("功能");
		titleView.setRightBtnText("设置");
		titleView.setOnTitleClickListener(new OnTitleClickListener() {
			
			@Override
			public void onRightButtonClick() {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, TabHostActivity.class));
			}
			
			@Override
			public void onLeftButtonClick() {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		datas = new ArrayList<String>();
		for(int i = 0; i < 5; i++){
			
			datas.add("hahha");
		}
		adapter.notifyDataSetChanged();
		listView.stopRefresh();
		listView.stopLoadMore();
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		ArrayList<String> dataList = new ArrayList<String>();
		for(int i = 0; i < 5; i++){
			
			dataList.add("hahaa");
		}
		datas.addAll(dataList);
		adapter.notifyDataSetChanged();
		listView.stopRefresh();
		listView.stopLoadMore();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	class ListAdapter extends BaseAdapter {
		public int getCount() {
			// TODO Auto-generated method stub
			return datas.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (contentView[position] == null) {
				//String str = datas.get(position).getActCover();
				String str = "http://h.hiphotos.baidu.com/album/w%3D2048/sign=88773d2634fae6cd0cb4ac613b8b0e24/728da9773912b31baf0d11388718367adab4e1ba.jpg";
				convertView = getLayoutInflater().inflate(
						R.layout.list_item_one_pic, null);
				ImageView img = (ImageView) convertView.findViewById(R.id.pic);
				manager.displayImage(img, str, R.drawable.bg);
				//manager.displayImage(img, str, null);
				
				TextView title = (TextView) convertView
						.findViewById(R.id.news_title);
				TextView tag = (TextView) convertView.findViewById(R.id.tag);
				TextView summary = (TextView) convertView
						.findViewById(R.id.summary);
				//
				//title.setText(datas.get(position).getActTitle());
				title.setText(datas.get(position));
				//tag.setText(datas.get(position).getTag());
				tag.setText(datas.get(position));
				//summary.setText(datas.get(position).getActDiscription());
				summary.setText(datas.get(position));
				contentView[position] = convertView;
				return convertView;
			} else {
				return contentView[position];
			}
		}
	}
}
