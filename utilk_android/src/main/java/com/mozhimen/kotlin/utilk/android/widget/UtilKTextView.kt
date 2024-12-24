package com.mozhimen.kotlin.utilk.android.widget

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.widget.TextView

/**
 * @ClassName UtilKTextView
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/27
 * @Version 1.0
 */
object UtilKTextView {
    @JvmStatic
    fun getText(textView: TextView): CharSequence =
        textView.text

    /**
     * 特点:
     * 返回 TextView 左、上、右、下的复合图标。
     * 不支持方向感知：
     * Drawable[0] 始终表示左侧图标。
     * Drawable[2] 始终表示右侧图标。
     * 不考虑布局的方向（LTR 或 RTL）。
     *
     * 返回值:
     * 一个 Drawable[] 数组，包含 4 个元素：
     * Drawable[0]: 左侧图标（left）。
     * Drawable[1]: 顶部图标（top）。
     * Drawable[2]: 右侧图标（right）。
     * Drawable[3]: 底部图标（bottom）。
     */
    @JvmStatic
    fun getCompoundDrawables(textView: TextView): Array<out Drawable> =
        textView.compoundDrawables

    /**
     * 特点:
     * 返回 TextView 起始、顶部、结束、底部的复合图标。
     * 支持方向感知：
     * 在 LTR 模式下：
     * Drawable[0] 表示起始（start）图标（左侧）。
     * Drawable[2] 表示结束（end）图标（右侧）。
     * 在 RTL 模式下：
     * Drawable[0] 表示起始（start）图标（右侧）。
     * Drawable[2] 表示结束（end）图标（左侧）。
     *
     * 返回值:
     * 一个 Drawable[] 数组，包含 4 个元素：
     * Drawable[0]: 起始图标（start）。
     * Drawable[1]: 顶部图标（top）。
     * Drawable[2]: 结束图标（end）。
     * Drawable[3]: 底部图标（bottom）。
     */
    @JvmStatic
    fun getCompoundDrawablesRelative(textView: TextView): Array<out Drawable> =
        textView.compoundDrawablesRelative

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyTypeface(textView: TextView, tf: Typeface?) {
        textView.typeface = tf
    }

    @JvmStatic
    fun applyFilters(textView: TextView, filters: Array<InputFilter>) {
        textView.filters = filters
    }

    /////////////////////////////////////////////////////////////////

    /**
     * 设置 TextView 左、上、右、下的 Drawable。
     * 不支持方向感知（LTR/RTL），left 和 right 始终表示固定的左右位置。
     * 必须手动设置 Drawable 的边界（通过 Drawable#setBounds）。
     * 如果未设置边界，图标可能不会显示。
     * 使用示例:
     */
    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, left: Drawable?, top: Drawable?, right: Drawable?, bottom: Drawable?) {
        textView.setCompoundDrawables(left, top, right, bottom)
    }

    /**
     * 设置 TextView 的复合图标，支持方向感知（LTR/RTL）。
     * 在 LTR 模式下，start 表示左侧，end 表示右侧。
     * 在 RTL 模式下，start 表示右侧，end 表示左侧。
     * 必须手动设置 Drawable 的边界（通过 Drawable#setBounds）。
     * 如果未设置边界，图标可能不会显示。
     */
    @JvmStatic
    fun applyCompoundDrawablesRelative(textView: TextView, start: Drawable?, top: Drawable?, end: Drawable?, bottom: Drawable?) {
        textView.setCompoundDrawablesRelative(start, top, end, bottom)
    }

    /**
     * 设置 TextView 的复合图标，并自动使用 Drawable 的固有大小（intrinsic width 和 intrinsic height）。
     * 不需要手动调用 Drawable#setBounds。
     * 不支持方向感知（LTR/RTL），left 和 right 始终表示固定的左右位置。
     */
    @JvmStatic
    fun applyCompoundDrawablesWithIntrinsicBounds(textView: TextView, left: Drawable?, top: Drawable?, right: Drawable?, bottom: Drawable?) {
        textView.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
    }

    @JvmStatic
    fun applyCompoundDrawablesWithIntrinsicBounds(textView: TextView, left: Int, top: Int, right: Int, bottom: Int) {
        textView.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
    }

    /**
     * 设置 TextView 的复合图标，支持方向感知（LTR/RTL）。
     * 在 LTR 模式下，start 表示左侧，end 表示右侧。
     * 在 RTL 模式下，start 表示右侧，end 表示左侧。
     * 自动使用 Drawable 的固有大小（intrinsic width 和 intrinsic height）。
     * 不需要手动调用 Drawable#setBounds。
     */
    @JvmStatic
    fun applyCompoundDrawablesRelativeWithIntrinsicBounds(textView: TextView, left: Drawable?, top: Drawable?, right: Drawable?, bottom: Drawable?) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom)
    }

    @JvmStatic
    fun applyCompoundDrawablesRelativeWithIntrinsicBounds(textView: TextView, left: Int, top: Int, right: Int, bottom: Int) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom)
    }
}