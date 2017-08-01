package com.bupt.umi.userinterface.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bupt.umi.R;
import com.bupt.umi.StopDetailsActivity;
import com.bupt.umi.qrscan.CaptureActivity;
import com.bupt.umi.userinterface.home.SearchActivity;
import com.bupt.umi.userinterface.map.MapActivity;

/**
 * @author Azure Wang
 *	功能描述：线路fragment页面
 */
public class HomeFragment extends Fragment{

//	private View mParent;
	
//	private FragmentActivity mActivity;
//	private TitleView mTitle;
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	HomeAdapter homeAdapter = null;
	
	protected View layoutMain = null;
	
	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static HomeFragment newInstance(int index) {
		HomeFragment f = new HomeFragment();

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
		setHasOptionsMenu(true);
		if(layoutMain == null) {
			layoutMain = inflater.inflate(R.layout.fragment_home, container, false);
			setHasOptionsMenu(true);
			// 
			myList = (ListView)layoutMain.findViewById(R.id.list_item_home);
			//得到一个MyAdapter对象
			homeAdapter = new HomeAdapter(inflater.getContext());
			//为ListView绑定Adapter 
			myList.setAdapter(homeAdapter);
		}
		
		//为Listview绑定监听器
		myList.setOnItemClickListener(new OnItemClickListener(){
    	 
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
			switch (position) {
			case -1:
				break;
			default:
            	startActivity(new Intent(getActivity(), StopDetailsActivity.class));
				break;
			}
        }
         
    });	
		return layoutMain;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		mActivity = getActivity();
//		mParent = getView();

//		mTitle = (TitleView) mParent.findViewById(R.id.title);
//		mTitle.setTitle(R.string.title_home);
//		mTitle.setLeftButton(R.string.exit, new OnLeftButtonClickListener(){
//
//			@Override
//			public void onClick(View button) {
//				mActivity.finish();
//			}
//			
//		});
//		mTitle.setRightButton(R.drawable.main_option, new OnRightButtonClickListener() {
//
//			@Override
//			public void onClick(View button) {
//				popUpMyOverflow();
//			}
//		});

		
	}
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	        inflater.inflate(R.menu.home, menu);
	        super.onCreateOptionsMenu(menu,inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
        case R.id.action_more:
        	// 这里是重点
//            PopupMenu popupMenu = new PopupMenu(this,findViewById(R.id.home_action_more));
//            popupMenu.inflate(R.menu.home);
//            popupMenu.setOnMenuItemClickListener(this);
        	break;
        case R.id.home_option_scan:
        	startActivity(new Intent(getActivity(), CaptureActivity.class));
			break;
        case R.id.home_option_search:
        	startActivity(new Intent(getActivity(), SearchActivity.class));
            break;	
        case R.id.home_option_nearby_site:
        	startActivity(new Intent(getActivity(), MapActivity.class));
            break;
        }
        return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}

@SuppressLint("InflateParams")
class HomeAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	public HomeAdapter(Context context) {
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
			
			
			HomeViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_home, null);
            	
            	holder = new HomeViewHolder();

            	holder.companyName = (TextView)convertView.findViewById(R.id.home_company_name);
            	holder.routeName = (TextView)convertView.findViewById(R.id.home_route_name);
            	holder.privateMark = (ImageView)convertView.findViewById(R.id.home_is_private);
            	holder.alarmMark = (ImageView)convertView.findViewById(R.id.home_alarm_mark);
            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }
            else{
                holder = (HomeViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.companyName.setText("审美");
            	holder.routeName.setText("去头油就这么简单");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.alarmMark.setVisibility(View.VISIBLE);
            	break;
            case 1:
            	holder.companyName.setText("审美");
            	holder.routeName.setText("爱上卷发");
            	holder.privateMark.setVisibility(View.VISIBLE);
            	holder.alarmMark.setVisibility(View.VISIBLE);
            	break;
            case 2:
            	holder.companyName.setText("PrettyTime");
            	holder.routeName.setText("想要变白，变漂亮");
            	holder.privateMark.setVisibility(View.INVISIBLE);
            	holder.alarmMark.setVisibility(View.VISIBLE);
            	break;
            case 3:
            	holder.companyName.setText("PrettyTime");
            	holder.routeName.setText("情人节微整容特惠");
            	holder.privateMark.setVisibility(View.INVISIBLE);
            	holder.alarmMark.setVisibility(View.VISIBLE);
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
	
class HomeViewHolder{
	public TextView companyName;
	public TextView routeName;
	public ImageView privateMark;
	public ImageView alarmMark;
	public TextView running_vehicle;
}
