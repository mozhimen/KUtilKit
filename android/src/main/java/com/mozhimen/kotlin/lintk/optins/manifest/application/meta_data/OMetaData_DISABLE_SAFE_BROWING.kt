package com.mozhimen.kotlin.lintk.optins.manifest.application.meta_data

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OMetaData_DISABLE_SAFE_BROWING
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
             <!--关闭内置浏览器安全策略-->
            <meta-data
                android:name="android.webkit.WebView.EnableSafeBrowsing"
                android:value="false" />
""")
@RequiresOptIn("The api is must add this MetaData to your AndroidManifest.xml. 需要声明此MetaData到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OMetaData_DISABLE_SAFE_BROWING
