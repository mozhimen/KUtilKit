package com.mozhimen.kotlin.utilk.android.test.elemk.androidx

import androidx.lifecycle.SavedStateViewModelFactory
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDBVM
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityElemkVbvmBinding

class ElemKVBVMActivity : BaseActivityVDBVM<ActivityElemkVbvmBinding, com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKViewModel>() {

    override fun bindViewVM(vb: ActivityElemkVbvmBinding) {
        vdb.elemkVbvm = vm
    }

    override fun getViewModelProviderFactory() =
    SavedStateViewModelFactory(application, this)
}