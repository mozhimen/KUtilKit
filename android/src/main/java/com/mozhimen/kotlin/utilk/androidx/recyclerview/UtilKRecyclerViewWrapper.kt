package com.mozhimen.kotlin.utilk.androidx.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.ranges.constraint
import kotlin.math.ceil

/**
 * @ClassName UtilKRecyclerViewLayoutManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/3/26
 * @Version 1.0
 */

fun RecyclerView.gainItemCount(): Int =
    UtilKRecyclerViewWrapper.gainItemCount(this)

fun RecyclerView.gainSpanCount(): Int =
    UtilKRecyclerViewWrapper.gainSpanCount(this)

fun RecyclerView.getLastVisibleItemPosition(): Int =
    UtilKRecyclerViewWrapper.getLastVisibleItemPosition(this)

fun RecyclerView.getFirstVisibleItemPosition(): Int =
    UtilKRecyclerViewWrapper.getFirstVisibleItemPosition(this)

///////////////////////////////////////////////////////////////////////////

fun RecyclerView.isScrollVertical(): Boolean =
    UtilKRecyclerViewWrapper.isScrollVertical(this)

fun RecyclerView.isScroll2top(): Boolean =
    UtilKRecyclerViewWrapper.isScroll2top(this)

fun RecyclerView.isScroll2end(): Boolean =
    UtilKRecyclerViewWrapper.isScroll2end(this)

fun RecyclerView.isScroll2verticalEdge(): Boolean =
    UtilKRecyclerViewWrapper.isScroll2verticalEdge(this)

fun RecyclerView.isScroll2top_ofItem(): Boolean =
    UtilKRecyclerViewWrapper.isScroll2top_ofItem(this)

fun RecyclerView.isScroll2end_ofItem(): Boolean =
    UtilKRecyclerViewWrapper.isScroll2end_ofItem(this)

fun RecyclerView.isScroll2verticalEdge_ofItem(): Boolean =
    UtilKRecyclerViewWrapper.isScroll2verticalEdge_ofItem(this)

//fun RecyclerView.isScrollUp(dy: Int): Boolean =
//    UtilKRecyclerView.isScrollUp(dy)
//
//fun RecyclerView.isScrollDown(dx: Int): Boolean =
//    UtilKRecyclerView.isScrollDown(dx)

///////////////////////////////////////////////////////////////////////////

fun RecyclerView.applyScroll2top() {
    UtilKRecyclerViewWrapper.applyScroll2top(this)
}

fun RecyclerView.applyScroll2top_smooth() {
    UtilKRecyclerViewWrapper.applyScroll2top_smooth(this)
}

fun RecyclerView.requireLayoutManager_ofLinear(): LinearLayoutManager? =
    UtilKRecyclerViewWrapper.requireLayoutManager_ofLinear(this)

fun RecyclerView.requireLayoutManager_ofGrid(): GridLayoutManager? =
    UtilKRecyclerViewWrapper.requireLayoutManager_ofGrid(this)

///////////////////////////////////////////////////////////////////////////

object UtilKRecyclerViewWrapper : IUtilK {

    /**
     * 获取目标状态按钮
     */
    /*open fun getProgressButtonByAppFileParams(appFileParams: AppFileParams): DownloadProgressButton? {
        val recyclerView = getRecyclerView()
        recyclerView ?: return null
        val linearLayoutManager =
            recyclerView.layoutManager as NiuLinearLayoutManager
        //拿到开始显示的位置和最后显示的位置
        val findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()
        if (findFirstVisibleItemPosition < 0) {
            return null
        }
        val findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()
        if (findLastVisibleItemPosition < 0) {
            return null
        }
        (recyclerView.adapter as? AppBaseInfoPagedListAdapter<*>)?.let { adapter ->
            if (adapter.itemCount <= 0) {
                return null
            }
            for (position in findFirstVisibleItemPosition..findLastVisibleItemPosition) {
                adapter.getItem(position)?.let { appBaseInfo ->
                    if (appBaseInfo.id == appFileParams.appId && appBaseInfo.packageName == appFileParams.packName) {
                        linearLayoutManager.findViewByPosition(position)
                            ?.let { findViewByPosition ->
                                return findViewByPosition.findViewById(R.id.common_app_base_info_status)
                            }
                    }
                }
            }
        }
        return null
    }*/

    @JvmStatic
    fun gainItemCount(recyclerView: RecyclerView): Int =
        recyclerView.layoutManager?.itemCount ?: 0

    /**
     * 获取 spanCount
     * 注：此方法只针对设置 LayoutManager 为 GridLayoutManager 的 RecyclerView 生效
     */
    @JvmStatic
    fun gainSpanCount(recyclerView: RecyclerView): Int =
        requireLayoutManager_ofGrid(recyclerView)?.spanCount ?: 0

    ///////////////////////////////////////////////////////////////////////////

    //找到最后一个可视的Item
    @JvmStatic
    fun getLastVisibleItemPosition(recyclerView: RecyclerView): Int =
        recyclerView.layoutManager?.getLastVisibleItemPosition() ?: -1

    //找到第一个可视的View
    @JvmStatic
    fun getFirstVisibleItemPosition(recyclerView: RecyclerView): Int =
        recyclerView.layoutManager?.getFirstVisibleItemPosition() ?: -1

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isScrollVertical(recyclerView: RecyclerView): Boolean =
        when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager -> layoutManager.orientation == LinearLayoutManager.VERTICAL
            else -> true
        }

    //是否滑动到边缘
    @JvmStatic
    fun isScroll2verticalEdge(recyclerView: RecyclerView): Boolean =
        isScroll2end(recyclerView) || isScroll2top(recyclerView)

    //是否滑动到顶部
    @JvmStatic
    fun isScroll2top(recyclerView: RecyclerView): Boolean =
        !UtilKRecyclerView.canScrollVertically(recyclerView, -1)

    //是否滑动到底部
    @JvmStatic
    fun isScroll2end(recyclerView: RecyclerView): Boolean =
        !UtilKRecyclerView.canScrollVertically(recyclerView, 1)

    //是否滑动到边缘2
    @JvmStatic
    fun isScroll2verticalEdge_ofItem(recyclerView: RecyclerView): Boolean =
        isScroll2end_ofItem(recyclerView) || isScroll2top_ofItem(recyclerView)

    //滑动到顶部2
    @JvmStatic
    fun isScroll2end_ofItem(recyclerView: RecyclerView): Boolean {
        when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager, is StaggeredGridLayoutManager -> {
                val firstItemPos = layoutManager.getFirstVisibleItemPosition()
                val lastItemPos = layoutManager.getLastVisibleItemPosition()
                val lastChild: View? = UtilKRecyclerView.getChildAt(recyclerView, lastItemPos - firstItemPos)
                val itemCount = layoutManager.itemCount
                if (lastItemPos == itemCount - 1 && lastChild != null && lastChild.bottom <= recyclerView.measuredHeight)
                    return true
            }
        }
        return false
    }

    //滑动到底部2
    @JvmStatic
    fun isScroll2top_ofItem(recyclerView: RecyclerView): Boolean {
        when (val layoutManager = recyclerView.layoutManager) {
            is LinearLayoutManager, is StaggeredGridLayoutManager -> {
                return (UtilKRecyclerView.getChildAt(recyclerView, 0)?.y.also {
                    UtilKLogWrapper.d(TAG, "UtilKRecyclerView.getChildAt(recyclerView, 0)?.y ${UtilKRecyclerView.getChildAt(recyclerView, 0)?.y}")
                } == 0f) && layoutManager.getFirstVisibleItemPosition().also {
                    UtilKLogWrapper.d(TAG, "layoutManager.getFirstVisibleItemPosition() ${layoutManager.getFirstVisibleItemPosition()}")
                } == 0
            }
        }
        return false
    }

//    //是否向上滚动
//    @JvmStatic
//    fun isScrollUp(dy: Int): Boolean =
//        dy < 0
//
//    //是否向下滚动
//    @JvmStatic
//    fun isScrollDown(dx: Int): Boolean =
//        dy > 0

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun applyScroll2top(recyclerView: RecyclerView) {
        UtilKRecyclerView.scrollToPosition(recyclerView, 0)
    }

    @JvmStatic
    fun applyScroll2top_smooth(recyclerView: RecyclerView) {
        UtilKRecyclerView.smoothScrollToPosition(recyclerView, 0)
    }

    ///////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun requireLayoutManager_ofLinear(recyclerView: RecyclerView): LinearLayoutManager? {
        val layoutManager = recyclerView.layoutManager ?: return null
        if (layoutManager !is LinearLayoutManager)
            throw IllegalStateException("Make sure you are using the LinearLayoutManager")
        return layoutManager
    }

    /**
     * 检查 RecyclerView 设置的 GridLayoutManager
     */
    @JvmStatic

    fun requireLayoutManager_ofGrid(recyclerView: RecyclerView): GridLayoutManager? {
        val layoutManager = recyclerView.layoutManager ?: return null
        if (layoutManager !is GridLayoutManager) {
            throw IllegalStateException("Make sure you are using the GridLayoutManager")
        }
        return layoutManager
    }

    ///////////////////////////////////////////////////////////////////////////

    /**
     * {@link ItemDecoration#getItemOffsets(outRect: Rect,view: View,parent: RecyclerView)} or
     * {@link ItemDecoration#getItemOffsets(outRect: Rect,view: View,parent: RecyclerView,state: RecyclerView.State)}.
     * 均分 LinearLayoutManager 间距的便捷方法
     */
    @JvmStatic
    fun equilibriumAssignment_ofLinearLayoutManager(recyclerView: RecyclerView, itemView: View, outRect: Rect, gapOuter: Int, gapInner: Int = gapOuter / 2, gapOther: Int = gapOuter) {
        val itemCount = recyclerView.gainItemCount()// item 的个数
        val itemPosition = recyclerView.getChildAdapterPosition(itemView)// 当前 item 的 position
        val layoutManager = recyclerView.requireLayoutManager_ofLinear() ?: return
        val orientation = layoutManager.orientation// 获取 LinearLayoutManager 的布局方向
        for (index in 0..itemCount) {// 遍历所有 item
            when (itemPosition) {
                0 -> {// 第一行/列
                    if (orientation == RecyclerView.VERTICAL) {// 第一行/列 && VERTICAL 布局方式 -> 对item的底部特殊处理
                        outRect.top = gapOuter
                        outRect.bottom = gapInner
                        outRect.left = gapOther
                        outRect.right = gapOther
                    } else {// 第一行/列 && HORIZONTAL 布局方式 -> 对item的右边特殊处理
                        outRect.top = gapOther
                        outRect.bottom = gapOther
                        outRect.left = gapOuter
                        outRect.right = gapInner
                    }
                }

                itemCount - 1 -> {// 最后一行/列
                    if (orientation == RecyclerView.VERTICAL) {// 最后一行/列 && VERTICAL 布局方式 -> 对item的顶部特殊处理
                        outRect.top = gapInner
                        outRect.bottom = gapOuter
                        outRect.left = gapOther
                        outRect.right = gapOther
                    } else {// 最后一行/列 && HORIZONTAL 布局方式 -> 对item的左边特殊处理
                        outRect.top = gapOther
                        outRect.bottom = gapOther
                        outRect.left = gapInner
                        outRect.right = gapOuter
                    }
                }

                else -> {// 中间的行/列
                    if (orientation == RecyclerView.VERTICAL) {// 中间的行/列 && VERTICAL 布局方式 -> 对item的顶部和底部特殊处理
                        outRect.top = gapInner
                        outRect.bottom = gapInner
                        outRect.left = gapOther
                        outRect.right = gapOther
                    } else {// 中间的行/列 && HORIZONTAL 布局方式 -> 对item的左边和右边特殊处理
                        outRect.top = gapOther
                        outRect.bottom = gapOther
                        outRect.left = gapInner
                        outRect.right = gapInner
                    }
                }
            }
        }
    }

    /**
     * {@link ItemDecoration#getItemOffsets(outRect: Rect,view: View,parent: RecyclerView)} or
     * {@link ItemDecoration#getItemOffsets(outRect: Rect,view: View,parent: RecyclerView,state: RecyclerView.State)}.
     * 均分 GridLayoutManager 间距的便捷方法
     */
    @JvmStatic
    fun equilibriumAssignment_ofGridLayoutManager(
        recyclerView: RecyclerView,
        itemView: View,
        outRect: Rect,
        gapOuter: Int,
        gapInnerHorizontal: Int = gapOuter / 2,
        gapInnerVertical: Int = gapInnerHorizontal,
        gapOther: Int = gapOuter,
    ) {
        val itemCount = recyclerView.gainItemCount()// item 的个数
        val spanCount = recyclerView.gainSpanCount()// 网格布局的跨度数
        val itemPosition = recyclerView.getChildAdapterPosition(itemView)// 当前 item 的 position
        val lastRowFirstPosition = ((ceil(itemCount.toDouble() / spanCount.toDouble()).toInt() - 1) * spanCount).constraint(0, itemCount - 1)
        UtilKLogWrapper.d(TAG, "equilibriumAssignment_ofGridLayoutManager: lastRowFirstPosition $lastRowFirstPosition");
        val layoutManager = recyclerView.requireLayoutManager_ofGrid() ?: return
        if (spanCount < 2) {
            equilibriumAssignment_ofLinearLayoutManager(recyclerView, itemView, outRect, gapOuter, gapInnerHorizontal, gapOther)
            return
        }
        val orientation = layoutManager.orientation// 获取 GridLayoutManager 的布局方向
        if (orientation == RecyclerView.HORIZONTAL)
            throw UnsupportedOperationException("You can’t set a horizontal grid layout because we don’t support!")// 暂不支持横向布局的 GridLayoutManager
        for (index in 0..itemCount) {// 遍历所有 item
            when {
                itemPosition % spanCount == 0 -> {// 最左边的那一列
                    outRect.left = gapOuter
                    outRect.right = gapInnerHorizontal
                }

                (itemPosition - (spanCount - 1)) % spanCount == 0 -> {// 最右边的那一列
                    outRect.left = gapInnerHorizontal
                    outRect.right = gapOuter
                }

                else -> {// 中间的列（可能有多列）
                    outRect.left = gapInnerHorizontal
                    outRect.right = gapInnerHorizontal
                }
            }
            when (itemPosition) {
                in 0 until spanCount -> {
                    outRect.top = gapOuter
                    if (itemPosition in lastRowFirstPosition until itemCount) {
                        outRect.bottom = gapOuter
                    } else
                        outRect.bottom = gapInnerVertical
                }

                in lastRowFirstPosition until itemCount /*(itemCount - spanCount) until itemCount*/ -> {// 判断是否为最后一行，最后一行单独添加底部的间距
                    UtilKLogWrapper.d(TAG, "equilibriumAssignment_ofGridLayoutManager: itemPosition $itemPosition")
                    outRect.bottom = gapOuter
                    outRect.top = gapInnerVertical
                }

                else -> {
                    outRect.top = gapInnerVertical
                    outRect.bottom = gapInnerVertical
                }
            }
        }
    }
}