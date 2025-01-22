package com.mozhimen.kotlin.elemk.android.content.bases

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.android.content.commons.IBroadcastReceiver
import com.mozhimen.kotlin.elemk.android.net.cons.CConnectivityManager
import com.mozhimen.kotlin.elemk.commons.IConnectionListener
import com.mozhimen.kotlin.elemk.android.net.cons.ENetType
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_NETWORK_STATE
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_INTERNET
import com.mozhimen.kotlin.utilk.wrapper.UtilKNet
import com.mozhimen.kotlin.utilk.android.util.w


/**
 * @ClassName BaseConnectivityBroadcastReceiver
 * @Description

 * 权限:
CPermission.ACCESS_NETWORK_STATE,
CPermission.INTERNET

 * 继承:
class ElemKNetConnectionReceiver : BaseNetConnectionBroadcastReceiver()

 * 静态注册(AndroidManifest.xml)一般动态注册:
<receiver
android:name=".elemk.receiver.ElemKNetConnectionReceiver"
android:enabled="true"
android:exported="true">
<intent-filter>
<action android:name="android.intent.action.CONNECTIVITY_ACTION" />
</intent-filter>
</receiver>

 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
@OPermission_ACCESS_NETWORK_STATE
@OPermission_INTERNET
open class BaseConnectivityBroadcastReceiver : BaseBroadcastReceiver, IBroadcastReceiver {
//    companion object {
//        @JvmStatic
//        val instance = INSTANCE.holder
//    }

    ///////////////////////////////////////////////////////////////////////////

    @RequiresPermission(allOf = [CPermission.ACCESS_NETWORK_STATE, CPermission.INTERNET])
    constructor() : super()

    ///////////////////////////////////////////////////////////////////////////

    private val _listeners: ArrayList<IConnectionListener> = ArrayList()
    protected var netTypes = setOf(ENetType.NONE)

    ///////////////////////////////////////////////////////////////////////////

    @RequiresPermission(CPermission.ACCESS_NETWORK_STATE)
    override fun onReceive(context: Context?, intent: Intent) {
        if (CConnectivityManager.CONNECTIVITY_ACTION != intent.action) return
        val netTypes = UtilKNet.getNetTypes_ofActive()
        if (this.netTypes != netTypes) {
            "onReceive: eNetKType $netTypes".w(TAG)
            notifyListeners(netTypes)
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    override fun <R : BaseBroadcastReceiver> registerReceiver(context: Context, receiver: R) {
        context.registerReceiver(receiver, IntentFilter(CConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun <R : BaseBroadcastReceiver> unregisterReceiver(context: Context, receiver: R) {
        context.unregisterReceiver(receiver)
    }

    ///////////////////////////////////////////////////////////////////////////

    fun registerListener(listener: IConnectionListener) {
        if (!_listeners.contains(listener)) _listeners.add(listener)
    }

    fun unRegisterListener(listener: IConnectionListener) {
        _listeners.remove(listener)
    }

    private fun notifyListeners(netTypes: Set<ENetType>) {
        if (netTypes == setOf(ENetType.NONE) || netTypes.isEmpty()) {
            for (listener in _listeners) listener.onDisconnect()
        } else {
            for (listener in _listeners) listener.onConnect(netTypes)
        }
    }

    ///////////////////////////////////////////////////////////////////////////

//    private object INSTANCE {
//        val holder = BaseConnectivityBroadcastReceiver()
//    }
}