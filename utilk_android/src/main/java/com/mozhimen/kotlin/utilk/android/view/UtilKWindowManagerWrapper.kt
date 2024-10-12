package com.mozhimen.kotlin.utilk.android.view

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.WindowManager
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.UtilKLazyJVM.lazy_ofNone
import com.mozhimen.kotlin.utilk.kotlin.strPackage2clazz

/**
 * @ClassName UtilKWindowManagerGlobal
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/13
 * @Version 1.0
 */
fun WindowManager.addViewSafe(view: View, layoutParams: WindowManager.LayoutParams) {
    UtilKWindowManagerWrapper.addViewSafe(this, view, layoutParams)
}

fun WindowManager.addViewSafe(view: View, width: Int, height: Int) {
    UtilKWindowManagerWrapper.addViewSafe(this, view, width, height)
}

fun WindowManager.removeViewSafe(view: View) {
    UtilKWindowManagerWrapper.removeViewSafe(this, view)
}

////////////////////////////////////////////////////////

object UtilKWindowManagerWrapper : IUtilK {

    private val _windowManagerClazz by lazy_ofNone {
        try {
            "android.view.WindowManagerGlobal".strPackage2clazz()
        } catch (ignored: Throwable) {
            Log.w(TAG, ignored)
            null
        }
    }

    private val _windowManagerInstance by lazy_ofNone {
        _windowManagerClazz?.getMethod("getInstance")?.invoke(null)
    }

    private val _viewsField by lazy_ofNone {
        _windowManagerClazz?.let { windowManagerClass ->
            windowManagerClass.getDeclaredField("mViews").apply { isAccessible = true }
        }
    }

    private val _paramsField by lazy_ofNone {
        _windowManagerClazz?.let { windowManagerClass ->
            windowManagerClass.getDeclaredField("mParams").apply { isAccessible = true }
        }
    }

    @JvmStatic
    @SuppressLint("PrivateApi", "ObsoleteSdkInt", "DiscouragedPrivateApi")
    fun getViews(): List<View> {
        try {
            _windowManagerInstance?.let { windowManagerInstance ->
                _viewsField?.let { mViewsField ->
                    return mViewsField[windowManagerInstance] as ArrayList<View>
                }
            }
        } catch (ignored: Throwable) {
            Log.w(TAG, ignored)
        }
        return emptyList()
    }

    @JvmStatic
    @SuppressLint("PrivateApi", "ObsoleteSdkInt", "DiscouragedPrivateApi")
    fun getParams(): List<WindowManager.LayoutParams> {
        try {
            _windowManagerInstance?.let { windowManagerInstance ->
                _paramsField?.let { mViewsField ->
                    return mViewsField[windowManagerInstance] as ArrayList<WindowManager.LayoutParams>
                }
            }
        } catch (ignored: Throwable) {
            Log.w(TAG, ignored)
        }
        return emptyList()
    }

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addViewSafe(windowManager: WindowManager, view: View, width: Int, height: Int) {
        addViewSafe(windowManager, view, WindowManager.LayoutParams(width, height))
    }

    @JvmStatic
    fun addViewSafe(windowManager: WindowManager, view: View, layoutParams: WindowManager.LayoutParams) {
        try {
            if (!view.hasParentOrAttachedToWindow())
                windowManager.addView(view, layoutParams)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun removeViewSafe(windowManager: WindowManager, view: View) {
        try {
            if (view.hasParentOrAttachedToWindow())
                windowManager.removeViewImmediate(view)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}