package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.provider.UtilKSettingsSecureGet
import com.mozhimen.kotlin.utilk.android.provider.UtilKSettingsSystemGet
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkSettingsBinding

/**
 * @ClassName UtilKSettingsActivity
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/13
 * @Version 1.0
 */
class UtilKSettingsActivity : BaseActivityVDB<ActivityUtilkSettingsBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        UtilKLogWrapper.d(TAG, "initView: UtilKSettingsSystemGet.getString_ANDROID_ID ${UtilKSettingsSystemGet.getString_ANDROID_ID(this)}")
        UtilKLogWrapper.d(TAG, "initView: UtilKSettingsSecureGet.getString_ANDROID_ID ${UtilKSettingsSecureGet.getString_ANDROID_ID(this)}")
    }
}