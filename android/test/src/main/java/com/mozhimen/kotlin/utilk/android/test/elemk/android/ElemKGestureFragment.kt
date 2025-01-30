package com.mozhimen.kotlin.utilk.android.test.elemk.android

import android.os.Bundle
import android.widget.TextView
import com.mozhimen.basick.helpers.DragAndDropProxy
import com.mozhimen.kotlin.lintk.optins.OApiInit_ByLazy
import com.mozhimen.bindk.bases.viewdatabinding.fragment.BaseFragmentVDB
import com.mozhimen.kotlin.lintk.optins.OApiCall_BindLifecycle
import com.mozhimen.kotlin.utilk.kotlin.UtilKLazyJVM.lazy_ofNone
import com.mozhimen.utilk.android.test.databinding.FragmentElemkGestureBinding

class ElemKGestureFragment : BaseFragmentVDB<FragmentElemkGestureBinding>() {
    @OptIn(OApiInit_ByLazy::class, OApiCall_BindLifecycle::class)
    private val _dragAndDropProxy by lazy_ofNone { DragAndDropProxy() }

    @OptIn(OApiInit_ByLazy::class, OApiCall_BindLifecycle::class)
    override fun initView(savedInstanceState: Bundle?) {
        _dragAndDropProxy.bindLifecycle(this)
        _dragAndDropProxy.dragAndDrop(vdb.elemkGestureFragmentTxt1, vdb.elemkGestureFragmentTxt2) { source, dest ->
            (dest as TextView).text = (source as TextView).text.toString()
        }
    }
}