package com.mozhimen.kotlin.elemk.android.view.impls

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy
import com.mozhimen.kotlin.utilk.android.view.applyVisibleIfElseInVisible
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes
import java.lang.ref.WeakReference

/**
 * @ClassName ViewProxy
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/4/26
 * @Version 1.0
 */
@OApiInit_ByLazy
@Suppress("UNCHECKED_CAST")
class ViewProxy<T>(private val _viewRef: WeakReference<View>) {

    fun setText(@IdRes intResId: Int, text: CharSequence?): T {
        _viewRef.get()?.findViewById<TextView>(intResId)?.text = text
        return this as T
    }

    fun setText(@IdRes intResId: Int, @StringRes intResStr: Int): T {
        _viewRef.get()?.findViewById<TextView>(intResId)?.setText(intResStr)
        return this as T
    }

    fun setTextColor(@IdRes intResId: Int, @ColorInt intResColor: Int): T {
        _viewRef.get()?.findViewById<TextView>(intResId)?.setTextColor(intResColor)
        return this as T
    }

    fun setTextColor(@IdRes intResId: Int, @ColorRes intResColor: Int, context: Context): T {
        _viewRef.get()?.findViewById<TextView>(intResId)?.setTextColor(UtilKRes.gainColor(context, intResColor))
        return this as T
    }

    fun setImageResource(@IdRes intResId: Int, @DrawableRes intResDrawable: Int): T {
        _viewRef.get()?.findViewById<ImageView>(intResId)?.setImageResource(intResDrawable)
        return this as T
    }

    fun setImageDrawable(@IdRes intResId: Int, drawable: Drawable): T {
        _viewRef.get()?.findViewById<ImageView>(intResId)?.setImageDrawable(drawable)
        return this as T
    }

    fun setImageBitmap(@IdRes intResId: Int, bitmap: Bitmap): T {
        _viewRef.get()?.findViewById<ImageView>(intResId)?.setImageBitmap(bitmap)
        return this as T
    }

    fun setBackgroundColor(@IdRes intResId: Int, @ColorInt intResColor: Int): T {
        _viewRef.get()?.findViewById<View>(intResId)?.setBackgroundColor(intResColor)
        return this as T
    }

    fun setBackgroundResource(@IdRes intResId: Int, @DrawableRes intResDrawable: Int): T {
        _viewRef.get()?.findViewById<View>(intResId)?.setBackgroundResource(intResDrawable)
        return this as T
    }

    //设置可见
    fun setVisibility(@IdRes intResId: Int, visible: Int): T {
        _viewRef.get()?.findViewById<View>(intResId)?.visibility = visible
        return this as T
    }

    fun setVisibility(@IdRes intResId: Int, isVisible: Boolean): T {
        _viewRef.get()?.findViewById<View>(intResId)?.applyVisibleIfElseInVisible(isVisible)
        return this as T
    }

    fun isEnabled(@IdRes intResId: Int, isEnabled: Boolean): T {
        _viewRef.get()?.findViewById<View>(intResId)?.isEnabled = isEnabled
        return this as T
    }

    //设置标签
    fun setTag(@IdRes intResId: Int, obj: Any): T {
        _viewRef.get()?.findViewById<View>(intResId)?.tag = obj
        return this as T
    } //其他方法可自行扩展

    //设置点击监听
    fun setOnClickListener(@IdRes intResId: Int, listener: View.OnClickListener): T {
        _viewRef.get()?.findViewById<View>(intResId)?.setOnClickListener(listener)
        return this as T
    }
}