package com.mozhimen.utilk.android.test.utilk.android

import android.view.View
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.content.startContext
import com.mozhimen.kotlin.utilk.android.view.UtilKView
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkAndroidBinding

/**
 * @ClassName UtilKContentActivity
 * @Description TODO
 * @Author Mozhimen & Kolin
 * @Date 2023/4/17 17:24
 * @Version 1.0
 */
class UtilKAndroidActivity : BaseActivityVDB<ActivityUtilkAndroidBinding>() {
    fun goUtilKApk(view: View) {
        startContext<UtilKApkActivity>()
    }

    fun goUtilKAppInstall(view: View) {
        startContext<UtilKAppInstallActivity>()
    }

    fun goUtilKAsset(view: View) {
        startContext<UtilKAssetActivity>()
    }

    fun goUtilKBitmap(view: View) {
        startContext<UtilKBitmapActivity>()
    }

    fun goUtilKContextDir(view: View) {
        startContext<UtilKContextDirActivity>()
    }

    fun goUtilKGraphics(view: View) {
        startContext<UtilKGraphicsActivity>()
    }

    fun goUtilKInput(view: View) {
        startContext<UtilKInputActivity>()
    }

    fun goUtilKIntent(view: View) {
        startContext<UtilKIntentActivity>()
    }

    fun goUtilKLaunchActivity(view: View) {
        startContext<UtilKLaunchActivityActivity>()
    }

    fun goUtilKPackageActivity(view: View) {
        startContext<UtilKPackageActivity>()
    }

    fun goUtilKScreen(view: View) {
        startContext<UtilKScreenActivity>()
    }

    fun goUtilKView(view: View) {
        startContext<UtilKViewActivity>()
    }
}