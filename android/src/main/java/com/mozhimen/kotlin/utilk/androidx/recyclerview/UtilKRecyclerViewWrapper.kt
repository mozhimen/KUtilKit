package com.mozhimen.kotlin.utilk.androidx.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK

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
//                    UtilKLogWrapper.d(TAG, "UtilKRecyclerView.getChildAt(recyclerView, 0)?.y ${UtilKRecyclerView.getChildAt(recyclerView, 0)?.y}")
                } == 0f) && layoutManager.getFirstVisibleItemPosition().also {
//                    UtilKLogWrapper.d(TAG, "layoutManager.getFirstVisibleItemPosition() ${layoutManager.getFirstVisibleItemPosition()}")
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
    fun equilibriumAssignment_ofLinearLayoutManager(
        recyclerView: RecyclerView,
        itemView: View,
        outRect: Rect,
        gapOuter: Int,
        gapInner: Int = gapOuter / 2,
        gapOpposite: Int = gapOuter,
    ) {
        val itemPosition = recyclerView.getChildAdapterPosition(itemView).takeIf { it != RecyclerView.NO_POSITION } ?: return
        val itemCount = recyclerView.gainItemCount().coerceAtLeast(0)// item 的个数
        if (itemCount == 0) return
        val layoutManager = recyclerView.requireLayoutManager_ofLinear() ?: return
        val isVertical = layoutManager.orientation == RecyclerView.VERTICAL
        when (itemPosition) {
            0 -> {// 第一行/列
                if (isVertical) {// 第一行/列 && VERTICAL 布局方式 -> 对item的底部特殊处理
                    outRect.left = gapOpposite
                    outRect.top = gapOuter
                    outRect.right = gapOpposite
                    outRect.bottom = gapInner
                } else {// 第一行/列 && HORIZONTAL 布局方式 -> 对item的右边特殊处理
                    outRect.left = gapOuter
                    outRect.top = gapOpposite
                    outRect.right = gapInner
                    outRect.bottom = gapOpposite
                }
            }

            itemCount - 1 -> {// 最后一行/列
                if (isVertical) {// 最后一行/列 && VERTICAL 布局方式 -> 对item的顶部特殊处理
                    outRect.left = gapOpposite
                    outRect.top = gapInner
                    outRect.right = gapOpposite
                    outRect.bottom = gapOuter
                } else {// 最后一行/列 && HORIZONTAL 布局方式 -> 对item的左边特殊处理
                    outRect.left = gapInner
                    outRect.top = gapOpposite
                    outRect.right = gapOuter
                    outRect.bottom = gapOpposite
                }
            }

            else -> {// 中间的行/列
                if (isVertical) {// 中间的行/列 && VERTICAL 布局方式 -> 对item的顶部和底部特殊处理
                    outRect.left = gapOpposite
                    outRect.top = gapInner
                    outRect.right = gapOpposite
                    outRect.bottom = gapInner
                } else {// 中间的行/列 && HORIZONTAL 布局方式 -> 对item的左边和右边特殊处理
                    outRect.left = gapInner
                    outRect.top = gapOpposite
                    outRect.right = gapInner
                    outRect.bottom = gapOpposite
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
        gapInnerHorizontal: Int,
        gapInnerVertical: Int = gapInnerHorizontal,
    ) {
        val itemCount = recyclerView.gainItemCount()// item 的个数
        val spanCount = recyclerView.gainSpanCount()// 网格布局的跨度数
        val itemPosition = recyclerView.getChildAdapterPosition(itemView)// 当前 item 的 position
        if (spanCount < 2) {
            equilibriumAssignment_ofLinearLayoutManager(recyclerView, itemView, outRect, 0, gapInnerHorizontal, 0)
            return
        }

        val currentColumn: Int = itemPosition % spanCount // 计算这个child 处于第几列

        // 水平间距：通过调整 outRect，但不影响 Item 宽度
        outRect.left = (currentColumn * gapInnerHorizontal / spanCount)
        outRect.right = gapInnerHorizontal - (currentColumn + 1) * gapInnerHorizontal / spanCount//if (isLastInRow) gapOuter else gapInnerHorizontal / 2

        // 垂直间距（类似逻辑）
        val rows = (itemCount + spanCount - 1) / spanCount
        val currentRow = itemPosition / spanCount

        outRect.top = (currentRow * gapInnerVertical / rows)//if (isFirstRow) 0 else gapInnerVertical / 2
        outRect.bottom = gapInnerVertical - (currentRow + 1) * gapInnerVertical / rows//if (isLastRow) gapOuter else gapInnerVertical / 2
    }
}