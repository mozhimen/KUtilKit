package com.mozhimen.kotlin.elemk.android.text.impls

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Html
import android.util.Log
import android.widget.TextView
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.io.IOException

/**
 * @ClassName ImageGetterAssets
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/14
 * @Version 1.0
 */
/**
 * Assets Image Getter
 *
 *
 * Load image from assets folder
 *
 * @author [Daniel Passos](mailto:daniel@passos.me)
 */
class ImageGetterAssets : Html.ImageGetter, IUtilK {
    private val _context: Context

    ////////////////////////////////////////////////////////////////

    constructor(context: Context) {
        this._context = context
    }

    constructor(textView: TextView) {
        this._context = textView.context
    }

    ////////////////////////////////////////////////////////////////

    override fun getDrawable(source: String): Drawable? {
        try {
            val inputStream = _context.assets.open(source)
            val d = Drawable.createFromStream(inputStream, null)
            d?.setBounds(0, 0, d.intrinsicWidth, d.intrinsicHeight)
            return d
        } catch (e: IOException) {
            // prevent a crash if the resource still can't be found
            Log.e(TAG, "source could not be found: $source")
            return null
        }
    }
}
