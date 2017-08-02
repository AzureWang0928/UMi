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
	
	//����һ��Listview�ռ䣨����������fragment_test.xml �������� RelativeLayout��
	ListView myList = null;
	CompanyLineAdapter companyLineAdapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_line);
		initCustomActionBar();

		myList = (ListView)findViewById(R.id.list_item_company_line);
		//�õ�һ��MyAdapter����
		companyLineAdapter = new CompanyLineAdapter(this);
		//ΪListView��Adapter 
		myList.setAdapter(companyLineAdapter);
		myList.setOnItemClickListener(new OnItemClickListener(){
	    	 
	        @Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
	            switch (position) {
				case 4:
					Toast toast = Toast.makeText(CompanyLineActivity.this, "�ף�������עŶ��\n�л���һʱ��֪ͨ����^_^", Toast.LENGTH_SHORT); 
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
	private LayoutInflater myInflater = null; //�õ�һ��LayoutInfalter�����������벼��
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
			
			//�������convertViewΪ�գ�����Ҫ����View
            if(convertView == null){
				//�����Զ����Item���ּ��ز���
                convertView = myInflater.inflate(R.layout.list_item_company_line, null);
            	
            	holder = new CompanyLineViewHolder();

            	holder.lineNumber = (TextView)convertView.findViewById(R.id.attention_company_line_number);
            	holder.lineName = (TextView)convertView.findViewById(R.id.attention_company_line_name);
            	holder.privateMark = (ImageView)convertView.findViewById(R.id.attention_company_line_private);
            	holder.focusMark = (ImageView)convertView.findViewById(R.id.attention_company_line_focus);
//            	//�����úõĲ��ֱ��浽�����У�������������Tag��Ա���淽��ȡ��Tag
//                convertView.setTag(holder);
            }
//            else{
//                holder = (ViewHolder)convertView.getTag();
//            }
        	
            switch(position){
            case 0:
            	holder.lineNumber.setText("�1");
            	holder.lineName.setText("ȥͷ�;���ô��");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 1:
            	holder.lineNumber.setText("�2");
            	holder.lineName.setText("���Ͼ�");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 2:
            	holder.lineNumber.setText("�3");
            	holder.lineName.setText("��ľɫ��Ⱦ");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 3:
            	holder.lineNumber.setText("�4");
            	holder.lineName.setText("���ü��� ���ܼ���");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.focusMark.setVisibility(View.VISIBLE);
            	break;
            case 4:
            	holder.lineNumber.setText("�����������ڴ�������");
            	holder.lineName.setText("");
            	holder.privateMark.setVisibility(View.INVISIBLE);
            	holder.focusMark.setVisibility(View.INVISIBLE);
            }
            	              
            
            /*
			 * ����ListView�м佻��ɫ
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