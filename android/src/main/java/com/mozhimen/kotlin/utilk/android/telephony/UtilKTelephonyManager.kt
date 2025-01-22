package com.mozhimen.kotlin.utilk.android.telephony

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.telephony.CTelephonyManager
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PRIVILEGED_PHONE_STATE
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.lintk.optins.OApiDeprecated_Official_AfterV_28_9_P
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_READ_PHONE_STATE
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.commons.IUtilK


/**
 * @ClassName UtilKTelephony
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/3/20 16:03
 * @Version 1.0
 */
object UtilKTelephonyManager : IUtilK {
    @JvmStatic
    fun get(context: Context): TelephonyManager =
        UtilKContext.getTelephonyManager(context)

    /**
     * API 23-28
     */
    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @OPermission_READ_PHONE_STATE
    @OApiDeprecated_Official_AfterV_28_9_P
    @RequiresPermission(allOf = [CPermission.READ_PRIVILEGED_PHONE_STATE, CPermission.READ_PHONE_STATE])
    @SuppressLint("HardwareIds")
    fun getDeviceId(context: Context, slotIndex: Int): String =
        get(context).getDeviceId(slotIndex)

    /**
     * API 23-28
     */
    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @OPermission_READ_PHONE_STATE
    @OApiDeprecated_Official_AfterV_28_9_P
    @RequiresPermission(allOf = [CPermission.READ_PRIVILEGED_PHONE_STATE, CPermission.READ_PHONE_STATE])
    @SuppressLint("HardwareIds")
    fun getDeviceId(context: Context): String =
        get(context).deviceId

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @OPermission_READ_PHONE_STATE
    @OApiDeprecated_Official_AfterV_28_9_P
    @RequiresPermission(allOf = [CPermission.READ_PRIVILEGED_PHONE_STATE, CPermission.READ_PHONE_STATE])
    fun getImei(context: Context): String =
        get(context).imei

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    @OPermission_READ_PRIVILEGED_PHONE_STATE
    @OPermission_READ_PHONE_STATE
    @OApiDeprecated_Official_AfterV_28_9_P
    @RequiresPermission(allOf = [CPermission.READ_PRIVILEGED_PHONE_STATE, CPermission.READ_PHONE_STATE])
    fun getMeid(context: Context): String =
        get(context).meid

    @JvmStatic
    fun getPhoneType(context: Context): Int =
        get(context).phoneType

    //////////////////////////////////////////////////////////////

    @JvmStatic
    fun hasTelephone(context: Context): Boolean =
        getPhoneType(context) != CTelephonyManager.PHONE_TYPE_NONE
}