package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver
import android.view.Window
import android.widget.FrameLayout
import com.mozhimen.kotlin.elemk.android.view.cons.CWinMgr
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.elemk.cons.CCons
import com.mozhimen.kotlin.lintk.optins.OApiUse_BaseApplication
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityWrapper
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKViewTreeObserver
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/29 0:15
 * @Version 1.0
 */
fun View.addAndRemoveOnGlobalLayoutListener(invoke: I_Listener) {
    UtilKViewTreeObserver.addAndRemoveOnGlobalLayoutListener(this, invoke)
}

////////////////////////////////////////////////////////////////////////

object UtilKViewTreeObserver : IUtilK {
    @JvmStatic
    fun get(view: View): ViewTreeObserver? =
        UtilKView.getViewTreeObserver(view)

    ////////////////////////////////////////////////////////////////////////

    //添加全局监听
    @JvmStatic
    fun safeAddOnGlobalLayoutListener(view: View, listener: ViewTreeObserver.OnGlobalLayoutListener) {
        try {
            get(view)?.removeOnGlobalLayoutListener(listener)
            get(view)?.addOnGlobalLayoutListener(listener)
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
    }

    //删除全局监听
    @JvmStatic
    fun safeRemoveOnGlobalLayoutListener(view: View, listener: ViewTreeObserver.OnGlobalLayoutListener?) {
        try {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
    }

    @JvmStatic
    fun addAndRemoveOnGlobalLayoutListener(view: View, invoke: I_Listener) {
        if (get(view)?.isAlive == true){
            UtilKLogWrapper.d(TAG, "addAndRemoveOnGlobalLayoutListener: get(view)?.isAlive == true")
            invoke.invoke()
        }
        get(view)?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (get(view) != null) {
                    get(view)?.removeOnGlobalLayoutListener(this)
                    UtilKLogWrapper.d(TAG, "addAndRemoveOnGlobalLayoutListener onGlobalLayout: ")
                    invoke.invoke()
                }
            }
        })
    }
}