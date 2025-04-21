package com.mozhimen.kotlin.utilk.wrapper

import android.R
import android.content.Context
import android.util.TypedValue
import com.mozhimen.kotlin.utilk.bases.BaseUtilK


/**
 * @ClassName UtilKActionBar
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/4/21
 * @Version 1.0
 */
object UtilKActionBar : BaseUtilK() {
    @JvmStatic
    fun getHeight_resources(context: Context = _context): Int {
        var actionBarHeight = 0
        val typedValue = TypedValue()
        if (context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            actionBarHeight = UtilKRes.getDimensionPixelSize_ofResources(context, typedValue.resourceId)
        }
        return actionBarHeight
    }
}