package com.mozhimen.kotlin.lintk.optins.application

import com.mozhimen.kotlin.lintk.annors.AManifestRequire
import com.mozhimen.kotlin.lintk.cons.CApplication

/**
 * @ClassName OApplication_REQUEST_LEGACY_EXTERNAL_STORAGE
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
@AManifestRequire(CApplication.USES_CLEAR_TEXT_TRAFFIC)
@RequiresOptIn("The api is must add this application property to your AndroidManifest.xml. 需要声明此application属性到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OApplication_USES_CLEAR_TEXT_TRAFFIC