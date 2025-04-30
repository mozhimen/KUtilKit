package com.mozhimen.kotlin.utilk.android.view

import android.view.View
import android.view.ViewGroup
import androidx.annotation.Px
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import com.mozhimen.kotlin.utilk.java.lang.UtilKClass
import com.mozhimen.kotlin.utilk.wrapper.UtilKStatusBar

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

fun View.applyMargin(@Px leftMargin: Int, @Px topMargin: Int, @Px rightMargin: Int, @Px bottomMargin: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyMargin(this, leftMargin, topMargin, rightMargin, bottomMargin)
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

fun View.applyLayoutParams(width: Int, height: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyLayoutParams(this, width, height)
}

fun View.applyLayoutParams(size: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyLayoutParams(this, size)
}

fun View.applyLayoutParams_MATCH_MATCH() {
    UtilKViewGroup_LayoutParamsWrapper.applyLayoutParams_MATCH_MATCH(this)
}

fun View.applyLayoutParamsHeight_statusBar() {
    UtilKViewGroup_LayoutParamsWrapper.applyLayoutParamsHeight_statusBar(this)
}

fun View.applyLayoutParamsWidth(layoutParamsWidth: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyLayoutParamsWidth(this, layoutParamsWidth)
}

fun View.applyLayoutParamsHeight(layoutParamsHeight: Int) {
    UtilKViewGroup_LayoutParamsWrapper.applyLayoutParamsHeight(this, layoutParamsHeight)
}

inline fun <reified T : ViewGroup.LayoutParams> View.applyUpdateLayoutParams(block: IExt_Listener<T>) {
    UtilKViewGroup_LayoutParamsWrapper.applyUpdateLayoutParams(this, block)
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

    ///////////////////////////////////////////////////////////////////////////

    //重置大小
    @JvmStatic
    fun applyLayoutParams(view: View, width: Int, height: Int) {
        val layoutParams = UtilKView.getLayoutParams(view)
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
    fun applyLayoutParams_MATCH_MATCH(view: View) {
        view.layoutParams = UtilKViewGroup_LayoutParamsGet.get_MATCH_MATCH()
    }


    @JvmStatic
    fun applyLayoutParamsWidth(view: View, layoutParamsWidth: Int) {
        view.layoutParams = view.layoutParams.apply {
            width = layoutParamsWidth
        }
    }

    @JvmStatic
    fun applyLayoutParamsHeight(view: View, layoutParamsHeight: Int) {
        view.layoutParams = view.layoutParams.apply {
            height = layoutParamsHeight
        }
    }

    @JvmStatic
    fun applyLayoutParamsHeight_statusBar(view: View) {
        applyLayoutParamsHeight(view, UtilKStatusBar.getHeight_resources())
    }

    inline fun <reified T : ViewGroup.LayoutParams> applyUpdateLayoutParams(view: View, block: IExt_Listener<T>) {
        view.layoutParams = (view.layoutParams as? T)?.apply(block) ?: kotlin.run {
            val width = view.layoutParams?.width ?: 0
            val height = view.layoutParams?.height ?: 0
            val lp = ViewGroup.LayoutParams(width, height)
            UtilKClass.newInstance<T>(lp).apply(block)
        }
    }
}