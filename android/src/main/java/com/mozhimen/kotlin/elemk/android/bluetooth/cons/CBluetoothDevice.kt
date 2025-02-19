package com.mozhimen.kotlin.elemk.android.bluetooth.cons

import android.bluetooth.BluetoothDevice


/**
 * @ClassName CBluetoothDevice
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CBluetoothDevice {
    const val ACTION_ACL_DISCONNECTED = BluetoothDevice.ACTION_ACL_DISCONNECTED
    const val ACTION_FOUND = BluetoothDevice.ACTION_FOUND
    const val ACTION_BOND_STATE_CHANGED = BluetoothDevice.ACTION_BOND_STATE_CHANGED
    const val EXTRA_DEVICE = BluetoothDevice.EXTRA_DEVICE
    const val BOND_BONDING = BluetoothDevice.BOND_BONDING
    const val BOND_BONDED = BluetoothDevice.BOND_BONDED
    const val BOND_NONE = BluetoothDevice.BOND_NONE
}