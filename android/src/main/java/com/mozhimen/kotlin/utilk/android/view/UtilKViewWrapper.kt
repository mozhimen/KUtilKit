package com.mozhimen.kotlin.utilk.android.view

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Rect
import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.annotation.Px
import com.mozhimen.kotlin.elemk.android.view.cons.CGravity
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.commons.I_AListener
import com.mozhimen.kotlin.elemk.commons.I_Listener
import com.mozhimen.kotlin.elemk.cons.CCons
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.android.util.UtilKLongLogWrapper
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.androidx.core.UtilKViewCompat
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.java.lang.UtilKField
import com.mozhimen.kotlin.utilk.kotlin.UtilKAny
import com.mozhimen.kotlin.utilk.kotlin.strColor2intColor
import com.mozhimen.kotlin.utilk.kotlinx.coroutines.throttleFirst
import com.mozhimen.kotlin.utilk.wrapper.UtilKScreen
import com.mozhimen.kotlin.utilk.wrapper.UtilKStatusBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * @ClassName UtilKViewFormat
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/7 14:13
 * @Version 1.0
 */
fun View.getOnClickFlow(): Flow<Unit> =
    UtilKViewWrapper.getOnClickFlow(this)

fun View.getOnLongClickFlow(): Flow<Unit> =
    UtilKViewWrapper.getOnLongClickFlow(this)

fun View.getOnTouchFlow(): Flow<MotionEvent> =
    UtilKViewWrapper.getOnTouchFlow(this)

fun View.getOnTouchActionFlow(): Flow<Int> =
    UtilKViewWrapper.getOnTouchActionFlow(this)

fun View.getOnTouchDirectionFlow(): Flow<Int> =
    UtilKViewWrapper.getOnTouchDirectionFlow(this)

//////////////////////////////////////////////////////////////////

fun View.getLocation(): Pair<Int, Int> =
    UtilKViewWrapper.getLocation(this)

//////////////////////////////////////////////////////////////////

fun View.isAttachedToWindow_ofCompat(): Boolean =
    UtilKViewWrapper.isAttachedToWindow_ofCompat(this)

//////////////////////////////////////////////////////////////////

fun View.applyDebounceClickListener(thresholdMillis: Long = 500, block: IA_Listener<View>) {
    UtilKViewWrapper.applyDebounceClickListener(this, block, thresholdMillis)
}

fun View.applyDebounceClickListener(scope: CoroutineScope, thresholdMillis: Long = 500, block: IA_Listener<View>) {
    UtilKViewWrapper.applyDebounceClickListener(this, scope, block, thresholdMillis)
}

fun View.applySuspendDebounceClickListener(scope: CoroutineScope, thresholdMillis: Long = 500, block: suspend CoroutineScope.(View) -> Unit) {
    UtilKViewWrapper.applySuspendDebounceClickListener(this, scope, block, thresholdMillis)
}

//////////////////////////////////////////////////////////////////

fun View.applyVisible() {
    UtilKViewWrapper.applyVisible(this)
}

fun View.applyInVisible() {
    UtilKViewWrapper.applyInVisible(this)
}

fun View.applyGone() {
    UtilKViewWrapper.applyGone(this)
}

//////////////////////////////////////////////////////////////////

fun View.applyVisibleIfElseGone(invoke: I_AListener<Boolean>) {
    UtilKViewWrapper.applyVisibleIfElseGone(this, invoke)
}

fun View.applyVisibleIfElseGone(boolean: Boolean) {
    UtilKViewWrapper.applyVisibleIfElseGone(this, boolean)
}

fun View.applyVisibleIfElseInVisible(invoke: I_AListener<Boolean>) {
    UtilKViewWrapper.applyVisibleIfElseInVisible(this, invoke)
}

fun View.applyVisibleIfElseInVisible(boolean: Boolean) {
    UtilKViewWrapper.applyVisibleIfElseInVisible(this, boolean)
}

//////////////////////////////////////////////////////////////////

fun View.applyVisibleIf(invoke: I_AListener<Boolean>) {
    UtilKViewWrapper.applyVisibleIf(this, invoke)
}

fun View.applyVisibleIf(boolean: Boolean) {
    UtilKViewWrapper.applyVisibleIf(this, boolean)
}

fun View.applyInVisibleIf(invoke: I_AListener<Boolean>) {
    UtilKViewWrapper.applyInVisibleIf(this, invoke)
}

fun View.applyInVisibleIf(boolean: Boolean) {
    UtilKViewWrapper.applyInVisibleIf(this, boolean)
}

fun View.applyGoneIf(invoke: I_AListener<Boolean>) {
    UtilKViewWrapper.applyGoneIf(this, invoke)
}

fun View.applyGoneIf(boolean: Boolean) {
    UtilKViewWrapper.applyGoneIf(this, boolean)
}

//////////////////////////////////////////////////////////////////

fun View.removeView_ofParent() {
    UtilKViewWrapper.removeView_ofParent(this)
}

fun View.addAndRemoveOnAttachStateChangeListener(invoke: I_Listener) {
    UtilKViewWrapper.addAndRemoveOnAttachStateChangeListener(this, invoke)
}

//////////////////////////////////////////////////////////////////

object UtilKViewWrapper : IUtilK {
    const val DEBOUNCE_LAST_CLICK_TIME = 1123461123

    @JvmStatic
    fun getOnClickFlow(view: View): Flow<Unit> =
        callbackFlow {
            view.setOnClickListener { this.trySend(Unit).isSuccess }
            awaitClose { view.setOnClickListener(null) }
        }

    @JvmStatic
    fun getOnLongClickFlow(view: View): Flow<Unit> =
        callbackFlow {
            view.setOnLongClickListener { this.trySend(Unit).isSuccess;true }
            awaitClose { view.setOnLongClickListener(null) }
        }

    @SuppressLint("ClickableViewAccessibility")
    @JvmStatic
    fun getOnTouchFlow(view: View): Flow<MotionEvent> =
        callbackFlow {
            view.setOnTouchListener { _, event -> trySend(event).isSuccess;true }
            awaitClose { view.setOnTouchListener(null) }
        }

    @SuppressLint("ClickableViewAccessibility")
    @JvmStatic
    fun getOnTouchActionFlow(view: View): Flow<Int> =
        callbackFlow {
            view.setOnTouchListener { _, event -> trySend(event.action).isSuccess;true }
            awaitClose { view.setOnTouchListener(null) }
        }

    @SuppressLint("ClickableViewAccessibility")
    @JvmStatic
    fun getOnTouchDirectionFlow(view: View, @Px extraTouchArea: Int = 0): Flow<Int> =
        callbackFlow {
            val rect = Rect()
            view.setOnTouchListener { _, event ->
                if (rect.width() == 0) {
                    view.getHitRect(rect)
                    if (extraTouchArea != 0) {
                        rect.apply {
                            left -= extraTouchArea
                            top -= extraTouchArea
                            right += extraTouchArea
                            bottom += extraTouchArea
                        }
                    }
                }
                if (event.action == MotionEvent.ACTION_UP) {
                    when {
                        event.x <= rect.left -> trySend(CGravity.LEFT).isSuccess
                        event.y <= rect.top -> trySend(CGravity.TOP).isSuccess
                        event.x >= rect.right -> trySend(CGravity.RIGHT).isSuccess
                        event.y >= rect.bottom -> trySend(CGravity.BOTTOM).isSuccess
                    }
                }
                false
            }
            awaitClose { view.setOnTouchListener(null) }
        }

    @JvmStatic
    fun getThrottleOnClickListener(block: IA_Listener<View>, thresholdMillis: Long = 500): View.OnClickListener {
        return View.OnClickListener { v ->
            if (isDebounceClickable(v, thresholdMillis)) {
                block.invoke(v)
            }
        }
    }

    //////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getLocation(view: View): Pair<Int, Int> {
        val intArray = UtilKView.getLocationOnScreen(view)
        return intArray[0] to intArray[1]
    }

    //寻找父View是否匹配列举的类型
    @JvmStatic
    fun getParent_ofClazz(view: View, vararg matches: Class<*>): View? {
        var tempView: View = view
        while (tempView.parent != null && tempView.parent is View) {
            try {
                tempView = tempView.parent as View
                if (UtilKAny.isObjTypeMatch(tempView, *matches)) return tempView
            } catch (e: Exception) {
                e.printStackTrace()
                e.message?.e(UtilKView.TAG)
            }
        }
        return null
    }

    //显示占比
    @JvmStatic
    fun getVisiblePercent(view: View): Int {
        if (view.isShown) {
            val rect = UtilKView.getGlobalVisibleRect(view)
            return if (rect.top > 0 && rect.left < UtilKScreen.getWidth_ofDisplayMetrics_ofSys())
                ((rect.width().toFloat() * rect.height().toFloat()) / (view.width.toFloat() * view.height.toFloat()) * 100).toInt()
            else 0
        }
        return 0
    }

    @JvmStatic
    fun getBitmap_ofViewBackground(view: View, fullScreen: Boolean): Bitmap? =
        getBitmap_ofViewBackground(view, 1.0f, fullScreen, 0, 0)

    @JvmStatic
    fun getBitmap_ofViewBackground(view: View, scaledRatio: Float, fullScreen: Boolean, cutoutX: Int, cutoutY: Int): Bitmap? {
        if (view.width <= 0 || view.height <= 0) {
            UtilKLongLogWrapper.e("getViewBitmap  >>  宽或者高为空")
            return null
        }
        val statusBarHeight = UtilKStatusBar.getHeight(false)
        var tempBitmap: Bitmap
        UtilKLongLogWrapper.i("getViewBitmap 模糊原始图像分辨率 [" + view.width + " x " + view.height + "]")
        tempBitmap = try {
            Bitmap.createBitmap((view.width * scaledRatio).toInt(), (view.height * scaledRatio).toInt(), Bitmap.Config.ARGB_8888)
        } catch (error: OutOfMemoryError) {
            System.gc()
            return null
        }
        val canvas = Canvas(tempBitmap)
        val matrix = Matrix()
        matrix.preScale(scaledRatio, scaledRatio)
        canvas.setMatrix(matrix)
        val bgDrawable = view.background
        if (bgDrawable == null)
            canvas.drawColor("#FAFAFA".strColor2intColor())
        else
            bgDrawable.draw(canvas)
        if (fullScreen) {
            if (statusBarHeight > 0 && UtilKBuildVersion.isAfterV_21_5_L() && view.context is Activity) {
                val statusBarColor = (view.context as Activity).window.statusBarColor
                val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                paint.color = statusBarColor
                val rect = Rect(0, 0, view.width, statusBarHeight)
                canvas.drawRect(rect, paint)
            }
        }
        view.draw(canvas)
        UtilKLongLogWrapper.i("getViewBitmap 模糊缩放图像分辨率 [" + tempBitmap.width + " x " + tempBitmap.height + "]")
        if (cutoutX > 0 || cutoutY > 0) {
            try {
                val cutLeft = (cutoutX * scaledRatio).toInt()
                val cutTop = (cutoutY * scaledRatio).toInt()
                val cutWidth = tempBitmap.width - cutLeft
                val cutHeight = tempBitmap.height - cutTop
                tempBitmap = Bitmap.createBitmap(tempBitmap, cutLeft, cutTop, cutWidth, cutHeight, null, false)
            } catch (e: Exception) {
                System.gc()
            }
        }
        return tempBitmap
    }

//////////////////////////////////////////////////////////////////

    //寻找父View是否匹配列举的类型
    @JvmStatic
    fun isParentMatchClazz(view: View, vararg matches: Class<*>): Boolean =
        getParent_ofClazz(view, *matches) != null

    @JvmStatic
    fun <V : View> isDebounceClickable(view: V, thresholdMillis: Long = 500): Boolean {
        var isClickable = false
        val currentClickTime = SystemClock.uptimeMillis()
        val lastClickTime = view.getLongTag(DEBOUNCE_LAST_CLICK_TIME, 0)
        if (kotlin.math.abs(currentClickTime - lastClickTime) >= thresholdMillis) {
            view.setTag(DEBOUNCE_LAST_CLICK_TIME, currentClickTime).also { isClickable = true }
        }
        return isClickable
    }

    @JvmStatic
    fun isAttachedToWindow_ofCompat(view: View): Boolean =
        UtilKViewCompat.isAttachedToWindow(view)

//////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyDebounceClickListener(view: View, scope: CoroutineScope, block: IA_Listener<View>, thresholdMillis: Long = 500) {
        getOnClickFlow(view).throttleFirst(thresholdMillis).onEach { block.invoke(view) }.launchIn(scope)
    }

    @JvmStatic
    fun applySuspendDebounceClickListener(view: View, scope: CoroutineScope, block: suspend CoroutineScope.(View) -> Unit, thresholdMillis: Long = 500) {
        getOnClickFlow(view).throttleFirst(thresholdMillis).onEach { scope.block(view) }.launchIn(scope)
    }

//////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyDebounceClickListener(view: View, block: IA_Listener<View>, thresholdMillis: Long = 500) {
        view.setOnClickListener(getThrottleOnClickListener(block, thresholdMillis))
    }

//////////////////////////////////////////////////////////////////

    // 根据View的高度和宽高比, 设置高度
    @JvmStatic
    fun applyViewRatio(view: View, ratio: Float) {
        view.addAndRemoveOnGlobalLayoutListener {
            if (view.height > 0) {
                view.layoutParams.width = (view.height * ratio).toInt()
                view.postInvalidate()
            }
        }
    }

    @JvmStatic
    fun applyVisible(view: View) {
        if (!UtilKView.isVisible(view))
            view.visibility = View.VISIBLE
    }

    @JvmStatic
    fun applyInVisible(view: View) {
        if (!UtilKView.isInvisible(view))
            view.visibility = View.INVISIBLE
    }

    @JvmStatic
    fun applyGone(view: View) {
        if (!UtilKView.isGone(view))
            view.visibility = View.GONE
    }

//////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyVisibleIfElseGone(view: View, invoke: I_AListener<Boolean>) {
        if (invoke.invoke()) applyVisible(view)
        else applyGone(view)
    }

    @JvmStatic
    fun applyVisibleIfElseGone(view: View, boolean: Boolean) {
        if (boolean) applyVisible(view)
        else applyGone(view)
    }

    @JvmStatic
    fun applyVisibleIfElseInVisible(view: View, invoke: I_AListener<Boolean>) {
        if (invoke.invoke()) applyVisible(view)
        else applyInVisible(view)
    }

    @JvmStatic
    fun applyVisibleIfElseInVisible(view: View, boolean: Boolean) {
        if (boolean) applyVisible(view)
        else applyInVisible(view)
    }

//////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyVisibleIf(view: View, invoke: I_AListener<Boolean>) {
        if (invoke.invoke()) applyVisible(view)
    }

    @JvmStatic
    fun applyVisibleIf(view: View, boolean: Boolean) {
        if (boolean) applyVisible(view)
    }

    @JvmStatic
    fun applyInVisibleIf(view: View, invoke: I_AListener<Boolean>) {
        if (invoke.invoke()) applyInVisible(view)
    }

    @JvmStatic
    fun applyInVisibleIf(view: View, boolean: Boolean) {
        if (boolean) applyInVisible(view)
    }

    @JvmStatic
    fun applyGoneIf(view: View, invoke: I_AListener<Boolean>) {
        if (invoke.invoke()) applyGone(view)
    }

    @JvmStatic
    fun applyGoneIf(view: View, boolean: Boolean) {
        if (boolean) applyGone(view)
    }

//////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addAndRemoveOnAttachStateChangeListener(view: View, block: I_Listener) {
        if (view.isAttachedToWindow_ofCompat()) {
            block.invoke()
            return
        }
        view.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                view.removeOnAttachStateChangeListener(this)
                block.invoke()
            }

            override fun onViewDetachedFromWindow(v: View) {
                view.removeOnAttachStateChangeListener(this)
            }
        })
    }

    //逐层在父View中查找View
    @JvmStatic
    fun findViewById_ofParent(view: View, viewId: Int): View? {
        var tempView: View = view
        while (tempView.parent is View) {
            //逐层在父View中查找，是为了查找离自己最近的目标对象，因为ID可能重复
            tempView = tempView.parent as View
            val targetView = tempView.findViewById<View>(viewId)
            if (targetView != null)
                return targetView
        }
        return null
    }

    //逐层在父View中查找View
    @JvmStatic
    fun findViewByView_ofParent(destView: View, sourceView: View): View? {
        var tempView: View = sourceView
        while (tempView.parent is View) {
            //需要从content一直遍历往前找到decorView下的第一个child，那个为准
            tempView = tempView.parent as View
            if (tempView == destView)
                return tempView
        }
        return null
    }

    //从父布局删除View
    @JvmStatic
    fun removeView_ofParent(view: View) {
        val viewParent: ViewParent? = view.parent
        if (viewParent != null && viewParent is ViewGroup) {
            viewParent.removeViewSafe(view)
        }
    }

//////////////////////////////////////////////////////////////////

    @JvmStatic
    @Throws(Exception::class)
    fun fixLeak_ofDragChild(vararg views: View) {
        var tempView: View
        views.forEach { v ->
            tempView = v
            while (tempView.parent != null && tempView.parent is ViewGroup) {
                tempView = tempView.parent as ViewGroup
                fixLeak_ofDragChild(tempView)
            }
        }
    }

    @JvmStatic
    @Throws(Exception::class)
    fun fixLeak_ofDragChild(view: View) {
        try {
            val fieldMCurrentDragChild = UtilKField.get(view, "mCurrentDragChild")
            if (!fieldMCurrentDragChild.isAccessible)
                fieldMCurrentDragChild.isAccessible = true
            val childView = fieldMCurrentDragChild.get(view)
            if (childView != null) {
                fieldMCurrentDragChild.set(childView, null)
                "fixLeak: set viewGroup ${childView.javaClass.simpleName} mCurrentDragChild null".d(TAG)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            e.message?.e(TAG)
        }
    }
}