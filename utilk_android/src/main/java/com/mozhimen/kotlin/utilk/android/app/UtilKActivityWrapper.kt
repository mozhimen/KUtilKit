package com.mozhimen.kotlin.utilk.android.app

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.mozhimen.kotlin.elemk.android.app.cons.CActivity
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.view.cons.CWindow
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.lintk.optins.OApiInit_InApplication
import com.mozhimen.kotlin.lintk.optins.OApiUse_BaseApplication
import com.mozhimen.kotlin.utilk.android.content.UtilKIntent
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.view.UtilKContentView
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorView
import com.mozhimen.kotlin.utilk.android.view.UtilKWindowManagerWrapper
import com.mozhimen.kotlin.utilk.androidx.appcompat.UtilKAlertDialog
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.UtilKClazz
import com.mozhimen.kotlin.utilk.kotlin.strPackage2clazz
import java.lang.reflect.InvocationTargetException

/**
 * @ClassName UtilKActivityWrapper
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/3/16 17:27
 * @Version 1.0
 */
fun <V : View> Activity.getContentView(): V =
    UtilKActivityWrapper.getContentView(this)

fun <V : View> Activity.getDecorView(): V =
    UtilKActivityWrapper.getDecorView(this)

fun <A : Annotation> Activity.getAnnotation(annotationClazz: Class<A>): A? =
    UtilKActivityWrapper.getAnnotation(this, annotationClazz)

inline fun <reified T> Activity.getIntent(): Intent =
    UtilKIntent.get<T>(this)

inline fun <reified T> Activity.getIntent(block: IExt_Listener<Intent>): Intent =
    UtilKIntent.get<T>(this, block)

/////////////////////////////////////////////////////////////////////////

fun Activity.isFinishingOrDestroyed(): Boolean =
    UtilKActivityWrapper.isFinishingOrDestroyed(this)

/////////////////////////////////////////////////////////////////////////

fun Activity.applyResult_ofCANCELED(data: Intent? = null, isFinish: Boolean = true) {
    UtilKActivityWrapper.applyResult_ofCANCELED(this, data, isFinish)
}

fun Activity.applyResult_ofOK(data: Intent? = null, isFinish: Boolean = true) {
    UtilKActivityWrapper.applyResult_ofOK(this, data, isFinish)
}

/////////////////////////////////////////////////////////////////////////

fun Activity.showAlertDialog(intResStrMsg: Int, intResStrLabel: Int, block: I_Listener) {
    UtilKActivityWrapper.showAlertDialog(this, intResStrMsg, intResStrLabel, block)
}

fun Activity.showAlertDialog(strMsg: String, strLabel: String, block: I_Listener) {
    UtilKActivityWrapper.showAlertDialog(this, strMsg, strLabel, block)
}

/////////////////////////////////////////////////////////////////////////

object UtilKActivityWrapper : IUtilK {
    @JvmStatic
    fun get_ofContext(context: Context): Activity? =
        get_ofContext(context, true).also { UtilKLogWrapper.d(TAG, "get_ofContext: $it") }

    //判断context是否是Activity 这里注意一定要再Application中加入StackK并初始化
    @JvmStatic
    fun get_ofContext(context: Context, returnTopIfNull: Boolean): Activity? {
        var tempContext = context
        if (tempContext is Activity) return tempContext
        var tryCount = 0
        while (tempContext is ContextWrapper) {
            if (tempContext is Activity) return tempContext
            if (tryCount > 20) {
                break
            }
            tempContext = tempContext.baseContext
            tryCount++
        }
        return if (returnTopIfNull) getTop_ofReflect() else null
    }

    //根据View获取Activity
    @JvmStatic
    @OApiUse_BaseApplication
    fun get_ofView(view: View): Activity? =
        get_ofContext(view.context)

    //寻找Activity从Obj
    @JvmStatic
    @OApiUse_BaseApplication
    fun get_ofObj(obj: Any): Activity? =
        get_ofObj(obj, false)

    //寻找Activity从Obj
    @JvmStatic
    @OApiUse_BaseApplication
    fun get_ofObj(obj: Any, returnTopIfNull: Boolean): Activity? {
        var activity: Activity? = null
        when (obj) {
            is Context -> activity = get_ofContext(obj, true)
            is Fragment -> activity = obj.activity
            is Dialog -> activity = get_ofContext(obj.context, true)
        }
        if (activity == null && returnTopIfNull) {
            activity = getTop_ofReflect()
        }
        return activity
    }

    @JvmStatic
    fun getTop_ofReflect(): Activity? {
        try {
            val clazzActivityThread = "android.app.ActivityThread".strPackage2clazz()
            val methodCurrentActivityThread = clazzActivityThread.getMethod("currentActivityThread").invoke(null)
            val field_mActivityList = clazzActivityThread.getDeclaredField("mActivityList")
            if (!field_mActivityList.isAccessible)
                field_mActivityList.isAccessible = true
            val activityMap: Map<*, *> = field_mActivityList[methodCurrentActivityThread] as Map<*, *>
            for (activity in activityMap.values) {
                val clazz_activityRecord: Class<*> = activity?.javaClass ?: continue
                val field_paused = clazz_activityRecord.getDeclaredField("paused")
                if (!field_paused.isAccessible)
                    field_paused.isAccessible = true
                if (!field_paused.getBoolean(activity)) {
                    val field_activity = clazz_activityRecord.getDeclaredField("activity")
                    if (!field_activity.isAccessible)
                        field_activity.isAccessible = true
                    return field_activity[activity] as Activity
                }
            }
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun <V : View> getContentView(activity: Activity): V =
        UtilKContentView.get(activity)

    @JvmStatic
    fun <V : View> getDecorView(activity: Activity): V =
        UtilKDecorView.getAs(activity)

    @JvmStatic
    fun <A : Annotation> getAnnotation(activity: Activity, annotationClazz: Class<A>): A? =
        UtilKClazz.getAnnotation(activity.javaClass, annotationClazz)

    @JvmStatic
    inline fun <reified T> getIntent(activity: Activity): Intent =
        UtilKIntent.get<T>(activity)

    @JvmStatic
    inline fun <reified T> getIntent(activity: Activity, block: IExt_Listener<Intent>): Intent =
        UtilKIntent.get<T>(activity, block)

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getFloatWindowSize(activity: Activity): Int {
        val targetDecorView = activity.window.decorView// 获取目标 Activity 的 decorView
        val targetSubToken = targetDecorView.windowToken// 获取目标 Activity 的 子窗口的 token
        val mView = UtilKWindowManagerWrapper.getViews().map { it }.toList()//  拿到 mView 集合，找到目标 Activity 所在的 index 位置
        val targetIndex = mView.indexOfFirst { it == targetDecorView }
        val mParams = UtilKWindowManagerWrapper.getParams()// 获取 mParams 集合
        val targetToken = mParams[targetIndex].token// 根据目标 index 从 mParams 集合中找到目标 token
        return mParams
            .map { it.token }
            .filter { it == targetSubToken || it == null || it == targetToken }
            .size // 遍历判断时，目标 Activity 自己不能包括,所以 size 需要大于 1
    }

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hasFloatWindow_ofToken(activity: Activity): Boolean =
        getFloatWindowSize(activity) > 1// 遍历判断时，目标 Activity 自己不能包括,所以 size 需要大于 1

    @JvmStatic
    fun isFinishingOrDestroyed(activity: Activity): Boolean =
        (UtilKActivity.isFinishing(activity) || UtilKActivity.isDestroyed(activity)).also { UtilKLogWrapper.d(UtilKActivity.TAG, "isFinishingOrDestroyed: activity $activity $it") }

    //判断Activity是否被销毁
    @JvmStatic
    fun isFinishingOrDestroyed(context: Context): Boolean {
        val activity: Activity? = get_ofContext(context)
        return (if (activity != null) isFinishingOrDestroyed(activity) else true).also { UtilKLogWrapper.d(TAG, "isFinishingOrDestroyed: $it") }
    }
    /////////////////////////////////////////////////////////////////////////

    /**
     * 判断这个意图的 Activity 是否存在
     */
    fun hasActivity_ofIntent(context: Context, intent: Intent): Boolean {
        // 这里为什么不用 Intent.resolveActivity(intent) != null 来判断呢？
        // 这是因为在 OPPO R7 Plus （Android 5.0）会出现误判，明明没有这个 Activity，却返回了 ComponentName 对象
        val packageManager = context.packageManager
        if (UtilKBuildVersion.isAfterV_33_13_TIRAMISU()) {
            return packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY.toLong())).isNotEmpty()
        }
        return packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isNotEmpty()
    }

    @JvmStatic
    fun applyResult_ofCANCELED(activity: Activity, data: Intent? = null, isFinish: Boolean = true) {
        UtilKActivity.applyResult(activity, CActivity.RESULT_CANCELED, data)
        if (isFinish)
            activity.finish()
    }

    @JvmStatic
    fun applyResult_ofOK(activity: Activity, data: Intent? = null, isFinish: Boolean = true) {
        UtilKActivity.applyResult(activity, CActivity.RESULT_OK, data)
        if (isFinish)
            activity.finish()
    }

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun showAlertDialog(activity: Activity, intResStrMsg: Int, intResStrLabel: Int, block: I_Listener) {
        UtilKAlertDialog.show(activity, intResStrMsg, intResStrLabel, block)
    }

    @JvmStatic
    fun showAlertDialog(activity: Activity, strMsg: String, strLabel: String, block: I_Listener) {
        UtilKAlertDialog.show(activity, strMsg, strLabel, block)
    }

    /////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun requestWindowFeature_ofCONTENT_TRANSITIONS(activity: Activity) {
        UtilKActivity.requestWindowFeature(activity, CWindow.FEATURE_CONTENT_TRANSITIONS)
    }
}