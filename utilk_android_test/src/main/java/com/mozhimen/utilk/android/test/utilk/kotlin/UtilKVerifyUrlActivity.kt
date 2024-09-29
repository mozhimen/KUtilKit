package com.mozhimen.utilk.android.test.utilk.kotlin

import android.os.Bundle
import com.mozhimen.bindk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.widget.showToast
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKRegexMatch
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkVerifyUrlBinding

class UtilKVerifyUrlActivity : BaseActivityVDB<ActivityUtilkVerifyUrlBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        vdb.utilkVerifyUrlBtnPort.setOnClickListener {
            "是否合法: ${UtilKRegexMatch.matches_ofStrPort(vdb.utilkVerifyUrlTxtPort.text.toString())}".showToast()
        }
    }
}