package com.mozhimen.kotlin.elemk.mos

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 * @ClassName MoKKey
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Version 1.0
 */
data class MKey2(
    var id: Long,
    var name: String
) : Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MKey2> {
        override fun createFromParcel(parcel: Parcel): MKey2 {
            return MKey2(parcel)
        }

        override fun newArray(size: Int): Array<MKey2?> {
            return arrayOfNulls(size)
        }
    }
}