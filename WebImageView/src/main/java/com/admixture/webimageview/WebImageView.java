package com.admixture.webimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by void on 2016/11/4.
 */

public class WebImageView extends ImageView {

    public WebImageView(Context context) {
        super(context);
    }

    public WebImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WebImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setUrl(String url) {
        try {
            setUrl(new URL(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUrl(final URL url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URLConnection conn = url.openConnection();
                    conn.setConnectTimeout(1000);
                    conn.setReadTimeout(1000);
                    final Bitmap bitmap = BitmapFactory.decodeStream((InputStream) conn.getContent());
                    getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            setImageBitmap(bitmap);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}