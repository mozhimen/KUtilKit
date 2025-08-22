package com.mozhimen.kotlin.utilk.kotlin

import android.graphics.Bitmap
import com.mozhimen.kotlin.elemk.commons.IAB_Listener
import com.mozhimen.kotlin.utilk.android.content.UtilKAssetManager
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.java.io.inputStream2bitmapAny_use
import com.mozhimen.kotlin.utilk.java.io.inputStream2bytes_use
import com.mozhimen.kotlin.utilk.java.io.inputStream2file_use
import com.mozhimen.kotlin.utilk.java.io.inputStream2str_use_bytes
import com.mozhimen.kotlin.utilk.java.io.inputStream2str_use_bufferedReader
import java.io.File

/**
 * @ClassName UtilKAssetFormat
 * @Description android:requestLegacyExternalStorage="true" application 设置
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/18 23:47
 * @Version 1.0
 */
fun String.getStrAssetName(): String =
    UtilKStrAsset.getStrAssetName(this)

fun String.getStrAssetParentPath(): String =
    UtilKStrAsset.getStrAssetParentPath(this)

fun String.getStrFilePathName(strFilePathNameDest: String): String =
    UtilKStrAsset.getStrFilePathName(this, strFilePathNameDest)

///////////////////////////////////////////////////////////////////

fun String.isAssetExists(): Boolean =
    UtilKStrAsset.isAssetExists(this)

///////////////////////////////////////////////////////////////////

fun String.strAssetName2bytes_use(): ByteArray =
    UtilKStrAsset.strAssetName2bytes_use(this)

fun String.strAssetName2str_use_ofBufferedReader(): String? =
    UtilKStrAsset.strAssetName2str_use_ofBufferedReader(this)

fun String.strAssetName2str_use_ofBytes(): String? =
    UtilKStrAsset.strAssetName2str_use_ofBytes(this)

fun String.strAssetName2str_use_ofStream(): String? =
    UtilKStrAsset.strAssetName2str_use_ofStream(this)

fun String.strAssetName2file_use(fileDest: File, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
    UtilKStrAsset.strAssetName2file_use(this, fileDest, isAppend, bufferSize, block)

fun String.strAssetName2file_use(strFilePathNameDest: String, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
    UtilKStrAsset.strAssetName2file_use(this, strFilePathNameDest, isAppend, bufferSize, block)

fun String.strAssetName2bitmap_use(): Bitmap? =
    UtilKStrAsset.strAssetName2bitmap_use(this)

///////////////////////////////////////////////////////////////////

object UtilKStrAsset : BaseUtilK() {
    @JvmStatic
    fun getStrAssetName(strAssetName: String): String =
        if (strAssetName.containsSafe("/")) strAssetName.getSplitLastIndexToEnd("/")
        else ""

    @JvmStatic
    fun getStrAssetParentPath(strAssetName: String): String =
        if (strAssetName.containsSafe("/")) strAssetName.getSplitLastIndexToStart("/")
        else ""

    @JvmStatic
    fun getStrFilePathName(strAssetName: String, strFilePathNameDest: String): String =
        if (strFilePathNameDest.endsWith("/")) strFilePathNameDest + strAssetName
        else strFilePathNameDest

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isAssetExists(strAssetName: String): Boolean {
        val parentPath = getStrAssetParentPath(strAssetName)
        UtilKLogWrapper.d(TAG, "isAssetExists: parentPath $parentPath")
        val assets = UtilKAssetManager.list(_context, parentPath) ?: kotlin.run {
            UtilKLogWrapper.d(TAG, "isAssetExists: assets null")
            return false
        }
        for (index in assets.indices) {
            if ((parentPath + assets[index]) == strAssetName) {
                UtilKLogWrapper.d(TAG, "isAssetExists: true")
                return true
            }
        }
        UtilKLogWrapper.d(TAG, "isAssetExists: false")
        return false
    }

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun strAssetName2bytes_use(strAssetName: String): ByteArray =
        UtilKAssetManager.open(_context, strAssetName).inputStream2bytes_use()

    ///////////////////////////////////////////////////////////////////

    /**
     * 文件转String:分析json文件,从资产文件加载内容:license,获取txt文本文件内容等
     */
    @JvmStatic
    fun strAssetName2str_use_ofBufferedReader(strAssetName: String): String? =
        if (!isAssetExists(strAssetName)) null
        else UtilKAssetManager.open(_context, strAssetName).inputStream2str_use_bufferedReader()

    /**
     * 获取文本文件内容: txt 最快的方法
     */
    @JvmStatic
    fun strAssetName2str_use_ofBytes(strAssetName: String): String? =
        if (!isAssetExists(strAssetName)) null
        else strAssetName2bytes_use(strAssetName).bytes2str()

    /**
     * 通过路径加载Assets中的文本内容
     */
    @JvmStatic
    fun strAssetName2str_use_ofStream(strAssetName: String): String? =
        if (!isAssetExists(strAssetName)) null
        else UtilKAssetManager.open(_context, strAssetName).inputStream2str_use_bytes()

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun strAssetName2file_use(strAssetName: String, fileDest: File, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
        if (!isAssetExists(strAssetName)) {
            UtilKLogWrapper.d(TAG, "strAssetName2file: dont exist")
            null
        } else UtilKAssetManager.open(_context, strAssetName).inputStream2file_use(fileDest, isAppend, bufferSize, block)

    /**
     * 从资产拷贝到文件
     */
    @JvmStatic
    fun strAssetName2file_use(strAssetName: String, strFilePathNameDest: String, isAppend: Boolean = false, bufferSize: Int = 1024, block: IAB_Listener<Int, Float>? = null): File? =
        if (!isAssetExists(strAssetName)) {
            UtilKLogWrapper.d(TAG, "strAssetName2file: dont exist")
            null
        } else UtilKAssetManager.open(_context, strAssetName).inputStream2file_use(strAssetName.getStrFilePathName(strFilePathNameDest), isAppend, bufferSize, block)

    ///////////////////////////////////////////////////////////////////

    @JvmStatic
    fun strAssetName2bitmap_use(strAssetName: String): Bitmap? =
        if (!isAssetExists(strAssetName)) null
        else UtilKAssetManager.open(_context, strAssetName).inputStream2bitmapAny_use()
}