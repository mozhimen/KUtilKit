package com.mozhimen.kotlin.lintk.optins.manifest.application.activity.intent_filter

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OApplication_REQUEST_LEGACY_EXTERNAL_STORAGE
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/4
 * @Version 1.0
 */
@AManifestRequire("""
     <!--外部浏览器拉起策略-->
     <intent-filter>
         <!--必有项-->
         <action android:name="android.intent.action.VIEW" />
         <!--表示该页面可以被隐式调用，必须加上该项-->
         <category android:name="android.intent.category.DEFAULT" />
         <!--BROWSABLE指定该Activity能被浏览器安全调用-->
         <category android:name="android.intent.category.BROWSABLE" />
         <!--协议部分-->
         <!--声明自定义scheme，类似于http, https-->
         <data
             android:host="com.xx.xxx"
             android:scheme="http?" />
     </intent-filter>
""")
@RequiresOptIn("The api is must add this IntentFilte to your AndroidManifest.xml. 需要声明此IntentFilter到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OIntentFilter_ACTION_VIEW_CATEGORY_DEFAULT_BROWSABLE