package com.mozhimen.kotlin.elemk.android.os.cons

import android.os.Environment
import androidx.annotation.RequiresApi

/**
 * @ClassName CEnvironment
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/9/8 18:33
 * @Version 1.0
 */
object CEnvironment {
    val DIRECTORY_MUSIC get() = Environment.DIRECTORY_MUSIC
    val DIRECTORY_PODCASTS get() = Environment.DIRECTORY_PODCASTS
    val DIRECTORY_RINGTONES get() = Environment.DIRECTORY_RINGTONES
    val DIRECTORY_ALARMS get() = Environment.DIRECTORY_ALARMS
    val DIRECTORY_NOTIFICATIONS get() = Environment.DIRECTORY_NOTIFICATIONS
    val DIRECTORY_PICTURES get() = Environment.DIRECTORY_PICTURES
    val DIRECTORY_MOVIES get() = Environment.DIRECTORY_MOVIES
    val DIRECTORY_DOWNLOADS get() = Environment.DIRECTORY_DOWNLOADS
    val DIRECTORY_DCIM get() = Environment.DIRECTORY_DCIM
    val DIRECTORY_DOCUMENTS get() = Environment.DIRECTORY_DOCUMENTS
    val MEDIA_MOUNTED get() = Environment.MEDIA_MOUNTED
    @get:RequiresApi(CVersCode.V_29_10_Q)
    val DIRECTORY_SCREENSHOTS get() = Environment.DIRECTORY_SCREENSHOTS
    @get:RequiresApi(CVersCode.V_29_10_Q)
    val DIRECTORY_AUDIOBOOKS get() = Environment.DIRECTORY_AUDIOBOOKS
    @get:RequiresApi(CVersCode.V_31_12_S)
    val DIRECTORY_RECORDINGS get() = Environment.DIRECTORY_RECORDINGS
}