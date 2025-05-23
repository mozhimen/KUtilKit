package com.mozhimen.kotlin.utilk.android.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothServerSocket
import android.content.Context
import androidx.annotation.RequiresPermission
import java.util.UUID

/**
 * @ClassName UtilKBluetoothAdapter
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/11
 * @Version 1.0
 */
object UtilKBluetoothAdapter {
    @JvmStatic
    fun get(context: Context): BluetoothAdapter? =
        UtilKBluetoothManager.getAdapter(context)

    @JvmStatic
    fun getDefault(): BluetoothAdapter? =
        BluetoothAdapter.getDefaultAdapter()

    ////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isDefaultSupport(): Boolean =
        isSupport(getDefault())

    @JvmStatic
    fun isSupport(context: Context): Boolean =
        isSupport(get(context))

    @JvmStatic
    fun isSupport(adapter: BluetoothAdapter?): Boolean =
        adapter != null

    @JvmStatic
    fun isEnabled(adapter: BluetoothAdapter): Boolean =
        adapter.isEnabled

    ////////////////////////////////////////////////////////////////////

    //获取已经配对的设备
    @JvmStatic
    @RequiresPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
    fun getBondedDevices(bluetoothAdapter: BluetoothAdapter): Set<BluetoothDevice> =
        bluetoothAdapter.bondedDevices

    ////////////////////////////////////////////////////////////////////

    //加密传输，Android强制执行配对，弹窗显示配对码
    @JvmStatic
    @RequiresPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
    fun listenUsingRfcommWithServiceRecord(bluetoothAdapter: BluetoothAdapter, name: String, uuid: UUID): BluetoothServerSocket =
        bluetoothAdapter.listenUsingRfcommWithServiceRecord(name, uuid)

    //明文传输(不安全)，无需配对
    @JvmStatic
    @RequiresPermission(android.Manifest.permission.BLUETOOTH_CONNECT)
    fun listenUsingInsecureRfcommWithServiceRecord(bluetoothAdapter: BluetoothAdapter, name: String, uuid: UUID): BluetoothServerSocket =
        bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(name, uuid)
}