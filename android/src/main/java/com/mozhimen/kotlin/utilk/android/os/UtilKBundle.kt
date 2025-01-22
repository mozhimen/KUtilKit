package com.mozhimen.kotlin.utilk.android.os

import android.os.Bundle
import android.os.Parcelable

/**
 * @ClassName UtilKBundle
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
fun <T : Parcelable> Bundle.gainParcelable(key: String?, clazz: Class<T>): T? =
    UtilKBundle.gainParcelable(this, key, clazz)

/////////////////////////////////////////////////////////////////

object UtilKBundle {
    @JvmStatic
    fun <T : Parcelable> gainParcelable(bundle: Bundle?, key: String?, clazz: Class<T>): T? =
        if (UtilKBuildVersion.isAfterV_33_13_T())
            bundle?.getParcelable(key, clazz)
        else
            bundle?.getParcelable(key)

    /////////////////////////////////////////////////////////////////

}