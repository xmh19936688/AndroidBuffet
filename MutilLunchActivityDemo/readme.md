#带多个启动图标的应用
[toc]

##设置为启动activity
在`清单文件`中需要显示到`启动器`上的`activity`标签体中添加如下代码即可
```
<intent-filter>
    <action android:name="android.intent.action.MAIN" />
    <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```

##设置activity的显示标签
```
<activity
    android:label="name"
    />
```

##设置activiyt的显示icon
```
<activity
    android:icon="@drawable/name"
    />
```