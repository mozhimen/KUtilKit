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
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.text.UtilKInputFilter
import com.mozhimen.kotlin.utilk.kotlin.obj2str_trim
import com.mozhimen.kotlin.utilk.kotlin.whether
import androidx.annotation.IntRange
import androidx.core.graphics.drawable.toDrawable

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

fun TextView.applyTypeface_ofBold() {
    UtilKTextViewWrapper.applyTypeface_ofBold(this)
}

fun TextView.applyTypeface_ofNormal() {
    UtilKTextViewWrapper.applyTypeface_ofNormal(this)
}

fun TextView.applyTypeface_ofDefault() {
    UtilKTextViewWrapper.applyTypeface_ofDefault(this)
}

fun TextView.applyTypeface_ofDefaultBold() {
    UtilKTextViewWrapper.applyTypeface_ofDefaultBold(this)
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
        textSize: Float? = 16f
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
    fun applyCompoundDrawables(textView: TextView, @DrawableRes start: Int = 0, @DrawableRes top: Int = 0, @DrawableRes end: Int = 0, @DrawableRes bottom: Int = 0, boundsSize: Int = 0) {
        if (boundsSize <= 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom)
        } else {
            val drawables = listOfNotNull(start, top, end, bottom).map { if (it != 0) it.toDrawable() else null }.onEach { it?.setBounds(0, 0, boundsSize, boundsSize) }
            textView.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3])
        }
    }

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, @DrawableRes intResDrawable: Int, @AGravity gravity: Int, boundsSize: Int = 0) {
        when (gravity) {
            CGravity.START, CGravity.LEFT -> applyCompoundDrawables(textView, top = intResDrawable, boundsSize = boundsSize)
            CGravity.TOP -> applyCompoundDrawables(textView, top = intResDrawable, boundsSize = boundsSize)
            CGravity.END, CGravity.RIGHT -> applyCompoundDrawables(textView, end = intResDrawable, boundsSize = boundsSize)
            else -> applyCompoundDrawables(textView, bottom = intResDrawable, boundsSize = boundsSize)
        }
    }

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, start: Drawable? = null, top: Drawable? = null, end: Drawable? = null, bottom: Drawable? = null, boundsSize: Int = 0) {
        if (boundsSize <= 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom)
        } else {
            listOfNotNull(start, top, end, bottom).forEach {
                it.setBounds(0, 0, boundsSize, boundsSize)
            }
            textView.setCompoundDrawables(start, top, end, bottom)
        }
    }

    @JvmStatic
    fun applyCompoundDrawables(textView: TextView, drawable: Drawable, @AGravity gravity: Int, boundsSize: Int = 0) {
        when (gravity) {
            CGravity.START, CGravity.LEFT -> applyCompoundDrawables(textView, top = drawable, boundsSize = boundsSize)
            CGravity.TOP -> applyCompoundDrawables(textView, top = drawable, boundsSize = boundsSize)
            CGravity.END, CGravity.RIGHT -> applyCompoundDrawables(textView, end = drawable, boundsSize = boundsSize)
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
        UtilKTextView.setTypeface(textView, Typeface.defaultFromStyle(style))
    }

    @JvmStatic
    fun applyTypeface_ofBold(textView: TextView) {
        applyTypeface(textView, Typeface.BOLD)
    }

    @JvmStatic
    fun applyTypeface_ofNormal(textView: TextView) {
        applyTypeface(textView, Typeface.NORMAL)
    }

    @JvmStatic
    fun applyTypeface_ofDefault(textView: TextView) {
        UtilKTextView.setTypeface(textView, Typeface.DEFAULT)
    }

    @JvmStatic
    fun applyTypeface_ofDefaultBold(textView: TextView) {
        UtilKTextView.setTypeface(textView, Typeface.DEFAULT_BOLD)
    }

    /**
     * 设置字体
     * assetFontPathWithName "fonts/iconfont.ttf"
     */
    @JvmStatic
    fun applyTypeface_ofAsset(textView: TextView, assetFontPathWithName: String) {
        UtilKTextView.setTypeface(textView, Typeface.createFromAsset(UtilKContext.getAssets(textView.context), assetFontPathWithName))
    }

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyFilter_ofLength(textView: TextView, inputLength: Int) {
        if (inputLength > 0) {
            UtilKTextView.setFilters(textView, arrayOf(UtilKInputFilter.getLengthFilter(inputLength)))
        }
    }
}