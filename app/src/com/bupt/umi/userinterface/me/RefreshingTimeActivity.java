package com.bupt.umi.userinterface.me;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bupt.umi.R;

public class RefreshingTimeActivity extends Activity {

	private ActionBar actionBar;
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	AddressAdapter addressAdapter = null;	
//	RadioGroup refreshingtTimeRadioGroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_refreshing_time);
		initCustomActionBar();

		myList = (ListView)findViewById(R.id.list_item_refreshing_time);
		//得到一个MyAdapter对象
		addressAdapter = new AddressAdapter(this);
		//为ListView绑定Adapter 
		myList.setAdapter(addressAdapter);
//		refreshingtTimeRadioGroup =(RadioGroup)findViewById(R.id.refreshing_time_option);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.refreshing_time, menu);
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
class AddressAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	@SuppressWarnings("unused")
	private Context myContext = null;
	
	public AddressAdapter(Context context) {
		this.myInflater = LayoutInflater.from(context);
		this.myContext = context;
   	}
        	
	@Override
	public int getCount() {
		
		return 2;
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
			
			
			AddressViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_refreshing_time, null);
            	
            	holder = new AddressViewHolder();
            	
            	holder.name = (TextView)convertView.findViewById(R.id.name);
            	holder.telephone = (TextView)convertView.findViewById(R.id.telephone);
            	holder.address = (TextView)convertView.findViewById(R.id.address);
            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }
            else{
                holder = (AddressViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.name.setText("王昊喆");
            	holder.telephone.setText("13269619176");
            	holder.address.setText("北京市昌平区北京邮电大学宏福校区");
            	break;
            case 1:
            	holder.name.setText("许凡奇");
            	holder.telephone.setText("13241259804");
            	holder.address.setText("北京市海淀区西土城路十号北京邮电大学");
            	break;
            default:
            	break;
            }
            if (position%2 == 0 ) {
				convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
			}	              
            
            return convertView;
        }
}	
	
class AddressViewHolder{
	public TextView name;
	public TextView telephone;
	public TextView address;
}

