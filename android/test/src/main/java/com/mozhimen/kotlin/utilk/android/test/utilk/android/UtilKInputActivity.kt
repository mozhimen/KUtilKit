package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.view.MotionEvent
import android.view.View
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.view.UtilKInputMethodManagerWrapper
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkKeyboardBinding


/**
 * @ClassName UtilKKeyBoardActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/2 17:49
 * @Version 1.0
 */
class UtilKInputActivity : BaseActivityVDB<ActivityUtilkKeyboardBinding>() {
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            val focusView: View? = currentFocus
            if (focusView != null && UtilKInputMethodManagerWrapper.isShouldHide(focusView, event)) {
                UtilKInputMethodManagerWrapper.hide(this)
            }
        }
        return super.dispatchTouchEvent(event)
    }
}