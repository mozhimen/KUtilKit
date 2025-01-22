package com.mozhimen.kotlin.utilk.android.animation

import android.animation.ObjectAnimator
import android.view.View
import androidx.annotation.FloatRange
import androidx.core.animation.addListener
import com.mozhimen.kotlin.elemk.android.view.cons.CView
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.utilk.android.view.applyGone
import com.mozhimen.kotlin.utilk.android.view.applyVisible

/**
 * @ClassName UtilKObjectAnimatorWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/18
 * @Version 1.0
 */
fun View.applyAnimateVisibleIfElseGone(
    boolean: Boolean,
    durationMillis: Long,
    onStart: I_Listener? = null,
    onEnd: I_Listener? = null,
) {
    UtilKObjectAnimatorWrapper.applyAnimateVisibleIfElseGone(this, boolean, durationMillis, onStart, onEnd)
}

fun View.applyAnimateAlphaShow(
    durationMillis: Long,
    onStart: I_Listener? = null,
    onEnd: I_Listener? = null,
) {
    UtilKObjectAnimatorWrapper.applyAnimateAlphaShow(this, durationMillis, onStart, onEnd)
}

fun View.applyAnimateAlphaHide(
    durationMillis: Long,
    onStart: I_Listener? = null,
    onEnd: I_Listener? = null,
) {
    UtilKObjectAnimatorWrapper.applyAnimateAlphaHide(this, durationMillis, onStart, onEnd)
}

fun View.applyAnimateAlpha(
    @FloatRange(from = 0.0, to = 1.0) from: Float,
    @FloatRange(from = 0.0, to = 1.0) to: Float,
    durationMillis: Long,
    onStart: I_Listener? = null,
    onEnd: I_Listener? = null,
) {
    UtilKObjectAnimatorWrapper.applyAnimateAlpha(this, from, to, durationMillis, onStart, onEnd)
}

fun View.applyAnimateTranslationYToTopHide(
    durationMillis: Long,
    toY: Float = -this.height.toFloat(),
    onStart: I_Listener? = null,
    onEnd: I_Listener? = null,
) {
    UtilKObjectAnimatorWrapper.applyAnimateTranslationYToTopHide(this, durationMillis, toY, onStart, onEnd)
}

fun View.applyAnimateTranslationY(
    from: Float,
    to: Float,
    durationMillis: Long,
    onStart: I_Listener? = null,
    onEnd: I_Listener? = null,
) {
    UtilKObjectAnimatorWrapper.applyAnimateTranslationY(this, from, to, durationMillis, onStart, onEnd)
}

//////////////////////////////////////////////////////////////////

object UtilKObjectAnimatorWrapper {
    @JvmStatic
    fun applyAnimateVisibleIfElseGone(
        view: View,
        boolean: Boolean,
        durationMillis: Long,
        onStart: I_Listener? = null,
        onEnd: I_Listener? = null,
    ) {
        val alphaFrom = if (boolean) 0f else 1.0f
        val alphaTo = if (boolean) 1.0f else 0.0f
        applyAnimateAlpha(view, alphaFrom, alphaTo, durationMillis,
            onStart = {
                if (boolean)
                    view.applyVisible()
                onStart?.invoke()
            },
            onEnd = {
                if (!boolean)
                    view.applyGone()
                onEnd?.invoke()
            }).apply {
        }
    }

    @JvmStatic
    fun applyAnimateAlphaShow(
        view: View,
        durationMillis: Long,
        onStart: I_Listener? = null,
        onEnd: I_Listener? = null,
    ) {
        applyAnimateAlpha(view, 0f, 1f, durationMillis, onStart, onEnd)
    }

    @JvmStatic
    fun applyAnimateAlphaHide(
        view: View,
        durationMillis: Long,
        onStart: I_Listener? = null,
        onEnd: I_Listener? = null,
    ) {
        applyAnimateAlpha(view, 1f, 0f, durationMillis, onStart, onEnd)
    }

    @JvmStatic
    fun applyAnimateAlpha(
        view: View,
        @FloatRange(from = 0.0, to = 1.0) from: Float,
        @FloatRange(from = 0.0, to = 1.0) to: Float,
        durationMillis: Long,
        onStart: I_Listener? = null,
        onEnd: I_Listener? = null,
    ) {
        ObjectAnimator.ofFloat(view, CView.Property.ALPHA, from, to).apply {
            duration = durationMillis
            setAutoCancel(true)
            addListener(
                onStart = {
                    onStart?.invoke()
                },
                onEnd = {
                    onEnd?.invoke()
                }
            )
            start()
        }
    }

    @JvmStatic
    fun applyAnimateTranslationYToTopHide(
        view: View,
        durationMillis: Long,
        toY: Float = -view.height.toFloat(),
        onStart: I_Listener? = null,
        onEnd: I_Listener? = null,
    ) {
        applyAnimateTranslationY(view, 0f, toY, durationMillis, onStart, onEnd)
    }

    @JvmStatic
    fun applyAnimateTranslationY(
        view: View,
        from: Float,
        to: Float,
        durationMillis: Long,
        onStart: I_Listener? = null,
        onEnd: I_Listener? = null,
    ) {
        ObjectAnimator.ofFloat(view, CView.Property.TRANSLATION_Y, from, to).apply {
            duration = durationMillis
            setAutoCancel(true)
            addListener(
                onStart = {
                    onStart?.invoke()
                },
                onEnd = {
                    onEnd?.invoke()
                }
            )
            start()
        }
    }
}