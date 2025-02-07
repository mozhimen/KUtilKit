package com.mozhimen.kotlin.utilk.android.os

import android.os.HandlerThread

/**
 * @ClassName UtilKHandlerThread
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/2/5 0:24
 * @Version 1.0
 */
object UtilKHandlerThread {
    @JvmStatic
    fun get(name: String): HandlerThread =
        HandlerThread(name)
}