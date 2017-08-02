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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.me.AboutUsActivity;
import com.bupt.umi.userinterface.me.CartActivity;
import com.bupt.umi.userinterface.me.RefreshingTimeActivity;
import com.bupt.umi.userinterface.me.RemindingActivity;

/**
 * @author Azure Wang
 *	功能描述：个人fragment页面
 */
public class MeFragment extends Fragment {

//	private View mParent;
//	@SuppressWarnings("unused")
//	private FragmentActivity mActivity;
//
//	private TitleView mTitle;
	
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	MeAdapter meAdapter = null;
	
	protected View layoutMain = null;
	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static MeFragment newInstance(int index) {
		MeFragment f = new MeFragment();

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
			layoutMain = inflater.inflate(R.layout.fragment_me, container, false);
			// 
			myList = (ListView)layoutMain.findViewById(R.id.list_item_me);
			//得到一个MyAdapter对象
			meAdapter = new MeAdapter(inflater.getContext());
			//为ListView绑定Adapter 
			myList.setAdapter(meAdapter);
		}
	
		//为Listview绑定监听器
		myList.setOnItemClickListener(new OnItemClickListener(){
    	 
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            // TODO Auto-generated method stub
            if(position == 0){
            	startActivity(new Intent(getActivity(), RemindingActivity.class));
            }
            if(position == 1){
            	startActivity(new Intent(getActivity(), RefreshingTimeActivity.class));
            }
            if(position == 2){
            	startActivity(new Intent(getActivity(), CartActivity.class));
            }
            if(position == 3){
            	startActivity(new Intent(getActivity(), AboutUsActivity.class));
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
//		mTitle.setTitle(R.string.title_me);
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
class MeAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	public MeAdapter(Context context) {
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
			
			
			MeViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_me, null);
            	
            	holder = new MeViewHolder();

            	holder.settingType = (TextView)convertView.findViewById(R.id.me_setting_type);
            	
            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }
            else{
                holder = (MeViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.settingType.setText("权限设置");
            	break;
            case 1:
            	holder.settingType.setText("收货地址");
            	break;
            case 2:
            	holder.settingType.setText("购物车");
            	break;
            case 3:
            	holder.settingType.setText("关于我们");
            	break;
            default:
            	break;
            }
            	              
            
            /*
			 * 设置ListView行间交替色
			 */
			if (position % 2 == 1) {
                convertView.setBackgroundColor(Color.TRANSPARENT);
            } 
			else {
                convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
            }
			
            return convertView;
        }
}	
	
class MeViewHolder{
	public TextView settingType;
}

