package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import android.view.ViewGroup
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.android.view.UtilKContentView
import com.mozhimen.kotlin.utilk.android.view.UtilKTitleBar
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkContentViewBinding
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper

class UtilKContentViewActivity : BaseActivityVDB<ActivityUtilkContentViewBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        UtilKTitleBar.getHeight(this).toString().d()
        UtilKLogWrapper.d(TAG, "initView: get ${UtilKContentView.get_window<ViewGroup>(this)}")
        UtilKLogWrapper.d(TAG, "initView: get_ofDecorView ${UtilKContentView.get_decor<ViewGroup>(this)}")
    }
}