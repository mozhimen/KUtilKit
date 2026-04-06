package com.mozhimen.kotlin.lintk.optins.manifest.application.provider

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OProvider
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
    * AndroidManifest.xml sdk>24

<provider
android:name="androidx.core.content.FileProvider"
android:authorities="${'$'}{applicationId}.fileProvider"
android:exported="false"
android:grantUriPermissions="true">
<meta-data
android:name="android.support.FILE_PROVIDER_PATHS"
android:resource="@xml/file_paths"  />
</provider>

     * file_paths.xml sdk>24
<paths>
<files-path
name="files-path"
path="." />
</paths>
 """)
@RequiresOptIn("The api is must add this Provider to your AndroidManifest.xml. 需要声明此Provider到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OProvider()
