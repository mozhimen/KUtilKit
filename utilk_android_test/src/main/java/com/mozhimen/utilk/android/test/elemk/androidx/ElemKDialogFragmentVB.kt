package com.mozhimen.utilk.android.test.elemk.androidx

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mozhimen.mvvmk.bases.fragment.databinding.BaseDialogFragmentVDB
import com.mozhimen.utilk.android.test.databinding.FragmentElemkDialogFragmentVbvmBinding

class ElemKDialogFragmentVB : BaseDialogFragmentVDB<FragmentElemkDialogFragmentVbvmBinding>() {
    private val vm: ElemKViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun initView(savedInstanceState: Bundle?) {
        vdb.elemkFragmentVbvmBtn.setOnClickListener {
            vm.addNum()
        }
    }
}