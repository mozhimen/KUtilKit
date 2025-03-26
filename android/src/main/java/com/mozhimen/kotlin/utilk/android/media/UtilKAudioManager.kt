package com.mozhimen.kotlin.utilk.android.media

import android.content.Context
import android.media.AudioManager
import com.mozhimen.kotlin.elemk.android.media.cons.CAudioManager
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet

/**
 * @ClassName UtilKAudioManager
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2023/3/20 23:02
 * @Version 1.0
 */
object UtilKAudioManager {
    @JvmStatic
    fun get(context: Context): AudioManager =
        UtilKContextGet.getSystemService_AUDIO(context)

    @JvmStatic
    fun getStreamVolume(context: Context, streamType: Int): Int =
        get(context).getStreamVolume(streamType)

    @JvmStatic
    fun getStreamVolume_ofSTREAM_MUSIC(context: Context): Int =
        getStreamVolume(context, CAudioManager.STREAM_MUSIC)
}