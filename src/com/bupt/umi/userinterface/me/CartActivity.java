package com.bupt.umi.userinterface.me;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bupt.umi.R;
import com.bupt.umi.userinterface.attention.LineDetailsActivity;

public class CartActivity extends Activity {

	private ActionBar actionBar;
	//声明一个Listview空间（撑满了整个fragment_test.xml 布局属性 RelativeLayout）
	ListView myList = null;
	CartAdapter cartAdapter = null;	
	public Button payButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		
		initCustomActionBar();
		payButton = (Button)findViewById(R.id.pay_button);
		payButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(CartActivity.this, "已支付", Toast.LENGTH_SHORT); 
				toast.show();				
			}
		});
		myList = (ListView)findViewById(R.id.list_item_cart);
		//得到一个MyAdapter对象
		cartAdapter = new CartAdapter(this);
		//为ListView绑定Adapter 
		myList.setAdapter(cartAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cart, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
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

@SuppressLint("InflateParams")
class CartAdapter extends BaseAdapter{
	private LayoutInflater myInflater = null; //得到一个LayoutInfalter对象用来导入布局
	@SuppressWarnings("unused")
	private Context myContext = null;
	
	public CartAdapter(Context context) {
		this.myInflater = LayoutInflater.from(context);
		this.myContext = context;
   	}
        	
	@Override
	public int getCount() {
		
		return 2;
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
			
			
			CartViewHolder holder = null;
			
			//如果缓存convertView为空，则需要创建View
            if(convertView == null){
				//根据自定义的Item布局加载布局
                convertView = myInflater.inflate(R.layout.list_item_cart, null);
            	
            	holder = new CartViewHolder();
            	
            	holder.productImage = (ImageView)convertView.findViewById(R.id.product_image);
            	holder.productName = (TextView)convertView.findViewById(R.id.product_name);
            	holder.productPrice = (TextView)convertView.findViewById(R.id.product_price);
            	holder.productNumber = (TextView)convertView.findViewById(R.id.product_number);
            	holder.checkPay = (CheckBox)convertView.findViewById(R.id.check_pay);
            	//将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }
            else{
                holder = (CartViewHolder)convertView.getTag();
            }
        	
            switch(position){
            case 0:
            	holder.productImage.setBackgroundResource(R.drawable.product_photo);
            	holder.productName.setText("水光美白面膜");
            	holder.productPrice.setText("￥85");
            	holder.productNumber.setText("x2");
            	holder.checkPay.setChecked(true);
            	break;
            case 1:
            	holder.productImage.setBackgroundResource(R.drawable.product_photo2);
            	holder.productName.setText("多芬护发素");
            	holder.productPrice.setText("￥59");
            	holder.productNumber.setText("x1");
            	holder.checkPay.setChecked(true);
            	break;
            default:
            	break;
            }
            if (position%2 == 0 ) {
				convertView.setBackgroundColor(Color.argb(40, 125, 125, 125));
			}	              
            
            return convertView;
        }
}	
	
class CartViewHolder{
	public ImageView productImage;
	public TextView productName;
	public TextView productPrice;
	public TextView productNumber;
	public CheckBox checkPay;
}



