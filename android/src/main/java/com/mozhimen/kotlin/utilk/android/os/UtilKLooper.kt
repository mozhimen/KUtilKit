package com.mozhimen.kotlin.utilk.android.os

import android.os.Looper
import com.mozhimen.kotlin.elemk.commons.I_Listener

/**
 * @ClassName UtilKLooper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/28 23:13
 * @Version 1.0
 */
object UtilKLooper {
    @JvmStatic
    fun get_main(): Looper =
        getMainLooper()

    @JvmStatic
    fun get_my(): Looper? =
        getMyLooper()

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getMainLooper(): Looper =
        Looper.getMainLooper()

    @JvmStatic
    fun getMyLooper(): Looper? =
        Looper.myLooper()

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getThread_main(): Thread =
        get_main().thread

    @JvmStatic
    fun getThread_my(): Thread? =
        get_my()?.thread
}