package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import com.mozhimen.kotlin.elemk.android.view.cons.CWinMgr

/**
 * @ClassName UtilKWindowManagerLayoutParamsWrapepr
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/24
 * @Version 1.0
 */
object UtilKWindowManagerLayoutParamsWrapper {
    @JvmStatic
    fun isFlagTranslucentStatus(activity: Activity): Boolean =
        UtilKWindowManagerLayoutParams.getFlags(activity) and CWinMgr.Lpf.TRANSLUCENT_STATUS != 0

    @JvmStatic
    fun isFlagFullScreen(activity: Activity): Boolean =
        UtilKWindowManagerLayoutParams.getFlags(activity) and CWinMgr.Lpf.FULLSCREEN != 0

    @JvmStatic
    fun isFullScreen(activity: Activity): Boolean =
        isFlagFullScreen(activity) || !UtilKNavigationBar.isVisible(activity) || !UtilKStatusBar.isVisible(activity)
}