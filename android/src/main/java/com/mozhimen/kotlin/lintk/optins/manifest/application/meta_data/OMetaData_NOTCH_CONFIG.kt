package com.mozhimen.kotlin.lintk.optins.manifest.application.meta_data

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OMetaData_NOTCH_CONFIG
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
                    <!--适配小米（xiaomi）刘海屏-->
            <meta-data
                android:name="notch.config"
                android:value="portrait|landscape" />
""")
@RequiresOptIn("The api is must add this MetaData to your AndroidManifest.xml. 需要声明此MetaData到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OMetaData_NOTCH_CONFIG