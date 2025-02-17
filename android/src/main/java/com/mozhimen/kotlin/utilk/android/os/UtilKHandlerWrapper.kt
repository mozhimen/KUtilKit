package com.mozhimen.kotlin.utilk.android.os

import android.os.Handler
import android.os.Looper

/**
 * @ClassName UtilKHandlerWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/2
 * @Version 1.0
 */
object UtilKHandlerWrapper {
    private val _handler: Handler by lazy { Handler(Looper.getMainLooper()) }

    @JvmStatic
    fun get(): Handler =
        _handler

    @JvmStatic
    fun post(runnable: Runnable) {
        if (UtilKLooperWrapper.isLooperMain()) {
            runnable.run()
        } else {
            _handler.post(runnable)
        }
    }

    @JvmStatic
    fun postDelayed(delayMillis: Long, runnable: Runnable) {
        _handler.postDelayed(runnable, delayMillis)
    }
}