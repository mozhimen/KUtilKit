package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_INSTALL_PACKAGES
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_REQUEST_INSTALL_PACKAGES
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
    @OptIn(OUsesPermission_INSTALL_PACKAGES::class, OUsesPermission_REQUEST_INSTALL_PACKAGES::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val path = "${UtilKStrPath.Absolute.Internal.getCache()}/lelejoy.apk"
        UtilKStrAsset.strAssetName2file_use("lelejoy.apk", path)
        if (path.isFileExist()) {
            UtilKAppInstall.install_ofSilence(path, com.mozhimen.kotlin.utilk.android.test.utilk.android.InstallKReceiver::class.java)
        }
    }
}