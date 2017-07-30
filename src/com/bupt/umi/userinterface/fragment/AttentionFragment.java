package com.bupt.umi.userinterface.fragment;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.bupt.umi.MainActivity;
import com.bupt.umi.R;
import com.bupt.umi.userinterface.attention.CompanyLineActivity;
import com.bupt.umi.userinterface.attention.LineDetailsActivity;
import com.bupt.umi.userinterface.attention.MoreLineActivity;
import com.bupt.umi.userinterface.find.PublicCommunityActivity;

/**
 * @author Azure Wang
 *	功能描述：关注fragment页面
 */
public class AttentionFragment extends Fragment {

	private View mParent;
	@SuppressWarnings("unused")
	private FragmentActivity mActivity;
	private ActionBar actionBar;
	
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView attentionList = null;
	ListView beautyList = null;
	AttentionAdapter attentionAdapter = null;
	BeautyAdapter beautyAdapter = null;
	protected View layoutMain = null;
	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static AttentionFragment newInstance(int index) {
		AttentionFragment f = new AttentionFragment();

		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);

		return f;
	}

	public int getShownIndex() {
		return getArguments().getInt("index", 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(layoutMain == null) {
			layoutMain = inflater.inflate(R.layout.fragment_attention, container, false);
			// 
			attentionList = (ListView)layoutMain.findViewById(R.id.list_item_attention);
			beautyList = (ListView)layoutMain.findViewById(R.id.list_item_beauty);
			//得到一个MyAdapter对象
			attentionAdapter = new AttentionAdapter(inflater.getContext());
			beautyAdapter = new BeautyAdapter(inflater.getContext());
			//为ListView绑定Adapter 
			attentionList.setAdapter(attentionAdapter);
			beautyList.setAdapter(beautyAdapter);
		}
		
		//为Listview绑定监听器
		attentionList.setOnItemClickListener(new OnItemClickListener(){
    	 
			@Override
	        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
	            // TODO Auto-generated method stub
	        	switch (position) {
				case 2:
					Toast toast = Toast.makeText(getActivity(), "我们会尽快与更多公司合作的！\n感谢您的支持^_^", Toast.LENGTH_SHORT); 
					toast.show();
					break;
				default:
	            	startActivity(new Intent(getActivity(), CompanyLineActivity.class));
					break;
				}
        }
    });	
		beautyList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
	            	startActivity(new Intent(getActivity(), LineDetailsActivity.class));
					break;
				case 1:
	            	startActivity(new Intent(getActivity(), LineDetailsActivity.class));
					break;
			}
		}	
	});
		return layoutMain;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mParent = getView();
		mActivity = getActivity();

//		mTitle = (TitleView) mParent.findViewById(R.id.title);
//		mTitle.setTitle(R.string.title_attention);
//		mTitle.setLeftButton(R.string.back, new OnLeftButtonClickListener() {
//
//			@Override
//			public void onClick(View button) {
//			}
//		});
//		mTitle.hiddenLeftButton();
	}
	

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if (!hidden) {
		}
	}


}

@SuppressLint("InflateParams")
class AttentionAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	@SuppressWarnings("unused")
	private Context myContext = null;
	
	public AttentionAdapter(Context context) {
		this.myInflater = LayoutInflater.from(context);
		this.myContext = context;
   	}
        	
	@Override
	public int getCount() {
		
		return 3;
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
			
			
			AttentionViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_attention, null);
            	
            	holder = new AttentionViewHolder();

            	holder.companyName = (TextView)convertView.findViewById(R.id.attention_company_name);
            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }
            else{
                holder = (AttentionViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.companyName.setText("审美美容美发有限公司");
            	break;
            case 1:
            	holder.companyName.setText("PrettyTimem美容整容有限公司");
            	break;
            case 2:
            	holder.companyName.setText("更多公司活动");
            	break;
            default:
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
	
class AttentionViewHolder{
	public TextView companyName;
}


class BeautyAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	@SuppressWarnings("unused")
	private Context myContext = null;
	
	public BeautyAdapter(Context context) {
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
			
			
			BeautyViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_beauty, null);
            	
            	holder = new BeautyViewHolder();

            	holder.beautyName = (TextView)convertView.findViewById(R.id.attention_beauty_name);
            	holder.beautyDirection = (TextView)convertView.findViewById(R.id.attention_beauty_direction);
            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }
            else{
                holder = (BeautyViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.beautyName.setText("01. 戴安安医师");
            	holder.beautyDirection.setText("主攻方向：单眼皮");
            	break;
            case 1:
            	holder.beautyName.setText("02. 朴正纯医师");
            	holder.beautyDirection.setText("主攻方向：隆鼻");
            	break;
            default:
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
	
class BeautyViewHolder{
	public TextView beautyName;
	public TextView beautyDirection;
}
