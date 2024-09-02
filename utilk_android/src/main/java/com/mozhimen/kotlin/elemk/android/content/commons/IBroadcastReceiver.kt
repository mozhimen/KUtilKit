package com.mozhimen.kotlin.elemk.android.content.commons

import android.content.Context
import com.mozhimen.kotlin.elemk.android.content.bases.BaseBroadcastReceiver
import com.mozhimen.kotlin.elemk.android.content.bases.BaseConnectivityBroadcastReceiver

/**
 * @ClassName IBroadcastReceiver
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/7/11 18:20
 * @Version 1.0
 */
interface IBroadcastReceiver {
    fun <R : BaseBroadcastReceiver> registerReceiver(context: Context, receiver: R)
    fun <R : BaseBroadcastReceiver> unregisterReceiver(context: Context, receiver: R)
}