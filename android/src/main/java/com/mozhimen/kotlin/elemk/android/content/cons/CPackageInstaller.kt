package com.mozhimen.kotlin.elemk.android.content.cons

import android.content.pm.PackageInstaller
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode

/**
 * @ClassName CPackageInstaller
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/8/3 21:56
 * @Version 1.0
 */
object CPackageInstaller {
    object SessionParams {
        @RequiresApi(CVersCode.V_21_5_L)
        const val MODE_FULL_INSTALL = PackageInstaller.SessionParams.MODE_FULL_INSTALL
    }
}