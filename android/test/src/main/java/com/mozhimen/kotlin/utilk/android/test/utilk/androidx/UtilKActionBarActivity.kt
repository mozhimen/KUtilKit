package com.mozhimen.kotlin.utilk.android.test.utilk.androidx

import android.os.Bundle
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkActionBarBinding

class UtilKActionBarActivity : BaseActivityVDB<ActivityUtilkActionBarBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(vdb.utilkActionToolbar)
        supportActionBar?.title = NAME
        supportActionBar?.subtitle = TAG
    }
}