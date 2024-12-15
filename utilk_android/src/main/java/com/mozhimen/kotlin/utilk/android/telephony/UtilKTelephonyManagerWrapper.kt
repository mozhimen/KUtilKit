package com.mozhimen.kotlin.utilk.android.telephony

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.telephony.UtilKTelephonyManager.TAG
import com.mozhimen.kotlin.utilk.android.telephony.UtilKTelephonyManager.get
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.kotlin.strPackage2clazz
import java.lang.reflect.Method

/**
 * @ClassName UtilKTelephonyManagerWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
object UtilKTelephonyManagerWrapper {
    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun getImei(context: Context, slotIndex: Int): String {
        val telephonyManager = get(context)
        return telephonyManager.javaClass.getMethod("getImei", Int::class.javaPrimitiveType).invoke(telephonyManager, slotIndex) as String// android 8 即以后建议用getImei 方法获取 不会获取到MEID
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_26_8_O)
    fun getMeid(context: Context, slotIndex: Int): String {
        val telephonyManager = get(context)
        return telephonyManager.javaClass.getMethod("getMeid", Int::class.javaPrimitiveType).invoke(telephonyManager, slotIndex) as String// android 8 即以后建议用getImei 方法获取 不会获取到MEID
    }

    /**
     * 反射获取 IMEI/MEID
     * Android 6.0之后如果用户不允许通过 [CPermission.READ_PHONE_STATE] 权限的话，
     * 那么是没办法通过系统api进行获取 IMEI/MEID 的，但是可以通过这个反射来尝试绕过权限进行获取
     * @return 获取到的值 或者 空串""
     */
    @JvmStatic
    @SuppressLint("DiscouragedPrivateApi")
    fun getDeviceId_ofReflect(context: Context): String {
        try {
            val telephonyManager = get(context)
            return if (UtilKBuildVersion.isAfterV_21_5_L()) {
                val methodGetDefaultSim: Method = TelephonyManager::class.java.getDeclaredMethod("getDefaultSim")
                methodGetDefaultSim.isAccessible = true
                val defaultSim: Any? = methodGetDefaultSim.invoke(telephonyManager)

                val methodGetDeviceId: Method = TelephonyManager::class.java.getDeclaredMethod("getDeviceId", Int::class.javaPrimitiveType)
                methodGetDeviceId.invoke(telephonyManager, defaultSim)?.toString() ?: ""
            } else {
                val methodGetSubscriberInfo: Method = TelephonyManager::class.java.getDeclaredMethod("getSubscriberInfo")
                methodGetSubscriberInfo.isAccessible = true
                val subInfo: Any? = methodGetSubscriberInfo.invoke(telephonyManager)

                val methodGetDeviceId: Method = "com.android.internal.telephony.IPhoneSubInfo".strPackage2clazz().getDeclaredMethod("getDeviceId")
                methodGetDeviceId.invoke(subInfo)?.toString() ?: ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
        return ""
    }

    /**
     * 反射获取 deviceId
     * @param slotId  slotId为卡槽Id，它的值为 0、1；
     */
    @JvmStatic
    fun getDeviceId_ofReflect(context: Context, slotIndex: Int): String {
        try {
            val telephonyManager = get(context)
            val methodGetDeviceId: Method = telephonyManager.javaClass.getMethod("getDeviceId", Int::class.javaPrimitiveType)
            return methodGetDeviceId.invoke(telephonyManager, slotIndex)?.toString() ?: ""
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
        return ""
    }
}