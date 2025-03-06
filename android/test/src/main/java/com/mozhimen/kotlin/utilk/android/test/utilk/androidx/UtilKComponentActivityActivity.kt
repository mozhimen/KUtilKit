package com.mozhimen.kotlin.utilk.android.test.utilk.androidx

import android.view.View
import com.mozhimen.kotlin.elemk.android.media.cons.CMediaFormat
import com.mozhimen.kotlin.utilk.android.net.uri2file
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkComponentActivityBinding
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.androidx.activity.UtilKComponentActivity
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB

/**
 * @ClassName UtilKComponentActivityActivity
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/3/6
 * @Version 1.0
 */
class UtilKComponentActivityActivity : BaseActivityVDB<ActivityUtilkComponentActivityBinding>() {
    private val _registerForActivityResult_GetContent = UtilKComponentActivity.registerForActivityResult_GetContent(this) { uri ->
        UtilKLogWrapper.d(TAG, "_registerForActivityResult_GetContent: uri ${uri}")
        val file = uri?.uri2file()
        UtilKLogWrapper.d(TAG, "_registerForActivityResult_GetContent: uri ${file?.absolutePath} ${file?.length()}")
    }

    fun getContent(view: View) {
        _registerForActivityResult_GetContent.launch(CMediaFormat.MIMETYPE_ALL)
    }
}