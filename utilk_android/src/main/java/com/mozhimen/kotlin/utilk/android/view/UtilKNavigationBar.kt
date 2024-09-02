package com.mozhimen.kotlin.utilk.android.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import com.mozhimen.kotlin.elemk.android.view.cons.CGravity
import com.mozhimen.kotlin.lintk.annors.ADescription
import com.mozhimen.kotlin.elemk.android.view.cons.CView
import com.mozhimen.kotlin.elemk.android.view.cons.CWinMgr
import com.mozhimen.kotlin.lintk.optins.OApiUse_BaseApplication
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityWrapper
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes
import com.mozhimen.kotlin.utilk.android.content.UtilKResources
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import java.util.*

/**
 * @ClassName UtilKNavBar
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/23 23:37
 * @Version 1.0
 */
object UtilKNavigationBar : BaseUtilK() {

    /**
     * Return the navigation bar's height.
     * @return Int
     */
    @SuppressLint("DiscouragedApi", "InternalInsetResource")
    @JvmStatic
    fun getHeight(): Int {
        val dimensionId = UtilKResources.getIdentifier_ofSys("navigation_bar_height", "dimen", "android")
        return if (dimensionId != 0) UtilKRes.getDimensionPixelSize_ofResources(dimensionId) else 0
    }

    /**
     * 获得View所在界面 NavigationBar 高度
     * @param view View 目标View
     * @return Int 如果存在NavigationBar则返回高度，否则0
     */
    @OApiUse_BaseApplication
    @JvmStatic
    fun getHeight(view: View): Int {
        val activity: Activity? = UtilKActivityWrapper.get_ofView(view)
        if (activity != null) {
            val usableHeight: Int = UtilKDisplay.getSizeY_ofDef(activity)
            val realHeight: Int = if (UtilKBuildVersion.isAfterV_17_42_J1()) {
                UtilKDisplay.getRealSizeY_ofDef(activity) // getRealMetrics is only available with API 17 and +
            } else {
                try {
                    UtilKDisplay.getRawHeight_ofDef(activity)
                } catch (e: Exception) {
                    e.printStackTrace()
                    usableHeight
                }
            }
            return if (realHeight > usableHeight) realHeight - usableHeight else 0
        }
        return 0
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 设置状态栏沉浸式
     */
    @JvmStatic
    @ADescription("需要${CView.SystemUiFlag.LAYOUT_HIDE_NAVIGATION or CView.SystemUiFlag.LAYOUT_STABLE}")
    fun applyTranslucent(activity: Activity) {
        if (UtilKBuildVersion.isAfterV_21_5_L()) {//21//5.0以上状态栏透明
            UtilKWindow.clearFlags(activity, CWinMgr.Lpf.TRANSLUCENT_NAVIGATION)//清除透明状态栏
            //UtilKDecorView.setSystemUiVisibility(activity, CView.SystemUiFlag.LAYOUT_FULLSCREEN or CView.SystemUiFlag.LAYOUT_STABLE)
            UtilKWindow.addFlags(activity, CWinMgr.Lpf.DRAWS_SYSTEM_BAR_BACKGROUNDS)//设置状态栏颜色必须添加
            UtilKWindow.applyNavigationBarColor(activity, Color.TRANSPARENT)//设置透明
        } else if (UtilKBuildVersion.isAfterV_19_44_K()) {//19
            UtilKWindow.addFlags(activity, CWinMgr.Lpf.TRANSLUCENT_NAVIGATION)
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hide(activity: Activity) {
        UtilKDecorView.applySystemUiVisibilityOr(activity, CView.SystemUiFlag.HIDE_NAVIGATION /*or CView.SystemUi.FLAG_LIGHT_STATUS_BAR*/)
    }

    @JvmStatic
    fun overlay(activity: Activity) {
        UtilKDecorView.applySystemUiVisibilityOr(activity, CView.SystemUiFlag.LAYOUT_HIDE_NAVIGATION)
    }

    @JvmStatic
    fun isVisible(activity: Activity): Boolean {
        val windowSystemUiVisibility = UtilKDecorView.getWindowSystemUiVisibility(activity)
        return windowSystemUiVisibility and CView.SystemUiFlag.HIDE_NAVIGATION == 0 && windowSystemUiVisibility and CView.SystemUiFlag.LAYOUT_HIDE_NAVIGATION == 0
    }
}