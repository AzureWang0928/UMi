package com.bupt.umi.userinterface.find;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupMenu.OnMenuItemClickListener;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.me.AboutUsActivity;
import com.bupt.umi.userinterface.me.RefreshingTimeActivity;
import com.bupt.umi.userinterface.me.RemindingActivity;

public class PostActivity extends Activity{

	private ActionBar actionBar;
	//����һ��Listview�ռ䣨����������fragment_test.xml �������� RelativeLayout��
	ListView myList = null;
	PostAdapter postAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		initCustomActionBar();

		myList = (ListView)findViewById(R.id.list_item_post);
		//�õ�һ��MyAdapter����
		postAdapter = new PostAdapter(this);
		//ΪListView��Adapter 
		myList.setAdapter(postAdapter);
		myList.setOnItemClickListener(new OnItemClickListener(){
	    	 
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
	            switch (position) {
				default:
	            	startActivity(new Intent(PostActivity.this, PostDetailActivity.class));
					break;
				}
	        }
	    });	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
        case android.R.id.home:
            // ���ϽǷ��ذ�ť
        	finish();
        	break;
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
class PostAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //�õ�һ��LayoutInfalter�����������벼��
	@SuppressWarnings("unused")
	private Context myContext = null;
	
	public PostAdapter(Context context) {
		this.myInflater = LayoutInflater.from(context);
		this.myContext = context;
   	}
        	
	@Override
	public int getCount() {
		
		return 7;
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
			
			
			PostViewHolder holder = null;
			
			//�������convertViewΪ�գ�����Ҫ����View
            if(convertView == null){
				//�����Զ����Item���ּ��ز���
                convertView = myInflater.inflate(R.layout.list_item_post, null);
            	
            	holder = new PostViewHolder();

            	holder.postCompany = (TextView)convertView.findViewById(R.id.find_post_company);
            	//�����úõĲ��ֱ��浽�����У�������������Tag��Ա���淽��ȡ��Tag
                convertView.setTag(holder);
            }
            else{
                holder = (PostViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.postCompany.setText("01. ˮ��������Ĥ");
            	break;
            case 1:
            	holder.postCompany.setText("02. ޱ����˪");
            	break;
            case 2:
            	holder.postCompany.setText("03. ����«����");
            	break;
            case 3:
            	holder.postCompany.setText("04. ��ȸ��ˬ��ˮ");
            	break;
            case 4:
            	holder.postCompany.setText("05. Free+ϴ��˪");
            	break;
            case 5:
            	holder.postCompany.setText("06. �����ʿ����Ĥ");
            	break;
            case 6	:
            	holder.postCompany.setText("07. BodyShop��ϴ��������");
            	break;
            default:
            	break;
            }
//            if (position%2 == 0 ) {
//				convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
//			}	              
            
            return convertView;
        }
}	
	
class PostViewHolder{
	public TextView postCompany;
}
