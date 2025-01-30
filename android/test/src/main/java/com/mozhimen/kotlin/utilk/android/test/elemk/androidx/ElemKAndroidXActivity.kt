package com.mozhimen.kotlin.utilk.android.test.elemk.androidx

import android.view.View
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityElemkAndroidxBinding

class ElemKAndroidXActivity : BaseActivityVDB<ActivityElemkAndroidxBinding>() {
    fun goElemKBar(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKBarActivity>()
    }

    fun goElemKVBVM(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKVBVMActivity>()
    }
}