package com.mozhimen.kotlin.utilk.android.graphics

import android.graphics.Rect

/**
 * @ClassName UtilKRect
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
fun Rect.relativeTo(otherRect: Rect): Rect =
    UtilKRect.relativeTo(this, otherRect)

////////////////////////////////////////////////////////////////

object UtilKRect {
    /**
     * get the relative rect of the [Rect] according to the [otherRect] ,considering the [otherRect]'s left and top is zero
     */
    @JvmStatic
    fun relativeTo(curRect: Rect, otherRect: Rect): Rect {
        val relativeLeft = curRect.left - otherRect.left
        val relativeTop = curRect.top - otherRect.top
        val relativeRight = relativeLeft + curRect.right - curRect.left
        val relativeBottom = relativeTop + curRect.bottom - curRect.top
        return Rect(relativeLeft, relativeTop, relativeRight, relativeBottom)
    }
}