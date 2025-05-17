package com.mozhimen.kotlin.elemk.android.text.impls

import android.text.Selection
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.method.Touch
import android.text.style.ClickableSpan
import android.view.MotionEvent
import android.widget.TextView

/**
 * @ClassName LinkMovementMethodLocal
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/5/14
 * @Version 1.0
 */
/**
 * Copied from http://stackoverflow.com/questions/8558732
 */
class LinkMovementMethodLocal : LinkMovementMethod() {
    companion object {
        var sInstance: LinkMovementMethodLocal? = null

        val instance: LinkMovementMethodLocal
            get() {
                if (sInstance == null)
                    sInstance = LinkMovementMethodLocal()
                return sInstance!!
            }
    }

    ///////////////////////////////////////////////////////////////////////////

    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {
        val action = event.action

        if (action == MotionEvent.ACTION_UP ||
            action == MotionEvent.ACTION_DOWN
        ) {
            var x = event.x.toInt()
            var y = event.y.toInt()

            x -= widget.totalPaddingLeft
            y -= widget.totalPaddingTop

            x += widget.scrollX
            y += widget.scrollY

            val layout = widget.layout
            val line = layout.getLineForVertical(y)
            val off = layout.getOffsetForHorizontal(line, x.toFloat())

            val link = buffer.getSpans(off, off, ClickableSpan::class.java)

            if (link.isNotEmpty()) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(widget)
                } else if (action == MotionEvent.ACTION_DOWN) {
                    Selection.setSelection(
                        buffer,
                        buffer.getSpanStart(link[0]),
                        buffer.getSpanEnd(link[0])
                    )
                }
                return true
            } else {
                Selection.removeSelection(buffer)
                Touch.onTouchEvent(widget, buffer, event)
                return false
            }
        }
        return Touch.onTouchEvent(widget, buffer, event)
    }
}
