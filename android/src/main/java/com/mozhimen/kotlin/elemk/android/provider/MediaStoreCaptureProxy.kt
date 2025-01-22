package com.mozhimen.kotlin.elemk.android.provider

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.Uri
import androidx.annotation.RequiresPermission
import androidx.fragment.app.Fragment
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_QUERY_ALL_PACKAGES
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContextWrapper
import com.mozhimen.kotlin.utilk.android.content.UtilKIntentGet
import com.mozhimen.kotlin.utilk.android.content.isIntentAvailable
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
        var intent = UtilKIntentGet.getMediaStoreImageCapture()

        if (intent.isIntentAvailable(context)&&_currentPhotoUri!=null) {
            createCurrentPhotoUri()
            intent = UtilKIntentGet.getMediaStoreImageCaptureOutput(_currentPhotoUri!!)
            UtilKContextWrapper.grantUriPermission_before21(context,intent, _currentPhotoUri!!)
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