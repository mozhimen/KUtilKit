package com.mozhimen.kotlin.elemk.android.text.impls

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Html
import android.util.Log
import com.mozhimen.kotlin.utilk.commons.IUtilK

/**
 * @ClassName ImageGetterRes
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/14
 * @Version 1.0
 */
/**
 * Copied from http://stackoverflow.com/a/22298833
 */
class ImageGetterRes(private val context: Context) : Html.ImageGetter,IUtilK {
    override fun getDrawable(source: String): Drawable? {
        var id = context.resources.getIdentifier(source, "drawable", context.packageName)
        if (id == 0) {
            // the drawable resource wasn't found in our package, maybe it is a stock android drawable?
            id = context.resources.getIdentifier(source, "drawable", "android")
        }
        if (id == 0) {
            // prevent a crash if the resource still can't be found
            Log.e(TAG, "source could not be found: $source")
            return null
        } else {
            val d = context.resources.getDrawable(id)
            d.setBounds(0, 0, d.intrinsicWidth, d.intrinsicHeight)
            return d
        }
    }
}