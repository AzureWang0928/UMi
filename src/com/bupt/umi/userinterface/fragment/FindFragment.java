package com.bupt.umi.userinterface.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.find.CommunityActivity;
import com.bupt.umi.userinterface.find.PostActivity;


/**
 * @author Azure Wang
 *	功能描述：发现fragment页面
 */
public class FindFragment extends Fragment {
	
//	private View mParent;
//	
//	@SuppressWarnings("unused")
//	private FragmentActivity mActivity;
//
//	private TitleView mTitle;

	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	FindAdapter findAdapter = null;
	
	protected View layoutMain = null;
	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static FindFragment newInstance(int index) {
		FindFragment f = new FindFragment();

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
			layoutMain = inflater.inflate(R.layout.fragment_find, container, false);
			// 
			myList = (ListView)layoutMain.findViewById(R.id.list_item_find);
			//得到一个MyAdapter对象
			findAdapter = new FindAdapter(inflater.getContext());
			//为ListView绑定Adapter 
			myList.setAdapter(findAdapter);
		}
		
		//为Listview绑定监听器
		myList.setOnItemClickListener(new OnItemClickListener(){
    	 
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            // TODO Auto-generated method stub
            if(position == 0){
            	startActivity(new Intent(getActivity(), PostActivity.class));
            }
            if(position == 2){
            	startActivity(new Intent(getActivity(), CommunityActivity.class));
            }
        }
         
    });	
		
		return layoutMain;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		mParent = getView();
//		mActivity = getActivity();
//
//		mTitle = (TitleView) mParent.findViewById(R.id.title);
//		mTitle.setTitle(R.string.title_find);
//		mTitle.setLeftButton(R.string.back, new OnLeftButtonClickListener() {
//
//			@Override
//			public void onClick(View button) {
//			}
//		});
//		mTitle.hiddenLeftButton();
//		mTitle.setRightButton(R.string.help, new OnRightButtonClickListener() {
//
//			@Override
//			public void onClick(View button) {
//			}
//		});
//		mTitle.hiddenRightButton();
	}
	
	public void updateUI() {
		findAdapter.notifyDataSetChanged();
	}
}

	@SuppressLint("InflateParams")
	class FindAdapter extends BaseAdapter{
		private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
		public FindAdapter(Context context) {
			this.myInflater = LayoutInflater.from(context);
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
				
				
				FindViewHolder holder = null;
				
				//如果缓存convertView为空，则需要创建View
	            if(convertView == null){
					//根据自定义的Item布局加载布局
	                convertView = myInflater.inflate(R.layout.list_item_find, null);
	            	
	            	holder = new FindViewHolder();
	
	            	holder.findTypeMark = (ImageView)convertView.findViewById(R.id.find_type_mark);
	            	holder.findTypeName = (TextView)convertView.findViewById(R.id.find_type_name);
	                holder.nextLevelMark = (ImageView)convertView.findViewById(R.id.find_nextlevel_mark);
	            	convertView.setTag(holder);
	            }
	            else{
	                holder = (FindViewHolder)convertView.getTag();
	            }
	        	
	            switch(position){
	            case 0:
	            	holder.findTypeMark.setImageResource(R.drawable.find_type_mark_inform);
	            	holder.findTypeName.setText("排行");
	            	break;
	            case 1:
	            	holder.findTypeMark.setVisibility(View.INVISIBLE);
	            	holder.findTypeName.setVisibility(View.INVISIBLE);
	            	holder.nextLevelMark.setVisibility(View.INVISIBLE);
	            case 2:
	            	holder.findTypeMark.setImageResource(R.drawable.find_type_mark_community);
	            	holder.findTypeName.setText("社区");
	            	break;
	            }
	            if (position%2 == 0) {
		            convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
				}	              
	            return convertView;
	        }
	}	
		
	class FindViewHolder{
		public ImageView findTypeMark;
		public TextView findTypeName;
		public ImageView nextLevelMark;
	}

