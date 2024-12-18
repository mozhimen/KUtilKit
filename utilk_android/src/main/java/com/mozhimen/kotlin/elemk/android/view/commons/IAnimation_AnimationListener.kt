package com.mozhimen.kotlin.elemk.android.view.commons

import android.view.animation.Animation

/**
 * @ClassName IAnimation_AnimationListener
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/12/18 1:13
 * @Version 1.0
 */
interface IAnimation_AnimationListener : Animation.AnimationListener {
    override fun onAnimationStart(animation: Animation?){}
    override fun onAnimationEnd(animation: Animation?){}
    override fun onAnimationRepeat(animation: Animation?){}
}