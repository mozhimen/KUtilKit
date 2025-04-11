package com.mozhimen.kotlin.elemk.androidx.lifecycle.impls

import androidx.annotation.CallSuper
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.mozhimen.kotlin.elemk.androidx.lifecycle.commons.ILifecycleOwner
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
open class LifecycleOwnerProxy : ILifecycleOwner {
    private var _lifecycleRegistry: LifecycleRegistry? = null

    ///////////////////////////////////////////////////////////////////////

    @CallSuper
    override fun onCreate() {
        UtilKLogWrapper.v(TAG, "onCreate: ")
        lifecycleRegistry.handleLifecycleEventOnCreate()
    }

    @CallSuper
    override fun onStart() {
        UtilKLogWrapper.v(TAG, "onStart: ")
        lifecycleRegistry.handleLifecycleEventOnStart()
    }

    @CallSuper
    override fun onResume() {
        UtilKLogWrapper.v(TAG, "onResume: ")
        lifecycleRegistry.handleLifecycleEventOnResume()
    }

    @CallSuper
    override fun onPause() {
        UtilKLogWrapper.v(TAG, "onPause: ")
        lifecycleRegistry.handleLifecycleEventOnPause()
    }

    @CallSuper
    override fun onStop() {
        UtilKLogWrapper.v(TAG, "onStop: ")
        lifecycleRegistry.handleLifecycleEventOnStop()
    }

    @CallSuper
    override fun onDestroy() {
        UtilKLogWrapper.v(TAG, "onDestroy: ")
        lifecycleRegistry.handleLifecycleEventOnDestroy()
    }

    ///////////////////////////////////////////////////////////////////////

    override val lifecycleRegistry: LifecycleRegistry
        get() = _lifecycleRegistry ?: LifecycleRegistry(this).also {
            _lifecycleRegistry = it
        }

    override val lifecycle: Lifecycle
        get() = lifecycleRegistry
}