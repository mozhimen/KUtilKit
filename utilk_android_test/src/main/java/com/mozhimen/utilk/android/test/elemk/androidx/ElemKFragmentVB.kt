package com.mozhimen.utilk.android.test.elemk.androidx

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mozhimen.mvvmk.bases.fragment.databinding.BaseFragmentVDB
import com.mozhimen.utilk.android.test.databinding.FragmentElemkFragmentVbBinding

class ElemKFragmentVB : BaseFragmentVDB<FragmentElemkFragmentVbBinding>() {
    private val vm: ElemKViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun initView(savedInstanceState: Bundle?) {
        vdb.elemkFragmentVbBtn.setOnClickListener {
            vm.addNum()
        }
    }
}