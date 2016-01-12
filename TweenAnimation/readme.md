#补间动画
[toc]

##明确被添加动画的控件
此处把动画添加到一个ImageView上

##针对该控件写动画文件
文件都在res/anim下，包括：透明度动画、旋转动画、形变动画、位移动画。

##播放动画
在需要开始动画的地方添加如下代码：
```
AnimationSet animationSet = new AnimationSet(this, null);

Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
animationSet.addAnimation(alphaAnimation);

Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
animationSet.addAnimation(scaleAnimation);

Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
animationSet.addAnimation(translateAnimation);

Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
animationSet.addAnimation(rotateAnimation);

imageView.startAnimation(animationSet);
```