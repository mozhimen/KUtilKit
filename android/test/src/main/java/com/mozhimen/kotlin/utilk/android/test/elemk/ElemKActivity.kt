package com.mozhimen.kotlin.utilk.android.test.elemk

import android.view.View
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityElemkBinding
import com.mozhimen.kotlin.utilk.android.test.elemk.android.ElemKAndroidActivity
import com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKAndroidXActivity

/**
 * @ClassName ElemKActivity
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/19 16:44
 * @Version 1.0
 */
class ElemKActivity : BaseActivityVDB<ActivityElemkBinding>() {

    fun goElemKAndroid(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.android.ElemKAndroidActivity>()
    }

    fun goElemKAndroidX(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKAndroidXActivity>()
    }
}