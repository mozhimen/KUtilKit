package com.mozhimen.kotlin.lintk.optins.permission

import com.mozhimen.kotlin.lintk.annors.AManifestRequire
import com.mozhimen.kotlin.elemk.android.cons.CPermission

/**
 * @ClassName OPermission_INTERNET
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
@AManifestRequire(CPermission.QUERY_ALL_PACKAGES)
@RequiresOptIn("The api is must add this permission to yout AndroidManifest.xml or dynamic call requestPermission. 需要声明此权限到你的AndroidManifest.xml或动态申请权限", RequiresOptIn.Level.ERROR)
annotation class OPermission_QUERY_ALL_PACKAGES
