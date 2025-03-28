package com.mozhimen.kotlin.utilk.android.os

import android.os.Parcel
import android.os.Parcelable

/**
 * @ClassName UtilKParcel
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
inline fun <reified T:Parcelable> Parcel.applyReadParcelable(): T? =
    UtilKParcelWrapper.applyReadParcelable(this)

fun Parcel.applyWriteBoolean(value: Boolean) {
    UtilKParcelWrapper.applyWriteBoolean(this, value)
}

fun Parcel.applyReadBoolean(value: Boolean): Boolean =
    UtilKParcelWrapper.applyReadBoolean(this)

fun Parcel.applyWriteStringList(value: List<String>) {
    UtilKParcelWrapper.applyWriteStringList(this, value)
}

fun Parcel.applyReadStringList(): List<String> =
    UtilKParcelWrapper.applyReadStringList(this)

/////////////////////////////////////////////////////////////////

object UtilKParcelWrapper {
    @JvmStatic
    inline fun <reified T:Parcelable> applyReadParcelable(parcel: Parcel): T? =
        if (UtilKBuildVersion.isAfterV_33_13_T())
            parcel.readParcelable(T::class.java.classLoader, T::class.java)
        else
            parcel.readParcelable(T::class.java.classLoader)

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

    @JvmStatic
    fun applyWriteStringList(parcel: Parcel, value: List<String>) {
        parcel.writeStringList(value)
    }

    @JvmStatic
    fun applyReadStringList(parcel: Parcel): List<String> =
        parcel.createStringArrayList() ?: emptyList()
}