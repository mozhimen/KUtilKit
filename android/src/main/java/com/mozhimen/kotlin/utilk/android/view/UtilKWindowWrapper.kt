package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.view.WindowManager
import androidx.annotation.FloatRange
import com.mozhimen.kotlin.elemk.android.view.cons.CWinMgr
import com.mozhimen.kotlin.utilk.android.view.UtilKWindowManager_LayoutParams.get

/**
 * @ClassName UtilKWindowWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/30 11:10
 * @Version 1.0
 */
object UtilKWindowWrapper {

    /**
     * 设置屏幕亮度
     * @param paramFloat Float 0-1范围
     */
    @JvmStatic
    fun applyAttributes_ofBrightness(activity: Activity, @FloatRange(from = 0.0, to = 1.0) paramFloat: Float) {
        val layoutParams: WindowManager.LayoutParams = get(activity)
        layoutParams.screenBrightness = paramFloat
        UtilKWindow.applyAttributes(activity, layoutParams)
    }

    @JvmStatic
    fun applyAttributes_ofBrightest(activity: Activity, isBrightest: Boolean) {
        val layoutParams: WindowManager.LayoutParams = get(activity)
        layoutParams.screenBrightness = if (isBrightest) CWinMgr.Lp.BRIGHTNESS_OVERRIDE_FULL else CWinMgr.Lp.BRIGHTNESS_OVERRIDE_NONE
        UtilKWindow.applyAttributes(activity, layoutParams)
    }

    @JvmStatic
    fun applyKeepScreen(activity: Activity, isKeepScreenOn: Boolean, isBrightest: Boolean) {
        if (isKeepScreenOn){
            addFlags_KEEP_SCREEN_ON(activity)
        }else{
            clearFlags_KEEP_SCREEN_ON(activity)
        }
        applyAttributes_ofBrightest(activity, isBrightest)
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addFlags_KEEP_SCREEN_ON(activity: Activity) {
        UtilKWindow.addFlags(activity, CWinMgr.Lpf.KEEP_SCREEN_ON)
    }

    @JvmStatic
    fun clearFlags_KEEP_SCREEN_ON(activity: Activity) {
        UtilKWindow.clearFlags(activity, CWinMgr.Lpf.KEEP_SCREEN_ON)
    }
}