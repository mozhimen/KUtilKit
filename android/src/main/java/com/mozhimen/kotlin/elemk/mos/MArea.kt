package com.mozhimen.kotlin.elemk.mos

import android.os.Parcel
import android.os.Parcelable


/**
 * @ClassName MArea
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
class MArea : Parcelable {
    var width: Int = 0
    var height: Int = 0
    var left: Int = 0
    var top: Int = 0
    val right: Int get() = width + left
    val bottom: Int get() = top + height

    constructor() {}

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    constructor(width: Int, height: Int, left: Int, top: Int) {
        this.width = width
        this.height = height
        this.left = left
        this.top = top
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(width)
        parcel.writeInt(height)
        parcel.writeInt(left)
        parcel.writeInt(top)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MArea> {
        override fun createFromParcel(parcel: Parcel): MArea {
            val mAreaF = MArea()
            mAreaF.readFromParcel(parcel)
            return mAreaF
        }

        override fun newArray(size: Int): Array<MArea?> {
            return arrayOfNulls(size)
        }
    }

    fun readFromParcel(parcel: Parcel) {
        width = parcel.readInt()
        height = parcel.readInt()
        left = parcel.readInt()
        top = parcel.readInt()
    }

    override fun toString(): String {
        return "MArea(width=$width, height=$height, left=$left, top=$top, right=$right, bottom=$bottom)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MArea

        if (width != other.width) return false
        if (height != other.height) return false
        if (left != other.left) return false
        if (top != other.top) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + left
        result = 31 * result + top
        return result
    }
}

class MAreaF : Parcelable {
    var width: Float = 0f
    var height: Float = 0f
    var left: Float = 0f
    var top: Float = 0f
    val right: Float get() = width + left
    val bottom: Float get() = top + height

    constructor() {}

    constructor(width: Int, height: Int) {
        this.width = width.toFloat()
        this.height = height.toFloat()
    }

    constructor(width: Float, height: Float) {
        this.width = width
        this.height = height
    }

    constructor(width: Float, height: Float, left: Float, top: Float) {
        this.width = width
        this.height = height
        this.left = left
        this.top = top
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(width)
        parcel.writeFloat(height)
        parcel.writeFloat(left)
        parcel.writeFloat(top)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MAreaF> {
        override fun createFromParcel(parcel: Parcel): MAreaF {
            val mAreaF = MAreaF()
            mAreaF.readFromParcel(parcel)
            return mAreaF
        }

        override fun newArray(size: Int): Array<MAreaF?> {
            return arrayOfNulls(size)
        }
    }

    fun readFromParcel(parcel: Parcel) {
        width = parcel.readFloat()
        height = parcel.readFloat()
        left = parcel.readFloat()
        top = parcel.readFloat()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MAreaF

        if (width != other.width) return false
        if (height != other.height) return false
        if (left != other.left) return false
        if (top != other.top) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + height.hashCode()
        result = 31 * result + left.hashCode()
        result = 31 * result + top.hashCode()
        return result
    }

    override fun toString(): String {
        return "MAreaF(width=$width, height=$height, left=$left, top=$top, right=$right, bottom=$bottom)"
    }
}