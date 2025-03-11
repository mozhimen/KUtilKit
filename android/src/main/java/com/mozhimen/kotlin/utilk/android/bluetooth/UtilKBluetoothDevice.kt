package com.mozhimen.kotlin.utilk.android.bluetooth

import android.bluetooth.BluetoothDevice
import androidx.annotation.RequiresPermission
import java.util.UUID

/**
 * @ClassName UtilKBluetoothDevice
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/11
 * @Version 1.0
 */
object UtilKBluetoothDevice {
    //加密传输，Android强制执行配对，弹窗显示配对码
    @JvmStatic
    @RequiresPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
    fun createRfcommSocketToServiceRecord(bluetoothDevice: BluetoothDevice, uuid: UUID) {
        bluetoothDevice.createRfcommSocketToServiceRecord(uuid)
    }

    //明文传输(不安全)，无需配对
    @JvmStatic
    @RequiresPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
    fun createInsecureRfcommSocketToServiceRecord(bluetoothDevice: BluetoothDevice, uuid: UUID) {
        bluetoothDevice.createInsecureRfcommSocketToServiceRecord(uuid)
    }
}