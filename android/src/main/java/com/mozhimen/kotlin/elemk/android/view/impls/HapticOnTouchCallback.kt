package com.mozhimen.kotlin.elemk.android.view.impls

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import com.mozhimen.kotlin.elemk.android.view.cons.CHapticFeedbackConstants
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion

/**
 * @ClassName HapticTouchCallback
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/18
 * @Version 1.0
 */
class HapticOnTouchCallback : View.OnTouchListener {
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.actionMasked) {
            MotionEvent.ACTION_DOWN ->
                v?.performHapticFeedback(CHapticFeedbackConstants.VIRTUAL_KEY)
            MotionEvent.ACTION_UP ->
                if (UtilKBuildVersion.isAfterV_27_81_OM1()) {
                    v?.performHapticFeedback(CHapticFeedbackConstants.VIRTUAL_KEY_RELEASE)
                }
        }
        return false
    }
}