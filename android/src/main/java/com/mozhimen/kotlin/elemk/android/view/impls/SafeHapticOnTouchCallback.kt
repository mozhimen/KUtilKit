package com.mozhimen.kotlin.elemk.android.view.impls

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.mozhimen.kotlin.elemk.android.view.cons.CHapticFeedbackConstants
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.view.safePerformHapticFeedback

/**
 * @ClassName SafeHapticOnTouchCallback
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/23
 * @Version 1.0
 */
class SafeHapticOnTouchCallback : View.OnTouchListener {
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.actionMasked) {
            MotionEvent.ACTION_DOWN ->
                v?.safePerformHapticFeedback(CHapticFeedbackConstants.VIRTUAL_KEY)
            MotionEvent.ACTION_UP ->
                if (UtilKBuildVersion.isAfterV_27_81_OM1()) {
                    v?.safePerformHapticFeedback(CHapticFeedbackConstants.VIRTUAL_KEY_RELEASE)
                }
        }
        return false
    }
}