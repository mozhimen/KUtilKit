package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.mozhimen.uik.databinding.bases.viewbinding.activity.BaseActivityVB
import com.mozhimen.kotlin.utilk.android.app.UtilKApplicationWrapper
import com.mozhimen.kotlin.utilk.android.content.UtilKApplicationInfo
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.android.test.R
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkApplicationBinding

class UtilKApplicationActivity : BaseActivityVB<ActivityUtilkApplicationBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        UtilKLogWrapper.d(TAG, "initView: ${UtilKApplicationInfo.get(this)}")
        UtilKLogWrapper.d(TAG, "initView: ${UtilKApplicationInfo.get_ofPackageInfo(this, this.packageName, 0)}")
        UtilKLogWrapper.d(TAG, "initView: ${UtilKApplicationInfo.get_ofPackageManager(this, this.packageName, 0)}")
    }
}