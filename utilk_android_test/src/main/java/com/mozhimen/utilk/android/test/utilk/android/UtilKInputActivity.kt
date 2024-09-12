package com.mozhimen.utilk.android.test.utilk.android

import android.view.MotionEvent
import android.view.View
import com.mozhimen.mvvmk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.view.UtilKInputMethodManagerWrapper
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkKeyboardBinding


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