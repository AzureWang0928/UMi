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
 *	��������������fragmentҳ��
 */
public class MeFragment extends Fragment {

//	private View mParent;
//	@SuppressWarnings("unused")
//	private FragmentActivity mActivity;
//
//	private TitleView mTitle;
	
	//����һ��Listview�ռ䣨����������fragment_test.xml �������� RelativeLayout��
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
			//�õ�һ��MyAdapter����
			meAdapter = new MeAdapter(inflater.getContext());
			//ΪListView��Adapter 
			myList.setAdapter(meAdapter);
		}
	
		//ΪListview�󶨼�����
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
	private LayoutInflater myInflater = null; //�õ�һ��LayoutInfalter�����������벼��
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
			
			//�������convertViewΪ�գ�����Ҫ����View
            if(convertView == null){
				//�����Զ����Item���ּ��ز���
                convertView = myInflater.inflate(R.layout.list_item_me, null);
            	
            	holder = new MeViewHolder();

            	holder.settingType = (TextView)convertView.findViewById(R.id.me_setting_type);
            	
            	//�����úõĲ��ֱ��浽�����У�������������Tag��Ա���淽��ȡ��Tag
                convertView.setTag(holder);
            }
            else{
                holder = (MeViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.settingType.setText("Ȩ������");
            	break;
            case 1:
            	holder.settingType.setText("�ջ���ַ");
            	break;
            case 2:
            	holder.settingType.setText("���ﳵ");
            	break;
            case 3:
            	holder.settingType.setText("��������");
            	break;
            default:
            	break;
            }
            	              
            
            /*
			 * ����ListView�м佻��ɫ
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

