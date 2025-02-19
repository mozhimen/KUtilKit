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
    const val ACTION_DISCOVERY_FINISHED = BluetoothAdapter.ACTION_DISCOVERY_FINISHED
    const val EXTRA_STATE = BluetoothAdapter.EXTRA_STATE
    const val ERROR = BluetoothAdapter.ERROR
    const val STATE_OFF = BluetoothAdapter.STATE_OFF
    const val STATE_TURNING_OFF = BluetoothAdapter.STATE_TURNING_OFF
    const val STATE_ON = BluetoothAdapter.STATE_ON
    const val STATE_TURNING_ON = BluetoothAdapter.STATE_TURNING_ON
}