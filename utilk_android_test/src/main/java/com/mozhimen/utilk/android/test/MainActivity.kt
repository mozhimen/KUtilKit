package com.mozhimen.utilk.android.test

import android.view.View
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.utilk.android.test.databinding.ActivityMainBinding
import com.mozhimen.utilk.android.test.elemk.ElemKActivity
import com.mozhimen.utilk.android.test.utilk.UtilKActivity

class MainActivity : BaseActivityVDB<ActivityMainBinding>() {
    fun goElemK(view: View) {
        startContext<ElemKActivity>()
    }

    fun goUtilK(view: View) {
        startContext<UtilKActivity>()
    }
}