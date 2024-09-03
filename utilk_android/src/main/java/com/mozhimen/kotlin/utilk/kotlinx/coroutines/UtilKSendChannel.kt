package com.mozhimen.kotlin.utilk.kotlinx.coroutines

import android.view.View
import kotlinx.coroutines.channels.SendChannel

/**
 * @ClassName UtilKSendChannel
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
fun <T> SendChannel<T>.applyAutoDispose(view: View): SendChannel<T> =
    UtilKSendChannel.applyAutoDispose(this, view)

////////////////////////////////////////////////////////////////

object UtilKSendChannel {
    /**
     * avoid memory leak
     */
    @JvmStatic
    fun <T> applyAutoDispose(sendChannel: SendChannel<T>, view: View): SendChannel<T> {
        val isAttached =
            view.isAttachedToWindow || view.windowToken != null
        val listener = object : View.OnAttachStateChangeListener {
            override fun onViewDetachedFromWindow(v: View) {
                sendChannel.close()
                v.removeOnAttachStateChangeListener(this)
            }

            override fun onViewAttachedToWindow(v: View) = Unit
        }

        view.addOnAttachStateChangeListener(listener)
        sendChannel.invokeOnClose {
            view.removeOnAttachStateChangeListener(listener)
        }
        return sendChannel
    }
}