package com.xmh.systemconfig;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String str="";
        Configuration configuration = getResources().getConfiguration();

        //region orientation
        str=configuration.orientation==Configuration.ORIENTATION_LANDSCAPE?"横屏":"竖屏";
        Log.e("orientation",str);
        //endregion

        //region navigation
        switch (configuration.navigation){
            case Configuration.NAVIGATION_DPAD:
                str="dpad";
                break;
            case Configuration.NAVIGATION_NONAV:
                str="nonav";
                break;
            case Configuration.NAVIGATION_TRACKBALL:
                str="trackball";
                break;
            case Configuration.NAVIGATION_UNDEFINED:
                str="undefined";
                break;
            case Configuration.NAVIGATION_WHEEL:
                str="wheel";
                break;
        }
        Log.e("navigation",str);
        //endregion

        //region touch
        str=configuration.touchscreen==Configuration.TOUCHSCREEN_FINGER?"无":"触";
        Log.e("touch",str);
        //endregion

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("new",newConfig.toString());
    }
}
