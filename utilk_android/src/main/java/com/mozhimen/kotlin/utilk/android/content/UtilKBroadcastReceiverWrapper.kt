package com.mozhimen.kotlin.utilk.android.content

import android.content.BroadcastReceiver
import com.mozhimen.kotlin.elemk.commons.ISuspendExt_Listener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @ClassName UtilKBroadcastReceiverWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/27
 * @Version 1.0
 */
fun BroadcastReceiver.goAsyncOnCoroutine(
    context: CoroutineContext = EmptyCoroutineContext,
    block: ISuspendExt_Listener<CoroutineScope>,
) {
    UtilKBroadcastReceiverWrapper.goAsyncOnCoroutine(this, context, block)
}

/////////////////////////////////////////////////////////////////////////

object UtilKBroadcastReceiverWrapper {
    @JvmStatic
    fun goAsyncOnCoroutine(
        broadcastReceiver: BroadcastReceiver,
        context: CoroutineContext = EmptyCoroutineContext,
        block: ISuspendExt_Listener<CoroutineScope>,
    ) {
        val pendingResult = broadcastReceiver.goAsync()
        @OptIn(DelicateCoroutinesApi::class) // Must run globally; there's no teardown callback.
        GlobalScope.launch(context) {
            try {
                block()
            } finally {
                pendingResult.finish()
            }
        }
    }
}