package com.mozhimen.kotlin.utilk.android.test.utilk.androidx

import android.view.View
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkAndroidxBinding

class UtilKAndroidXActivity : BaseActivityVDB<ActivityUtilkAndroidxBinding>() {
    fun goUtilKActionBar(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.androidx.UtilKActionBarActivity>()
    }
}