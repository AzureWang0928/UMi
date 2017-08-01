package com.bupt.umi.userinterface.me;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.find.PublicCommunityActivity;
import com.bupt.umi.userinterface.fragment.MeFragment;

public class AboutUsActivity extends FragmentActivity {

	private ActionBar actionBar;
	private TextView tvTitle;
	private Button leftButton; 
	private ImageButton rightButton;
	public Button submitButton;
	public TextView commondTextView;
	public EditText inputText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		getWindow().requestFeature(Window.FEATURE_CUSTOM_TITLE);
//	    setContentView(R.layout.activity_animation);
//		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_view);
		setContentView(R.layout.activity_about_us);
		initCustomActionBar();
		submitButton = (Button)findViewById(R.id.me_about_us_submit);
		commondTextView = (TextView)findViewById(R.id.me_about_us_command);
		inputText = (EditText)findViewById(R.id.me_about_us_input);
		submitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!(inputText.getText().equals(""))) {
					commondTextView.setText(System.currentTimeMillis() + "\n" + inputText.getText());
					Toast toast = Toast.makeText(AboutUsActivity.this, "反馈已收到！\n我们会尽快审核并给您一个答复^_^", Toast.LENGTH_SHORT); 
					toast.show();
				}
				else {
					Toast toast = Toast.makeText(AboutUsActivity.this, "请输入您的意见！", Toast.LENGTH_SHORT); 
					toast.show();
				}
				inputText.setText("");
				
				
			}
		});
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_us, menu);
		return true;
	}

	@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
