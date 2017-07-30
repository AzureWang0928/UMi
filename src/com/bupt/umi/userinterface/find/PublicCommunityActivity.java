package com.bupt.umi.userinterface.find;

import com.bupt.umi.R;
import com.bupt.umi.R.id;
import com.bupt.umi.R.layout;
import com.bupt.umi.R.menu;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PublicCommunityActivity extends Activity {

	private ActionBar actionBar;
	private TextView tvTitle;
	private Button leftButton; 
	private ImageButton rightButton;
	public Button beQuick;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_public_community);
		initCustomActionBar();
		beQuick = (Button)findViewById(R.id.be_quick);
		beQuick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(PublicCommunityActivity.this, "已收到！\n我们会尽快努力的^_^", Toast.LENGTH_SHORT); 
				toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.public_community, menu);
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
