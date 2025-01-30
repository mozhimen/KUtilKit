package com.mozhimen.kotlin.utilk.android.test.utilk.kotlin

import android.view.View
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkKotlinBinding

class UtilKKotlinActivity : BaseActivityVDB<ActivityUtilkKotlinBinding>() {

    fun goUtilKVerifyUrl(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.kotlin.UtilKVerifyUrlActivity>()
    }

    fun goUtilKMd5(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.kotlin.UtilKMd5Activity>()
    }

}