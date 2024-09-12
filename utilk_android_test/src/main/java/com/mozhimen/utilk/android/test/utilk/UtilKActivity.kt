package com.mozhimen.utilk.android.test.utilk

import android.view.View
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.mvvmk.bases.activity.databinding.BaseActivityVDB
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkBinding
import com.mozhimen.utilk.android.test.utilk.android.UtilKAndroidActivity
import com.mozhimen.utilk.android.test.utilk.androidx.UtilKAndroidXActivity
import com.mozhimen.utilk.android.test.utilk.java.UtilKJavaActivity
import com.mozhimen.utilk.android.test.utilk.javax.UtilKJavaXActivity
import com.mozhimen.utilk.android.test.utilk.kotlin.UtilKKotlinActivity

class UtilKActivity : BaseActivityVDB<ActivityUtilkBinding>() {

    fun goUtilKAndroid(view: View) {
        startContext<UtilKAndroidActivity>()
    }

    fun goUtilKAndroidX(view: View) {
        startContext<UtilKAndroidXActivity>()
    }

    fun goUtilKJava(view: View) {
        startContext<UtilKJavaActivity>()
    }

    fun goUtilKJavaX(view: View) {
        startContext<UtilKJavaXActivity>()
    }

    fun goUtilKKotlin(view: View) {
        startContext<UtilKKotlinActivity>()
    }
}