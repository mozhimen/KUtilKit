package com.mozhimen.kotlin.utilk.android.view

import android.view.animation.Animation
import com.mozhimen.kotlin.utilk.kotlin.ranges.constraint


fun Animation.cancel_setAnimationListener_null() {
    UtilKAnimationWrapper.cancel_setAnimationListener_null(this)
}

//////////////////////////////////////////////////////////////////////////////////////////

object UtilKAnimationWrapper {
    /**
     * 获取时长
     * @param animation Animation
     * @return Long
     */
    @JvmStatic
    fun gainDuration(animation: Animation): Long =
        animation.duration.constraint(0, animation.duration)

    //////////////////////////////////////////////////////////////////////////////////////////

    //释放Animation
    @JvmStatic
    fun cancel_setAnimationListener_null(animation: Animation) {
        animation.cancel()
        animation.setAnimationListener(null)
    }
}