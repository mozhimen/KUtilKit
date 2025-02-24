package com.mozhimen.kotlin.utilk.android.app

import android.app.Activity
import android.app.Dialog
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.mozhimen.kotlin.elemk.android.view.cons.CView
import com.mozhimen.kotlin.utilk.android.os.UtilKIBinder
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorView
import com.mozhimen.kotlin.utilk.android.view.UtilKWindow
import com.mozhimen.kotlin.utilk.android.view.UtilKWindowManager_LayoutParams

/**
 * @ClassName UtilKDialogWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/24
 * @Version 1.0
 */
object UtilKDialogWrapper {

    /**
     * 没有用activity作为context的时候, 需要activity的window token
     */
    @JvmStatic
    fun applyToken(dialog: Dialog, window: Window) {
        UtilKDialog.setWindowAttributesToken(dialog, UtilKIBinder.get(window))
    }

    /**
     * dialog 全屏
     */
    @JvmStatic
    fun applyFullScreen(dialog: Dialog) {
        val window = UtilKDialog.getWindow(dialog)
        if (window != null) {
            UtilKWindow.applyLayout(window, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            UtilKDecorView.applySystemUiVisibility(
                window,
                CView.SystemUiFlag.FULLSCREEN or
                        CView.SystemUiFlag.LAYOUT_FULLSCREEN or
                        CView.SystemUiFlag.HIDE_NAVIGATION or
                        CView.SystemUiFlag.LAYOUT_HIDE_NAVIGATION or
                        CView.SystemUiFlag.LAYOUT_STABLE
            )
        }
    }
}