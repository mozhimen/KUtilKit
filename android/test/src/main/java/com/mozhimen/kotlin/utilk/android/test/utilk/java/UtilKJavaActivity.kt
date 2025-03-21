package com.mozhimen.kotlin.utilk.android.test.utilk.java

import android.content.Intent
import android.provider.Settings
import android.view.View
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkJavaBinding


class UtilKJavaActivity : BaseActivityVDB<ActivityUtilkJavaBinding>() {
    fun goUtilKFile(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKFileActivity>()
    }

    fun goManageAllStorage(view: View) {
        if (UtilKBuildVersion.isAfterV_30_11_R()) {
            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            startActivity(intent)
        }
    }

    fun goManageAllStorageByReflect(view: View) {
//        ManageAllStorageByReflect.reflect1()
    }
}