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
    fun get_ofSupport(activity: AppCompatActivity): ActionBar? =
        activity.supportActionBar

    /////////////////////////////////////////////////////////////////

    /**
     * enableBackIfActionBarExists
     */
    @JvmStatic
    fun applyDisplayHomeAsUpEnabled(activity: AppCompatActivity) {
        get_ofSupport(activity)?.setDisplayHomeAsUpEnabled(true)
    }

    @JvmStatic
    fun applyTitle(activity: AppCompatActivity, str: String) {
        get_ofSupport(activity)?.title = str
    }

    /////////////////////////////////////////////////////////////////

    @JvmStatic
    fun hide(activity: Activity) {
        if (activity is AppCompatActivity)
            hide(activity)
    }

    @JvmStatic
    fun hide(activity: AppCompatActivity) {
        get_ofSupport(activity)?.hide()
    }
}