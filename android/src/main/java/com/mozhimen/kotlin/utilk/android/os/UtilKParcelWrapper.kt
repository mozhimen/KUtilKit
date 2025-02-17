package com.mozhimen.kotlin.utilk.android.os

import android.os.Parcel

/**
 * @ClassName UtilKParcel
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
fun Parcel.applyWriteBoolean(value: Boolean) {
    UtilKParcelWrapper.applyWriteBoolean(this, value)
}

fun Parcel.applyReadBoolean(value: Boolean): Boolean =
    UtilKParcelWrapper.applyReadBoolean(this)

/////////////////////////////////////////////////////////////////

object UtilKParcelWrapper {
    @JvmStatic
    fun applyWriteBoolean(parcel: Parcel, value: Boolean) {
        if (UtilKBuildVersion.isAfterV_29_10_Q()) {
            parcel.writeBoolean(value)
        } else {
            parcel.writeByte(if (value) 1 else 0)
        }
    }

    @JvmStatic
    fun applyReadBoolean(parcel: Parcel): Boolean =
        if (UtilKBuildVersion.isAfterV_29_10_Q()) {
            parcel.readBoolean()
        } else {
            parcel.readByte() != 0.toByte()
        }
}