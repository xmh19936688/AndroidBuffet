package com.xmh.sampleofcontentproviderother;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_text)TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        requestQuery();
//        requestDelete();
//        requestUpdate();
//        requestInsert();
    requestOne();
    }

    //查询请求
    private void requestQuery() {
        //得到内容提供中间件
        ContentResolver resolver = getContentResolver();
        //生成URI
        Uri uri=Uri.parse("content://com.xmh.sampleofcontentprovider/query");
        //请求获取游标
        Cursor cursor = resolver.query(uri, null, null, null, null);
        //处理查询结果
        while(cursor.moveToNext()){
            String id=cursor.getString(cursor.getColumnIndex("id"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            Log.e("xmh","id="+id+",name="+name+"age="+age);
            textView.setText("id="+id+",name="+name+",age="+age);
        }
        //关闭游标
        cursor.close();
    }

    //删除请求
    private void requestDelete() {
        //得到内容提供中间件
        ContentResolver resolver = getContentResolver();
        //生成URI
        Uri uri=Uri.parse("content://com.xmh.sampleofcontentprovider/delete");
        //请求删除
        int delete = resolver.delete(uri, "id = ?", new String[]{"001"});

        textView.setText("delete:" + delete);

    }

    //修改请求
    private void requestUpdate() {
        //得到内容提供中间件
        ContentResolver resolver=getContentResolver();
        //生成URI
        Uri uri=Uri.parse("content://com.xmh.sampleofcontentprovider/update");
        //请求修改
        ContentValues contentValues = new ContentValues();
        contentValues.put("age",50);
        int count=resolver.update(uri, contentValues, "id=?", new String[]{"002"});
        textView.setText("update:" + count);
    }

    //请求插入数据
    private void requestInsert() {
        //得到中间件
        ContentResolver resolver=getContentResolver();
        //生成URI
        Uri uri=Uri.parse("content://com.xmh.sampleofcontentprovider/insert");
        //请求插入数据
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "beda");
        resolver.insert(uri, contentValues);
    }

    //请求查询数据类型
    private void requestOne() {
        //得到中间件
        ContentResolver resolver=getContentResolver();
        //生成URI
        Uri uri=Uri.parse("content://com.xmh.sampleofcontentprovider/query/10");
        //请求获取游标
        Cursor cursor = resolver.query(uri, null, null, null, null);
        //处理查询结果
        while(cursor.moveToNext()){
            String id=cursor.getString(cursor.getColumnIndex("id"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int age = cursor.getInt(cursor.getColumnIndex("age"));
            Log.e("xmh","id="+id+",name="+name+"age="+age);
            textView.setText("id="+id+",name="+name+",age="+age);
        }
        //关闭游标
        cursor.close();
    }
}
