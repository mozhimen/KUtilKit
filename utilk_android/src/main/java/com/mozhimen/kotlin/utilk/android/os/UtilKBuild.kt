package com.mozhimen.kotlin.utilk.android.os

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CBuild
import com.mozhimen.kotlin.elemk.java.util.cons.CDateFormat
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PRIVILEGED_PHONE_STATE
import com.mozhimen.kotlin.utilk.kotlin.array2str
import com.mozhimen.kotlin.utilk.java.text.longDate2strDate

/**
 * @ClassName UtilKBuild
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/5/29 19:56
 * @Version 1.0
 */

object UtilKBuild {

    @JvmStatic
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @SuppressLint("HardwareIds")
    fun getSerial(): String =
        Build.SERIAL

    //设备名
    @JvmStatic
    fun getProduct(): String =
        Build.PRODUCT

    //构建类型
    @JvmStatic
    fun getType(): String =
        Build.TYPE

    //构建标签聚合
    @JvmStatic
    fun getTags(): String? =
        Build.TAGS

    //构建SDK版本
    @JvmStatic
    fun getVersionSDK(): String =
        UtilKBuildVersion.getStrSDKInt()

    //构建Release版本号
    @JvmStatic
    fun getVersionRelease(): String =
        UtilKBuildVersion.getRelease()

    //构建版本名称
    @JvmStatic
    fun getVersionCodeName(): String =
        UtilKBuildVersion.getCodeName()

    //设备品牌
    @JvmStatic
    fun getBrand(): String =
        Build.BRAND

    //设备/硬件制造商
    @JvmStatic
    fun getManufacture(): String =
        Build.MANUFACTURER

    //设备最终用户名
    @JvmStatic
    fun getModel(): String =
        Build.MODEL

    //设备支持架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getSupportABIs(): String =
        Build.SUPPORTED_ABIS.array2str()

    //设备支持32位架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getSupport32BitABIs(): String =
        Build.SUPPORTED_32_BIT_ABIS.array2str()

    //设备支持64位架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getSupport64BitABIs(): String =
        Build.SUPPORTED_64_BIT_ABIS.array2str()

    //设备开发板名称
    @JvmStatic
    fun getBoard(): String =
        Build.BOARD

    //设备工业设计名
    @JvmStatic
    fun getDevice(): String =
        Build.DEVICE

    //硬件名称
    @JvmStatic
    fun getHardware(): String =
        Build.HARDWARE

    //唯一标识版本字符
    @JvmStatic
    fun getFingerPrint(): String =
        Build.FINGERPRINT

    //构建显示ID
    @JvmStatic
    fun getDisplay(): String =
        Build.DISPLAY

    //构建变更列表号
    @JvmStatic
    fun getId(): String =
        Build.ID

    //设备无线固件版本
    @JvmStatic
    fun getRadioVersion(): String =
        Build.getRadioVersion() ?: CBuild.UNKNOWN

    //系统引导加载程序版本
    @JvmStatic
    fun getBootLoader(): String =
        Build.BOOTLOADER

    //构建内部Host
    @JvmStatic
    fun getHost(): String =
        Build.HOST

    //构建内部构建者
    @JvmStatic
    fun getUser(): String =
        Build.USER

    //构建内部时间
    @JvmStatic
    fun getTime(): String =
        Build.TIME.longDate2strDate(CDateFormat.Format.yyyy_MM_dd_HH_mm_ss)
}