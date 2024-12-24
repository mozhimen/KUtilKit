package com.mozhimen.kotlin.utilk.android.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.Gravity
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.mozhimen.kotlin.elemk.android.view.annors.AGravity
import com.mozhimen.kotlin.elemk.android.view.cons.CGravity
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.utilk.android.text.UtilKInputFilter
import com.mozhimen.kotlin.utilk.kotlin.obj2str_trim
import com.mozhimen.kotlin.utilk.kotlin.whether
import androidx.annotation.IntRange
import androidx.core.graphics.drawable.toDrawable
import com.mozhimen.kotlin.utilk.android.content.UtilKAssetManager

/**
 * @ClassName UtilKViewText
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/6 0:27
 * @Version 1.0
 */

val TextView.value: String get() = UtilKTextViewWrapper.getValue(this)

fun TextView.getValueIfNotEmpty(invoke: IA_Listener<String>/*(value: String) -> Unit*/) {
    UtilKTextViewWrapper.getValueIfNotEmpty(this, invoke)
}

//////////////////////////////////////////////////////////////////////////////////////

fun TextView.applySingleLine() {
    UtilKTextViewWrapper.applySingleLine(this)
}

fun TextView.applyTypeface(@IntRange(from = 0, to = 3) style: Int = Typeface.NORMAL) {
    UtilKTextViewWrapper.applyTypeface(this, style)
}

fun TextView.applyTypeface_BOLD() {
    UtilKTextViewWrapper.applyTypeface_BOLD(this)
}

fun TextView.applyTypeface_NORMAL() {
    UtilKTextViewWrapper.applyTypeface_NORMAL(this)
}

fun TextView.applyTypeface_DEFAULT() {
    UtilKTextViewWrapper.applyTypeface_DEFAULT(this)
}

fun TextView.applyTypeface_DEFAULT_BOLD() {
    UtilKTextViewWrapper.applyTypeface_DEFAULT_BOLD(this)
}

fun TextView.applyTypeface_ofAsset(assetFontPathWithName: String) {
    UtilKTextViewWrapper.applyTypeface_ofAsset(this, assetFontPathWithName)
}

fun TextView.applyValueIfNotEmpty(str: String?) {
    UtilKTextViewWrapper.applyValueIfNotEmpty(this, str)
}

fun TextView.applyFilter_ofLength(inputLength: Int) {
    UtilKTextViewWrapper.applyFilter_ofLength(this, inputLength)
}

//////////////////////////////////////////////////////////////////////////////////////

fun TextView.applyCompoundDrawables(@DrawableRes intResDrawable: Int, @AGravity gravity: Int, boundsSize: Int = 0) {
    UtilKTextViewWrapper.applyCompoundDrawables(this, intResDrawable, gravity, boundsSize)
}

fun TextView.applyCompoundDrawables(@DrawableRes start: Int = 0, @DrawableRes top: Int = 0, @DrawableRes end: Int = 0, @DrawableRes bottom: Int = 0, boundsSize: Int = 0) {
    UtilKTextViewWrapper.applyCompoundDrawables(this, start, top, end, bottom, boundsSize)
}

fun TextView.applyCompoundDrawables(drawable: Drawable, @AGravity gravity: Int, boundsSize: Int = 0) {
    UtilKTextViewWrapper.applyCompoundDrawables(this, drawable, gravity, boundsSize)
}

fun TextView.applyCompoundDrawables(start: Drawable? = null, top: Drawable? = null, end: Drawable? = null, bottom: Drawable? = null, boundsSize: Int = 0) {
    UtilKTextViewWrapper.applyCompoundDrawables(this, start, top, end, bottom, boundsSize)
}

//////////////////////////////////////////////////////////////////////////////////////

object UtilKTextViewWrapper {
    @JvmStatic
    fun get(
        context: Context,
        singleLine: Boolean = false,
        ems: Int = 10,
        truncateAt: TextUtils.TruncateAt? = TextUtils.TruncateAt.END,
        gravity: Int? = Gravity.CENTER,
        intResColor: Int? = android.R.color.black,
        textSize: Float? = 16f,
    ): TextView {
        val textView = TextView(context)
        singleLine.whether { textView.setSingleLine() }//设置显示为1行
        if (ems > 0) textView.setEms(ems)//设置最多显示多少个字
        truncateAt?.let { textView.ellipsize = it }//设置省略号在尾部
        gravity?.let { textView.gravity = it }
        intResColor?.let { textView.setTextColor(ContextCompat.getColor(context, it)) }
        textSize?.let { textView.textSize = it }
        return textView
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getValue(textView: TextView): String =
        textView.text.obj2str_trim()

    @JvmStatic
    fun getValueIfNotEmpty(textView: TextView, invoke: IA_Listener<String>/*(value: String) -> Unit*/) {
        val value = getValue(textView)
        if (value.isNotEmpty()) invoke.invoke(value)
    }

    @JvmStatic
    fun getLineHeight(textView: TextView, lineCount: Int): Float {
        if (lineCount <= 1) return 0f
        val fm = textView.paint.fontMetricsInt
        return (fm.descent - fm.ascent) * lineCount * textView.lineSpacingMultiplier + textView.getLineSpacingExtra() * (lineCount - 1)
    }

    @JvmStatic
    @SuppressLint("SetTextI18n")
    fun applyValue_ofLog(textView: TextView, log: String) {
        textView.text = textView.text.toString() + log + "\n"
        //let text view to move to the last line.
        val offset = textView.lineCount * textView.lineHeight
        if (offset > textView.height) {
            textView.scrollTo(0, offset - textView.height)
        }
    }

    @JvmStatic
    fun applyValueIfNotEmpty(textView: TextView, str: String?): Boolean =
        if (!str.isNullOrEmpty()) {
            textView.text = str;true
        } else false

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, @DrawableRes left: Int = 0, @DrawableRes top: Int = 0, @DrawableRes right: Int = 0, @DrawableRes bottom: Int = 0, boundsSize: Int = 0) {
        if (boundsSize <= 0) {
            UtilKTextView.applyCompoundDrawablesWithIntrinsicBounds(textView, left, top, right, bottom)
        } else {
            val drawables = listOfNotNull(left, top, right, bottom).map { if (it != 0) it.toDrawable() else null }.onEach { it?.setBounds(0, 0, boundsSize, boundsSize) }
            UtilKTextView.applyCompoundDrawables(textView, drawables[0], drawables[1], drawables[2], drawables[3])
        }
    }

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, @DrawableRes intResDrawable: Int, @AGravity gravity: Int, boundsSize: Int = 0) {
        when (gravity) {
            CGravity.START, CGravity.LEFT -> applyCompoundDrawables(textView, left = intResDrawable, boundsSize = boundsSize)
            CGravity.TOP -> applyCompoundDrawables(textView, top = intResDrawable, boundsSize = boundsSize)
            CGravity.END, CGravity.RIGHT -> applyCompoundDrawables(textView, right = intResDrawable, boundsSize = boundsSize)
            else -> applyCompoundDrawables(textView, bottom = intResDrawable, boundsSize = boundsSize)
        }
    }

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, left: Drawable? = null, top: Drawable? = null, right: Drawable? = null, bottom: Drawable? = null, boundsSize: Int = 0) {
        if (boundsSize <= 0) {
            UtilKTextView.applyCompoundDrawablesWithIntrinsicBounds(textView, left, top, right, bottom)
        } else {
            listOfNotNull(left, top, right, bottom).forEach {
                it.setBounds(0, 0, boundsSize, boundsSize)
            }
            UtilKTextView.applyCompoundDrawables(textView, left, top, right, bottom)
        }
    }

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, drawable: Drawable, @AGravity gravity: Int, boundsSize: Int = 0) {
        when (gravity) {
            CGravity.START, CGravity.LEFT -> applyCompoundDrawables(textView, left = drawable, boundsSize = boundsSize)
            CGravity.TOP -> applyCompoundDrawables(textView, top = drawable, boundsSize = boundsSize)
            CGravity.END, CGravity.RIGHT -> applyCompoundDrawables(textView, right = drawable, boundsSize = boundsSize)
            else -> applyCompoundDrawables(textView, bottom = drawable, boundsSize = boundsSize)
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applySingleLine(textView: TextView) {
        textView.setSingleLine()
        textView.maxLines = 1
    }

    ////////////////////////////////////////////////////////////////////////////
    //typeface

    //设置字体的细或粗
    @JvmStatic
    fun applyTypeface(textView: TextView, @IntRange(from = 0, to = 3) style: Int = Typeface.NORMAL) {
        UtilKTextView.applyTypeface(textView, Typeface.defaultFromStyle(style))
    }

    @JvmStatic
    fun applyTypeface_NORMAL(textView: TextView) {
        applyTypeface(textView, Typeface.NORMAL)
    }

    @JvmStatic
    fun applyTypeface_BOLD(textView: TextView) {
        applyTypeface(textView, Typeface.BOLD)
    }

    @JvmStatic
    fun applyTypeface_ITALIC(textView: TextView) {
        applyTypeface(textView, Typeface.ITALIC)
    }

    @JvmStatic
    fun applyTypeface_BOLD_ITALIC(textView: TextView) {
        applyTypeface(textView, Typeface.BOLD_ITALIC)
    }

    @JvmStatic
    fun applyTypeface_DEFAULT(textView: TextView) {
        UtilKTextView.applyTypeface(textView, Typeface.DEFAULT)
    }

    @JvmStatic
    fun applyTypeface_DEFAULT_BOLD(textView: TextView) {
        UtilKTextView.applyTypeface(textView, Typeface.DEFAULT_BOLD)
    }

    /**
     * 设置字体
     * assetFontPathWithName "fonts/iconfont.ttf"
     */
    @JvmStatic
    fun applyTypeface_ofAsset(textView: TextView, assetFontPathWithName: String) {
        UtilKTextView.applyTypeface(textView, Typeface.createFromAsset(UtilKAssetManager.get_ofContext(textView.context), assetFontPathWithName))
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyFilter_ofLength(textView: TextView, inputLength: Int) {
        if (inputLength > 0) {
            UtilKTextView.applyFilters(textView, arrayOf(UtilKInputFilter.getLengthFilter(inputLength)))
        }
    }
}