package com.mozhimen.kotlin.utilk.java.lang

import com.mozhimen.kotlin.utilk.android.os.UtilKLooper

/**
 * @ClassName UtilKThread
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/25 0:03
 * @Version 1.0
 */
object UtilKThread {
    @JvmStatic
    fun get_ofCurrent(): Thread =
        Thread.currentThread()

    @JvmStatic
    fun get_ofMainLooper(): Thread =
        UtilKLooper.getThread_main()

    /////////////////////////////////////////////////////////

    @JvmStatic
    fun getName_ofCurrent(): String =
        get_ofCurrent().name

    @JvmStatic
    fun getStackTrace_ofCurrent(): Array<StackTraceElement> =
        get_ofCurrent().stackTrace
}