package com.mozhimen.kotlin.utilk.android.bluetooth

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.bluetooth.cons.CBluetoothDevice
import com.mozhimen.kotlin.elemk.android.cons.CPermission

/**
 * @ClassName UtilKBluetoothDeviceWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/19
 * @Version 1.0
 */
@SuppressLint("InlinedApi")
@RequiresPermission(CPermission.BLUETOOTH_CONNECT)
fun BluetoothDevice.isBondState_BOND_BONDING(): Boolean =
    UtilKBluetoothDeviceWrapper.isBondState_BOND_BONDING(this)

@SuppressLint("InlinedApi")
@RequiresPermission(CPermission.BLUETOOTH_CONNECT)
fun BluetoothDevice.isBondState_BOND_BONDED(): Boolean =
    UtilKBluetoothDeviceWrapper.isBondState_BOND_BONDED(this)

@SuppressLint("InlinedApi")
@RequiresPermission(CPermission.BLUETOOTH_CONNECT)
fun BluetoothDevice.isBondState_BOND_NONE(): Boolean =
    UtilKBluetoothDeviceWrapper.isBondState_BOND_NONE(this)

//////////////////////////////////////////////////////////////////////////

object UtilKBluetoothDeviceWrapper {
    @SuppressLint("InlinedApi")
    @JvmStatic
    @RequiresPermission(CPermission.BLUETOOTH_CONNECT)
    fun isBondState_BOND_BONDING(bluetoothDevice: BluetoothDevice): Boolean =
        bluetoothDevice.bondState == CBluetoothDevice.BOND_BONDING

    @SuppressLint("InlinedApi")
    @JvmStatic
    @RequiresPermission(CPermission.BLUETOOTH_CONNECT)
    fun isBondState_BOND_BONDED(bluetoothDevice: BluetoothDevice): Boolean =
        bluetoothDevice.bondState == CBluetoothDevice.BOND_BONDED

    @SuppressLint("InlinedApi")
    @JvmStatic
    @RequiresPermission(CPermission.BLUETOOTH_CONNECT)
    fun isBondState_BOND_NONE(bluetoothDevice: BluetoothDevice): Boolean =
        bluetoothDevice.bondState == CBluetoothDevice.BOND_NONE

}