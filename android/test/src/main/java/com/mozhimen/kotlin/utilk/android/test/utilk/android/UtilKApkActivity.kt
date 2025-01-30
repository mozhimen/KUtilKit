package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.wrapper.UtilKApk
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrAsset
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrPath
import com.mozhimen.kotlin.utilk.kotlin.isFileExist
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkApkBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @ClassName UtilKApkActivity
 * @Description TODO
 * @Author Mozhimen & Kolin
 * @Date 2023/4/18 13:44
 * @Version 1.0
 */
class UtilKApkActivity : BaseActivityVDB<ActivityUtilkApkBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        lifecycleScope.launch(Dispatchers.IO) {
            val strPathNameApk = UtilKStrPath.Absolute.Internal.getCache() + "/temp/${UtilKStrFile.getStrFileName_ofNow()}.apk"
            if (!strPathNameApk.isFileExist()) {
                UtilKStrAsset.strAssetName2file_use("basicktest-debug.apk", strPathNameApk)
            }
            UtilKApk.printApkInfo(strPathNameApk)
        }
    }
}