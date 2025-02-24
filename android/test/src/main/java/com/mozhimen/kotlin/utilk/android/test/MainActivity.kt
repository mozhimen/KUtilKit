package com.mozhimen.kotlin.utilk.android.test

import android.view.View
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityMainBinding
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB

class MainActivity : BaseActivityVDB<ActivityMainBinding>() {
    fun goElemK(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.ElemKActivity>()
    }

    fun goUtilK(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.UtilKActivity>()
    }
}