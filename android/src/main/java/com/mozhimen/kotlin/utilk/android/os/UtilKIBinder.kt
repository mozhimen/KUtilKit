package com.mozhimen.kotlin.utilk.android.os

import android.app.Activity
import android.os.IBinder
import android.view.Window
import com.mozhimen.kotlin.utilk.android.view.UtilKWindowManager_LayoutParams

/**
 * @ClassName UtilKIBinder
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/21
 * @Version 1.0
 */
object UtilKIBinder {
    @JvmStatic
    fun get(window: Window): IBinder =
        UtilKWindowManager_LayoutParams.get(window).token

    @JvmStatic
    fun get(activity: Activity): IBinder =
        UtilKWindowManager_LayoutParams.get(activity).token
}