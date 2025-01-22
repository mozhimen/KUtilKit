package com.mozhimen.kotlin.utilk.androidx.constraintlayout

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.mozhimen.kotlin.elemk.commons.IExt_Listener

/**
 * @ClassName UtilKConstraintLayoutLayoutParams
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/23 22:34
 * @Version 1.0
 */
fun View.constraintTo(
    startToStart: Int? = null,
    startToEnd: Int? = null,
    endToEnd: Int? = null,
    endToStart: Int? = null,
    topToTop: Int? = null,
    topToBottom: Int? = null,
    bottomToBottom: Int? = null,
    bottomToTop: Int? = null
) {
    UtilKConstraintLayoutLayoutParams.constraintTo(this, startToStart, startToEnd, endToEnd, endToStart, topToTop, topToBottom, bottomToBottom, bottomToTop)
}

fun View.constraintTo(
    block: IExt_Listener<ConstraintLayout.LayoutParams>
) {
    UtilKConstraintLayoutLayoutParams.constraintTo(this, block)
}

////////////////////////////////////////////////////////////////////////

object UtilKConstraintLayoutLayoutParams {
    @JvmStatic
    fun constraintTo(
        view: View,
        startToStart: Int? = null,
        startToEnd: Int? = null,
        endToEnd: Int? = null,
        endToStart: Int? = null,
        topToTop: Int? = null,
        topToBottom: Int? = null,
        bottomToBottom: Int? = null,
        bottomToTop: Int? = null
    ) {
        if (view.layoutParams !is ConstraintLayout.LayoutParams ||
            startToStart == null &&
            startToEnd == null &&
            endToEnd == null &&
            endToStart == null &&
            topToTop == null &&
            topToBottom == null &&
            bottomToBottom == null &&
            bottomToTop == null
        ) return
        val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
        startToStart?.let { layoutParams.startToStart = it }
        startToEnd?.let { layoutParams.startToEnd = it }
        endToEnd?.let { layoutParams.endToEnd = it }
        endToStart?.let { layoutParams.endToStart = it }
        topToTop?.let { layoutParams.topToTop = it }
        topToBottom?.let { layoutParams.topToBottom = it }
        bottomToBottom?.let { layoutParams.bottomToBottom = it }
        bottomToTop?.let { layoutParams.bottomToTop = it }
        view.layoutParams = layoutParams
    }

    @JvmStatic
    fun constraintTo(
        view: View,
        block: IExt_Listener<ConstraintLayout.LayoutParams>
    ) {
        if (view.layoutParams is ConstraintLayout.LayoutParams) {
            val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.block()
            view.layoutParams = layoutParams
        }
    }
}