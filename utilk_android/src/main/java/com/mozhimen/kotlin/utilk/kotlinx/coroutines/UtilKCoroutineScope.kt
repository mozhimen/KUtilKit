package com.mozhimen.kotlin.utilk.kotlinx.coroutines

import android.view.View
import androidx.lifecycle.LiveData
import com.mozhimen.kotlin.elemk.commons.ISuspendExt_Listener
import com.mozhimen.kotlin.elemk.commons.ISuspend_AListener
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @ClassName UtilKCoroutineScope
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/30 9:41
 * @Version 1.0
 */
fun CoroutineScope.launchSafe(coroutineContext: CoroutineContext = EmptyCoroutineContext, block: ISuspendExt_Listener<CoroutineScope>) {
    UtilKCoroutineScope.launchSafe(this, coroutineContext, block)
}

//////////////////////////////////////////////////////////////////

object UtilKCoroutineScope {
    @JvmStatic
    fun getOrCreateViewScope(view: View): CoroutineScope {
        val key = "ViewScope".hashCode()
        var scope = view.getTag(key) as? CoroutineScope
        if (scope == null) {
            scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
            view.setTag(key, scope)
            val listener = object : View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View) {
                }

                override fun onViewDetachedFromWindow(v: View) {
                    scope.cancel()
                }

            }
            view.addOnAttachStateChangeListener(listener)
        }
        return scope
    }

    @JvmStatic
    fun launchOnMainScope(coroutineScope: CoroutineScope, block: ISuspendExt_Listener<CoroutineScope>) {
        coroutineScope.launch(Dispatchers.Main) {
            this.block()
        }
    }

    @JvmStatic
    fun launchOnBackScope(coroutineScope: CoroutineScope, block: ISuspendExt_Listener<CoroutineScope>) {
        coroutineScope.launch(Dispatchers.IO) {
            this.block()
        }
    }

    @JvmStatic
    fun launchSafe(coroutineScope: CoroutineScope, coroutineContext: CoroutineContext = EmptyCoroutineContext, block: ISuspendExt_Listener<CoroutineScope>) {
        coroutineScope.launch(coroutineContext) {
            try {
                this.block()
            } catch (e: Throwable) {
                UtilKLogWrapper.e(e)
            }
        }
    }
}