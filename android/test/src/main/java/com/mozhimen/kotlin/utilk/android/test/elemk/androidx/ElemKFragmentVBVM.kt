package com.mozhimen.kotlin.utilk.android.test.elemk.androidx

import android.os.Bundle
import com.mozhimen.uik.databinding.bases.viewdatabinding.fragment.BaseFragmentVDBVM
import com.mozhimen.kotlin.utilk.android.test.databinding.FragmentElemkFragmentVbvmBinding

class ElemKFragmentVBVM : BaseFragmentVDBVM<FragmentElemkFragmentVbvmBinding, com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKViewModel>() {

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