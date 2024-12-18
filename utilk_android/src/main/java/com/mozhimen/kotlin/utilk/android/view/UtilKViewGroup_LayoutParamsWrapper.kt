package com.mozhimen.kotlin.utilk.android.view

import android.view.View
import android.view.ViewGroup
import androidx.annotation.Px

/**
 * @ClassName UtilKViewGroupLayoutParams
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/4/4 15:48
 * @Version 1.0
 */
fun View.applyMargin(@Px verticalMargin: Int, @Px horizontalMargin: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyMargin(this, verticalMargin, horizontalMargin)
}

fun View.applyMarginVertical(@Px margin: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyMarginVertical(this, margin)
}

fun View.applyMarginEnd(@Px rightMargin: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyMarginEnd(this, rightMargin)
}

fun View.applyMarginTop(@Px topMargin: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyMarginTop(this, topMargin)
}

///////////////////////////////////////////////////////////////////////////

object UtilKViewGroup_LayoutParamsWrapper {

    @JvmStatic
    fun requireMarginLayoutParams(view: View): ViewGroup.MarginLayoutParams? =
        when (view.layoutParams) {
            is ViewGroup.MarginLayoutParams -> view.layoutParams as ViewGroup.MarginLayoutParams
            else -> null
        }

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyMargin(view: View, @Px verticalMargin: Int, @Px horizontalMargin: Int) {
        applyMargin(view, horizontalMargin, verticalMargin, horizontalMargin, verticalMargin)
    }

    @JvmStatic
    fun applyMargin(view: View, @Px leftMargin: Int, @Px topMargin: Int, @Px rightMargin: Int, @Px bottomMargin: Int) {
        when (view.layoutParams) {
            is ViewGroup.MarginLayoutParams -> {
                val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin)
                view.layoutParams = layoutParams
            }
        }
    }

    @JvmStatic
    fun applyMarginTop(view: View, @Px topMargin: Int) {
        when (view.layoutParams) {
            is ViewGroup.MarginLayoutParams -> {
                val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(layoutParams.leftMargin, topMargin, layoutParams.rightMargin, layoutParams.bottomMargin)
                view.layoutParams = layoutParams
            }
        }
    }

    @JvmStatic
    fun applyMarginEnd(view: View, @Px rightMargin: Int) {
        when (view.layoutParams) {
            is ViewGroup.MarginLayoutParams -> {
                val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, rightMargin, layoutParams.bottomMargin)
                view.layoutParams = layoutParams
            }
        }
    }

    @JvmStatic
    fun applyMarginVertical(view: View, @Px margin: Int) {
        applyMarginVertical(view, margin, margin)
    }

    @JvmStatic
    fun applyMarginVertical(view: View, @Px topMargin: Int, @Px bottomMargin: Int) {
        when (view.layoutParams) {
            is ViewGroup.MarginLayoutParams -> {
                val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(layoutParams.leftMargin, topMargin, layoutParams.rightMargin, bottomMargin)
                view.layoutParams = layoutParams
            }
        }
    }
}