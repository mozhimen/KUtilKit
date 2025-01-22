package com.mozhimen.kotlin.utilk.androidx.appcompat

import androidx.appcompat.app.AppCompatActivity

/**
 * @ClassName UtilKAppCompatActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/3 10:25
 * @Version 1.0
 */
object UtilKAppCompatActivity {
    @JvmStatic
    fun supportRequestWindowFeature(appCompatActivity: AppCompatActivity, featureId: Int){
        appCompatActivity.supportRequestWindowFeature(featureId)
    }
}