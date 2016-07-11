#Android自助餐同步代码

##FrameAnimation
带帧动画的ImageView
- 动画xml文件在`drawable`下（animation.xml）
- ImageView的src设置为`@drawable/animation`
- 播放的时候在java中写
```
AnimationDrawable animationXml = (AnimationDrawable) image.getBackground();
animationXml.start();
```

##PropertyAnimationDemo
属性动画使用demo
- 字体大小
- 透明度

##TweenAnimation
补间动画demo
- 透明图
- 旋转
- 形变
- 位移

##MutilLunchActivityDemo
多个启动图标的应用，每个图标点击进入一个activity

##SampleOfContentProvider(Other)
ContentProvider使用demo

##UseOfEventBus
EventBus使用

##SystemConfig
读取系统信息，监听系统信息改变

##SampleOfAndroidListener
**TOTO**监听android系统广播