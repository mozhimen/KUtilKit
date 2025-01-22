package com.mozhimen.kotlin.utilk.android.os

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.java.util.cons.CDateFormat
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.OApiDeprecated_Official_AfterV_25_71_NM1
import com.mozhimen.kotlin.lintk.optins.OApiDeprecated_Official_AfterV_28_9_P
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PHONE_STATE
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

    /**
     * 在API 23-25版本的设备上无需配置权限
     */
    @JvmStatic
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @OPermission_READ_PHONE_STATE
    @OApiDeprecated_Official_AfterV_25_71_NM1
    @SuppressLint("HardwareIds")
    fun get_SERIAL(): String =
        Build.SERIAL

    //设备名
    @JvmStatic
    fun get_PRODUCT(): String =
        Build.PRODUCT

    //构建类型
    @JvmStatic
    fun get_TYPE(): String =
        Build.TYPE

    //构建标签聚合
    @JvmStatic
    fun get_TAGS(): String? =
        Build.TAGS

    //设备品牌
    @JvmStatic
    fun get_BRAND(): String =
        Build.BRAND

    //设备/硬件制造商
    @JvmStatic
    fun get_MANUFACTURER(): String =
        Build.MANUFACTURER

    //设备最终用户名
    @JvmStatic
    fun get_MODEL(): String =
        Build.MODEL

    //设备支持架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_SUPPORTED_ABIS(): Array<String> =
        Build.SUPPORTED_ABIS

    //设备支持架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_SUPPORTED_ABIS_STR(): String =
        get_SUPPORTED_ABIS().array2str()

    //设备支持32位架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_SUPPORTED_32_BIT_ABIS(): Array<String> =
        Build.SUPPORTED_32_BIT_ABIS

    //设备支持32位架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_SUPPORTED_32_BIT_ABIS_STR(): String =
        Build.SUPPORTED_32_BIT_ABIS.array2str()

    //设备支持64位架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_SUPPORTED_64_BIT_ABIS(): Array<String> =
        Build.SUPPORTED_64_BIT_ABIS

    //设备支持64位架构
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun get_SUPPORTED_64_BIT_ABIS_STR(): String =
        Build.SUPPORTED_64_BIT_ABIS.array2str()

    //设备开发板名称
    @JvmStatic
    fun get_BOARD(): String =
        Build.BOARD

    //设备工业设计名
    @JvmStatic
    fun get_DEVICE(): String =
        Build.DEVICE

    //硬件名称
    @JvmStatic
    fun get_HARDWARE(): String =
        Build.HARDWARE

    //唯一标识版本字符
    @JvmStatic
    fun get_FINGERPRINT(): String =
        Build.FINGERPRINT

    //构建显示ID
    @JvmStatic
    fun get_DISPLAY(): String =
        Build.DISPLAY

    //构建变更列表号
    @JvmStatic
    fun get_ID(): String =
        Build.ID

    //系统引导加载程序版本
    @JvmStatic
    fun get_BOOTLOADER(): String =
        Build.BOOTLOADER

    //构建内部Host
    @JvmStatic
    fun get_HOST(): String =
        Build.HOST

    //构建内部构建者
    @JvmStatic
    fun get_USER(): String =
        Build.USER

    //构建内部时间
    @JvmStatic
    fun get_TIME(): String =
        Build.TIME.longDate2strDate(CDateFormat.Format.`yyyy-MM-dd_HH_mm_ss`)

    //设备无线固件版本
    @JvmStatic
    fun getRadioVersion(): String? =
        Build.getRadioVersion()

    //API 26-28
    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    @RequiresPermission(allOf = [CPermission.READ_PRIVILEGED_PHONE_STATE, CPermission.READ_PHONE_STATE])
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @OPermission_READ_PHONE_STATE
    @OApiDeprecated_Official_AfterV_28_9_P
    fun getSerial(): String =
        Build.getSerial()
}