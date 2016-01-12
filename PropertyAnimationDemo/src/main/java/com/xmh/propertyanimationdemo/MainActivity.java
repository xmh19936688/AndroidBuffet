package com.xmh.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus)
            return;
        initAnim();
    }

    private void initAnim() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.property_animator);
        animator.setTarget(view);
        animator.start();
    }
}
