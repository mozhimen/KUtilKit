package com.mozhimen.kotlin.utilk.android.content

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Parcelable
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKIntentWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/22
 * @Version 1.0
 */
inline fun <reified T : Parcelable> Intent.gainParcelableArrayListExtra(name: String): ArrayList<T>? =
    UtilKIntentWrapper.gainParcelableArrayListExtra(this, name)

inline fun <reified T : Parcelable> Intent.gainParcelableExtra(name: String): T? =
    UtilKIntentWrapper.gainParcelableExtra(this, name)

///////////////////////////////////////////////////////////////////////////////////////

@OPermission_QUERY_ALL_PACKAGES
fun Intent.isIntentAvailable(context: Context): Boolean =
    UtilKIntentWrapper.isIntentAvailable(this, context)

@OPermission_QUERY_ALL_PACKAGES
fun Intent.isIntentAvailable(pm: PackageManager): Boolean =
    UtilKIntentWrapper.isIntentAvailable(this, pm)

///////////////////////////////////////////////////////////////////////////////////////

object UtilKIntentWrapper : IUtilK {

    @JvmStatic
    inline fun <reified T : Parcelable> gainParcelableArrayListExtra(intent: Intent, name: String): ArrayList<T>? =
        try {
            UtilKIntent.getParcelableArrayListExtra(intent, name)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    @JvmStatic
    inline fun <reified T : Parcelable> gainParcelableExtra(intent: Intent, name: String): T? =
        try {
            UtilKIntent.getParcelableExtra(intent, name)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    ///////////////////////////////////////////////////////////////////////////////////////

    //要启动的intent是否可用
    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    fun isIntentAvailable(intent: Intent, context: Context): Boolean =
        (UtilKIntent.resolveActivity(intent, context) != null).also { UtilKLogWrapper.d(TAG, "isIntentAvailable: $it") }

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    fun isIntentAvailable(intent: Intent, pm: PackageManager): Boolean =
        (UtilKIntent.resolveActivity(intent, pm) != null).also { UtilKLogWrapper.d(TAG, "isIntentAvailable: $it") }
}