package com.mozhimen.kotlin.elemk.android.media.cons

import android.media.MediaFormat
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode


/**
 * @ClassName CMediaFormat
 * @Description [android.media.MediaFormat]
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CMediaFormat {
    const val MIMETYPE_TEXT_PLAIN = "text/plain"

    ///////////////////////////////////////////////////////////////////

    const val MIMETYPE_IMAGE_ALL = "image/*"
    const val MIMETYPE_IMAGE_PNG = "image/png"
    const val MIMETYPE_IMAGE_JPEG = "image/jpeg"

    ///////////////////////////////////////////////////////////////////

    const val MIMETYPE_VIDEO_ALL = "video/*"

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_VP8 = MediaFormat.MIMETYPE_VIDEO_VP8//video/x-vnd.on2.vp8

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_VP9 = MediaFormat.MIMETYPE_VIDEO_VP9//video/x-vnd.on2.vp9

    @RequiresApi(CVersCode.V_29_10_Q)
    const val MIMETYPE_VIDEO_AV1 = MediaFormat.MIMETYPE_VIDEO_AV1//video/av01

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_AVC = MediaFormat.MIMETYPE_VIDEO_AVC//video/avc

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_HEVC = MediaFormat.MIMETYPE_VIDEO_HEVC//video/hevc

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_MPEG4 = MediaFormat.MIMETYPE_VIDEO_MPEG4//video/mp4v-es

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_H263 = MediaFormat.MIMETYPE_VIDEO_H263//video/3gpp

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_MPEG2 = MediaFormat.MIMETYPE_VIDEO_MPEG2//video/mpeg2

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_VIDEO_RAW = MediaFormat.MIMETYPE_VIDEO_RAW//video/scrambled

    @RequiresApi(CVersCode.V_24_7_N)
    const val MIMETYPE_VIDEO_DOLBY_VISION = MediaFormat.MIMETYPE_VIDEO_DOLBY_VISION//

    @RequiresApi(CVersCode.V_26_8_O)
    const val MIMETYPE_VIDEO_SCRAMBLED = MediaFormat.MIMETYPE_VIDEO_SCRAMBLED//

    ///////////////////////////////////////////////////////////////////

    const val MIMETYPE_AUDIO_ALL = "audio/*"

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_AMR_NB = MediaFormat.MIMETYPE_AUDIO_AMR_NB//audio/3gpp

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_AMR_WB = MediaFormat.MIMETYPE_AUDIO_AMR_WB//audio/amr-wb

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_MPEG = MediaFormat.MIMETYPE_AUDIO_MPEG//audio/mpeg

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_AAC = MediaFormat.MIMETYPE_AUDIO_AAC//audio/mp4a-latm

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_QCELP = MediaFormat.MIMETYPE_AUDIO_QCELP//audio/qcelp

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_VORBIS = MediaFormat.MIMETYPE_AUDIO_VORBIS//audio/vorbis

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_OPUS = MediaFormat.MIMETYPE_AUDIO_OPUS//audio/opus

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_G711_ALAW = MediaFormat.MIMETYPE_AUDIO_G711_ALAW//audio/g711-alaw

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_G711_MLAW = MediaFormat.MIMETYPE_AUDIO_G711_MLAW//audio/g711-mlaw

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_RAW = MediaFormat.MIMETYPE_AUDIO_RAW//audio/raw

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_FLAC = MediaFormat.MIMETYPE_AUDIO_FLAC//audio/flac

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_MSGSM = MediaFormat.MIMETYPE_AUDIO_MSGSM//audio/gsm

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_AUDIO_AC3 = MediaFormat.MIMETYPE_AUDIO_AC3//audio/ac3

    @RequiresApi(CVersCode.V_23_6_M)
    const val MIMETYPE_AUDIO_EAC3 = MediaFormat.MIMETYPE_AUDIO_EAC3//audio/eac3

    @RequiresApi(CVersCode.V_29_10_Q)
    const val MIMETYPE_AUDIO_EAC3_JOC = MediaFormat.MIMETYPE_AUDIO_EAC3_JOC//audio/eac3-joc

    @RequiresApi(CVersCode.V_29_10_Q)
    const val MIMETYPE_AUDIO_AC4 = MediaFormat.MIMETYPE_AUDIO_AC4//audio/ac4

    @RequiresApi(CVersCode.V_26_8_O)
    const val MIMETYPE_AUDIO_SCRAMBLED = MediaFormat.MIMETYPE_AUDIO_SCRAMBLED//audio/scrambled

    @RequiresApi(CVersCode.V_31_12_S)
    const val MIMETYPE_AUDIO_MPEGH_MHA1 = MediaFormat.MIMETYPE_AUDIO_MPEGH_MHA1//audio/mha1

    @RequiresApi(CVersCode.V_31_12_S)
    const val MIMETYPE_AUDIO_MPEGH_MHM1 = MediaFormat.MIMETYPE_AUDIO_MPEGH_MHM1//audio/mhm1

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_DTS = MediaFormat.MIMETYPE_AUDIO_DTS//audio/vnd.dts

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_DTS_HD = MediaFormat.MIMETYPE_AUDIO_DTS_HD//audio/vnd.dts.hd

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_DTS_UHD = MediaFormat.MIMETYPE_AUDIO_DTS_UHD//audio/vnd.dts.uhd

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_DRA = MediaFormat.MIMETYPE_AUDIO_DRA//audio/vnd.dra

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_DOLBY_MAT = MediaFormat.MIMETYPE_AUDIO_DOLBY_MAT//audio/vnd.dolby.mat

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_DOLBY_TRUEHD = MediaFormat.MIMETYPE_AUDIO_DOLBY_TRUEHD//audio/vnd.dolby.mlp

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_AAC_LC = MediaFormat.MIMETYPE_AUDIO_AAC_LC//"audio/mp4a.40.02"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_AAC_HE_V1 = MediaFormat.MIMETYPE_AUDIO_AAC_HE_V1//"audio/mp4a.40.05"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_AAC_HE_V2 = MediaFormat.MIMETYPE_AUDIO_AAC_HE_V2//"audio/mp4a.40.29"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_AAC_ELD = MediaFormat.MIMETYPE_AUDIO_AAC_ELD//"audio/mp4a.40.39"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_AAC_XHE = MediaFormat.MIMETYPE_AUDIO_AAC_XHE//"audio/mp4a.40.42"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_MPEGH_BL_L3 = MediaFormat.MIMETYPE_AUDIO_MPEGH_BL_L3//"audio/mhm1.03"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_MPEGH_BL_L4 = MediaFormat.MIMETYPE_AUDIO_MPEGH_BL_L4//"audio/mhm1.04"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_MPEGH_LC_L3 = MediaFormat.MIMETYPE_AUDIO_MPEGH_LC_L3//"audio/mhm1.0d"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_MPEGH_LC_L4 = MediaFormat.MIMETYPE_AUDIO_MPEGH_LC_L4//"audio/mhm1.0e"

    @RequiresApi(CVersCode.V_33_13_T)
    const val MIMETYPE_AUDIO_IEC61937 = MediaFormat.MIMETYPE_AUDIO_IEC61937//"audio/x-iec61937"

    @RequiresApi(CVersCode.V_28_9_P)
    const val MIMETYPE_IMAGE_ANDROID_HEIC: String = MediaFormat.MIMETYPE_IMAGE_ANDROID_HEIC//"image/vnd.android.heic"

    @RequiresApi(CVersCode.V_34_14_UDC)
    const val MIMETYPE_IMAGE_AVIF: String = MediaFormat.MIMETYPE_IMAGE_AVIF//"image/avif"

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_TEXT_VTT: String = MediaFormat.MIMETYPE_TEXT_VTT//"text/vtt"

    @RequiresApi(CVersCode.V_28_9_P)
    const val MIMETYPE_TEXT_SUBRIP: String = MediaFormat.MIMETYPE_TEXT_SUBRIP//"application/x-subrip"

    @RequiresApi(CVersCode.V_21_5_L)
    const val MIMETYPE_TEXT_CEA_608: String = MediaFormat.MIMETYPE_TEXT_CEA_608//"text/cea-608"

    @RequiresApi(CVersCode.V_28_9_P)
    const val MIMETYPE_TEXT_CEA_708: String = MediaFormat.MIMETYPE_TEXT_CEA_708//"text/cea-708"

}