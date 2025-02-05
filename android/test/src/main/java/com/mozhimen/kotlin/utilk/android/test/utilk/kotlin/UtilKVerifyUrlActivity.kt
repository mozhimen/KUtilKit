package com.mozhimen.kotlin.utilk.android.test.utilk.kotlin

import android.os.Bundle
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKStringsMatches
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkVerifyUrlBinding

class UtilKVerifyUrlActivity : BaseActivityVDB<ActivityUtilkVerifyUrlBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        vdb.utilkVerifyUrlBtnPort.setOnClickListener {
            "是否合法: ${UtilKStringsMatches.matches_port(vdb.utilkVerifyUrlTxtPort.text.toString())}".showToast()
        }
    }
}