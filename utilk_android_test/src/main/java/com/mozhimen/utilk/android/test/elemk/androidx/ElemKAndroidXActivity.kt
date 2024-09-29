package com.mozhimen.utilk.android.test.elemk.androidx

import android.view.View
import com.mozhimen.bindk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityElemkAndroidxBinding

class ElemKAndroidXActivity : BaseActivityVDB<ActivityElemkAndroidxBinding>() {
    fun goElemKBar(view: View) {
        startContext<ElemKBarActivity>()
    }

    fun goElemKVBVM(view: View) {
        startContext<ElemKVBVMActivity>()
    }
}