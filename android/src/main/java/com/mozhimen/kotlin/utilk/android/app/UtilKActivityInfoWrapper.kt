package com.mozhimen.kotlin.utilk.android.app

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
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
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getMainLauncher(context: Context, strPackageName: String): ActivityInfo? {
        if (UtilKStringWrapper.hasSpace(strPackageName) || strPackageName.isEmpty()) return null
        val resolveInfos = UtilKPackageManager.queryIntentActivities(context, UtilKIntentGet.getMainLauncher_ofPackage(strPackageName, null), 0)
        return if (resolveInfos.isEmpty()) null else resolveInfos[0].activityInfo
    }

    /////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun getMainLauncherName(context: Context, strPackageName: String): String =
        getMainLauncher(context, strPackageName)?.name ?: ""
}