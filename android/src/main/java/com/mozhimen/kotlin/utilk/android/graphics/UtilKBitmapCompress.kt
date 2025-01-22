package com.mozhimen.kotlin.utilk.android.graphics

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import com.mozhimen.kotlin.utilk.android.util.v
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.kotlin.bytes2bitmapAny
import com.mozhimen.kotlin.utilk.kotlin.getStrFileExtension
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2bitmapAny
import kotlin.math.roundToInt
import kotlin.math.sqrt


/**
 * @ClassName UtilKBitmapCompress
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/1/4 14:35
 * @Version 1.0
 */
fun String.strCompressFormat2compressFormat(): CompressFormat =
    UtilKBitmapCompress.strCompressFormat2compressFormat(this)

fun Bitmap.compressBitmapAnyQuality(compressFormat: CompressFormat = CompressFormat.JPEG, @androidx.annotation.IntRange(from = 1, to = 100) quality: Int = 50): Bitmap? =
    UtilKBitmapCompress.compressBitmapAnyQuality(this, compressFormat, quality)

fun String.compressStrBitmapPathSampleSize(@androidx.annotation.IntRange(from = 1, to = 100) quality: Int): Bitmap? =
    UtilKBitmapCompress.compressStrBitmapPathSampleSize(this, quality)

fun Bitmap.compressBitmapAnyMatrix(@androidx.annotation.IntRange(from = 1, to = 100) quality: Int): Bitmap =
    UtilKBitmapCompress.compressBitmapAnyMatrix(this, quality)

fun Bitmap.compressBitmapAny2bitmapRgb565(): Bitmap =
    UtilKBitmapCompress.compressBitmapAny2bitmapRgb565(this)

fun String.compressStrBitmapPath2bitmapRgb565(): Bitmap? =
    UtilKBitmapCompress.compressStrBitmapPath2bitmapRgb565(this)

fun Bitmap.compressBitmapAnyScaled(@androidx.annotation.IntRange(from = 1, to = 100) quality: Int): Bitmap =
    UtilKBitmapCompress.compressBitmapAnyScaled(this, quality)

object UtilKBitmapCompress : BaseUtilK() {

    @JvmStatic
    fun strCompressFormat2compressFormat(strCompressFormat: String): CompressFormat =
        when (strCompressFormat.getStrFileExtension()?.lowercase()) {
            "png" -> CompressFormat.PNG
            "webp" -> CompressFormat.WEBP
            else -> CompressFormat.JPEG
        }

    //////////////////////////////////////////////////////////////////

    //压缩质量
    @JvmStatic
    fun compressBitmapAnyQuality(bitmapSource: Bitmap, compressFormat: CompressFormat = CompressFormat.JPEG, @androidx.annotation.IntRange(from = 1, to = 100) quality: Int = 50): Bitmap? =
        bitmapSource.bitmapAny2bytesAny_use(compressFormat, quality)?.let { bytes ->
            bytes.bytes2bitmapAny().also { printBitmapInfo(it, bytes, quality) }
        }

    //压缩采样率
    @JvmStatic
    fun compressStrBitmapPathSampleSize(bitmapPathName: String, @androidx.annotation.IntRange(from = 1, to = 100) quality: Int): Bitmap? {
        val options = BitmapFactory.Options()
        options.inSampleSize = (100f / quality.toFloat()).roundToInt().also { "compressSampleSize: inSampleSize $it".v(TAG) }
        return bitmapPathName.strFilePath2bitmapAny(options)?.also { printBitmapInfo(it, null, quality) }
    }

    //缩放压缩法
    @JvmStatic
    fun compressBitmapAnyMatrix(bitmapSource: Bitmap, @androidx.annotation.IntRange(from = 1, to = 100) quality: Int): Bitmap {
        val ratio: Float = sqrt(quality.toFloat() / 100f).also { "compressMatrix: ratio $it".v(TAG) }//这里很好理解, 我们是对面的比例, 开方才是边的缩小比例
        return bitmapSource.applyBitmapAnyScaleRatio(ratio).also { printBitmapInfo(it, null, quality) }
    }

    //rgb565压缩方法
    @JvmStatic
    fun compressBitmapAny2bitmapRgb565(bitmapSource: Bitmap): Bitmap =
        bitmapSource.bitmapAny2bitmapRgb565().also { printBitmapInfo(it, null, 100) }

    //rgb565压缩方法
    @JvmStatic
    fun compressStrBitmapPath2bitmapRgb565(bitmapPathName: String): Bitmap? {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return bitmapPathName.strFilePath2bitmapAny(options)?.also { printBitmapInfo(it, null, 100) }
    }

    //compressScaledBitmap方法压缩
    @JvmStatic
    fun compressBitmapAnyScaled(bitmapSource: Bitmap, @androidx.annotation.IntRange(from = 1, to = 100) quality: Int): Bitmap {
        val ratio: Float = sqrt(quality.toFloat() / 100f).also { "compressScaledBitmap: ratio $it".v(TAG) }//这里很好理解, 我们是对面的比例, 开方才是边的缩小比例
        return bitmapSource.applyBitmapAnyResize((bitmapSource.width * ratio).toInt(), (bitmapSource.height * ratio).toInt()).also { printBitmapInfo(it, null, quality) }
    }

    //打印bitmap信息
    @JvmStatic
    private fun printBitmapInfo(bitmapSource: Bitmap, bytes: ByteArray?, quality: Int) {
        "compress after bitmap size: ${bitmapSource.getByteCount_ofM()}MB width: ${bitmapSource.width} height: ${bitmapSource.height} bytes.length: ${bytes?.let { it.size / 1024 } ?: 0}KB quality: $quality".v(TAG)
    }
}