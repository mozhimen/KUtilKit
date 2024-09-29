package com.mozhimen.utilk.android.test.elemk

import android.view.View
import com.mozhimen.bindk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityElemkBinding
import com.mozhimen.utilk.android.test.elemk.android.ElemKAndroidActivity
import com.mozhimen.utilk.android.test.elemk.androidx.ElemKAndroidXActivity

/**
 * @ClassName ElemKActivity
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/19 16:44
 * @Version 1.0
 */
class ElemKActivity : BaseActivityVDB<ActivityElemkBinding>() {

    fun goElemKAndroid(view: View) {
        startContext<ElemKAndroidActivity>()
    }

    fun goElemKAndroidX(view: View) {
        startContext<ElemKAndroidXActivity>()
    }
}