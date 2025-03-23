package com.mozhimen.kotlin.utilk.android.graphics

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.graphics.*
import android.graphics.Bitmap.CompressFormat
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toDrawable
import com.mozhimen.kotlin.elemk.android.media.cons.CMediaFormat
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.provider.cons.CMediaStore
import com.mozhimen.kotlin.elemk.android.util.cons.CBase64
import com.mozhimen.kotlin.utilk.wrapper.UtilKPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContentResolver
import com.mozhimen.kotlin.utilk.android.content.UtilKResources
import com.mozhimen.kotlin.utilk.android.media.UtilKMediaScannerConnection
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.java.io.UtilKFileWrapper
import com.mozhimen.kotlin.utilk.java.io.byteArrayOutputStream2bytes_use
import com.mozhimen.kotlin.utilk.java.io.createFile
import com.mozhimen.kotlin.utilk.java.io.file2fileOutputStream
import com.mozhimen.kotlin.utilk.java.io.flushClose
import com.mozhimen.kotlin.utilk.java.io.outputStream2bufferedOutputStream
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.kotlin.utilk.kotlin.bytes2byteArrayInputStream
import com.mozhimen.kotlin.utilk.kotlin.bytes2file
import com.mozhimen.kotlin.utilk.kotlin.bytes2strBase64
import com.mozhimen.kotlin.utilk.kotlin.createFile
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2file
import java.io.BufferedOutputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.OutputStream


/**
 * @ClassName UtilKBitmapFormat
 * @Description Bitmap bytes 流转换类
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/1/3 4:54
 * @Version 1.0
 */
fun Bitmap.bitmapAny2strBase64(compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 50, flags: Int = CBase64.NO_WRAP): String? =
    UtilKBitmapFormat.bitmapAny2strBase64(this,compressFormat, quality, flags)

@RequiresApi(CVersCode.V_29_10_Q)
fun Bitmap.bitmapAny2fileImage(strBitmapPathName: String, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
    UtilKBitmapFormat.bitmapAny2fileImage(this, strBitmapPathName, compressFormat, quality)

fun Bitmap.bitmapAny2file(strBitmapPathNameDest: String, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
    UtilKBitmapFormat.bitmapAny2file(this, strBitmapPathNameDest, compressFormat, quality)

fun Bitmap.bitmapAny2file(fileDest: File, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
    UtilKBitmapFormat.bitmapAny2file(this, fileDest, compressFormat, quality)

fun Bitmap.bitmapJpeg2fileJpeg(strBitmapPathNameDest: String, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
    UtilKBitmapFormat.bitmapJpeg2fileJpeg(this, strBitmapPathNameDest, quality)

fun Bitmap.bitmapAny2fileJpeg(strBitmapPathNameDest: String, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
    UtilKBitmapFormat.bitmapAny2fileJpeg(this, strBitmapPathNameDest, quality)

fun Bitmap.bitmapAny2filePng(strBitmapPathNameDest: String, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
    UtilKBitmapFormat.bitmapAny2filePng(this, strBitmapPathNameDest, quality)

fun Bitmap.bitmapAny2fileBmp(strBitmapPathNameDest: String): File =
    UtilKBitmapFormat.bitmapAny2fileBmp(this, strBitmapPathNameDest)

//////////////////////////////////////////////////////////////////////////////////////////

fun Bitmap.bitmapAny2bytesAny_use(compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): ByteArray =
    UtilKBitmapFormat.bitmapAny2bytesAny_use(this, compressFormat, quality)

fun Bitmap.bitmapAny2byteArrayInputStream(compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): ByteArrayInputStream =
    UtilKBitmapFormat.bitmapAny2byteArrayInputStream(this, compressFormat, quality)

fun Bitmap.bitmapAny2bytesJpeg(): ByteArray =
    UtilKBitmapFormat.bitmapAny2bytesJpeg(this)

fun Bitmap.bitmapAny2bytesPng(): ByteArray =
    UtilKBitmapFormat.bitmapAny2bytesPng(this)

fun Bitmap.bitmapAny2bytesBmp(): ByteArray =
    UtilKBitmapFormat.bitmapAny2bytesBmp(this)

//////////////////////////////////////////////////////////////////////////////////////////

fun Bitmap.bitmapAny2bitmapRgb565(): Bitmap =
    UtilKBitmapFormat.bitmapAny2bitmapRgb565(this)

fun Bitmap.bitmapAny2drawable(): Drawable =
    UtilKBitmapFormat.bitmapAny2drawable(this)

fun Bitmap.bitmapAny2bitmapDrawable(): BitmapDrawable =
    UtilKBitmapFormat.bitmapAny2bitmapDrawable(this)

object UtilKBitmapFormat : BaseUtilK() {

    /**
     * 位图转base64
     * flags参数说明
     * URL_SAFE：安全的URL编码，base64转码过程中会生成“+”，“/”，“=”这些会被URL进行转码的特殊字符，导致前后台数据不同，所以需要将这些字符替代为URL不会进行转码的字符，保证数据同步；
     * "-" -> "+"
     * "_" -> "/"
     * NO_WRAP：不换行
     * NO_PADDING："="号补齐去除，base64会对字符进行串长度余4的"="的补位，需去除"="。
     */
    @JvmStatic
    fun bitmapAny2strBase64(sourceBitmap: Bitmap, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 50, flags: Int = CBase64.NO_WRAP): String? {
        return sourceBitmap.bitmapAny2bytesAny_use(compressFormat, quality).bytes2strBase64(flags)
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_29_10_Q)
    fun bitmapAny2fileImage(sourceBitmap: Bitmap, strBitmapPathName: String, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): File? {
        var outputStream: OutputStream? = null
        val fileDest = strBitmapPathName.strFilePath2file()
        fileDest.createFile()
        try {
            val contentValues = ContentValues().apply {
                put(CMediaStore.Images.ImageColumns.DATA, fileDest.absolutePath)
                put(CMediaStore.Images.ImageColumns.DISPLAY_NAME, strBitmapPathName.split("/").lastOrNull() ?: UtilKStrFile.getStrFileName_ofNow())
                put(CMediaStore.Images.ImageColumns.MIME_TYPE, CMediaFormat.MIMETYPE_IMAGE_JPEG)
                put(CMediaStore.Images.ImageColumns.DATE_TAKEN, System.currentTimeMillis().toString())
            }
            UtilKContentResolver.insert(_context, CMediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)?.let {
                outputStream = UtilKContentResolver.openOutputStream(_context, it)
                sourceBitmap.applyBitmapAnyCompress(compressFormat, quality, outputStream!!)
                return fileDest
            }
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        } finally {
            outputStream?.flushClose()
            try {
                UtilKMediaScannerConnection.scanFile(_context, arrayOf(fileDest.absolutePath), arrayOf(CMediaFormat.MIMETYPE_IMAGE_JPEG)) { path, uri ->
                    "bitmapAny2fileImage: path $path, uri $uri".d(TAG)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                e.message?.e(TAG)
            }
        }
        return null
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 保存图片 before 29
     */
    @JvmStatic
    fun bitmapAny2file(sourceBitmap: Bitmap, strBitmapPathNameDest: String, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
        bitmapAny2file(sourceBitmap, File(strBitmapPathNameDest), compressFormat, quality)

    /**
     * 保存图片 before 29
     */
    @JvmStatic
    fun bitmapAny2file(sourceBitmap: Bitmap, fileDest: File, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): File? {
        UtilKFileWrapper.createFile(fileDest)
        var bufferedOutputStream: BufferedOutputStream? = null
        try {
            bufferedOutputStream = fileDest.file2fileOutputStream().outputStream2bufferedOutputStream()
            sourceBitmap.applyBitmapAnyCompress(compressFormat, quality, bufferedOutputStream)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        } finally {
            bufferedOutputStream?.flushClose()
        }
        return null
    }

    @SuppressLint("MissingPermission")
    @JvmStatic
    fun bitmapJpeg2fileJpeg(sourceBitmap: Bitmap, strBitmapPathNameDest: String, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
        if (UtilKBuildVersion.isAfterV_29_10_Q()) {
            if (UtilKPermission.isSelfGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE))
                sourceBitmap.bitmapAny2fileImage(strBitmapPathNameDest, CompressFormat.JPEG, quality)
            else {
                UtilKLogWrapper.d(TAG, "bitmapJpeg2fileJpeg: dont has permission")
                null
            }
        } else bitmapAny2fileJpeg(sourceBitmap, strBitmapPathNameDest, quality)

    @JvmStatic
    fun bitmapAny2fileJpeg(sourceBitmap: Bitmap, strBitmapPathNameDest: String, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
        bitmapAny2file(sourceBitmap, strBitmapPathNameDest, CompressFormat.JPEG, quality)

    @JvmStatic
    fun bitmapAny2filePng(sourceBitmap: Bitmap, strBitmapPathNameDest: String, @IntRange(from = 0, to = 100) quality: Int = 100): File? =
        bitmapAny2file(sourceBitmap, strBitmapPathNameDest, CompressFormat.PNG, quality)

    @JvmStatic
    fun bitmapAny2fileBmp(sourceBitmap: Bitmap, strBitmapPathNameDest: String): File =
        sourceBitmap.bitmapAny2bytesBmp().bytes2file(strBitmapPathNameDest)

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun bitmapAny2bytesAny_use(sourceBitmap: Bitmap, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream(sourceBitmap.width * sourceBitmap.height * 4)
        sourceBitmap.applyBitmapAnyCompress(compressFormat, quality, byteArrayOutputStream)
        return byteArrayOutputStream.byteArrayOutputStream2bytes_use()
    }

    @JvmStatic
    fun bitmapAny2byteArrayInputStream(sourceBitmap: Bitmap, compressFormat: CompressFormat = CompressFormat.JPEG, @IntRange(from = 0, to = 100) quality: Int = 100): ByteArrayInputStream {
        return bitmapAny2bytesAny_use(sourceBitmap, compressFormat, quality).bytes2byteArrayInputStream()
    }

    @JvmStatic
    fun bitmapAny2bytesJpeg(sourceBitmap: Bitmap, @IntRange(from = 0, to = 100) quality: Int = 100): ByteArray =
        bitmapAny2bytesAny_use(sourceBitmap, CompressFormat.JPEG, quality)

    @JvmStatic
    fun bitmapAny2bytesPng(sourceBitmap: Bitmap, @IntRange(from = 0, to = 100) quality: Int = 100): ByteArray =
        bitmapAny2bytesAny_use(sourceBitmap, CompressFormat.PNG, quality)

    @JvmStatic
    fun bitmapAny2bytesBmp(sourceBitmap: Bitmap): ByteArray {
        val width: Int = sourceBitmap.width
        val height: Int = sourceBitmap.height
        val wWidth = width * 3 + width % 4
        val bmpDateSize = height * wWidth
        val size = 14 + 40 + bmpDateSize
        val bytes = ByteArray(size)

        // 1.BMP文件头 14
        bytes[0] = 0x42 //bfType 2bytes
        bytes[1] = 0x4D
        bytes[2] = (size shr 0 and 0xFF).toByte() //bfSize 4bytes
        bytes[3] = (size shr 8 and 0xFF).toByte()
        bytes[4] = (size shr 16 and 0xFF).toByte()
        bytes[5] = (size shr 24 and 0xFF).toByte()
        bytes[6] = 0x00 //bfReserved1 2bytes
        bytes[7] = 0x00
        bytes[8] = 0x00 //bfReserved2 2bytes
        bytes[9] = 0x00
        bytes[10] = 0x36 //bfOffBits 14+40 4bytes
        bytes[11] = 0x00
        bytes[12] = 0x00
        bytes[13] = 0x00

        // 2.BMP信息头 40
        bytes[14] = 0x28 //biSize 40 4bytes
        bytes[15] = 0x00
        bytes[16] = 0x00
        bytes[17] = 0x00
        bytes[18] = (width shr 0 and 0xFF).toByte() //biWidth 4bytes
        bytes[19] = (width shr 8 and 0xFF).toByte()
        bytes[20] = (width shr 16 and 0xFF).toByte()
        bytes[21] = (width shr 24 and 0xFF).toByte()
        bytes[22] = (height shr 0 and 0xFF).toByte() //biHeight 4bytes
        bytes[23] = (height shr 8 and 0xFF).toByte()
        bytes[24] = (height shr 16 and 0xFF).toByte()
        bytes[25] = (height shr 24 and 0xFF).toByte()
        bytes[26] = 0x01 //biPlanes 2bytes
        bytes[27] = 0x00
        bytes[28] = 0x18 //biBitCount 24位位图 2bytes
        bytes[29] = 0x00
        bytes[30] = 0x00 //biCompression 4bytes
        bytes[31] = 0x00
        bytes[32] = 0x00
        bytes[33] = 0x00
        bytes[34] = 0x00 //biSizeImage 4bytes
        bytes[35] = 0x00
        bytes[36] = 0x00
        bytes[37] = 0x00
        bytes[38] = 0x00 //biXpelsPerMeter 4bytes
        bytes[39] = 0x00
        bytes[40] = 0x00
        bytes[41] = 0x00
        bytes[42] = 0x00 //biYPelsPerMeter 4bytes
        bytes[43] = 0x00
        bytes[44] = 0x00
        bytes[45] = 0x00
        bytes[46] = 0x00 //biClrUsed 4bytes
        bytes[47] = 0x00
        bytes[48] = 0x00
        bytes[49] = 0x00
        bytes[50] = 0x00 //biClrImportant 4bytes
        bytes[51] = 0x00
        bytes[52] = 0x00
        bytes[53] = 0x00

        val bmpData = ByteArray(bmpDateSize)
        var nCol: Int = 0
        var nRealCol: Int = height - 1
        while (nCol < height) {
            var wRow: Int = 0
            var wByteIdex: Int = 0
            while (wRow < width) {
                val clr: Int = sourceBitmap.getPixel(wRow, nCol)
                //clr = clr == 0 ? 0xFFFFFF : clr; //黑色背景转为白色
                bmpData[nRealCol * wWidth + wByteIdex] = Color.blue(clr).toByte()
                bmpData[nRealCol * wWidth + wByteIdex + 1] = Color.green(clr).toByte()
                bmpData[nRealCol * wWidth + wByteIdex + 2] = Color.red(clr).toByte()
                wRow++
                wByteIdex += 3
            }
            ++nCol
            --nRealCol
        }

        System.arraycopy(bmpData, 0, bytes, 54, bmpDateSize)
        return bytes
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun bitmapAny2bitmapRgb565(sourceBitmap: Bitmap): Bitmap =
        sourceBitmap.copy(Bitmap.Config.RGB_565, true)

    @JvmStatic
    fun bitmapAny2drawable(sourceBitmap: Bitmap): Drawable =
        sourceBitmap.toDrawable(UtilKResources.get_ofSys())

    @JvmStatic
    fun bitmapAny2bitmapDrawable(sourceBitmap: Bitmap): BitmapDrawable =
        BitmapDrawable(UtilKResources.get_ofApp(_context), sourceBitmap)
}