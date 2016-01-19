package com.xmh.useofeventbus;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity{

    @Bind(R.id.tv_text)TextView textView;
    //定义EventBus实例（本例只在此类中进行event的post和接收，因此定义为成员变量，跨对象发送处理event需要保证EventBus对象为同一个）
    private EventBus eventBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //实例化eventbus
        eventBus=EventBus.builder().build();
        //在onCreate中将自身注册到bus
        eventBus.register(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Event event=new Event();
                event.result="result";
                //在任意需要发送事件的地方调用post，参数为自定义类（见下）
                eventBus.post(event);
            }
        }).start();
    }

    //接到事件后在主线程消费事件
    public void onEventMainThread(Event event){
        Toast.makeText(MainActivity.this, event.result, Toast.LENGTH_SHORT).show();
        textView.setText(event.result);
    }

    //接到事件后在事件post的线程中消费事件（注意不能进行耗时操作，否则影响事件传递）（不建议使用）
    public void onEvent(Event event){
        Log.e("xmh", event.result);
    }

    //在后台线程中消费事件。如果事件的post线程为后台线程，则使用post线程，否则在新的子线程中消费事件（不建议使用）
    public void onEventBackgroundThread(Event event){
        Log.e("xmh-back", event.result);
    }

    //在新的子线程中消费事件。
    public void onEventAsync(Event event){
        Log.e("xmh-async", event.result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在onDestroy时将自身从bus注销
        eventBus.unregister(this);
    }

    //自定义一个事件类，类名与结构均不限制
    class Event{
        public String result="default";
    }
}
