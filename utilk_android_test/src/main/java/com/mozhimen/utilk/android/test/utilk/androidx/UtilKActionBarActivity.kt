package com.mozhimen.utilk.android.test.utilk.androidx

import android.os.Bundle
import com.mozhimen.bindk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkActionBarBinding

class UtilKActionBarActivity : BaseActivityVDB<ActivityUtilkActionBarBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(vdb.utilkActionToolbar)
        supportActionBar?.title = NAME
        supportActionBar?.subtitle = TAG
    }
}