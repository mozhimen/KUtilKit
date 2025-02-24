package com.mozhimen.kotlin.utilk.android.app

import android.app.Dialog
import android.os.IBinder
import android.view.Window
import android.view.WindowManager

/**
 * @ClassName UtilKDialog
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/21
 * @Version 1.0
 */
object UtilKDialog {
    @JvmStatic
    fun getWindow(dialog: Dialog): Window? =
        dialog.window

    @JvmStatic
    fun getWindowAttributes(dialog: Dialog): WindowManager.LayoutParams? =
        getWindow(dialog)?.attributes

    @JvmStatic
    fun getWindowAttributesToken(dialog: Dialog): IBinder? =
        getWindowAttributes(dialog)?.token

    @JvmStatic
    fun setWindowAttributesToken(dialog: Dialog, token: IBinder) {
        getWindowAttributes(dialog)?.token = token
    }
}