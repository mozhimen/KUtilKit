package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.view.View
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_MANAGE_EXTERNAL_STORAGE
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityStart
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkLaunchActivityBinding

/**
 * @ClassName UtilKLaunchActivityActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/10/23 16:59
 * @Version 1.0
 */
class UtilKLaunchActivityActivity : BaseActivityVDB<ActivityUtilkLaunchActivityBinding>() {
    @OptIn(OPermission_MANAGE_EXTERNAL_STORAGE::class)
    fun startManageAllFilesAccess(view: View) {
        UtilKActivityStart.startSettingsManageAllFilesAccessPermission(this)
    }
}