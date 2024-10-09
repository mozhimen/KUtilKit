package com.mozhimen.utilk.android.test.elemk.androidx

import android.os.Bundle
import com.mozhimen.bindk.bases.viewdatabinding.fragment.BaseFragmentVDBVM
import com.mozhimen.utilk.android.test.databinding.FragmentElemkFragmentVbvmBinding

class ElemKFragmentVBVM : BaseFragmentVDBVM<FragmentElemkFragmentVbvmBinding, ElemKViewModel>() {

    override fun bindViewVM(vb: FragmentElemkFragmentVbvmBinding) {
        vdb.vm = vm
    }

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        vdb.elemkFragmentVbvmBtn.setOnClickListener {
            vm.addNum()
        }
    }
}