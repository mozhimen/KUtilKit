package com.mozhimen.kotlin.utilk.android.view

import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKAnimationUtils
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/9/26 18:09
 * @Version 1.0
 */
object UtilKAnimationUtils : BaseUtilK() {
    @JvmStatic
    fun loadAnimation(@AnimRes intResAnim: Int) {
        AnimationUtils.loadAnimation(_context, intResAnim)
    }
}