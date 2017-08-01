package com.bupt.umi;

import com.bupt.umi.userinterface.attention.LineDetailsActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class StopDetailsActivity extends Activity {

	private ActionBar actionBar;
	public Button focusButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stop_details);
		initCustomActionBar();
		focusButton =(Button)findViewById(R.id.add_to_my_focus_button);
		focusButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(StopDetailsActivity.this, "已关注该活动！", Toast.LENGTH_SHORT); 
				toast.show();
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stop_details, menu);
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
