package com.mozhimen.kotlin.lintk.optins.manifest.application.meta_data

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OMetaData_MAX_ASPECT
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
                        <!--在全屏的时候，避免出现一些屏幕黑边-->
            <meta-data
                android:name="android.max_aspect"
                android:value="2.4" />
""")
@RequiresOptIn("The api is must add this MetaData to your AndroidManifest.xml. 需要声明此MetaData到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OMetaData_MAX_ASPECT