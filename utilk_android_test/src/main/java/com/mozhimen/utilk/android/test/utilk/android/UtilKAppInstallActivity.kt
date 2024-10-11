package com.mozhimen.utilk.android.test.utilk.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_INSTALL_PACKAGES
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_REQUEST_INSTALL_PACKAGES
import com.mozhimen.kotlin.utilk.wrapper.UtilKAppInstall
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrAsset
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrPath
import com.mozhimen.kotlin.utilk.kotlin.isFileExist

/**
 * @ClassName UtilKAppInstallActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/17 19:46
 * @Version 1.0
 */
class UtilKAppInstallActivity : AppCompatActivity() {
    @OptIn(OPermission_INSTALL_PACKAGES::class, OPermission_REQUEST_INSTALL_PACKAGES::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val path = "${UtilKStrPath.Absolute.Internal.getCache()}/lelejoy.apk"
        UtilKStrAsset.strAssetName2file_use("lelejoy.apk", path)
        if (path.isFileExist()) {
            UtilKAppInstall.install_ofSilence(path, InstallKReceiver::class.java)
        }
    }
}