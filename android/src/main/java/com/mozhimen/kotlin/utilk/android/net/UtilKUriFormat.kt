package com.mozhimen.kotlin.utilk.android.net

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.DocumentsContract
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.content.cons.CContentResolver
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.provider.cons.CMediaStore
import com.mozhimen.kotlin.utilk.android.content.UtilKContentResolver
import com.mozhimen.kotlin.utilk.android.content.UtilKContentResolverWrapper
import com.mozhimen.kotlin.utilk.android.content.withAppendedId
import com.mozhimen.kotlin.utilk.android.graphics.UtilKBitmapFactory
import com.mozhimen.kotlin.utilk.android.graphics.UtilKImageDecoder
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.provider.UtilKDocumentsContract
import com.mozhimen.kotlin.utilk.android.provider.UtilKMediaStore
import com.mozhimen.kotlin.utilk.android.content.getMediaColumns
import com.mozhimen.kotlin.utilk.wrapper.UtilKScreen
import com.mozhimen.kotlin.utilk.android.webkit.UtilKMimeTypeMap
import com.mozhimen.kotlin.utilk.bases.BaseUtilK
import com.mozhimen.kotlin.utilk.java.io.inputStream2bitmapAny_use
import com.mozhimen.kotlin.utilk.java.io.inputStream2file_use_fileUtils
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrPath
import com.mozhimen.kotlin.utilk.kotlin.getStrFolderPath
import com.mozhimen.kotlin.utilk.kotlin.isFileExist
import com.mozhimen.kotlin.utilk.kotlin.strUri2uri
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKRegexGet
import com.mozhimen.kotlin.utilk.kotlin.text.matches_digits2
import java.io.File
import java.io.InputStream
import kotlin.math.ceil

/**
 * @ClassName UtilKUriFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 0:23
 * @Version 1.0
 */
fun Uri.uri2strFilePathName(): String? =
    UtilKUriFormat.uri2strFilePathName(this)

fun Uri.uri2file(): File? =
    UtilKUriFormat.uri2file(this)

//////////////////////////////////////////////////////////////////////////////

fun Uri.uri2bitmap(): Bitmap =
    UtilKUriFormat.uri2bitmap(this)

fun Uri.uri2bitmap_ofStream(): Bitmap? =
    UtilKUriFormat.uri2bitmap_ofStream(this)

//////////////////////////////////////////////////////////////////////////////

object UtilKUriFormat : BaseUtilK() {
    @JvmStatic
    fun uri2file(uri: Uri): File? =
        this.uri2strFilePathName(uri)?.let { File(it) }

    @JvmStatic
    fun uri2strFilePathName(uri: Uri): String? =
        if (uri.scheme == CContentResolver.SCHEME_FILE) {
            uri.path
        } else if (UtilKBuildVersion.isAfterV_29_10_Q()) {
            uri2strFilePathName_after29(uri)
        } else if (UtilKBuildVersion.isAfterV_24_7_N()) {
            uri2strFilePathName_after24(uri)
        } else if (UtilKBuildVersion.isAfterV_19_44_K() && UtilKDocumentsContract.isDocumentUri(_context, uri)) {
            uri2strFilePathName_after19(uri)
        } else if (uri.scheme == CContentResolver.SCHEME_CONTENT) {
            uri.getMediaColumns()
        } else null

    //android Q 的写法 沙盒
    @RequiresApi(CVersCode.V_29_10_Q)
    fun uri2strFilePathName_after29(uri: Uri): String? =
        when (uri.scheme) {
            CContentResolver.SCHEME_FILE -> uri.path
            CContentResolver.SCHEME_CONTENT -> {
                //把文件保存到沙盒
                val strFileName = UtilKContentResolverWrapper.getOpenableColumns(uri) ?:
                "${UtilKStrFile.getStrFileName_ofNow()}.${UtilKMimeTypeMap.getExtensionFromMimeType(_context, uri)}"
                val strFilePathName = "${UtilKStrPath.Absolute.Internal.getCache().getStrFolderPath()}uri/$strFileName"
                UtilKContentResolver.openInputStream(_context, uri)?.inputStream2file_use_fileUtils(strFilePathName)?.absolutePath
            }

            else -> null
        }

    @JvmStatic
    @RequiresApi(CVersCode.V_24_7_N)
    fun uri2strFilePathName_after24(uri: Uri): String? {
        if (uri.scheme == CContentResolver.SCHEME_FILE)
            return uri.path
        val strFilePath = uri.path
        if (strFilePath != null) {
            val externals = arrayOf("/external", "/external_path")
            externals.forEach {
                if (strFilePath.startsWith("$it/")) {
                    val strFilePathName = UtilKStrPath.Absolute.External.getEnvStorage() + strFilePath.replace(it, "")
                    if (strFilePathName.isFileExist())
                        return strFilePathName
                }
            }
        }
        return uri.getMediaColumns()
    }

    @JvmStatic
    fun uri2strFilePathName_after19(uri: Uri): String? {
        if (uri.scheme == CContentResolver.SCHEME_FILE)
            return uri.path
        if (UtilKBuildVersion.isAfterV_19_44_K() && DocumentsContract.isDocumentUri(_context, uri)) {
            val documentId = UtilKDocumentsContract.getDocumentId(uri)
            val split = documentId.split(UtilKRegexGet.get_colon()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val type = split[0]
            val path = split[1]

            when {
                uri.isAuthorityDownloadsDocument() -> {
                    if (documentId.matches_digits2())
                        return "content://downloads/public_downloads".strUri2uri().withAppendedId(documentId.toLong()).getMediaColumns()
                }

                uri.isAuthorityExternalStorageDocument() -> {
                    if (type.equals(CMediaStore.Type.PRIMARY, true))
                        return "${UtilKStrPath.Absolute.External.getEnvStorage()}/$path"
                }

                uri.isAuthorityMediaDocument() -> {
                    if (type.equals(CMediaStore.Type.PRIMARY, true))
                        return "${UtilKStrPath.Absolute.External.getEnvStorage()}/$path"
                    else if (type.equals(CMediaStore.Type.RAW, true))
                        return path
                    val externalContentUri = when {
                        type.equals(CMediaStore.Type.VIDEO, true) -> CMediaStore.Video.Media.EXTERNAL_CONTENT_URI
                        type.equals(CMediaStore.Type.AUDIO, true) -> CMediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                        type.equals(CMediaStore.Type.IMAGE, true) -> CMediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        else -> null
                    }
                    if (externalContentUri != null)
                        return externalContentUri.getMediaColumns("${CMediaStore.MediaColumns._ID}=?", arrayOf(path))
                }
            }

            //沙盒
//            if (UtilKBuildVersion.isAfterV_29_10_Q()){
//                return UtilKContentResolver.openInputStream(_context, uri)?.inputStream2file("$strFilePathNameDest.${UtilKMimeTypeMap.getExtensionFromMimeType(_context, uri)}")?.absolutePath
//            }
        }
        return uri.getMediaColumns()
    }

    //////////////////////////////////////////////////////////////////////////////

    /**
     * 从相册获得图片
     */
    @JvmStatic
    fun uri2bitmap(uri: Uri): Bitmap =
        if (UtilKBuildVersion.isAfterV_28_9_P())
            uri2bitmap_ofDecoder(uri)
        else
            uri2bitmap_ofMedia(uri)

    @JvmStatic
    fun uri2bitmap_ofDescriptor(uri: Uri, opts: BitmapFactory.Options? = null): Bitmap? =
        try {
            UtilKContentResolver.openFileDescriptor(_context, uri, "r")?.use {// mode："r" 表示只读 "w"表示只写
                UtilKBitmapFactory.decodeFileDescriptor(it.fileDescriptor, null, opts = opts)
            }
        } catch (e: Exception) {
            null
        }

    @JvmStatic
    @RequiresApi(CVersCode.V_28_9_P)
    fun uri2bitmap_ofDecoder(uri: Uri): Bitmap =
        UtilKImageDecoder.decodeBitmap(_context, uri)

    @JvmStatic
    fun uri2bitmap_ofMedia(uri: Uri): Bitmap =
        UtilKMediaStore.getImagesMediaBitmap(_context, uri)

    @JvmStatic
    fun uri2bitmap_ofStream(uri: Uri): Bitmap? {
        var contentSizeInputStream: InputStream? = null
        var realInputStream: InputStream? = null
        try {
            //根据uri获取图片的流
            contentSizeInputStream = UtilKContentResolver.openInputStream(_context, uri)
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true            //options的in系列的设置了，injustDecodeBound只解析图片的大小，而不加载到内存中去
            //1.如果通过options.outHeight获取图片的宽高，就必须通过decodeStream解析同options赋值
            //否则options.outHeight获取不到宽高
            contentSizeInputStream?.inputStream2bitmapAny_use(null, options)
            //2.通过 btm.getHeight()获取图片的宽高就不需要1的解析，我这里采取第一张方式
            //Bitmap btm = BitmapFactory.decodeStream(inputStream)
            //获取图片的宽高
            val outHeight = options.outHeight.toDouble()
            val outWidth = options.outWidth.toDouble()
            //heightPixels就是要压缩后的图片高度，宽度也一样
            val a = ceil((outHeight / UtilKScreen.getHeight_ofDisplayMetrics_ofSys().toDouble())).toInt()
            val b = ceil((outWidth / UtilKScreen.getWidth_ofDisplayMetrics_ofSys().toDouble())).toInt()
            //比例计算,一般是图片比较大的情况下进行压缩
            val max = a.coerceAtLeast(b)
            if (max > 1)
                options.inSampleSize = max
            //解析到内存中去
            options.inJustDecodeBounds = false
            //根据uri重新获取流，inputStream在解析中发生改变了
            realInputStream = UtilKContentResolver.openInputStream(_context, uri)
            return realInputStream?.inputStream2bitmapAny_use(null, options)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            contentSizeInputStream?.close()
            realInputStream?.close()
        }
    }
}