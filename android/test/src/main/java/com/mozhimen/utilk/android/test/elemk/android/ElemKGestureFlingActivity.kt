package com.mozhimen.utilk.android.test.elemk.android

import android.view.GestureDetector
import android.view.MotionEvent
import com.mozhimen.kotlin.elemk.android.view.bases.BaseFlingSimpleOnGestureCallback
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkGestureBinding

class ElemKGestureFlingActivity : BaseActivityVDB<ActivityUtilkGestureBinding>() {

    private val _gestureDetector: GestureDetector by lazy {
        GestureDetector(this, object : BaseFlingSimpleOnGestureCallback() {
            override fun onFlingLeft() {
                "左划".showToast()
            }

            override fun onFlingDown() {
                "下划".showToast()
            }

            override fun onFlingRight() {
                "右划".showToast()
            }

            override fun onFlingUp() {
                "上划".showToast()
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return _gestureDetector.onTouchEvent(event)
    }

}