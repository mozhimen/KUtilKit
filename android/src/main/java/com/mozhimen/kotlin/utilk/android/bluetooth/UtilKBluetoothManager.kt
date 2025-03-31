package com.mozhimen.kotlin.utilk.android.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKBluetoothManager
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/26
 * @Version 1.0
 */
object UtilKBluetoothManager {
    @JvmStatic
    fun get(context: Context): BluetoothManager =
        UtilKContextGet.getSystemService_BLUETOOTH(context)

    @JvmStatic
    fun getAdapter(context: Context): BluetoothAdapter? =
        get(context).adapter
}