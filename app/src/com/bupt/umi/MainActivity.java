package com.bupt.umi;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.fragment.FragmentIndicator;
import com.bupt.umi.userinterface.fragment.FragmentIndicator.OnIndicateListener;

/**
 * @author Azure Wang
 *	功能描述：主Activity类
 */
public class MainActivity extends FragmentActivity{

	public static Fragment[] mFragments;
	private ActionBar actionBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initCustomActionBar();
		setFragmentIndicator(0);
	}

	/**
	 * 初始化fragment
	 */
	private void setFragmentIndicator(int whichIsDefault) {
		mFragments = new Fragment[4];
		mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fragment_home);
		mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fragment_attention);
		mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fragment_find);
		mFragments[3] = getSupportFragmentManager().findFragmentById(R.id.fragment_me);
		getSupportFragmentManager().beginTransaction().hide(mFragments[0])
				.hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]).show(mFragments[whichIsDefault]).commit();
		FragmentIndicator mIndicator = (FragmentIndicator) findViewById(R.id.indicator);
		FragmentIndicator.setIndicator(whichIsDefault);
		mIndicator.setOnIndicateListener(new OnIndicateListener() {
			@Override
			public void onIndicate(View v, int which) {
				switch (which) {
				case 0:
					actionBar.setTitle("关注");
					break;
				case 1:
					actionBar.setTitle("服务");
					break;
				case 2:
					actionBar.setTitle("产品");
					break;
				case 3:
					actionBar.setTitle("我");
					break;
				default:
					break;
				}
				getSupportFragmentManager().beginTransaction()
						.hide(mFragments[0]).hide(mFragments[1])
						.hide(mFragments[2]).hide(mFragments[3]).show(mFragments[which]).commit();
			}
		});
	}

	public boolean initCustomActionBar(){
		actionBar = getActionBar();
		if(actionBar == null){
			return false;
		}
		actionBar.setTitle("关注");
		return true;
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}


}
