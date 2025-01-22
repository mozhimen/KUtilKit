package com.mozhimen.utilk.android.test.elemk.android

import android.view.View
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.utilk.android.test.databinding.ActivityElemkAndroidBinding

class ElemKAndroidActivity : BaseActivityVDB<ActivityElemkAndroidBinding>() {

    fun goElemKGesture(view: View) {
        startContext<ElemKGestureActivity>()
    }

    fun goElemKGestureFling(view: View) {
        startContext<ElemKGestureFlingActivity>()
    }

    fun goElemKReceiver(view: View) {
        startContext<ElemKReceiverActivity>()
    }

}