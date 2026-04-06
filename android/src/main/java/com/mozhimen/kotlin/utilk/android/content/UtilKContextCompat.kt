package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager

/**
 * @ClassName UtilKContextCompat
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/3/20 22:39
 * @Version 1.0
 */
object UtilKContextCompat {
    @JvmStatic
    fun getColor(@ColorRes intResColor: Int, context: Context): Int =
        ContextCompat.getColor(context, intResColor)

    @JvmStatic
    fun getColorStateList(@ColorRes intResColor: Int, context: Context): ColorStateList? =
        ContextCompat.getColorStateList(context, intResColor)

    @JvmStatic
    fun getDrawable(@DrawableRes intResDrawable: Int, context: Context): Drawable? =
        ContextCompat.getDrawable(context, intResDrawable)

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isSelfPermissionGranted(permission: String, context: Context): Boolean =
        checkSelfPermission(permission, context) == CPackageManager.PERMISSION_GRANTED

    @JvmStatic
    fun checkSelfPermission(permission: String, context: Context): Int =
        ContextCompat.checkSelfPermission(context, permission)
}