package com.bupt.umi.userinterface.home;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import com.bupt.umi.R;

public class SearchActivity extends Activity {

	private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCustomActionBar();
		setContentView(R.layout.activity_search);
		doSearchQuery(getIntent()); 
    }

    @Override 
    protected void onNewIntent(Intent intent) {  //activity重新置顶
        super.onNewIntent(intent); 
        doSearchQuery(intent); 
    } 
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.search, menu);	
		// 获取搜索服务管理器  
	    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE); 
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView(); 
		// searchable activity的component name，由此系统可通过intent进行唤起
	    ComponentName cn = new ComponentName(this,SearchActivity.class); 
	    // 通过搜索管理器，从searchable activity中获取相关搜索信息，就是searchable的xml设置。如果返回null，表示该activity不存在，或者不是searchable
	    SearchableInfo info = searchManager.getSearchableInfo(cn); 
	    if(info == null){ 
	        Log.e("SearchableInfo","Fail to get search info."); 
	    }      
	    // 将searchable activity的搜索信息与search view关联
	    searchView.setSearchableInfo(info); 
	    return true; 
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
		case android.R.id.home:
            finish();
			break;
		default:
			break;
		}
        return super.onOptionsItemSelected(item);
	}
	
	private void doSearchQuery(Intent intent){  
//        if(intent == null) 
//            return; 
//
//        String queryAction = intent.getAction(); 
//        if( Intent.ACTION_SEARCH.equals( intent.getAction())){  //如果是通过ACTION_SEARCH来调用，即如果通过搜索调用 
//            String queryString = intent.getStringExtra(SearchManager.QUERY); //获取搜索内容
//        }  
         
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
