package com.mozhimen.kotlin.lintk.optins.manifest.application.service

import com.mozhimen.kotlin.lintk.annors.AManifestRequire

/**
 * @ClassName OService_ACCESSIBILITY
 * @Description TODO
 * @Author mozhimen
 * @Date 2026/3/30
 * @Version 1.0
 */
@AManifestRequire("""
    * AndroidManifest.xml
    <service
    android:name=".xxxAccessibilityService"
    android:enabled="true"
    android:exported="true"
    android:permission="android.permission.BIND_ACCESSIBILITY_SERVICE">
    <intent-filter>
    <action android:name="android.accessibilityservice.AccessibilityService" />
    </intent-filter>
    
    <meta-data
    android:name="android.accessibilityservice"
    android:resource="@xml/accessibility_service_config" />
    </service>

     * 配置文件 res/xml/accessibility_service_config.xml
    <accessibility-service xmlns:android="http://schemas.android.com/apk/res/android"
    android:description="@string/accessibility_service_description"
    android:accessibilityEventTypes="typeAllMask"
    android:accessibilityFeedbackType="feedbackGeneric"
    android:notificationTimeout="100"
    android:canPerformGestures="true"
    android:canRetrieveWindowContent="true"
    android:settingsActivity="com.example.autobehavior.SettingsActivity"
    />
    
    android:description：服务的描述，出现在辅助中心列表中，引用字符串资源。
    android:packageNames：监听的应用包名，用逗号隔开，这里监听的包名为com.android.automeng，com.ss.android.ugc.aweme这两个应用触发的事件。
    android:accessibilityEventTypes：指明要监听的事件类型，这里使用typeAllMask表示监听所有类型的辅助事件。
    ndroid:accessibilityFeedbackType：提供语音反馈等等。
    android:notificationTimeout：事件通知的超时时间，单位ms。如果超过这个时间服务没有响应，该事件将被丢弃。
    android:canRetrieveWindowContent：服务可以检索窗口内容，如果为false，onAccessibilityEvent()中的事件无法获取子View信息。
    android:canPerformGestures：服务可以执行手势操作，如双击、滑动等。
    android:settingsActivity服务的设置界面Activity,允许用户设置服务相关选项。
    android:accessibilityFlags：事件回调中报告视图ID，这样服务可以找到触发事件的具体视图。
    **/
""")
@RequiresOptIn("The api is must add this ACCESSIBILITY to your AndroidManifest.xml. 需要声明此ACCESSIBILITY属性到你的AndroidManifest.xml application下", RequiresOptIn.Level.WARNING)
annotation class OService_ACCESSIBILITY