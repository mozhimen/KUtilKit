package com.mozhimen.kotlin.utilk.android.app

import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.kotlin.strPackage2clazz


/**
 * @ClassName UtilKDialog
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/1/11 12:31
 * @Version 1.0
 */
object UtilKActivityThread : BaseUtilK() {

    /**
     * 关闭Android9.0弹出框（Detected problems with API compatibility）
     */
    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    @SuppressLint("PrivateApi", "DiscouragedPrivateApi", "SoonBlockedPrivateApi")
    fun hide_at28() {
        try {
//            val constructor = "android.content.pm.PackageParser\$Package".strPackage2clazz().getDeclaredConstructor(String::class.java)
//            constructor.isAccessible = true
            val clazzActivityThread = "android.app.ActivityThread".strPackage2clazz()

            val methodCurrentActivityThread = clazzActivityThread.getDeclaredMethod("currentActivityThread")
            methodCurrentActivityThread.isAccessible = true
            val activityThread = methodCurrentActivityThread.invoke(null)

            val fieldMHiddenApiWarningShown = clazzActivityThread.getDeclaredField("mHiddenApiWarningShown")
            fieldMHiddenApiWarningShown.isAccessible = true
            fieldMHiddenApiWarningShown.setBoolean(activityThread, true)
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
    }
}