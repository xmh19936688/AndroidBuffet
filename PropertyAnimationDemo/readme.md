#属性动画
[toc]

##明确被添加动画的控件
此处把动画添加到一个`TextView`上，被添加动画的属性为`textSize`和`alpah`。

##动画文件
**注意：**动画文件在`res/animator`下

##播放动画
```
Animator animator = AnimatorInflater.loadAnimator(this, R.animator.property_animator);
animator.setTarget(view);
animator.start();
```