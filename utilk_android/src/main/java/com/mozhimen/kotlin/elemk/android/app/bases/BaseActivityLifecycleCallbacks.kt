package com.mozhimen.kotlin.elemk.android.app.bases

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName BaseActivityLifecycleCallbacks
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/11
 * @Version 1.0
 */
open class BaseActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks, IUtilK {
    override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.v(TAG,"onActivityPreCreated___________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name} savedInstanceState $savedInstanceState" )
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.d(TAG,"onActivityCreated______________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name} savedInstanceState $savedInstanceState" )
    }

    override fun onActivityPostCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.v(TAG,"onActivityPostCreated__________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name} savedInstanceState $savedInstanceState" )
    }

    override fun onActivityPreStarted(activity: Activity) {
        Log.v(TAG,"onActivityPreStarted___________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(TAG,"onActivityStarted______________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPostStarted(activity: Activity) {
        Log.v(TAG,"onActivityPostStarted__________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPreResumed(activity: Activity) {
        Log.v(TAG,"onActivityPreResumed___________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(TAG,"onActivityResumed______________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPostResumed(activity: Activity) {
        Log.v(TAG,"onActivityPostResumed__________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPrePaused(activity: Activity) {
        Log.v(TAG,"onActivityPrePaused____________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(TAG,"onActivityPaused_______________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPostPaused(activity: Activity) {
        Log.v(TAG,"onActivityPostPaused___________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPreStopped(activity: Activity) {
        Log.v(TAG,"onActivityPreStopped___________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(TAG,"onActivityStopped______________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPostStopped(activity: Activity) {
        Log.v(TAG,"onActivityPostStopped__________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPreSaveInstanceState(activity: Activity, outState: Bundle) {
        Log.v(TAG,"onActivityPreSaveInstanceState_ activity ${activity.javaClass.simpleName} ${activity.javaClass.name} outState $outState")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d(TAG,"onActivitySaveInstanceState____ activity ${activity.javaClass.simpleName} ${activity.javaClass.name} outState $outState")
    }

    override fun onActivityPostSaveInstanceState(activity: Activity, outState: Bundle) {
        Log.v(TAG,"onActivityPaused activity ${activity.javaClass.simpleName} ${activity.javaClass.name} outState $outState")
    }

    override fun onActivityPreDestroyed(activity: Activity) {
        Log.v(TAG,"onActivityPreDestroyed_________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(TAG,"onActivityDestroyed____________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }

    override fun onActivityPostDestroyed(activity: Activity) {
        Log.v(TAG,"onActivityPostDestroyed________ activity ${activity.javaClass.simpleName} ${activity.javaClass.name}")
    }
}
