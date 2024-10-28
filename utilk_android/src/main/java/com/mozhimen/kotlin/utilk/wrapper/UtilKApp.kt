package com.mozhimen.kotlin.utilk.wrapper

import android.content.Context
import android.content.Intent
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CIntent
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKApplicationInfo
import com.mozhimen.kotlin.utilk.android.content.UtilKApplicationInfoWrapper
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKIntentWrapper
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.os.UtilKProcess
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.java.lang.UtilKSystem
import java.lang.IllegalArgumentException
import kotlin.system.exitProcess


/**
 * @ClassName UtilKActivity
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/5/26 16:42
 * @Version 1.0
 */
object UtilKApp : BaseUtilK() {
    @JvmStatic
    fun getLabelStr(): String =
        UtilKApplicationInfo.getLabelResStr(_context)

    /////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @Throws(IllegalArgumentException::class)
    fun isSystemApp(context: Context): Boolean =
        UtilKApplicationInfoWrapper.isSystemApp(context)

    @JvmStatic
    fun isSystemUpdateApp(context: Context): Boolean =
        UtilKApplicationInfoWrapper.isSystemUpdateApp(context)

    @JvmStatic
    fun isUserApp(context: Context): Boolean =
        UtilKApplicationInfoWrapper.isUserApp(context)

    @JvmStatic
    fun isSystemOrSystemUpdateApp(context: Context): Boolean =
        UtilKApplicationInfoWrapper.isSystemOrSystemUpdateApp(context)

    /////////////////////////////////////////////////////////////////////////////

    /**
     * 重启App
     */
    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun restartApp(isKillProcess: Boolean, isValid: Boolean = true, context: Context = _context) {
        val intent: Intent = UtilKIntentWrapper.getMainLauncher_ofPackageManger(context, UtilKContext.getPackageName(context)) ?: run {
            UtilKLogWrapper.e(TAG, "didn't exist launcher activity.");return
        }
        intent.addFlags(CIntent.FLAG_ACTIVITY_CLEAR_TOP or CIntent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startContext(intent)
        if (!isKillProcess) return
        exitApp(isValid)
    }

    /**
     * 退出App
     */
    @JvmStatic
    fun exitApp(isValid: Boolean = true, isGc: Boolean = false) {
        if (isGc) UtilKSystem.gc()
        UtilKProcess.killProcess_ofMyPid()//杀掉当前进程,并主动启动新的启动页,以完成重启的动作
        exitProcess(if (isValid) 0 else 10)
    }
}