package com.mozhimen.kotlin.lintk.optins.permission

import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.annors.AManifestRequire
import com.mozhimen.kotlin.elemk.android.cons.CPermission

/**
 * @ClassName OPermission_REQUEST_INSTALL_PACKAGES
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
@RequiresApi(CVersCode.V_33_13_TIRAMISU)
@AManifestRequire(CPermission.POST_NOTIFICATIONS)
@RequiresOptIn("The api is must add this permission to yout AndroidManifest.xml or dynamic call requestPermission. 需要声明此权限到你的AndroidManifest.xml或动态申请权限", RequiresOptIn.Level.ERROR)
annotation class OPermission_POST_NOTIFICATIONS