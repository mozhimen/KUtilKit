package com.mozhimen.kotlin.utilk.java.io

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.security.UtilKMessageDigestMD5
import com.mozhimen.kotlin.utilk.java.util.UtilKGZIPInputStream
import com.mozhimen.kotlin.utilk.kotlin.UtilKByteArray
import com.mozhimen.kotlin.utilk.kotlin.bytes2str
import com.mozhimen.kotlin.utilk.kotlin.bytes2strHex
import com.mozhimen.kotlin.utilk.kotlin.bytes2strHex_ofHexString
import com.mozhimen.kotlin.utilk.kotlin.bytes2strHex_ofBigInteger
import com.mozhimen.kotlin.utilk.kotlin.createFile
import com.mozhimen.kotlin.utilk.kotlin.strFilePath2file
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PushbackInputStream
import java.nio.charset.Charset
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.zip.GZIPInputStream


/**
 * @ClassName UtilKInputStreamFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/18 23:43
 * @Version 1.0
 */

fun InputStream.inputStream2bufferedInputStream(): BufferedInputStream =
    UtilKInputStreamFormat.inputStream2bufferedInputStream(this)

fun InputStream.inputStream2inputStreamReader(): InputStreamReader =
    UtilKInputStreamFormat.inputStream2inputStreamReader(this)

fun InputStream.inputStream2pushbackInputStream(size: Int? = null): PushbackInputStream =
    UtilKInputStreamFormat.inputStream2pushbackInputStream(this, size)

fun InputStream.inputStream2gZIPInputStream(size: Int? = null): GZIPInputStream =
    UtilKGZIPInputStream.get(this, size)

////////////////////////////////////////////////////////////////////////////

fun InputStream.inputStream2bytes_use(): ByteArray =
    UtilKInputStreamFormat.inputStream2bytes_use(this)

////////////////////////////////////////////////////////////////////////////

fun InputStream.inputStream2bytesMd5_use(bufferSize: Int = 1024 * 1024): ByteArray =
    UtilKInputStreamFormat.inputStream2bytesMd5_use(this, bufferSize)

fun InputStream.inputStream2strMd5Hex_use(): String =
    UtilKInputStreamFormat.inputStream2strMd5Hex_use(this)

fun InputStream.inputStream2strMd5Hex_use_ofBigInteger(): String =
    UtilKInputStreamFormat.inputStream2strMd5Hex_use_ofBigInteger(this)

fun InputStream.inputStream2strMd5Hex_use_ofHexString(): String =
    UtilKInputStreamFormat.inputStream2strMd5Hex_use_ofHexString(this)

fun InputStream.inputStream2str_use_ofBufferedReader(charset: String? = null, bufferSize: Int = 1024, isAddLineBreak: Boolean = false): String =
    UtilKInputStreamFormat.inputStream2str_use_ofBufferedReader(this, charset, bufferSize, isAddLineBreak)

fun InputStream.inputStream2str_use_ofBytesOutStream(byteArrayOutputStream: ByteArrayOutputStream): String =
    UtilKInputStreamFormat.inputStream2str_use_ofBytesOutStream(this, byteArrayOutputStream)

fun InputStream.inputStream2str_use_ofBytesOutStream(): String =
    UtilKInputStreamFormat.inputStream2str_use_ofBytesOutStream(this)

fun InputStream.inputStream2str_use_ofBytes(): String? =
    UtilKInputStreamFormat.inputStream2str_use_ofBytes(this)

////////////////////////////////////////////////////////////////////////////

fun InputStream.inputStream2strs_use_ofBufferedReader_forEachLine(charset: Charset = Charsets.UTF_8): List<String> =
    UtilKInputStreamFormat.inputStream2strs_use_ofBufferedReader_forEachLine(this, charset)

////////////////////////////////////////////////////////////////////////////

fun InputStream.inputStream2bitmapAny_use(): Bitmap =
    UtilKInputStreamFormat.inputStream2bitmapAny_use(this)

fun InputStream.inputStream2bitmapAny_use(outPadding: Rect?, opts: BitmapFactory.Options): Bitmap? =
    UtilKInputStreamFormat.inputStream2bitmapAny_use(this, outPadding, opts)

////////////////////////////////////////////////////////////////////////////

fun InputStream.inputStream2bitmapDrawable_use(): BitmapDrawable =
    UtilKInputStreamFormat.inputStream2bitmapDrawable_use(this)

////////////////////////////////////////////////////////////////////////////

fun InputStream.inputStream2file_use(strFilePathNameDest: String, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
    UtilKInputStreamFormat.inputStream2file_use(this, strFilePathNameDest, isAppend, bufferSize, block)

fun InputStream.inputStream2file_use(fileDest: File, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
    UtilKInputStreamFormat.inputStream2file_use(this, fileDest, isAppend, bufferSize, block)

fun InputStream.inputStream2file_use_ofCopyTo(strFilePathNameDest: String): File =
    UtilKInputStreamFormat.inputStream2file_use_ofCopyTo(this, strFilePathNameDest)

fun InputStream.inputStream2file_use_ofCopyTo(fileDest: File): File =
    UtilKInputStreamFormat.inputStream2file_use_ofCopyTo(this, fileDest)

fun InputStream.inputStream2File_use_ofCopyTo_gZip(fileDest: File): File =
    UtilKInputStreamFormat.inputStream2File_use_ofCopyTo_gZip(this, fileDest)

fun InputStream.inputStream2file_use_ofBufferedOutStream(strFilePathNameDest: String, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
    UtilKInputStreamFormat.inputStream2file_use_ofBufferedOutStream(this, strFilePathNameDest, isAppend, bufferSize, block)

fun InputStream.inputStream2file_use_ofBufferedOutStream(fileDest: File, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
    UtilKInputStreamFormat.inputStream2file_use_ofBufferedOutStream(this, fileDest, isAppend, bufferSize, block)

@RequiresApi(CVersCode.V_29_10_Q)
fun InputStream.inputStream2file_use_ofFileUtils(strFilePathNameDest: String, isAppend: Boolean = false): File? =
    UtilKInputStreamFormat.inputStream2file_use_ofFileUtils(this, strFilePathNameDest, isAppend)

@RequiresApi(CVersCode.V_29_10_Q)
fun InputStream.inputStream2file_use_ofFileUtils(fileDest: File, isAppend: Boolean = false): File? =
    UtilKInputStreamFormat.inputStream2file_use_ofFileUtils(this, fileDest, isAppend)

fun InputStream.inputStream2file_use_ofReadWriteBytes(strFilePathNameDest: String): File? =
    UtilKInputStreamFormat.inputStream2file_use_ofReadWriteBytes(this, strFilePathNameDest)

fun InputStream.inputStream2file_use_ofReadWriteBytes(fileDest: File): File? =
    UtilKInputStreamFormat.inputStream2file_use_ofReadWriteBytes(this, fileDest)

////////////////////////////////////////////////////////////////////////////

object UtilKInputStreamFormat : IUtilK {

    ////////////////////////////////////////////////////////////////////////////
    @JvmStatic
    fun inputStream2bufferedInputStream(inputStream: InputStream): BufferedInputStream =
        UtilKBufferedInputStream.get(inputStream)

    @JvmStatic
    fun inputStream2inputStreamReader(inputStream: InputStream, charset: Charset? = Charsets.UTF_8): InputStreamReader =
        UtilKInputStreamReader.get(inputStream, charset)

    @JvmStatic
    fun inputStream2pushbackInputStream(inputStream: InputStream, size: Int? = null): PushbackInputStream =
        UtilKPushbackInputStream.get(inputStream, size)

    @JvmStatic
    fun inputStream2gZIPInputStream(inputStream: InputStream, size: Int? = 0): GZIPInputStream =
        UtilKGZIPInputStream.get(inputStream, size)

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun inputStream2bytes_use(inputStream: InputStream): ByteArray =
        inputStream2bytes_use(inputStream, false)

    @JvmStatic
    fun inputStream2bytes_use(inputStream: InputStream, isVerify: Boolean): ByteArray {
        val bytes = UtilKByteArray.get(inputStream)
        val readSize = inputStream.read_use(bytes)
        if (isVerify && readSize.toLong() < inputStream.available())
            throw IOException(String.format("File length is [{}] but read [{}]!", *arrayOf<Any>(inputStream.available(), readSize)))
        return bytes
    }

    /**
     * 和方法二一样(增加完整性校验)
     */
    @JvmStatic
    fun inputStream2bytes_use_ofVerify(inputStream: InputStream): ByteArray =
        inputStream.use {
            val bytes = UtilKByteArray.get(inputStream)
            var offset = 0
            var readCount = 0
            while (offset < bytes.size && inputStream.read(bytes, offset, bytes.size - offset).also { readCount = it } != -1)
                offset += readCount
            // 确保所有数据均被读取
            if (offset != bytes.size) throw IOException("Could not completely read file.")
            bytes
        }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    @Throws(NoSuchAlgorithmException::class)
    fun inputStream2bytesMd5_use(inputStream: InputStream, bufferSize: Int = 1024 * 1024): ByteArray =
        inputStream.use {
            val messageDigest: MessageDigest = UtilKMessageDigestMD5.get()
            var readCount: Int
            val bytes = ByteArray(bufferSize)
            while (inputStream.read(bytes).also { readCount = it } != -1)
                messageDigest.update(bytes, 0, readCount)
            messageDigest.digest()
        }

    @JvmStatic
    @Throws(NoSuchAlgorithmException::class)
    fun inputStream2strMd5Hex_use(inputStream: InputStream): String =
        inputStream.inputStream2bytesMd5_use().bytes2strHex()

    @JvmStatic
    @Throws(NoSuchAlgorithmException::class)
    fun inputStream2strMd5Hex_use_ofBigInteger(inputStream: InputStream): String =
        inputStream.inputStream2bytesMd5_use().bytes2strHex_ofBigInteger()

    @JvmStatic
    @Throws(NoSuchAlgorithmException::class)
    fun inputStream2strMd5Hex_use_ofHexString(inputStream: InputStream): String =
        inputStream.inputStream2bytesMd5_use().bytes2strHex_ofHexString()

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun inputStream2str_use_ofBufferedReader(inputStream: InputStream, charset: String? = null, bufferSize: Int = 1024, isAddLineBreak: Boolean = false): String =
        UtilKInputStreamReader.readLines_use(inputStream, charset, bufferSize, isAddLineBreak)

    @JvmStatic
    fun inputStream2str_use_ofBytesOutStream(inputStream: InputStream): String =
        inputStream2str_use_ofBytesOutStream(inputStream, UtilKByteArrayOutputStream.get())

    @JvmStatic
    fun inputStream2str_use_ofBytesOutStream(inputStream: InputStream, byteArrayOutputStream: ByteArrayOutputStream, charset: Charset = Charsets.UTF_8): String {
        UtilKInputStream.read_write_use(inputStream, byteArrayOutputStream)
        return byteArrayOutputStream.byteArrayOutputStream2str_use(charset)
    }

    @JvmStatic
    fun inputStream2str_use_ofBytes(inputStream: InputStream): String {
        inputStream.use {
            val stringBuilder = StringBuilder()
            var readCount: Int
            val bytes = ByteArray(1024)
            while (inputStream.read(bytes).also { readCount = it } != -1)
                stringBuilder.append(bytes.bytes2str(0, readCount))
            return stringBuilder.toString()
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun inputStream2strs_use_ofBufferedReader_forEachLine(inputStream: InputStream, charset: Charset = Charsets.UTF_8): List<String> {
        val strs = mutableListOf<String>()
        inputStream.inputStream2inputStreamReader().inputStreamReader2bufferedReader().forEachLine_use(charset) { strs.add(it) }
        return strs
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun inputStream2bitmapAny_use(inputStream: InputStream): Bitmap =
        inputStream.use { BitmapFactory.decodeStream(it) }

    @JvmStatic
    fun inputStream2bitmapAny_use(inputStream: InputStream, outPadding: Rect?, opts: BitmapFactory.Options): Bitmap? =
        inputStream.use { BitmapFactory.decodeStream(it, outPadding, opts) }

    ////////////////////////////////////////////////////////////////////////////
    @JvmStatic
    fun inputStream2bitmapDrawable_use(inputStream: InputStream): BitmapDrawable =
        inputStream.use { BitmapDrawable(null, it) }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun inputStream2file_use(inputStream: InputStream, strFilePathNameDest: String, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
        inputStream2file_use(inputStream, strFilePathNameDest.strFilePath2file().apply { createFile() }, isAppend, bufferSize, block)

    @JvmStatic
    fun inputStream2file_use(inputStream: InputStream, fileDest: File, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? {
        UtilKFileWrapper.createFile(fileDest)
        /*//        val fileInputStream = file.file2fileInputStream()
        //        UtilKLogWrapper.d(TAG, "inputStream2file: inputStream ${inputStream.available()}")
        //        if (isInputStreamSame(inputStream, fileInputStream)) {//相似内容就直接返回地址
        //            UtilKLogWrapper.d(TAG, "assetCopyFile: the two files is same")
        //            return file//"the two files is same, don't need overwrite"
        //        }*/
        try {
            UtilKInputStream.read_write_use(inputStream, fileDest.file2fileOutputStream(isAppend), bufferSize, block)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    @JvmStatic
    fun inputStream2file_use_ofCopyTo(inputStream: InputStream, strFilePathNameDest: String): File =
        inputStream2file_use_ofCopyTo(inputStream, strFilePathNameDest.strFilePath2file().apply { createFile() })

    @JvmStatic
    fun inputStream2file_use_ofCopyTo(inputStream: InputStream, fileDest: File): File {
        inputStream.use { inputStream1 ->
            fileDest.outputStream().use { outputStream ->
                inputStream1.copyTo(outputStream)
                return fileDest
            }
        }
    }

    @JvmStatic
    fun inputStream2File_use_ofCopyTo_gZip(inputStream: InputStream, fileDest: File): File {
        inputStream.use { inputStream1 ->
            fileDest.outputStream().outputStream2gZipOutputStream().use { outputStream ->
                inputStream1.copyTo(outputStream)
                return fileDest
            }
        }
    }

    @JvmStatic
    fun inputStream2file_use_ofBufferedOutStream(
        inputStream: InputStream,
        strFilePathNameDest: String,
        isAppend: Boolean = false,
        bufferSize: Int = 1024,
        block: IAB_Listener<Int, Float>? = null
    ): File? =
        inputStream2file_use_ofBufferedOutStream(inputStream, strFilePathNameDest.strFilePath2file().apply { createFile() }, isAppend, bufferSize, block)

    @JvmStatic
    fun inputStream2file_use_ofBufferedOutStream(inputStream: InputStream, fileDest: File, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? {
        UtilKFileWrapper.createFile(fileDest)
        try {
            UtilKInputStream.read_write_use(inputStream, fileDest.file2bufferedOutputStream(isAppend), bufferSize, block)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
        return null
    }

    @JvmStatic
    @RequiresApi(CVersCode.V_29_10_Q)
    fun inputStream2file_use_ofFileUtils(inputStream: InputStream, strFilePathNameDest: String, isAppend: Boolean = false): File? =
        inputStream2file_use_ofFileUtils(inputStream, strFilePathNameDest.strFilePath2file().apply { createFile() }, isAppend)

    @JvmStatic
    @RequiresApi(CVersCode.V_29_10_Q)
    fun inputStream2file_use_ofFileUtils(inputStream: InputStream, fileDest: File, isAppend: Boolean = false): File? {
        UtilKFileWrapper.createFile(fileDest)
        /*//        val fileInputStream = file.file2fileInputStream()
        //        if (isInputStreamSame(inputStream, fileInputStream)) {//相似内容就直接返回地址
        //            UtilKLogWrapper.d(UtilKFile.TAG, "assetCopyFile: the two files is same")
        //            return file//"the two files is same, don't need overwrite"
        //        }*/
        try {
            UtilKInputStream.read_write_use_ofFileUtils(inputStream, fileDest.file2fileOutputStream(isAppend))
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    @JvmStatic
    fun inputStream2file_use_ofReadWriteBytes(inputStream: InputStream, strFilePathNameDest: String): File? =
        inputStream2file_use_ofReadWriteBytes(inputStream, strFilePathNameDest.strFilePath2file().apply { createFile() })

    @JvmStatic
    fun inputStream2file_use_ofReadWriteBytes(inputStream: InputStream, fileDest: File): File? {
        UtilKFileWrapper.createFile(fileDest)
        try {
            UtilKInputStream.read_write_use_ofReadWriteBytes(inputStream, fileDest)
            return fileDest
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
