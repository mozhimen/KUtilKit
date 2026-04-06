package com.mozhimen.kotlin.utilk.android.app

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKIntentGet
import com.mozhimen.kotlin.utilk.android.content.UtilKPackageManager
import com.mozhimen.kotlin.utilk.kotlin.UtilKStringWrapper

/**
 * @ClassName UtilKActivityInfo
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/3/16 23:21
 * @Version 1.0
 */
object UtilKActivityInfoWrapper {

    //获取启动Activity
    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getMainLauncher(strPackageName: String, context: Context): ActivityInfo? {
        if (UtilKStringWrapper.hasSpace(strPackageName) || strPackageName.isEmpty()) return null
        val resolveInfos = UtilKPackageManager.queryIntentActivities(UtilKIntentGet.getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_PACKAGE(strPackageName, null), 0, context)
        return if (resolveInfos.isEmpty()) null else resolveInfos[0].activityInfo
    }

    /////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getMainLauncherName(strPackageName: String, context: Context): String =
        getMainLauncher(strPackageName, context)?.name ?: ""
}