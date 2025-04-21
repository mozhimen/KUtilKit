package com.mozhimen.kotlin.utilk.androidx.appcompat

import android.app.Activity
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

/**
 * @ClassName UtilKActionBar
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/27 18:02
 * @Version 1.0
 */
fun AppCompatActivity.applyTitle(str: String) {
    UtilKActionBar.applyTitle(this, str)
}

object UtilKActionBar {

    @JvmStatic
    fun get_support(activity: AppCompatActivity): ActionBar? =
        activity.supportActionBar

    /////////////////////////////////////////////////////////////////

    /**
     * enableBackIfActionBarExists
     */
    @JvmStatic
    fun applyDisplayHomeAsUpEnabled(activity: AppCompatActivity) {
        get_support(activity)?.setDisplayHomeAsUpEnabled(true)
    }

    @JvmStatic
    fun applyTitle(activity: AppCompatActivity, str: String) {
        get_support(activity)?.title = str
    }

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hide(activity: Activity) {
        if (activity is AppCompatActivity)
            hide(activity)
    }

    @JvmStatic
    fun hide(activity: AppCompatActivity) {
        get_support(activity)?.hide()
    }
}