package com.mozhimen.kotlin.elemk.androidx.lifecycle

import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy
import com.mozhimen.kotlin.utilk.androidx.lifecycle.handleLifecycleEventOnCreate
import com.mozhimen.kotlin.utilk.androidx.lifecycle.handleLifecycleEventOnDestroy
import com.mozhimen.kotlin.utilk.androidx.lifecycle.handleLifecycleEventOnPause
import com.mozhimen.kotlin.utilk.androidx.lifecycle.handleLifecycleEventOnResume
import com.mozhimen.kotlin.utilk.androidx.lifecycle.handleLifecycleEventOnStart
import com.mozhimen.kotlin.utilk.androidx.lifecycle.handleLifecycleEventOnStop
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName LifecycleOwnerProxy
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/29
 * @Version 1.0
 */
@OApiInit_ByLazy
class LifecycleOwnerProxy : LifecycleOwner, IUtilK {
    private var _lifecycleRegistry: LifecycleRegistry? = null
    protected val lifecycleRegistry: LifecycleRegistry
        get() = _lifecycleRegistry ?: LifecycleRegistry(this).also {
            _lifecycleRegistry = it
        }

    ///////////////////////////////////////////////////////////////////////

    fun onCreate(name: String) {
        UtilKLogWrapper.v(TAG, "onCreate:  $name")
        lifecycleRegistry.handleLifecycleEventOnCreate()
    }

    fun onStart(name: String) {
        UtilKLogWrapper.v(TAG, "onStart:   $name")
        lifecycleRegistry.handleLifecycleEventOnStart()
    }

    fun onResume(name: String) {
        UtilKLogWrapper.v(TAG, "onResume:  $name")
        lifecycleRegistry.handleLifecycleEventOnResume()
    }

    fun onPause(name: String) {
        UtilKLogWrapper.v(TAG, "onPause:   $name")
        lifecycleRegistry.handleLifecycleEventOnPause()
    }

    fun onStop(name: String) {
        UtilKLogWrapper.v(TAG, "onStop:    $name")
        lifecycleRegistry.handleLifecycleEventOnStop()
    }

    fun onDestroy(name: String) {
        UtilKLogWrapper.v(TAG, "onDestroy: $name")
        lifecycleRegistry.handleLifecycleEventOnDestroy()
    }

    ///////////////////////////////////////////////////////////////////////

    override val lifecycle: Lifecycle
        get() = lifecycleRegistry
}