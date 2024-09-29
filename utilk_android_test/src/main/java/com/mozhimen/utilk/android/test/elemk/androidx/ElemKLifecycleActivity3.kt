package com.mozhimen.utilk.android.test.elemk.androidx

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.mozhimen.bindk.bases.activity.databinding.BaseActivityVDBVM
import com.mozhimen.utilk.android.test.databinding.ActivityElemkLifecycleBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ElemKLifecycleActivity3 : BaseActivityVDBVM<ActivityElemkLifecycleBinding, ElemkLifecycleViewModel3>(), Starter.IStarterListener {
    override fun initData(savedInstanceState: Bundle?) {
        Starter.addListener(this)
        super.initData(savedInstanceState)
    }

    override fun onDestroy() {
        Starter.removeListener(this)
        super.onDestroy()
    }

    override fun onChange(num: Int) {
        vm.setNum(num)
    }

    override fun initView(savedInstanceState: Bundle?) {
        vm.flowState.flowWithLifecycle(this.lifecycle, Lifecycle.State.CREATED).onEach {
            vdb.elemkLifecycleTxt1.text = it.toString()
        }.launchIn(this.lifecycleScope)
        vm.liveDataMutable.observe(this) {
            vdb.elemkLifecycleTxt2.text = it.toString()
        }
        vm.liveDataSticky.observeSticky(this) {
            vdb.elemkLifecycleTxt3.text = it.toString()
        }
        vdb.elemkLifecycleBtn.setOnClickListener {
            Starter.addNum()
        }
    }

    override fun bindViewVM(vdb: ActivityElemkLifecycleBinding) {

    }
}

