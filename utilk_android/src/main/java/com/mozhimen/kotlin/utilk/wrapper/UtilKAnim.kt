package com.mozhimen.kotlin.utilk.wrapper

import android.animation.Animator
import android.app.Activity
import android.transition.Transition
import android.view.View
import android.view.animation.Animation
import androidx.annotation.RequiresApi
import androidx.annotation.TransitionRes
import android.transition.TransitionInflater
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.animation.UtilKAnimator
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityWrapper
import com.mozhimen.kotlin.utilk.android.transition.UtilKTransitionInflater
import com.mozhimen.kotlin.utilk.android.view.UtilKAnimation
import com.mozhimen.kotlin.utilk.android.view.UtilKWindow
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKAnim
 * @Description 不推荐直接使用,因为属性动画需要不及时释放,会造成内存泄露
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/4/18 0:25
 * @Version 1.0
 */

fun View.stopAnim() {
    UtilKAnim.stopAnim(this)
}

object UtilKAnim : BaseUtilK() {
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun applyActivityTransition(activity: Activity, enterTransition: Transition?, exitTransition: Transition?, overlay: Boolean = true) {
        UtilKActivityWrapper.requestWindowFeature_ofCONTENT_TRANSITIONS(activity)
        enterTransition?.let { UtilKWindow.applyEnterTransition(activity, it) }
        exitTransition?.let { UtilKWindow.applyExitTransition(activity, it) }
        UtilKWindow.applyAllowEnterTransitionOverlap(activity, overlay)
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun applyActivityTransition(activity: Activity, @TransitionRes intEnterTransitionRes: Int?, @TransitionRes intExitTransitionRes: Int?, overlay: Boolean = true) {
        applyActivityTransition(
            activity,
            intEnterTransitionRes?.let { UtilKTransitionInflater.from_inflateTransition(activity, it) },
            intExitTransitionRes?.let { UtilKTransitionInflater.from_inflateTransition(activity,it) },
            overlay
        )
    }

    /**
     * 释放Anim
     */
    @JvmStatic
    fun releaseAnim(vararg objs: Any) {
        if (objs.isEmpty()) return
        for (obj in objs) {
            if (obj is Animation) UtilKAnimation.cancel_releaseAnimationListener(obj)
            else if (obj is Animator) UtilKAnimator.cancel_removeAllListeners(obj)
        }
    }

    /**
     * 停止View的Anim
     */
    @JvmStatic
    fun stopAnim(view: View) {
        view.apply {
            animation?.cancel()
            clearAnimation()
        }
    }
}