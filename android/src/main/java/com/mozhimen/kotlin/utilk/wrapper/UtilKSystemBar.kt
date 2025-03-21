package com.mozhimen.kotlin.utilk.wrapper

import android.app.Activity
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorViewWrapper
import com.mozhimen.kotlin.utilk.android.view.UtilKNavigationBar
import com.mozhimen.kotlin.utilk.android.view.UtilKTitleBar
import com.mozhimen.kotlin.utilk.androidx.appcompat.UtilKActionBar

/**
 * @ClassName UtilKSystemBar
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/6/28 17:12
 * @Version 1.0
 */
object UtilKSystemBar {
    @JvmStatic
    fun applyStatusBarLowProfile(activity: Activity) {
        UtilKStatusBar.applyIconLowProfile(activity)
    }

    @JvmStatic
    fun applyTranslucent(activity: Activity){
        applyStatusBarTranslucent(activity)
        applyNavigationBarTranslucent(activity)
    }

    @JvmStatic
    fun applyStatusBarTranslucent(activity: Activity) {
        UtilKStatusBar.applyTranslucent(activity)
    }

    @JvmStatic
    fun applyNavigationBarTranslucent(activity: Activity) {
        UtilKNavigationBar.applyTranslucent(activity)
    }

    ////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyLayoutStable(activity: Activity) {
        UtilKDecorViewWrapper.applyLayoutStable(activity)
    }

    @JvmStatic
    fun applyFitsSystemWindows(activity: Activity) {
        UtilKDecorViewWrapper.applyFitsSystemWindows(activity)
    }

    @JvmStatic
    fun applyImmersedHard(activity: Activity) {
        UtilKDecorViewWrapper.applyImmersedHard(activity)
    }

    @JvmStatic
    fun applyImmersedSticky(activity: Activity) {
        UtilKDecorViewWrapper.applyImmersedSticky(activity)
    }

    ////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hideTitleBar(activity: Activity) {
        UtilKTitleBar.hide(activity)
    }

    @JvmStatic
    fun hideActionBar(activity: Activity) {
        UtilKActionBar.hide(activity)
    }

    @JvmStatic
    fun hideStatusBar(activity: Activity) {
        UtilKStatusBar.hide(activity)
    }

    @JvmStatic
    fun hideNavigationBar(activity: Activity) {
        UtilKNavigationBar.hide(activity)
    }

    @JvmStatic
    fun overlayStatusBar(activity: Activity) {
        UtilKStatusBar.overlay(activity)
    }

    @JvmStatic
    fun overlayNavigationBar(activity: Activity) {
        UtilKNavigationBar.overlay(activity)
    }
}