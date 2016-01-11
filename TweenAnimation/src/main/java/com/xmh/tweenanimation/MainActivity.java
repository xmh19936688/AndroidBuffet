package com.xmh.tweenanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.image)ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        imageView.startAnimation(animation);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!hasFocus){
            return;
        }

        AnimationSet animationSet = new AnimationSet(this, null);

        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        animationSet.addAnimation(alphaAnimation);

        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        animationSet.addAnimation(scaleAnimation);

        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        animationSet.addAnimation(translateAnimation);

        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        animationSet.addAnimation(rotateAnimation);

        imageView.startAnimation(animationSet);
    }
}
