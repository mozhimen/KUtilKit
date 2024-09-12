package com.mozhimen.kotlin.elemk.androidx.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy

/**
 * @ClassName SavedStateRegistryOwnerProxy
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/12
 * @Version 1.0
 */
@OApiInit_ByLazy
class SavedStateRegistryOwnerProxy : SavedStateRegistryOwner, LifecycleOwnerProxy() {
    protected val savedStateRegistryController = SavedStateRegistryController.create(this)

    override val lifecycle: Lifecycle
        get() = lifecycleRegistry

    override val savedStateRegistry: SavedStateRegistry
        get() = savedStateRegistryController.savedStateRegistry

    override fun onCreate(name: String) {
        savedStateRegistryController.performRestore(null)
        super.onCreate(name)
    }
}