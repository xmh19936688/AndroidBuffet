#SystemConfig

##获取系统信息
1. 获取配置
    ```
    Configuration configuration = getResources().getConfiguration();
    ```
1. 获取配置项
    ```
    configuration.orientation
    configuration.navigation
    configuration.touchscreen
    ...
    ```

##监听系统信息改变
1. 在Activity中重写`onConfigurationChanged()`方法
1. 在Manifest.xml中对应修改Activity
    ```
    <activity
        android:configChanges="orientation">
    </activity>
    ```