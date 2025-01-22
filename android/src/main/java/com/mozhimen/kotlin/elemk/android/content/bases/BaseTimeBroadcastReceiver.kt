package com.mozhimen.kotlin.elemk.android.content.bases

import android.content.Context
import android.content.Intent
import com.mozhimen.kotlin.elemk.android.content.cons.CIntent
import com.mozhimen.kotlin.lintk.optins.OApiCall_RegisterDynamic
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName BaseTimeBroadcastReceiver
 * @Description

 * 权限:
无

 * 继承:
class ElemKTimeReceiver : BaseTimeReceiver(
object : ITimeReceiverListener {
override fun onTimeTick() {
UtilKLogWrapper.v("ElemKTimeReceiver>>>>>", "onTimeTick: long ${UtilKDate.getNowLong()} string ${UtilKDate.getNowString()}")
}
}
)

 * 动态注册:
class ElemKReceiverActivity : BaseActivityVDB<ActivityElemkReceiverBinding>() {
private lateinit var _receiverProxy: ReceiverProxy<ElemKReceiverActivity>

override fun initData(savedInstanceState: Bundle?) {
UtilKLogWrapper.d(TAG, "initData: start")
_receiverProxy = ReceiverProxy(
this,
arrayOf(
CIntent.ACTION_TIME_TICK,
CIntent.ACTION_TIMEZONE_CHANGED,
CIntent.ACTION_TIME_CHANGED
),
ElemKTimeReceiver()
)
super.initData(savedInstanceState)
}
}

 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
interface ITimeReceiverListener : IUtilK {
    fun onTimeZoneChanged() {}
    fun onTimeTick() {}
    fun onTimeChanged() {}
}

@OApiCall_RegisterDynamic
open class BaseTimeBroadcastReceiver(private val _listener: ITimeReceiverListener) : BaseBroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            CIntent.ACTION_TIMEZONE_CHANGED -> _listener.onTimeZoneChanged()
            CIntent.ACTION_TIME_TICK -> _listener.onTimeTick()
            CIntent.ACTION_TIME_CHANGED -> _listener.onTimeChanged()
        }
    }
}