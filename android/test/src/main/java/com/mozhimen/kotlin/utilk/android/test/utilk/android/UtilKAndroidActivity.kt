package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.view.View
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.view.UtilKView
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkAndroidBinding

/**
 * @ClassName UtilKContentActivity
 * @Description TODO
 * @Author Mozhimen & Kolin
 * @Date 2023/4/17 17:24
 * @Version 1.0
 */
class UtilKAndroidActivity : BaseActivityVDB<ActivityUtilkAndroidBinding>() {
    fun goUtilKApk(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKApkActivity>()
    }

    fun goUtilKAppInstall(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKAppInstallActivity>()
    }

    fun goUtilKAsset(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKAssetActivity>()
    }

    fun goUtilKBitmap(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKBitmapActivity>()
    }

    fun goUtilKContextDir(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKContextDirActivity>()
    }

    fun goUtilKGraphics(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKGraphicsActivity>()
    }

    fun goUtilKInput(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKInputActivity>()
    }

    fun goUtilKIntent(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKIntentActivity>()
    }

    fun goUtilKLaunchActivity(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKLaunchActivityActivity>()
    }

    fun goUtilKPackageActivity(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKPackageActivity>()
    }

    fun goUtilKScreen(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKScreenActivity>()
    }

    fun goUtilKView(view: View) {
        startContext<com.mozhimen.kotlin.utilk.android.test.utilk.android.UtilKViewActivity>()
    }
}