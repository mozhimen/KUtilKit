package com.mozhimen.kotlin.utilk.android.provider

import android.content.Context
import android.provider.Settings
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.provider.cons.CSettings
import com.mozhimen.kotlin.lintk.annors.ADescription
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_SYSTEM_ALERT_WINDOW
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.commons.IUtilK


/**
 * @ClassName UtilKSettings
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/3 13:48
 * @Version 1.0
 */
object UtilKSettings : IUtilK {

    @JvmStatic
    @RequiresPermission(CPermission.SYSTEM_ALERT_WINDOW)
    @OPermission_SYSTEM_ALERT_WINDOW
    @ADescription(CSettings.ACTION_MANAGE_OVERLAY_PERMISSION)
    fun canDrawOverlays(context: Context): Boolean =
        if (UtilKBuildVersion.isAfterV_23_6_M())
            Settings.canDrawOverlays(context)
        else true
}