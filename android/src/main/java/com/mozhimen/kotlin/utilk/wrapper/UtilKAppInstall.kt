package com.mozhimen.kotlin.utilk.wrapper

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInstaller
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageInstaller
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.ODeviceRoot
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_INSTALL_PACKAGES
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_REQUEST_INSTALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.app.UtilKActivityStart
import com.mozhimen.kotlin.utilk.android.app.UtilKPendingIntentGet
import com.mozhimen.kotlin.utilk.android.content.UtilKIntent
import com.mozhimen.kotlin.utilk.android.content.UtilKPackageInstaller
import com.mozhimen.kotlin.utilk.android.content.UtilKPackageInstaller_Session
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.java.lang.UtilKRuntimeWrapper
import java.io.*

/**
 * @ClassName UtilKAppInstall
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/1/4 23:29
 * @Version 1.0
 */
object UtilKAppInstall : BaseUtilK() {

    /**
     * 是否有包安装权限
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun hasRequestInstallPackages(): Boolean =
        UtilKPermission.hasRequestInstallPackages().also { "hasPackageInstalls: $it".d(TAG) }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * 打开包安装权限
     * @param activity Activity
     */
    @JvmStatic
    fun startManageUnknownInstallSource(activity: Activity) {
        UtilKActivityStart.startSettingManageUnknownInstallSource(activity)
    }

    /**
     * 打开包安装权限
     */
    @JvmStatic
    fun startManageUnknownInstallSource(context: Context) {
        UtilKActivityStart.startSettingManageUnknownInstallSource(context)
    }

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @Throws(Exception::class)
    @ODeviceRoot
    @RequiresPermission(CPermission.INSTALL_PACKAGES)
    @OPermission_INSTALL_PACKAGES
    fun install_ofRuntime(strPathNameApk: String): Boolean =
        UtilKRuntimeWrapper.exec_su_pm_install(strPathNameApk)

    /**
     * 手动安装 if sdk >= 24 add provider
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun install_ofView(strPathNameApk: String) :Boolean =
        UtilKActivityStart.startViewInstall(_context, strPathNameApk)

    /**
     * 手动安装 if sdk >= 24 add provider
     */
    @JvmStatic
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun install_ofView(fileApk: File) {
        UtilKActivityStart.startViewInstall(_context, fileApk)
    }

    /**
     * 静默安装
     */
    @JvmStatic
    @RequiresPermission(allOf = [CPermission.INSTALL_PACKAGES, CPermission.REQUEST_INSTALL_PACKAGES])
    @OPermission_INSTALL_PACKAGES
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun install_ofSilence(strPathNameApk: String, receiver: Class<*>) {
        if (UtilKBuildVersion.isAfterV_28_9_P()) install_ofSilence_after28(strPathNameApk, receiver)
        else UtilKRuntimeWrapper.exec_pm_install_before28(strPathNameApk)
    }

    /**
     * 静默安装 SDK28 之后的
     */
    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    @RequiresPermission(allOf = [CPermission.INSTALL_PACKAGES, CPermission.REQUEST_INSTALL_PACKAGES])
    @OPermission_INSTALL_PACKAGES
    @OPermission_REQUEST_INSTALL_PACKAGES
    fun install_ofSilence_after28(strPathNameApk: String, receiverClazz: Class<*>) {
        "install_ofSilence_after28 pathApk $strPathNameApk".d(TAG)
        val fileApk = File(strPathNameApk)
        val packageInstaller = UtilKPackageInstaller.get(_context)
        val sessionParams = PackageInstaller.SessionParams(CPackageInstaller.SessionParams.MODE_FULL_INSTALL).apply {
            setSize(fileApk.length())
        }
        val sessionId: Int = UtilKPackageInstaller.createSession(packageInstaller, sessionParams)
        "install_ofSilence_after28 sessionId $sessionId".d(TAG)

        if (sessionId != -1) {
            val isCopySuccess = UtilKPackageInstaller.copyBaseApk(packageInstaller, sessionId, strPathNameApk)
            "install_ofSilence_after28 isCopySuccess $isCopySuccess".d(TAG)
            if (isCopySuccess)
                UtilKPackageInstaller_Session.commit_use_ofBroadCast(packageInstaller, sessionId, UtilKIntent.get(_context, receiverClazz), 1,UtilKPendingIntentGet.getFlag_UPDATE_CURRENT())
        }
    }
}