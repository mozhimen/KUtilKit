package com.mozhimen.kotlin.utilk.google.material

import com.google.android.material.tabs.TabLayout

/**
 * @ClassName UtilKTabLayout
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/4/15
 * @Version 1.0
 */
object UtilKTabLayout {
    @JvmStatic
    fun addOnTabSelectedListener(tabLayout: TabLayout, listener: TabLayout.OnTabSelectedListener) {
        tabLayout.addOnTabSelectedListener(listener)
    }
}