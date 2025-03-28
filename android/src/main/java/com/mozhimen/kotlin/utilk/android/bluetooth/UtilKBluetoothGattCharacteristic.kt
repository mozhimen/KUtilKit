package com.mozhimen.kotlin.utilk.android.bluetooth

import android.bluetooth.BluetoothGattCharacteristic
import com.mozhimen.kotlin.elemk.android.bluetooth.cons.CBluetoothGattCharacteristic

/**
 * @ClassName UtilKBluetoothGattCharacteristic
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2025/3/27 21:58
 * @Version 1.0
 */
object UtilKBluetoothGattCharacteristic {
    @JvmStatic
    fun canBluetoothGattCharacteristicRead(bluetoothGattCharacteristic: BluetoothGattCharacteristic): Boolean =
        bluetoothGattCharacteristic.properties and CBluetoothGattCharacteristic.PROPERTY_READ != 0

    @JvmStatic
    fun canBluetoothGattCharacteristicWrite(bluetoothGattCharacteristic: BluetoothGattCharacteristic): Boolean =
        bluetoothGattCharacteristic.properties and CBluetoothGattCharacteristic.PROPERTY_WRITE != 0

    @JvmStatic
    fun canBluetoothGattCharacteristicNotify(bluetoothGattCharacteristic: BluetoothGattCharacteristic): Boolean =
        bluetoothGattCharacteristic.properties and CBluetoothGattCharacteristic.PROPERTY_NOTIFY != 0
}