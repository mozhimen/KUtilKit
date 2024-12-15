package com.mozhimen.kotlin.utilk.androidx.activity

import androidx.activity.result.ActivityResultLauncher
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion

/**
 * @ClassName UtilKComponentActivityPermission
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/21
 * @Version 1.0
 */
object UtilKComponentActivityPermission {
    @JvmStatic
    fun launch_ofREAD_EXTERNAL_STORAGE(activityResultLauncher: ActivityResultLauncher<String>) {
        if (UtilKBuildVersion.get_SDK_INT() in CVersCode.V_23_6_M until CVersCode.V_30_11_R)
            activityResultLauncher.launch(CPermission.READ_EXTERNAL_STORAGE)
    }

    @JvmStatic
    fun launch_ofPOST_NOTIFICATIONS(activityResultLauncher: ActivityResultLauncher<String>) {
        if (UtilKBuildVersion.isAfterV_33_13_T())
            activityResultLauncher.launch(CPermission.POST_NOTIFICATIONS)
    }
}