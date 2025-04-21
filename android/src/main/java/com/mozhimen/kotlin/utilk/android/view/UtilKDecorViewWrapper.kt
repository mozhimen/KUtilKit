package com.mozhimen.kotlin.utilk.android.view

import android.app.Activity
import android.graphics.Bitmap
import android.view.Window
import com.mozhimen.kotlin.elemk.android.view.cons.CView
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorView.TAG
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorView.applySystemUiVisibilityOr
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorView.get
import com.mozhimen.kotlin.utilk.wrapper.UtilKStatusBar
import kotlin.math.abs

/**
 * @ClassName UtilKDecorViewWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/22
 * @Version 1.0
 */
object UtilKDecorViewWrapper {
    @JvmStatic
    fun getInvisibleHeight(activity: Activity): Int =
        getInvisibleHeight(UtilKWindow.get(activity))

    //获取DecorView区域高度
    @JvmStatic
    fun getInvisibleHeight(window: Window): Int {
        val decorView = UtilKDecorView.get(window)
        val outRect = UtilKDecorView.getWindowVisibleDisplayFrame(window)
        val delta = abs(decorView.bottom - outRect.bottom)
        return (if (delta <= UtilKNavigationBar.getHeight() + UtilKStatusBar.getHeight_resources()) 0 else delta).also { ("getInvisibleHeight: " + (decorView.bottom - outRect.bottom)).d(UtilKDecorView.TAG) }
    }

    //截屏
    @JvmStatic
    fun getBitmapForDrawingCache(activity: Activity): Bitmap {
        val decorView = get(activity)
        decorView.isDrawingCacheEnabled = true
        decorView.buildDrawingCache()
        val bitmap = Bitmap.createBitmap(decorView.drawingCache, 0, 0, decorView.measuredWidth, decorView.measuredHeight - UtilKVirtualBar.getHeight(activity))
        decorView.isDrawingCacheEnabled = false
        decorView.destroyDrawingCache()
        return bitmap
    }

    //////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyLayoutStable(activity: Activity) {
        applySystemUiVisibilityOr(activity, CView.SystemUiFlag.LAYOUT_STABLE)
    }

    @JvmStatic
    fun applyImmersedHard(activity: Activity) {
        applySystemUiVisibilityOr(activity, CView.SystemUiFlag.IMMERSIVE)
    }

    @JvmStatic
    fun applyImmersedSticky(activity: Activity) {
        applySystemUiVisibilityOr(activity, CView.SystemUiFlag.IMMERSIVE_STICKY)
    }

    @JvmStatic
    fun applyImmersive(activity: Activity) {
        applyImmersive(UtilKWindow.get(activity))
    }

    @JvmStatic
    fun applyImmersive(window: Window) {
        UtilKDecorView.applySystemUiVisibility(
            window,
            CView.SystemUiFlag.IMMERSIVE_STICKY
                    or CView.SystemUiFlag.LAYOUT_STABLE
                    or CView.SystemUiFlag.FULLSCREEN
                    or CView.SystemUiFlag.LAYOUT_FULLSCREEN
                    or CView.SystemUiFlag.HIDE_NAVIGATION
                    or CView.SystemUiFlag.LAYOUT_HIDE_NAVIGATION
        )
    }

    /**
     * 采用谷歌原生状态栏文字颜色的方法进行设置,携带 [CView.SystemUiFlag.LAYOUT_FULLSCREEN] 这个flag那么默认界面会变成全屏模式,
     * 需要在根布局中设置FitSystemWindows属性为true, 所以添加Process方法中加入如下的代码
     * 或者在xml中添加android:fitSystemWindows="true"
     * 华为,OPPO机型在StatusUtil.setLightStatusBar后布局被顶到状态栏上去了
     *
     * 延迟加载不然getChild0为空
     */
    @JvmStatic
    fun applyFitsSystemWindows(activity: Activity) {
        get(activity).post {
            UtilKContentView.getChildAt0(activity)?.applyFitSystemWindow() ?: "setFitsSystemWindows contentView is null".e(TAG)
        }
    }

//    @JvmStatic
//    fun applyFullScreen(activity: Activity) {
//        setFullScreen(activity.window)
//    }
//
//    @JvmStatic
//    fun applyFullScreen(window: Window) {
//        setFullScreen(get(window))
//    }
//
//    /**
//     * 设置全屏
//     * @param decorView View
//     */
//    @JvmStatic
//    fun applyFullScreen(decorView: View) {
//        setSystemUiVisibility(
//            decorView, (CView.SystemUiFlag.LOW_PROFILE or
//                    CView.SystemUiFlag.FULLSCREEN or
//                    CView.SystemUiFlag.LAYOUT_STABLE or
//                    CView.SystemUiFlag.IMMERSIVE_STICKY or
//                    CView.SystemUiFlag.LAYOUT_HIDE_NAVIGATION or
//                    CView.SystemUiFlag.HIDE_NAVIGATION)
//        )
//    }
}