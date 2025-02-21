package com.mozhimen.kotlin.utilk.android.test.utilk

import android.view.View
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkBinding
import com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKAndroidActivity
import com.mozhimen.kotlin.utilk.android.test.utilk.androidx.UtilKAndroidXActivity
import com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKJavaActivity
import com.mozhimen.kotlin.utilk.android.test.utilk.javax.UtilKJavaXActivity
import com.mozhimen.kotlin.utilk.android.test.utilk.kotlin.UtilKKotlinActivity

class UtilKActivity : BaseActivityVDB<ActivityUtilkBinding>() {

    fun goUtilKAndroid(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKAndroidActivity>()
    }

    fun goUtilKAndroidX(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.androidx.UtilKAndroidXActivity>()
    }

    fun goUtilKJava(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.java.UtilKJavaActivity>()
    }

    fun goUtilKJavaX(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.javax.UtilKJavaXActivity>()
    }

    fun goUtilKKotlin(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.kotlin.UtilKKotlinActivity>()
    }
}