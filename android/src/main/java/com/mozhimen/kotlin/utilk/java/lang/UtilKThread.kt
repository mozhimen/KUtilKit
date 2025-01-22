package com.mozhimen.kotlin.utilk.java.lang

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.mozhimen.kotlin.elemk.commons.ISuspendExt_Listener
import com.mozhimen.kotlin.elemk.commons.ISuspend_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.os.UtilKHandlerWrapper
import com.mozhimen.kotlin.utilk.android.os.UtilKLooper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

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
        UtilKLooper.getThread_ofMain()

    /////////////////////////////////////////////////////////

    @JvmStatic
    fun getName_ofCurrent(): String =
        get_ofCurrent().name

    @JvmStatic
    fun getStackTrace_ofCurrent(): Array<StackTraceElement> =
        get_ofCurrent().stackTrace
}