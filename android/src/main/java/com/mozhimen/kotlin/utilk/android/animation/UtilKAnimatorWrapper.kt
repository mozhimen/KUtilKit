package com.mozhimen.kotlin.utilk.android.animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import kotlin.math.max

/**
 * @ClassName UtilKAnimator
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/22 23:06
 * @Version 1.0
 */
fun Animator.cancel_removeAll_AllUpdateListeners() {
    UtilKAnimatorWrapper.cancel_removeAll_AllUpdateListeners(this)
}

fun Animator.removeAll_AllUpdateListeners() {
    UtilKAnimatorWrapper.removeAll_AllUpdateListeners(this)
}


//////////////////////////////////////////////////////////////////////////////////////////

object UtilKAnimatorWrapper {
    /**
     * 获取时长
     * @param animator Animator
     * @return Long
     */
    @JvmStatic
    fun gainDuration(animator: Animator): Long {
        var duration: Long
        if (animator is AnimatorSet) {
            duration = animator.duration
            if (duration <= 0) {
                for (childAnimation in animator.childAnimations)
                    duration = max(duration, childAnimation.duration)
            }
        } else duration = animator.duration
        return if (duration <= 0) 0 else duration
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 释放Animator
     */
    @JvmStatic
    fun cancel_removeAll_AllUpdateListeners(animator: Animator) {
        animator.cancel()
        removeAll_AllUpdateListeners(animator)
    }

    @JvmStatic
    fun removeAll_AllUpdateListeners(animator: Animator) {
        animator.removeAllListeners()
        if (animator is ValueAnimator) {
            UtilKValueAnimator.removeAllUpdateListeners(animator)
        }
    }
}