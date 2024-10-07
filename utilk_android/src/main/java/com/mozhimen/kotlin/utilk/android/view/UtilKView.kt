package com.mozhimen.kotlin.utilk.android.view

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.*
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.core.graphics.Insets
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.view.HapticOnTouchCallback
import com.mozhimen.kotlin.elemk.android.view.cons.CHapticFeedbackConstants
import com.mozhimen.kotlin.elemk.android.view.cons.CView
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import com.mozhimen.kotlin.elemk.cons.CPackage
import com.mozhimen.kotlin.elemk.cons.CStrPackage
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.java.lang.UtilKClass


/**
 * @ClassName UtilKView
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/2/27 16:50
 * @Version 1.0
 */

fun View.isVisible(): Boolean =
    UtilKView.isVisible(this)

fun View.isInvisible(): Boolean =
    UtilKView.isInvisible(this)

fun View.isGone(): Boolean =
    UtilKView.isGone(this)

//////////////////////////////////////////////////////////////////////////////

fun View.applyPadding(padding: Int) {
    UtilKView.applyPadding(this, padding)
}

fun View.applyPadding(paddingHorizontal: Int, paddingVertical: Int) {
    UtilKView.applyPadding(this, paddingHorizontal, paddingVertical)
}

fun View.applyPaddingHorizontal(padding: Int) {
    UtilKView.applyPaddingHorizontal(this, padding)
}

fun View.applyPaddingVertical(padding: Int) {
    UtilKView.applyPaddingVertical(this, padding)
}

fun View.applyLayoutParams(size: Int) {
    UtilKView.applyLayoutParams(this, size)
}

fun View.applyLayoutParams(width: Int, height: Int) {
    UtilKView.applyLayoutParams(this, width, height)
}

fun View.applyLayoutParams_ofMatch() {
    UtilKView.applyLayoutParams_ofMatch(this)
}

fun View.applyLayoutParams_ofHeightStatusBar() {
    UtilKView.applyLayoutParams_ofHeightStatusBar(this)
}

inline fun <reified T : ViewGroup.LayoutParams> View.applyUpdateLayoutParams(block: IExt_Listener<T>) {
    UtilKView.applyUpdateLayoutParams(this, block)
}
//////////////////////////////////////////////////////////////////////////////

fun View.applyBackgroundNull() =
    UtilKView.applyBackgroundNull(this)

fun View.applyBackground(drawable: Drawable) {
    UtilKView.applyBackground(this, drawable)
}

fun View.applyElevation(elevation: Float) {
    UtilKView.applyElevation(this, elevation)
}

fun View.applyFocusable() {
    UtilKView.applyFocusable(this)
}

fun View.applyRequestFocus() {
    UtilKView.applyRequestFocus(this)
}

fun View.applyFitSystemWindow() {
    UtilKView.applyFitSystemWindow(this)
}

//////////////////////////////////////////////////////////////////////////////

fun View.applyHapticOnTouchListener() {
    UtilKView.applyHapticOnTouchListener(this)
}

//////////////////////////////////////////////////////////////////////////////
object UtilKView : BaseUtilK() {
    @JvmStatic
    fun get_ofInflate(viewGroup: ViewGroup, @LayoutRes intResLayout: Int): View =
        UtilKLayoutInflater.from_inflate(viewGroup, intResLayout)

    //////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getLocationOnScreen(view: View): IntArray {
        val intArray = IntArray(2)
        view.getLocationOnScreen(intArray)
        return intArray
    }

    @JvmStatic
    fun getViewTreeObserver(view: View): ViewTreeObserver? =
        view.viewTreeObserver

    @JvmStatic
    fun getLongTag(view: View, key: Int, defaultValue: Long): Long =
        if (view.getTag(key) != null) view.getTag(key) as Long else defaultValue

    @JvmStatic
    fun getWindowVisibleDisplayFrame(view: View, rect: Rect) {
        view.getWindowVisibleDisplayFrame(rect)
    }

    @JvmStatic
    fun getGlobalVisibleRect(view: View, rect: Rect): Rect {
        view.getGlobalVisibleRect(rect)
        return rect
    }

    @JvmStatic
    fun getGlobalVisibleRect(view: View): Rect =
        getGlobalVisibleRect(view, Rect())

    //////////////////////////////////////////////////////////////////////////////

    /**
     * 是否是DecorView
     */
    @JvmStatic
    fun isContentOrDecorView(view: View): Boolean =
        if (view.id == CPackage.ANDROID_R_ID_CONTENT) true
        else TextUtils.equals(view.javaClass.name, CStrPackage.com_android_internal_policy_Decorview)

    @JvmStatic
    fun isVisible(view: View): Boolean =
        view.visibility == CView.VISIBLE

    @JvmStatic
    fun isInvisible(view: View): Boolean =
        view.visibility == CView.INVISIBLE

    @JvmStatic
    fun isGone(view: View): Boolean =
        view.visibility == CView.GONE

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyHapticOnTouchListener(view: View) {
        view.setOnTouchListener(HapticOnTouchCallback())
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_30_11_R)
    fun applyPerformHapticFeedback(view: View, isSuccessful: Boolean) {
        if (isSuccessful) {
            view.performHapticFeedback(CHapticFeedbackConstants.CONFIRM)
        } else {
            view.performHapticFeedback(CHapticFeedbackConstants.REJECT)
        }
    }

    @JvmStatic
    fun applyFitSystemWindow(view: View) {
        view.fitsSystemWindows = true
    }

    @JvmStatic
    fun applyElevation(view: View, elevation: Float) {
        if (UtilKBuildVersion.isAfterV_21_5_L())
            view.elevation = elevation
    }

    @JvmStatic
    fun applyFocusable(view: View) {
        if (UtilKBuildVersion.isAfterV_26_8_O())
            view.focusable = CView.FOCUSABLE
    }

    @JvmStatic
    fun applyBackgroundNull(view: View) {
        applyBackground(view, null)
    }

    //设置背景
    @JvmStatic
    fun applyBackground(view: View, background: Drawable?) {
        if (UtilKBuildVersion.isAfterV_16_41_J())
            view.background = background
        else
            view.setBackgroundDrawable(background)
    }

    @JvmStatic
    fun applyPadding(view: View, insets: Insets) {
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom)
    }

    @JvmStatic
    fun applyPadding(view: View, padding: Int) {
        view.setPadding(padding, padding, padding, padding)
    }

    //四周内边距
    @JvmStatic
    fun applyPadding(view: View, paddingHorizontal: Int, paddingVertical: Int) {
        view.setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
    }

    //左右内边距
    @JvmStatic
    fun applyPaddingHorizontal(view: View, padding: Int) {
        view.setPadding(padding, 0, padding, 0)
    }

    //上下内边距
    @JvmStatic
    fun applyPaddingVertical(view: View, padding: Int) {
        view.setPadding(0, padding, 0, padding)
    }

    //////////////////////////////////////////////////////////////////////////////

    //重置大小
    @JvmStatic
    fun applyLayoutParams(view: View, width: Int, height: Int) {
        val layoutParams = view.layoutParams
        layoutParams.width = width
        layoutParams.height = height
        view.layoutParams = layoutParams
    }

    //重置大小
    @JvmStatic
    fun applyLayoutParams(view: View, size: Int) {
        applyLayoutParams(view, size, size)
    }

    @JvmStatic
    fun applyLayoutParams_ofMatch(view: View) {
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    @JvmStatic
    fun applyLayoutParams_ofHeightStatusBar(view: View) {
        view.layoutParams = view.layoutParams.apply {
            height = UtilKStatusBar.getHeight()
        }
    }

    inline fun <reified T : ViewGroup.LayoutParams> applyUpdateLayoutParams(view: View, block: IExt_Listener<T>) {
        view.layoutParams = (view.layoutParams as? T)?.apply(block) ?: kotlin.run {
            val width = view.layoutParams?.width ?: 0
            val height = view.layoutParams?.height ?: 0
            val lp = ViewGroup.LayoutParams(width, height)
            UtilKClass.newInstance<T>(lp).apply(block)
        }
    }

    //////////////////////////////////////////////////////////////////////////////

    //获取焦点
    @JvmStatic
    fun applyRequestFocus(view: View) {
        if (view.isInTouchMode) view.requestFocusFromTouch()
        else view.requestFocus()
    }
}

