package com.mozhimen.kotlin.utilk.androidx.core

import android.view.Window
import androidx.core.view.WindowInsetsControllerCompat
import com.mozhimen.kotlin.elemk.androidx.core.cons.CWindowInsetsControllerCompat

/**
 * @ClassName UtilKWindowInsetsControllerCompat
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/4
 * @Version 1.0
 */
object UtilKWindowInsetsControllerCompat {
    @JvmStatic
    fun get(window: Window): WindowInsetsControllerCompat =
        UtilKWindowCompat.getWindowInsetsController(window)

    @JvmStatic
    fun show(window: Window, types: Int) {
        get(window).show(types)
    }

    @JvmStatic
    fun hide(window: Window, types: Int) {
        get(window).hide(types)
    }

    @JvmStatic
    fun isAppearanceLightStatusBars(window: Window, isLight: Boolean) {
        get(window).isAppearanceLightStatusBars = isLight
    }

    @JvmStatic
    fun isAppearanceLightNavigationBars(window: Window, isLight: Boolean) {
        get(window).isAppearanceLightNavigationBars = isLight
    }

    @JvmStatic
    fun applySystemBarsBehavior(window: Window, /*@Behavior*/ behavior: Int) {
        get(window).systemBarsBehavior = behavior
    }

//        // Configure the behavior of the hidden system bars.
//        windowInsetsController.systemBarsBehavior =
//            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//
//        // Add a listener to update the behavior of the toggle fullscreen button when
//        // the system bars are hidden or revealed.
//        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, windowInsets ->
//            // You can hide the caption bar even when the other system bars are visible.
//            // To account for this, explicitly check the visibility of navigationBars()
//            // and statusBars() rather than checking the visibility of systemBars().
//            if (windowInsets.isVisible(WindowInsetsCompat.Type.navigationBars()) || windowInsets.isVisible(WindowInsetsCompat.Type.statusBars())) {
//                binding.toggleFullscreenButton.setOnClickListener {
//                    // Hide both the status bar and the navigation bar.
//                    windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
//                }
//            } else {
//                binding.toggleFullscreenButton.setOnClickListener {
//                    // Show both the status bar and the navigation bar.
//                    windowInsetsController.show(WindowInsetsCompat.Type.systemBars())
//                }
//            }
//            ViewCompat.onApplyWindowInsets(view, windowInsets)
//        }
}