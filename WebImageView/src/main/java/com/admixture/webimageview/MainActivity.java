package com.admixture.webimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebImageView webImageView = new WebImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        webImageView.setLayoutParams(layoutParams);
        ((RelativeLayout)findViewById(R.id.layout)).addView(webImageView);
        webImageView.setUrl("https://avatars0.githubusercontent.com/u/104009?v=3&s=40");

    }
}
