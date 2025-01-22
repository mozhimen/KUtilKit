package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CIntent
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.OApiUse_BaseApplication
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityManager
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityWrapper
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKDisplayMetrics
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrProcess
import java.util.Locale

/**
 * @ClassName UtilKContextWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/19
 * @Version 1.0
 */
fun Context.get_of_config_shortAnimTime(): Int =
    UtilKContextWrapper.get_of_config_shortAnimTime(this)

fun Context.get_of_config_mediumAnimTime(): Int =
    UtilKContextWrapper.get_of_config_mediumAnimTime(this)

fun Context.get_of_config_longAnimTime(): Int =
    UtilKContextWrapper.get_of_config_longAnimTime(this)

fun Context.isMainProcess(): Boolean =
    UtilKContextWrapper.isMainProcess(this)

///////////////////////////////////////////////////////////////////////

object UtilKContextWrapper {
    @JvmStatic
    fun get_of_config_shortAnimTime(context: Context): Int =
        UtilKResourcesWrapper.getInt_config_shortAnimTime(context.resources)

    @JvmStatic
    fun get_of_config_mediumAnimTime(context: Context): Int =
        UtilKResourcesWrapper.getInt_config_mediumAnimTime(context.resources)

    @JvmStatic
    fun get_of_config_longAnimTime(context: Context): Int =
        UtilKResourcesWrapper.getInt_config_longAnimTime(context.resources)

    ///////////////////////////////////////////////////////////////////////

    /**
     * 是否在主线程
     */
    @JvmStatic
    fun isMainProcess(context: Context): Boolean =
        UtilKStrProcess.isMainProcess(context.packageName)

    @JvmStatic
    @OApiUse_BaseApplication
    fun isFinishingOrDestroyed(context: Context): Boolean =
        UtilKActivityWrapper.isFinishingOrDestroyed(context)

    ///////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @SuppressLint("QueryPermissionsNeeded", "InlinedApi")
    fun grantUriPermission_before21(context: Context, intent: Intent, uri: Uri) {
        if (UtilKBuildVersion.isBeforeVersion(CVersCode.V_21_5_L)) {
            val resInfoList = UtilKPackageManager.queryIntentActivities(context, intent, CPackageManager.MATCH_DEFAULT_ONLY)
            for (resolveInfo in resInfoList) {
                val strPackageName = resolveInfo.activityInfo.packageName
                UtilKContext.grantUriPermission(context, strPackageName, uri, CIntent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
        }
    }

    /**
     * 这个方法虽然更新了资源但是只能以后的界面生效，之前没有finish的页面还是保留原来的语言
     */
    @JvmStatic
    fun updateLocale(context: Context, locale: Locale) {
        val configuration: Configuration = UtilKConfiguration.get_ofApp(context)
        UtilKConfiguration.setLocale(configuration, locale)
        UtilKResources.updateConfiguration_ofApp(context, configuration, UtilKDisplayMetrics.get_ofApp(context))
    }
}