package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.res.Resources.Theme
import android.content.res.TypedArray
import android.util.TypedValue
import androidx.annotation.AnyRes
import androidx.annotation.StyleableRes
import com.mozhimen.kotlin.elemk.cons.CPackage
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName UtilKTheme
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/3/18 20:57
 * @Version 1.0
 */
object UtilKTheme {
    @JvmStatic
    fun get(context: Context): Theme =
        UtilKContext.getTheme(context)

    ////////////////////////////////////////////////////////////////////

    //是否全屏
    @JvmStatic
    fun isFullScreen(context: Context): Boolean =
        obtainStyledAttributes(context, intArrayOf(CPackage.ANDROID_R_ATTR_WINDOWFULLSCREEN)).use { it.getBoolean(0, false) }

    ////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun resolveAttribute(context: Context,@AnyRes intResAny: Int, outValue: TypedValue, resolveRefs: Boolean) =
        get(context).resolveAttribute(intResAny, outValue, resolveRefs)

    @JvmStatic
    fun obtainStyledAttributes(context: Context, @StyleableRes attrs: IntArray): TypedArray =
        get(context).obtainStyledAttributes(attrs)

}