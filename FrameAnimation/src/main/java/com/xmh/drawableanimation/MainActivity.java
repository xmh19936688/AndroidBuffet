package com.xmh.drawableanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.iamge)ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //在屏幕获得焦点之后调用动画开始，注意不能在onCreate中调用
        if(hasFocus){
            initAnimation();
        }
    }

    private void initAnimation() {
        //获取动画并开启动画
        AnimationDrawable animationXml = (AnimationDrawable) image.getBackground();
        animationXml.start();
    }
}
