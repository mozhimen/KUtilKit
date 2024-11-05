package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Parcelable
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName UtilKIntent
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/2/26 23:03
 * @Version 1.0
 */
fun Intent.createChooser(title: CharSequence): Intent =
    UtilKIntent.createChooser(this, title)

///////////////////////////////////////////////////////////////////////////////////////

object UtilKIntent : IUtilK {
    @JvmStatic
    fun get(): Intent =
        Intent()

    @JvmStatic
    fun get(intent: Intent): Intent =
        Intent(intent)

    @JvmStatic
    fun get(action: String): Intent =
        Intent(action)

    @JvmStatic
    fun get(action: String, uri: Uri?): Intent =
        Intent(action, uri)

    @JvmStatic
    fun get(context: Context, clazz: Class<*>): Intent =
        Intent(context, clazz)

    @JvmStatic
    fun get(action: String, uri: Uri, context: Context, clazz: Class<*>): Intent =
        Intent(action, uri, context, clazz)

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    inline fun <reified T> get(context: Context): Intent =
        get(context, T::class.java)

    @JvmStatic
    inline fun <reified T> get(context: Context, block: IExt_Listener<Intent>): Intent =
        get(context, T::class.java).apply(block)

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getData(intent: Intent): Uri? =
        intent.data

    @JvmStatic
    fun getParcelableArrayListExtra(intent: Intent, name: String, clazz: Class<*>): ArrayList<*>? =
        if (UtilKBuildVersion.isAfterV_33_13_T())
            intent.getParcelableArrayListExtra(name, clazz)
        else
            intent.getParcelableArrayListExtra<Parcelable>(name)

    ///////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    fun resolveActivity(intent: Intent, context: Context): ComponentName? =
        resolveActivity(intent, UtilKPackageManager.get(context))

    @JvmStatic
    @OPermission_QUERY_ALL_PACKAGES
    fun resolveActivity(intent: Intent, pm: PackageManager): ComponentName? =
        intent.resolveActivity(pm)

    @JvmStatic
    fun createChooser(target: Intent, title: CharSequence): Intent =
        Intent.createChooser(target, title)
}