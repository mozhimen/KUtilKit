package com.mozhimen.kotlin.utilk.java.lang

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.mozhimen.kotlin.elemk.commons.ISuspendExt_Listener
import com.mozhimen.kotlin.elemk.commons.ISuspend_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.os.UtilKHandlerWrapper
import com.mozhimen.kotlin.utilk.java.lang.UtilKThread.get_ofCurrent
import com.mozhimen.kotlin.utilk.java.lang.UtilKThread.get_ofMainLooper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @ClassName UtilKThreadWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/28
 * @Version 1.0
 */
object UtilKThreadWrapper {

    /**
     * 是否是主线程
     */
    @JvmStatic
    fun isMainThread(): Boolean =
        get_ofMainLooper() == get_ofCurrent()

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun safeSleep(delayMillis: Long) {
        try {
            Thread.sleep(delayMillis)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun runOnMainThread(block: I_Listener) {
        if (isMainThread()) {
            block.invoke()
        } else {
            UtilKHandlerWrapper.post {
                block.invoke()
            }
        }
    }

    @JvmStatic
    fun runOnMainThread(lifecycleOwner: LifecycleOwner, block: ISuspendExt_Listener<CoroutineScope>) {
        if (isMainThread()) {
            runBlocking { lifecycleOwner.lifecycleScope.block() }
        } else
            lifecycleOwner.lifecycleScope.launch(Dispatchers.Main) { block() }
    }

    @JvmStatic
    fun runOnBackThread(lifecycleOwner: LifecycleOwner, block: ISuspendExt_Listener<CoroutineScope>) {
        if (isMainThread())
            lifecycleOwner.lifecycleScope.launch(Dispatchers.IO) { block() }
        else
            runBlocking { lifecycleOwner.lifecycleScope.block() }
    }


    @JvmStatic
    suspend fun runOnMainThread_ofSuspend(block: ISuspend_Listener) {
        if (isMainThread())
            block.invoke()
        else
            withContext(Dispatchers.Main) { block.invoke() }
    }

    @JvmStatic
    suspend fun runOnBackThread_ofSuspend(block: ISuspend_Listener) {
        if (isMainThread())
            withContext(Dispatchers.IO) { block.invoke() }
        else
            block.invoke()
    }
}