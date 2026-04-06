package com.mozhimen.kotlin.lintk.optins.manifest.application.meta_data

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OMetaData_NOTCH_SUPPORT
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
                        <!--适配华为（huawei）刘海屏-->
            <meta-data
                android:name="android.notch_support"
                android:value="true" />
""")
@RequiresOptIn("The api is must add this MetaData to your AndroidManifest.xml. 需要声明此MetaData到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OMetaData_NOTCH_SUPPORT