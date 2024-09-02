package com.mozhimen.kotlin.elemk.android.content.cons

import android.content.Intent

/**
 * @ClassName CIntent
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
object CIntent {
    const val ACTION_BOOT_COMPLETED = Intent.ACTION_BOOT_COMPLETED
    const val ACTION_PACKAGE_REPLACED = Intent.ACTION_PACKAGE_REPLACED
    const val ACTION_PACKAGE_ADDED = Intent.ACTION_PACKAGE_ADDED
    const val ACTION_PACKAGE_REMOVED = Intent.ACTION_PACKAGE_REMOVED
    const val ACTION_SEND = Intent.ACTION_SEND
    const val ACTION_TIMEZONE_CHANGED = Intent.ACTION_TIMEZONE_CHANGED
    const val ACTION_TIME_TICK = Intent.ACTION_TIME_TICK
    const val ACTION_TIME_CHANGED = Intent.ACTION_TIME_CHANGED
    const val ACTION_PICK = Intent.ACTION_PICK
    const val ACTION_MAIN = Intent.ACTION_MAIN
    const val ACTION_VIEW = Intent.ACTION_VIEW
    const val ACTION_GET_CONTENT = Intent.ACTION_GET_CONTENT
    const val ACTION_OPEN_DOCUMENT_TREE = Intent.ACTION_OPEN_DOCUMENT_TREE

    //////////////////////////////////////////////////////////////////////////

    const val CATEGORY_LAUNCHER = Intent.CATEGORY_LAUNCHER

    //////////////////////////////////////////////////////////////////////////

    const val EXTRA_STREAM = Intent.EXTRA_STREAM
    const val EXTRA_TEXT = Intent.EXTRA_TEXT

    //////////////////////////////////////////////////////////////////////////

    const val FLAG_GRANT_WRITE_URI_PERMISSION = Intent.FLAG_GRANT_WRITE_URI_PERMISSION
    const val FLAG_GRANT_READ_URI_PERMISSION = Intent.FLAG_GRANT_READ_URI_PERMISSION
    const val FLAG_GRANT_PERSISTABLE_URI_PERMISSION = Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION
    const val FLAG_GRANT_PREFIX_URI_PERMISSION = Intent.FLAG_GRANT_PREFIX_URI_PERMISSION

    //////////////////////////////////////////////////////////////////////////

    const val FLAG_ACTIVITY_CLEAR_TOP = Intent.FLAG_ACTIVITY_CLEAR_TOP
    const val FLAG_ACTIVITY_NEW_TASK = Intent.FLAG_ACTIVITY_NEW_TASK
    const val FLAG_ACTIVITY_CLEAR_TASK = Intent.FLAG_ACTIVITY_CLEAR_TASK
}