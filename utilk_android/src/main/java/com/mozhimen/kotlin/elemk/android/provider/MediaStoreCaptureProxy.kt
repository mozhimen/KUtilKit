package com.mozhimen.kotlin.elemk.android.provider

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment
import com.mozhimen.kotlin.elemk.android.content.cons.CPackageManager
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.elemk.android.provider.cons.CMediaStore
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKIntentWrapper
import com.mozhimen.kotlin.utilk.android.content.UtilKPackageManager
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.java.io.file2uri_ofImage
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrFile
import com.mozhimen.kotlin.utilk.kotlin.UtilKStrPath
import java.io.File
import java.lang.ref.WeakReference
import java.util.Locale

class MediaStoreCaptureProxy {

    private var _contextRef: WeakReference<Activity>
    private var _fragmentRef: WeakReference<Fragment>?
    private var _captureStrategy: CaptureStrategy? = null
    private var _currentPhotoUri: Uri? = null
    private var _currentPhotoStrPath: String? = null

    //////////////////////////////////////////////////////////

    constructor(activity: Activity) : this(activity, null)

    constructor(activity: Activity, fragment: Fragment?) {
        _contextRef = WeakReference(activity)
        _fragmentRef = if (fragment == null) null else WeakReference(fragment)
    }

    //////////////////////////////////////////////////////////

    data class CaptureStrategy(var isPublic: Boolean, var authority: String, var directory: String = "")

    //////////////////////////////////////////////////////////

    fun setCaptureStrategy(strategy: CaptureStrategy) {
        _captureStrategy = strategy
    }

    @OPermission_QUERY_ALL_PACKAGES
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    @SuppressLint("QueryPermissionsNeeded")
    fun dispatchCaptureIntent(context: Context, requestCode: Int) {
        val intent = UtilKIntentWrapper.getMediaStoreImageCapture()

        if (intent.resolveActivity(context.packageManager) != null) {
            // 创建uri
            createCurrentPhotoUri()

            intent.apply {
                putExtra(CMediaStore.EXTRA_OUTPUT, _currentPhotoUri)
                addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            }
            if (UtilKBuildVersion.isBeforeVersion(CVersCode.V_21_5_L)) {
                val resInfoList = UtilKPackageManager.queryIntentActivities(context,intent, CPackageManager.MATCH_DEFAULT_ONLY)
                for (resolveInfo in resInfoList) {
                    val strPackageName = resolveInfo.activityInfo.packageName
                    _currentPhotoUri?.let {
                        UtilKContext.grantUriPermission(context, strPackageName, it, Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    }
                }
            }

            if (_fragmentRef != null) {
                _fragmentRef?.get()?.startActivityForResult(intent, requestCode)
            } else {
                _contextRef.get()?.startActivityForResult(intent, requestCode)
            }

        }
    }

    fun getCurrentPhotoUri(): Uri? =
        _currentPhotoUri

    fun getCurrentPhotoStrPath(): String? =
        _currentPhotoStrPath

    //////////////////////////////////////////////////////////

    private fun createCurrentPhotoUri() {
        val currentPhotoFile = File(UtilKStrPath.Absolute.External.getEnvStoragePublicPictures(), String.format("JPEG_%s.jpg", UtilKStrFile.getStrFileName_ofNow(Locale.getDefault())))
        _currentPhotoUri = currentPhotoFile.file2uri_ofImage()?.apply {
            _currentPhotoStrPath = currentPhotoFile.absolutePath
        }
    }
}