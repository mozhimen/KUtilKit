package com.mozhimen.kotlin.elemk.androidx.lifecycle.commons

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName ILifecycleOwner
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/14
 * @Version 1.0
 */
interface ILifecycleOwner: LifecycleOwner, IUtilK {
    val lifecycleRegistry: LifecycleRegistry

    fun onCreate(){}
    fun onStart(){}
    fun onResume(){}
    fun onPause(){}
    fun onStop(){}
    fun onDestroy(){}
}