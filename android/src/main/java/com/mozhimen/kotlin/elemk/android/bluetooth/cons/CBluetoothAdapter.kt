package com.mozhimen.kotlin.elemk.android.bluetooth.cons

import android.bluetooth.BluetoothAdapter


/**
 * @ClassName CBluetoothAdapter
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CBluetoothAdapter {
    const val ACTION_REQUEST_ENABLE = BluetoothAdapter.ACTION_REQUEST_ENABLE
    const val ACTION_STATE_CHANGED = BluetoothAdapter.ACTION_STATE_CHANGED
    const val EXTRA_STATE = BluetoothAdapter.EXTRA_STATE
    const val ERROR = BluetoothAdapter.ERROR
}