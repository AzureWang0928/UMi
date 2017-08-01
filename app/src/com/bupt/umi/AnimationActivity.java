package com.bupt.umi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class AnimationActivity extends Activity {  
    private ImageView welcomeImg = null;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_animation);  
        welcomeImg = (ImageView) this.findViewById(R.id.welcome_img);  
        AlphaAnimation anima = new AlphaAnimation(1.0f, 1.0f);  
        anima.setDuration(3000);// ���ö�����ʾʱ��  
        welcomeImg.startAnimation(anima);  
        anima.setAnimationListener(new AnimationImpl());  
    }  
  
    private class AnimationImpl implements AnimationListener {  
  
        @Override  
        public void onAnimationStart(Animation animation) { 
        }  
  
        @Override  
        public void onAnimationEnd(Animation animation) {  
            skip(); // ������������ת�����ҳ��  
        }  
  
        @Override  
        public void onAnimationRepeat(Animation animation) {  
  
        }  
  
    }  
  
    private void skip() {  
        startActivity(new Intent(this, MainActivity.class));  
        finish();  
    }  
}  