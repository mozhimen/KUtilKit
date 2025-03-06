package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.view.View
import android.view.Window
import com.mozhimen.kotlin.utilk.wrapper.UtilKStatusBar
import kotlin.math.abs

/**
 * @ClassName UtilKContentViewWrapper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/3/16 22:57
 * @Version 1.0
 */
object UtilKContentViewWrapper {

    @JvmStatic
    fun getInvisibleHeight(activity: Activity): Int =
        getInvisibleHeight(UtilKWindow.get(activity))

    @JvmStatic
    fun getInvisibleHeight(window: Window): Int {
        val contentView = UtilKContentView.get_window<View>(window)
        val outRect = UtilKContentView.getWindowVisibleDisplayFrame(window)
        val delta = abs(contentView.bottom - outRect.bottom)
        return if (delta <= UtilKStatusBar.getHeight() + UtilKNavigationBar.getHeight()) 0
        else delta
    }

    /**
     * 获取View绘制区域TOP高度
     * 注: 在Activity的回调方法onWindowFocusChanged()执行后,才能得到预期结果
     */
    @JvmStatic
    fun getViewDrawHeight(activity: Activity): Int =
        UtilKContentView.getTop(activity)
}