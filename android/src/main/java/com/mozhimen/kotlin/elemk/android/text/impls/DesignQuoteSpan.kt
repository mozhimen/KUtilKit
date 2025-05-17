package com.mozhimen.kotlin.elemk.android.text.impls

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.Layout
import android.text.Spannable
import android.text.Spanned
import android.text.style.LeadingMarginSpan
import android.text.style.LineBackgroundSpan
import android.text.style.QuoteSpan

/**
 * @ClassName DesignQuoteSpan
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/14
 * @Version 1.0
 */
class DesignQuoteSpan constructor(private val backgroundColor: Int, private val stripColor: Int, stripWidth: Float, private val gap: Float) : LeadingMarginSpan, LineBackgroundSpan {
    companion object {
        fun replaceQuoteSpans(
            spanned: Spanned,
            blockQuoteBackgroundColor: Int = Color.WHITE,
            blockQuoteStripColor: Int = Color.BLACK,
            blockQuoteStripWidth: Float = 10f,
            blockQuoteGap: Float = 20f
        ) {
            val spannable = spanned as Spannable
            val quoteSpans = spannable.getSpans(0, spannable.length - 1, QuoteSpan::class.java)
            for (quoteSpan in quoteSpans) {
                val start = spannable.getSpanStart(quoteSpan)
                val end = spannable.getSpanEnd(quoteSpan)
                val flags = spannable.getSpanFlags(quoteSpan)
                spannable.removeSpan(quoteSpan)
                spannable.setSpan(
                    DesignQuoteSpan(blockQuoteBackgroundColor, blockQuoteStripColor, blockQuoteStripWidth, blockQuoteGap),
                    start,
                    end,
                    flags
                )
            }
        }
    }

    private val stripeWidth = stripWidth

    ///////////////////////////////////////////////////////////////////

    override fun getLeadingMargin(first: Boolean): Int {
        return (stripeWidth + gap).toInt()
    }

    override fun drawLeadingMargin(
        c: Canvas, p: Paint, x: Int, dir: Int, top: Int, baseline: Int,
        bottom: Int, text: CharSequence?, start: Int, end: Int, first: Boolean,
        layout: Layout?,
    ) {
        val style = p.style
        val paintColor = p.color
        p.style = Paint.Style.FILL
        p.color = stripColor
        c.drawRect(x.toFloat(), top.toFloat(), x + dir * stripeWidth, bottom.toFloat(), p)
        p.style = style
        p.color = paintColor
    }

    override fun drawBackground(
        canvas: Canvas, paint: Paint,
        left: Int, right: Int, top: Int, baseline: Int, bottom: Int,
        text: CharSequence, start: Int, end: Int, lineNumber: Int,
    ) {
        val paintColor = paint.color
        paint.color = backgroundColor
        canvas.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
        paint.color = paintColor
    }
}