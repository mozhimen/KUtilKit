package com.mozhimen.kotlin.utilk.androidx.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import androidx.fragment.app.DialogFragment

/**
 * @ClassName UtilKDialogFragment
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
fun DialogFragment.applyFullScreenMode() {
    UtilKDialogFragment.applyFullScreenMode(this)
}

/////////////////////////////////////////////////////////////////////

object UtilKDialogFragment {
    @JvmStatic
    fun applyFullScreenMode(dialogFragment: DialogFragment) {
        dialogFragment.dialog?.window?.apply {
            attributes?.apply {
                width = WindowManager.LayoutParams.MATCH_PARENT
                height = WindowManager.LayoutParams.MATCH_PARENT
            }
            decorView.setPadding(0, 0, 0, 0)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }
}