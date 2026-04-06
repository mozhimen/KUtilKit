package com.mozhimen.kotlin.utilk.android.test.elemk.android

import com.mozhimen.kotlin.elemk.android.content.bases.BaseDownloadInstallBroadcastReceiver
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_READ_INSTALL_SESSIONS
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_REPLACE_EXISTING_PACKAGE
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_REQUEST_INSTALL_PACKAGES


/**
 * @ClassName ElemKDownloadInstallReceiver
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/1/6 12:46
 * @Version 1.0
 */
@OptIn(OUsesPermission_REQUEST_INSTALL_PACKAGES::class, OUsesPermission_READ_INSTALL_SESSIONS::class, OUsesPermission_REPLACE_EXISTING_PACKAGE::class)
class ElemKDownloadInstallReceiver : BaseDownloadInstallBroadcastReceiver("")