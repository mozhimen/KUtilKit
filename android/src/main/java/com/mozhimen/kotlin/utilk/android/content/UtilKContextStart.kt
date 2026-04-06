package com.mozhimen.kotlin.utilk.android.content

import android.app.Activity
import android.app.ActivityOptions
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CIntent
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import kotlin.jvm.Throws

/**
 * @ClassName UtilKSkip
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/2/27 16:35
 * @Version 1.0
 */
@Throws(ActivityNotFoundException::class)
fun Context.startContext_throw(intent: Intent) {
    UtilKContextStart.startContext_throw(intent, this)
}

@Throws(ActivityNotFoundException::class)
fun Context.startContext_throw(intent: Intent, options: Bundle?) {
    UtilKContextStart.startContext_throw(intent, options, this)
}

fun Context.startContext(intent: Intent): Boolean =
    UtilKContextStart.startContext(intent, this)

fun Context.startContext(intent: Intent, options: Bundle?): Boolean =
    UtilKContextStart.startContext(intent, options, this)

fun Context.startContext(clazz: Class<*>): Boolean =
    UtilKContextStart.startContext(clazz, this)

/////////////////////////////////////////////////////////////////////////////////

inline fun <reified A : Context> Context.startContext() {
    UtilKContextStart.startContext<A>(this)
}

inline fun <reified A : Context> Context.startContext(block: IExt_Listener<Intent>) {
    UtilKContextStart.startContext<A>(this, block)
}

/////////////////////////////////////////////////////////////////////////////////

inline fun <reified A : Activity> Activity.startActivityAndFinish() {
    UtilKContextStart.startActivityAndFinish<A>(this)
}

inline fun <reified A : Activity> Activity.startActivityAndFinish(block: IExt_Listener<Intent>) {
    UtilKContextStart.startActivityAndFinish<A>(this, block)
}

inline fun <reified A : Activity> Activity.startActivityAndFinish(options: Bundle?) {
    UtilKContextStart.startActivityAndFinish<A>(this, options)
}

inline fun <reified A : Activity> Activity.startActivityAndFinish(options: Bundle?, block: IExt_Listener<Intent>) {
    UtilKContextStart.startActivityAndFinish<A>(this, options, block)
}

inline fun <reified A : Activity> Activity.startActivityAndFinishAnimation_ofActivityOptions(block: IExt_Listener<Intent>) {
    UtilKContextStart.startActivityAndFinishAnimation_ofActivityOptions<A>(this, block)
}

/////////////////////////////////////////////////////////////////////////////////

inline fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int) {
    UtilKContextStart.startActivityForResult<T>(this, requestCode)
}

inline fun <reified T : Activity> Activity.startActivityForResult(requestCode: Int, block: IExt_Listener<Intent>) {
    UtilKContextStart.startActivityForResult<T>(this, requestCode, block)
}

/////////////////////////////////////////////////////////////////////////////////

@OUsesPermission_QUERY_ALL_PACKAGES
@RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
fun Context.startContext_ofPackageName(strPackageName: String): Boolean =
    UtilKContextStart.startContext_ofPackageName(strPackageName, this)

fun Context.startContext_ofPackageName(strPackageName: String, strActivityName: String): Boolean =
    UtilKContextStart.startContext_ofPackageName(strPackageName, strActivityName, this)

/////////////////////////////////////////////////////////////////////////////////
object UtilKContextStart : BaseUtilK() {
    @JvmStatic
    @Throws(ActivityNotFoundException::class)
    fun startContext_throw(intent: Intent, context: Context) {
        if (context !is Activity)
            intent.addFlags(CIntent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    @JvmStatic
    @Throws(ActivityNotFoundException::class)
    fun startContext_throw(intent: Intent, options: Bundle?, context: Context) {
        if (context !is Activity)
            intent.addFlags(CIntent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent, options)
    }

    @JvmStatic
    fun startContext(intent: Intent, context: Context): Boolean {
        try {
            startContext_throw(intent, context)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "startContext: ", e)
            return false
        }
    }

    @JvmStatic
    fun startContext(intent: Intent, options: Bundle?, context: Context): Boolean {
        try {
            startContext_throw(intent, options, context)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "startContext: ", e)
            return false
        }
    }

    @JvmStatic
    fun startContext(clazz: Class<*>, context: Context): Boolean =
        startContext(UtilKIntent.get(clazz, context), context)

    /////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    inline fun <reified T : Context> startContext(context: Context): Boolean =
        startContext(UtilKIntent.get<T>(context), context)

    @JvmStatic
    inline fun <reified T : Context> startContext(context: Context, block: IExt_Listener<Intent>): Boolean =
        startContext(UtilKIntent.get<T>(context, block), context)

    /////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    inline fun <reified T : Activity> startActivityAndFinish(activity: Activity) {
        startContext(Intent(activity, T::class.java), activity).also { activity.finish() }
    }

    @JvmStatic
    inline fun <reified T : Activity> startActivityAndFinish(activity: Activity, block: IExt_Listener<Intent>): Boolean =
        startContext(Intent(activity, T::class.java).apply(block), activity).also { activity.finish() }

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    inline fun <reified T : Activity> startActivityAndFinish(activity: Activity, options: Bundle?): Boolean =
        startContext(Intent(activity, T::class.java), options, activity).also { activity.finish() }

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    inline fun <reified T : Activity> startActivityAndFinish(activity: Activity, options: Bundle?, block: IExt_Listener<Intent>): Boolean =
        startContext(Intent(activity, T::class.java).apply(block), options, activity).also { activity.finish() }

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    inline fun <reified T : Activity> startActivityAndFinishAnimation_ofActivityOptions(activity: Activity, block: IExt_Listener<Intent>): Boolean =
        startContext(Intent(activity, T::class.java).apply(block), ActivityOptions.makeSceneTransitionAnimation(activity).toBundle(), activity).also { activity.finish() }

    /////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun startActivityForResult(activity: Activity, requestCode: Int, intent: Intent): Boolean =
        try {
            activity.startActivityForResult(intent, requestCode)
            true
        } catch (e: Exception) {
            e.printStackTrace()
            UtilKLogWrapper.e(TAG, "startActivityForResult: ", e)
            false
        }

    /////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    inline fun <reified T : Activity> startActivityForResult(activity: Activity, requestCode: Int): Boolean =
        startActivityForResult(activity, requestCode, Intent(activity, T::class.java))

    @JvmStatic
    inline fun <reified T : Activity> startActivityForResult(activity: Activity, requestCode: Int, block: IExt_Listener<Intent>): Boolean =
        startActivityForResult(activity, requestCode, Intent(activity, T::class.java).apply(block))

    /////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    fun startContext_ofPackageName(strPackageName: String, context: Context): Boolean {
        val intent = UtilKIntentGet.getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_COMPONENT(strPackageName, context) ?: return false
        return context.startContext(intent)
    }

    @JvmStatic
    @OUsesPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @Throws(ActivityNotFoundException::class)
    fun startContext_ofPackageName_throw(strPackageName: String, context: Context): Boolean {
        val intent = UtilKIntentGet.getIntent_ACTION_MAIN_CATEGORY_LAUNCHER_COMPONENT(strPackageName, context) ?: return false
        return context.startContext(intent)
    }


    @JvmStatic
    fun startContext_ofPackageName(strPackageName: String, strActivityName: String, context: Context): Boolean =
        context.startContext(UtilKIntentGet.get_COMPONENT(strPackageName, strActivityName))

    @JvmStatic
    @Throws(ActivityNotFoundException::class)
    fun startContext_ofPackageName_throw(strPackageName: String, strActivityName: String, context: Context) {
        context.startContext_throw(UtilKIntentGet.get_COMPONENT(strPackageName, strActivityName))
    }
}

