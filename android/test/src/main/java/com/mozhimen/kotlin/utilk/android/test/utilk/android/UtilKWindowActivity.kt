package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import android.view.ViewGroup
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkWindowBinding
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.view.UtilKWindow
import com.mozhimen.uik.databinding.bases.viewbinding.activity.BaseActivityVB

/**
 * @ClassName UtilKAndroid2Activity
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/21
 * @Version 1.0
 */
class UtilKWindowActivity : BaseActivityVB<ActivityUtilkWindowBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        UtilKLogWrapper.d(TAG, "initView: getContentView_ofWindow ${UtilKWindow.getContentView_window<ViewGroup>(this)}")
        UtilKLogWrapper.d(TAG, "initView: getContentView_ofPackage ${UtilKWindow.getContentView_package<ViewGroup>(this)}")
    }
}