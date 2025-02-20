package com.mozhimen.kotlin.utilk.android.view

import android.view.MotionEvent

/**
 * @ClassName UtilKMotionEvent
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/20
 * @Version 1.0
 */
object UtilKMotionEvent {
    /**
     * rawX是绝对坐标，是相对于屏幕左上角的横坐标，
     * view本身没有getRawX的方法，这个方法一般在MotionEvent对象里使用。
     */
    @JvmStatic
    fun gainRawX(motionEvent: MotionEvent): Float =
        motionEvent.rawX

    /**
     * getX()是表示Widget相对于自身左上角的x坐标,
     */
    @JvmStatic
    fun gainX(motionEvent: MotionEvent): Float =
        motionEvent.x
}