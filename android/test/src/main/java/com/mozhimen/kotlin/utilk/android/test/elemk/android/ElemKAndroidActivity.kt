package com.mozhimen.kotlin.utilk.android.test.elemk.android

import android.view.View
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityElemkAndroidBinding

class ElemKAndroidActivity : BaseActivityVDB<ActivityElemkAndroidBinding>() {

    fun goElemKGesture(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.android.ElemKGestureActivity>()
    }

    fun goElemKGestureFling(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.android.ElemKGestureFlingActivity>()
    }

    fun goElemKReceiver(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.elemk.android.ElemKReceiverActivity>()
    }

}