package com.bupt.umi.userinterface.attention;

import com.bupt.umi.R;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MoreLineActivity extends Activity {

	private ActionBar actionBar;
	private TextView tvTitle;
	private Button leftButton; 
	private ImageButton rightButton;
	
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	MoreLineAdapter moreLineAdapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_line);
		initCustomActionBar();

		myList = (ListView)findViewById(R.id.list_item_more_line);
		//得到一个MyAdapter对象
		moreLineAdapter = new MoreLineAdapter(this);
		//为ListView绑定Adapter 
		myList.setAdapter(moreLineAdapter);
		myList.setOnItemClickListener(new OnItemClickListener(){
	    	 
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
	            if(position == 0){
	            	startActivity(new Intent(MoreLineActivity.this, LineDetailsActivity.class));
	            }
	            if(position == 1){
	            	startActivity(new Intent(MoreLineActivity.this, LineDetailsActivity.class));
	            }
	            if(position == 2){
	            	startActivity(new Intent(MoreLineActivity.this, LineDetailsActivity.class));
	            }
	            if(position == 3){
	            	startActivity(new Intent(MoreLineActivity.this, LineDetailsActivity.class));
	            }
	        }
	         
	    });
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.more_line, menu);
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
class MoreLineAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	public MoreLineAdapter(Context context) {
		this.myInflater = LayoutInflater.from(context);
   	}
        	
	@Override
	public int getCount() {
		
		return 4;
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
			
			
			MoreLineViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_more_line, null);
            	
            	holder = new MoreLineViewHolder();

            	holder.lineType = (TextView)convertView.findViewById(R.id.attention_line_type);
//            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
//                convertView.setTag(holder);
            }
//            else{
//                holder = (ViewHolder)convertView.getTag();
//            }
        	
            switch(position){
            case 0:
            	holder.lineType.setText("超市");
            	break;
            case 1:
            	holder.lineType.setText("驾校");
            	break;
            case 2:
            	holder.lineType.setText("校车");
            	break;
            case 3:
            	holder.lineType.setText("校园公交");
            	break;
            }
            	              
            
            /*
			 * 设置ListView行间交替色
			 */
			if (position % 2 == 0) {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            } 
			else {
                convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
            }
			
            return convertView;
        }
}	
	
class MoreLineViewHolder{
	public TextView lineType;

}