package com.mozhimen.kotlin.utilk.android.test.elemk.androidx

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.mozhimen.uik.databinding.bases.viewdatabinding.fragment.BaseDialogFragmentVDB
import com.mozhimen.utilk.android.test.databinding.FragmentElemkDialogFragmentVbvmBinding

class ElemKDialogFragmentVB : BaseDialogFragmentVDB<FragmentElemkDialogFragmentVbvmBinding>() {
    private val vm: com.mozhimen.kotlin.utilk.android.test.elemk.androidx.ElemKViewModel by viewModels(ownerProducer = { requireActivity() })

    override fun initView(savedInstanceState: Bundle?) {
        vdb.elemkFragmentVbvmBtn.setOnClickListener {
            vm.addNum()
        }
    }
}