package com.mozhimen.utilk.android.test.elemk.androidx

import androidx.lifecycle.SavedStateViewModelFactory
import com.mozhimen.mvvmk.bases.activity.databinding.BaseActivityVDBVM
import com.mozhimen.utilk.android.test.databinding.ActivityElemkVbvmBinding

class ElemKVBVMActivity : BaseActivityVDBVM<ActivityElemkVbvmBinding, ElemKViewModel>() {

    override fun bindViewVM(vb: ActivityElemkVbvmBinding) {
        vdb.elemkVbvm = vm
    }

    override fun getViewModelProviderFactory() =
    SavedStateViewModelFactory(application, this)
}