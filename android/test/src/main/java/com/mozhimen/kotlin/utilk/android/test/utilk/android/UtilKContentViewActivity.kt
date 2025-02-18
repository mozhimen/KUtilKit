package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.android.view.UtilKContentView
import com.mozhimen.kotlin.utilk.android.view.UtilKContentViewWrapper
import com.mozhimen.kotlin.utilk.android.view.UtilKTitleBar
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.utilk.android.test.R
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkContentViewBinding

class UtilKContentViewActivity : BaseActivityVDB<ActivityUtilkContentViewBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        UtilKTitleBar.getHeight(this).toString().d()
    }
}