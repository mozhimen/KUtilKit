package com.mozhimen.kotlin.utilk.wrapper

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.usb.UsbDevice
import android.os.Build
import android.os.Environment
import android.text.TextUtils
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CConfiguration
import com.mozhimen.kotlin.elemk.android.os.cons.CBuild
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.cons.CStrPackage
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PHONE_STATE
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PRIVILEGED_PHONE_STATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKConfiguration
import com.mozhimen.kotlin.utilk.android.content.UtilKPackage
import com.mozhimen.kotlin.utilk.android.hardware.UtilKCamera
import com.mozhimen.kotlin.utilk.android.hardware.UtilKUsbDevice
import com.mozhimen.kotlin.utilk.android.os.UtilKBuild
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.os.UtilKEnvironment
import com.mozhimen.kotlin.utilk.android.os.UtilKSystemProperties
import com.mozhimen.kotlin.utilk.android.os.UtilKSystemPropertiesWrapper
import com.mozhimen.kotlin.utilk.android.telephony.UtilKTelephonyManager
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.java.io.UtilKFileReader
import com.mozhimen.kotlin.utilk.java.io.UtilKRandomAccessFileWrapper

/**
 * @ClassName UtilKDevice
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/1/15 19:40
 * @Version 1.0
 */

object UtilKDevice : BaseUtilK() {

    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    @OPermission_READ_PHONE_STATE
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @RequiresPermission(allOf = [CPermission.READ_PHONE_STATE, CPermission.READ_PRIVILEGED_PHONE_STATE])
    fun getImei(): String =
        if (UtilKBuildVersion.isAfterV_23_6_M()) {
            UtilKImeiOrMeid.getImeiOrMeid(_context)
        } else ""

    /**
     * 设备内存空间
     */
    @JvmStatic
    fun getMemorySize(): String? =
        UtilKFileReader.getMemorySize()

    /**
     * cpu使用率
     */
    @JvmStatic
    fun getCpuUsage(): Float =
        UtilKRandomAccessFileWrapper.getCpuUsage()

    /**
     * 设备Rom版本
     */
    @JvmStatic
    fun getRomVersion(): String =
        UtilKSystemPropertiesWrapper.getRomVersion()

    /**
     * 设备硬件版本
     */
    @JvmStatic
    fun getHardwareVersion(): String =
        UtilKSystemPropertiesWrapper.getHwVersion()

    /**
     * 序列号
     */
    @SuppressLint("HardwareIds")
    @JvmStatic
    @OPermission_READ_PHONE_STATE
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @RequiresPermission(allOf = [CPermission.READ_PHONE_STATE, CPermission.READ_PRIVILEGED_PHONE_STATE])
    fun getSerialNumber(): String = if (UtilKBuildVersion.isAfterV_29_10_Q()) {
        CBuild.UNKNOWN
    } else if (UtilKBuildVersion.isAfterV_26_8_O()) {
        UtilKBuild.get_SERIAL()
    } else {
        UtilKSystemProperties.getStr(CStrPackage.ro_serialno, CBuild.UNKNOWN)
    }

    /**
     * 短序列号
     */
    @JvmStatic
    @OPermission_READ_PHONE_STATE
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @RequiresPermission(allOf = [CPermission.READ_PHONE_STATE, CPermission.READ_PRIVILEGED_PHONE_STATE])
    fun getSerialNumberShort(): String {
        var serial = getSerialNumber()
        if (!TextUtils.isEmpty(serial) && serial.length > 14)
            serial = serial.substring(14)
        return serial
    }

    ///////////////////////////////////////////////////////////////////////////////

    /**
     * 是否是平板
     */
    @JvmStatic
    fun isPad(context: Context): Boolean =
        if (UtilKTelephonyManager.hasTelephone(context)) {        //如果能打电话那可能是平板或手机，再根据配置判断
            //能打电话可能是手机也可能是平板
            (UtilKConfiguration.getScreenLayout_ofSys() and CConfiguration.ScreenLayout.SIZE_MASK >= CConfiguration.ScreenLayout.SIZE_LARGE)
        } else true //不能打电话一定是平板

    /**
     * 是否是折叠机型
     * 1.官方没有给我们提供api的
     * 2.只能去检测针对的机型
     */
    fun isFoldable(): Boolean {
        return if (TextUtils.equals(Build.BRAND, "samsung") && TextUtils.equals(Build.DEVICE, "Galaxy Z Fo1d2")) {
            UtilKScreen.getWidth() != 1768
        } else if (TextUtils.equals(Build.BRAND, "huawei") && TextUtils.equals(Build.DEVICE, "MateX")) {
            UtilKScreen.getWidth() != 2200
        } else if (TextUtils.equals(Build.BRAND, "google") && TextUtils.equals(Build.DEVICE, "generic_x86")) {
            UtilKScreen.getWidth() != 2200
        } else {
            true
        }
    }

    @JvmStatic
    fun hasFrontCamera(): Boolean =
        UtilKCamera.hasCamera_ofFront(_context)

    @JvmStatic
    fun hasFrontCameraOfPackage(): Boolean =
        UtilKPackage.hasFrontCamera()

    @JvmStatic
    fun hasBackCamera(): Boolean =
        UtilKCamera.hasCamera_ofBack(_context)

    @JvmStatic
    fun hasBackCameraOfPackage(): Boolean =
        UtilKPackage.hasBackCamera()

    /**
     * 设备是否有sd卡
     */
    @JvmStatic
    fun hasSdcard(): Boolean =
        TextUtils.equals(Environment.getExternalStorageState(), "mounted")

    /**
     * 设备是否有USB外设
     */
    @JvmStatic
    fun hasPid(context: Context, vendorId: Int, productId: Int): Boolean {
        val devices: Iterator<UsbDevice> = UtilKUsbDevice.getListValues(context).iterator()
        while (devices.hasNext()) {
            val usbDevice: UsbDevice = devices.next()
            if (usbDevice.vendorId == vendorId && usbDevice.productId == productId) return true
        }
        return false
    }

    /**
     * 是否有外部存储
     */
    @JvmStatic
    fun hasExternalStorage(): Boolean =
        UtilKEnvironment.isExternalStorageStateMounted()
}