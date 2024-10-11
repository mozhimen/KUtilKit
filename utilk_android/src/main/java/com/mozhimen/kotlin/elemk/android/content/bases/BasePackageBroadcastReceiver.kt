package com.mozhimen.kotlin.elemk.android.content.bases

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CIntent
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.OApiTarget_AtV_25_71_N1
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.wrapper.UtilKApp
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName BaseInstallObserverReceiver
 * @Description if you use it, you must register in manifest first

 * 权限:
无

 * 继承:
class ElemKInstallObserverReceiver : BaseInstallObserverReceiver()

 * 静态注册
<receiver
android:name=".elemk.receiver.ElemKInstallObserverReceiver"
android:enabled="true"
android:exported="true">
<intent-filter android:priority="100">
<action android:name="android.intent.action.PACKAGE_ADDED" />
<action android:name="android.intent.action.PACKAGE_REPLACED" />
<action android:name="android.intent.action.PACKAGE_REMOVED" />
<data android:scheme="package" />
</intent-filter>
</receiver>

 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
@OApiTarget_AtV_25_71_N1
@TargetApi(CVersCode.V_25_71_NM1)
@OPermission_QUERY_ALL_PACKAGES
open class BasePackageBroadcastReceiver : BaseBroadcastReceiver {

    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    constructor() : super()

    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    override fun onReceive(context: Context, intent: Intent) {
        val strPackageName = intent.dataString
        when (intent.action) {
            CIntent.ACTION_PACKAGE_REPLACED -> {
                UtilKLogWrapper.w(TAG, "onReceiveInstall: update one apk, restart program soon strPackageName $strPackageName // package:${UtilKContext.getPackageName(context)}")
                if (strPackageName == "package:${UtilKContext.getPackageName(context)}") {
                    UtilKApp.restartApp(isKillProcess = true, context = context)
                } else {
                    UtilKLogWrapper.w(TAG, "onReceiveInstall: strPackageName is different")
                }
            }

            CIntent.ACTION_PACKAGE_ADDED -> {
                UtilKLogWrapper.w(TAG, "onReceiveInstall: install one apk $strPackageName")
            }

            CIntent.ACTION_PACKAGE_REMOVED -> {
                UtilKLogWrapper.w(TAG, "onReceiveInstall: uninstall one apk $strPackageName")
            }
        }
    }
}