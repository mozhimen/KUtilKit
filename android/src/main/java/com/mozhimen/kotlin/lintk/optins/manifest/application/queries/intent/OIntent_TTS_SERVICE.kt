package com.mozhimen.kotlin.lintk.optins.manifest.application.queries.intent

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OIntent_TTS_SERVICE
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
<queries>
    <intent>
        <action android:name="android.intent.action.TTS_SERVICE" />
    </intent>
</queries>
""")
@RequiresOptIn("The api is must add this Intent to your AndroidManifest.xml. 需要声明此Intent到你的AndroidManifest.xml queries下", RequiresOptIn.Level.WARNING)
annotation class OIntent_TTS_SERVICE()
