package com.mozhimen.kotlin.utilk.android.test.utilk.wrapper

import android.os.Bundle
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkDeviceBinding
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.wrapper.UtilKDevice
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB

/**
 * @ClassName UtilKDeviceActivity
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/6/4
 * @Version 1.0
 */
class UtilKDeviceActivity : BaseActivityVDB<ActivityUtilkDeviceBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        UtilKLogWrapper.d(TAG, "initView: ${UtilKDevice.isPad(this)}")
    }
}