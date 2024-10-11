package com.mozhimen.kotlin.utilk.android.view

import android.nfc.Tag
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.view.contains
import androidx.recyclerview.widget.RecyclerView
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.androidx.recyclerview.isScroll2top
import com.mozhimen.kotlin.utilk.commons.IUtilK
import java.util.ArrayDeque
import java.util.Deque


/**
 * @ClassName UtilKViewGroupWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/25
 * @Version 1.0
 */
fun ViewGroup.addViewSafe_ofMatchParent(view: View) {
    UtilKViewGroupWrapper.addViewSafe_ofMatchParent(this, view)
}

fun ViewGroup.addViewSafe(view: View, width: Int, height: Int) {
    UtilKViewGroupWrapper.addViewSafe(this, view, width, height)
}

fun ViewGroup.addViewSafe(view: View) {
    UtilKViewGroupWrapper.addViewSafe(this, view)
}

fun ViewGroup.removeViewSafe(view: View) {
    UtilKViewGroupWrapper.removeViewSafe(this, view)
}

//////////////////////////////////////////////////////////////////////////////////////

object UtilKViewGroupWrapper : IUtilK {
    //查找可以滚动的child
    @JvmStatic
    fun getChildView_ofScrollable(viewGroup: ViewGroup): View {
        var child = viewGroup.getChildAt(1)
        if (child is RecyclerView || child is AdapterView<*>)
            return child
        if (child is ViewGroup) { //往下多找一层
            val tempChild = child.getChildAt(0)
            if (tempChild is RecyclerView || tempChild is AdapterView<*>)
                child = tempChild
        }
        return child
    }

    //获取指定类型的子View
    @JvmStatic
    fun <V : View> getChildView_ofType(viewGroup: ViewGroup, clazz: Class<V>): V? {
        val viewDeque: Deque<View> = ArrayDeque()
        viewDeque.add(viewGroup)
        while (!viewDeque.isEmpty()) {
            val node = viewDeque.removeFirst()
            if (clazz.isInstance(node)) {
                return clazz.cast(node)
            } else if (node is ViewGroup) {
                viewDeque.addAll(getChildViews(node))
            }
        }
        return null
    }

    @JvmStatic
    fun getChildViews(viewGroup: ViewGroup): List<View> {
        val views = mutableListOf<View>()
        for (i in 0 until viewGroup.childCount) {
            views.add(viewGroup.getChildAt(i))
        }
        return views
    }

    //包含ViewGroup
    @JvmStatic
    fun getAllViews(viewGroup: ViewGroup): List<View> {
        val viewDeque: Deque<View> = ArrayDeque()
        viewDeque.add(viewGroup)
        val views = mutableListOf<View>()
        while (!viewDeque.isEmpty()) {
            val node = viewDeque.removeFirst()
            views.add(node)
            if (node is ViewGroup) {
                viewDeque.addAll(getChildViews(node))
            }
        }
        return views.also { UtilKLogWrapper.i(TAG, "getAllViews ${it.map { it::class.java.simpleName }}") }
    }

    //不包含ViewGroup
    @JvmStatic
    fun getAllChildViews(viewGroup: ViewGroup): List<View> {
        val viewDeque: Deque<View> = ArrayDeque()
        viewDeque.add(viewGroup)
        val views = mutableListOf<View>()
        while (!viewDeque.isEmpty()) {
            val node = viewDeque.removeFirst()
            if (node is ViewGroup) {
                viewDeque.addAll(getChildViews(node))
            } else
                views.add(node)
        }
        return views
    }

    //判断child是否发生了滚动
    @JvmStatic
    fun isChildViewScrolled(viewGroup: ViewGroup): Boolean {
        if (viewGroup is AdapterView<*>) {
            if (viewGroup.firstVisiblePosition != 0 || viewGroup.firstVisiblePosition == 0 && viewGroup.getChildAt(0) != null && viewGroup.getChildAt(0).top < 0)
                return true
        } else if (viewGroup.scrollY > 0)
            return true
        if (viewGroup is RecyclerView) {
            val firstPosition = viewGroup.getChildAdapterPosition(viewGroup.getChildAt(0))
            return firstPosition != 0 || !viewGroup.isScroll2top()
        }
        return false
    }

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addViewSafe_ofMatchParent(viewGroup: ViewGroup, view: View) {
        addViewSafe(viewGroup, view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    @JvmStatic
    fun addViewSafe_ofWrapContent(viewGroup: ViewGroup, view: View) {
        addViewSafe(viewGroup, view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    //////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun addViewSafe(viewGroup: ViewGroup, view: View, width: Int, height: Int) {
        addViewSafe(viewGroup, view, ViewGroup.LayoutParams(width, height))
    }

    @JvmStatic
    fun addViewSafe(viewGroup: ViewGroup, view: View, layoutParams: ViewGroup.LayoutParams) {
        if (view.parent == null)
            viewGroup.addView(view, layoutParams)
        else if (view.parent === viewGroup) {
            UtilKLogWrapper.w(TAG, "addViewSafe: view.parent===viewGroup")
        } else if (view.parent is ViewGroup) {
            (view.parent as ViewGroup).removeView(view)
            viewGroup.addView(view, layoutParams)
        } else {
            UtilKLogWrapper.e(TAG, "addViewSafe: fail")
        }
    }

    @JvmStatic
    fun addViewSafe(viewGroup: ViewGroup, view: View) {
        if (view.parent == null)
            viewGroup.addView(view)
        else if (view.parent === viewGroup) {
            UtilKLogWrapper.e(TAG, "addViewSafe: view.parent===viewGroup")
        } else if (view.parent is ViewGroup) {
            (view.parent as ViewGroup).removeView(view)
            viewGroup.addView(view)
        } else {
            UtilKLogWrapper.e(TAG, "addViewSafe: fail")
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun removeViewSafe(viewGroup: ViewGroup, view: View) {
        if (view.parent == null) {
            UtilKLogWrapper.w(TAG, "removeViewSafe(: removeViewSafe")
        } else if (!view.isAttachedToWindow_ofCompat()) {
            UtilKLogWrapper.w(TAG, "removeViewSafe(: !view.isAttachedToWindow_ofCompat()")
        } else if (viewGroup.contains(view)) {
            viewGroup.removeView(view)
        }
    }
}