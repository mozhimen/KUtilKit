package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import com.mozhimen.bindk.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.util.dp2px
import com.mozhimen.kotlin.utilk.androidx.core.UtilKRoundedBitmapDrawable
import com.mozhimen.utilk.android.test.R
import com.mozhimen.utilk.android.test.databinding.ActivityUtilkGraphicsBinding

/**
 * @ClassName UtilKGraphicsActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/2/1
 * @Version 1.0
 */
class UtilKGraphicsActivity : BaseActivityVDB<ActivityUtilkGraphicsBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        vdb.utilkGraphicsImg.setImageDrawable(UtilKRoundedBitmapDrawable.get(this, R.drawable.utilk_img, 16f.dp2px()))
    }
}