package com.bupt.umi.userinterface.attention;


import com.bupt.umi.R;
import com.bupt.umi.StopDetailsActivity;
import com.bupt.umi.userinterface.find.PostDetailActivity;
import com.bupt.umi.userinterface.find.PublicCommunityActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CompanyLineActivity extends Activity {

	private ActionBar actionBar;
	private TextView tvTitle;
	private Button leftButton; 
	private ImageButton rightButton;
	
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	CompanyLineAdapter companyLineAdapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_line);
		initCustomActionBar();

		myList = (ListView)findViewById(R.id.list_item_company_line);
		//得到一个MyAdapter对象
		companyLineAdapter = new CompanyLineAdapter(this);
		//为ListView绑定Adapter 
		myList.setAdapter(companyLineAdapter);
		myList.setOnItemClickListener(new OnItemClickListener(){
	    	 
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
	            switch (position) {
				case 4:
					Toast toast = Toast.makeText(CompanyLineActivity.this, "亲！持续关注哦！\n有活动会第一时间通知您的^_^", Toast.LENGTH_SHORT); 
					toast.show();
					break;
				default:
	            	startActivity(new Intent(CompanyLineActivity.this, StopDetailsActivity.class));
					break;
				}
	        }
	         
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.company_line, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
	}
	
	public boolean initCustomActionBar(){
		actionBar = getActionBar();
		if(actionBar == null){
			return false;
		}
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		return true;
	}
}


@SuppressLint("InflateParams")
class CompanyLineAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	public CompanyLineAdapter(Context context) {
		this.myInflater = LayoutInflater.from(context);
   	}
        	
	@Override
	public int getCount() {
		
		return 5;
	}
			
	@Override
	public Object getItem(int position) {
		return null;
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}
			
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			
			CompanyLineViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_company_line, null);
            	
            	holder = new CompanyLineViewHolder();

            	holder.lineNumber = (TextView)convertView.findViewById(R.id.attention_company_line_number);
            	holder.lineName = (TextView)convertView.findViewById(R.id.attention_company_line_name);
            	holder.privateMark = (ImageView)convertView.findViewById(R.id.attention_company_line_private);
            	holder.focusMark = (ImageView)convertView.findViewById(R.id.attention_company_line_focus);
//            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
//                convertView.setTag(holder);
            }
//            else{
//                holder = (ViewHolder)convertView.getTag();
//            }
        	
            switch(position){
            case 0:
            	holder.lineNumber.setText("活动1");
            	holder.lineName.setText("去头油就这么简单");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 1:
            	holder.lineNumber.setText("活动2");
            	holder.lineName.setText("爱上卷发");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 2:
            	holder.lineNumber.setText("活动3");
            	holder.lineName.setText("桃木色烫染");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 3:
            	holder.lineNumber.setText("活动4");
            	holder.lineName.setText("美得极致 享受极致");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 4:
            	holder.lineNumber.setText("更多活动，敬请期待。。。");
            	holder.lineName.setText("");
            	holder.privateMark.setVisibility(View.INVISIBLE);
            	holder.focusMark.setVisibility(View.INVISIBLE);
            }
            	              
            
            /*
			 * 设置ListView行间交替色
			 */
			if (position % 2 == 0) {
				convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
            } 
			
            return convertView;
        }
}	
	
class CompanyLineViewHolder{
	public TextView lineNumber;
	public TextView lineName;
	public ImageView privateMark;
	public ImageView focusMark;
}