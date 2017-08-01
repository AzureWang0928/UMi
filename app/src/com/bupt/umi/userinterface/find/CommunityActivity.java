package com.bupt.umi.userinterface.find;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.me.RefreshingTimeActivity;

public class CommunityActivity extends Activity{

	private ActionBar actionBar;
	private TextView tvTitle;
	private Button leftButton; 
	private ImageButton rightButton;
	Button publicCommunity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_community);
		initCustomActionBar();

		publicCommunity = (Button) findViewById(R.id.public_community);
		
		publicCommunity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
            	startActivity(new Intent(CommunityActivity.this, PublicCommunityActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.community, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
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
