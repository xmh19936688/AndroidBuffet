package com.xmh.sampleofcontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by mengh on 2016/1/19 019.
 */
public class InfoProvider extends ContentProvider {

    //Uri匹配器
    private static UriMatcher matcher;

    //region 一组枚举值
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int UPDATE = 3;
    private static final int QUERY = 4;
    private static final int QUERY_ONE = 5;
    //endregion

    //用于匹配的Uri
    private static String URI_PROVIDER="com.xmh.sampleofcontentprovider";
    //数据库名
    private static String SQL_NAME="info_sql";
    //表名
    private static String TABLE_NAME="t_info";

    //数据库操作对象
    private  SQLiteDatabase database;

    static {
        //添加一组匹配规则
        matcher= new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(URI_PROVIDER,"insert",INSERT);
        matcher.addURI(URI_PROVIDER,"delete",DELETE);
        matcher.addURI(URI_PROVIDER,"update",UPDATE);
        matcher.addURI(URI_PROVIDER,"query",QUERY);

        matcher.addURI(URI_PROVIDER,"query/#",QUERY_ONE);
    }

    @Override
    public boolean onCreate() {

        //初始化一个测试用的数据库（app每启动一次都会插入两行数据）
        database= getContext().openOrCreateDatabase(SQL_NAME, Context.MODE_PRIVATE, null);
        database.execSQL("create table if not exists "+TABLE_NAME+"(id varchar(10),name varchar(10),age int)");
        database.execSQL("INSERT INTO "+TABLE_NAME+" VALUES ('001','aa', 10)");
        database.execSQL("INSERT INTO "+TABLE_NAME+" VALUES ('002','bb', 20)");

        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        //匹配URI
        if(matcher.match(uri)==QUERY){
            //执行查询语句并返回游标
            Cursor cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
            //因为游标还要使用，注意不要关闭数据库
            return cursor;
        }else if(matcher.match(uri)==QUERY_ONE){
            //根据age查询一条数据
            long age= ContentUris.parseId(uri);
            Cursor cursor = database.query(TABLE_NAME, projection, "age=?", new String[]{age + ""}, null, null, sortOrder);
            return cursor;
        }else {
            Log.e("xmh","query-error:"+uri);
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        if(matcher.match(uri)==QUERY){
            //dir表示一组数据
            return "vnd.android.cursor.dir/beanname";
        }else if(matcher.match(uri)==QUERY_ONE){
            //item表示一项数据
            return "vnd.android.cursor.item/beanname";
        }else{
            Log.e("xmh","type-error:"+uri);
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //匹配URI
        if(matcher.match(uri)==INSERT){
            database.insert(TABLE_NAME,null,values);
        }else {
            Log.e("xmh","insert-error:"+uri);
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        //匹配URI
        if(matcher.match(uri)==DELETE){
            //执行删除并返回受影响行数
            return database.delete(TABLE_NAME, selection, selectionArgs);
        }else {
            Log.e("xmh","delete-error:"+uri);
        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        //匹配UIR
        if(matcher.match(uri)==UPDATE){
            //执行修改并返回受影响行数
            return database.update(TABLE_NAME,values,selection,selectionArgs);
        }else {
            Log.e("xmh","update-error:"+uri);
        }
        return 0;
    }
}
