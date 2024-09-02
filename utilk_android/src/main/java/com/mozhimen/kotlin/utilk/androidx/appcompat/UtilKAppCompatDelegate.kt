package com.mozhimen.kotlin.utilk.androidx.appcompat

import androidx.appcompat.app.AppCompatDelegate
import com.mozhimen.kotlin.elemk.androidx.appcompat.cons.CAppCompatDelegate

/**
 * @ClassName UtilKAppCompatDelegate
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/6/30 16:21
 * @Version 1.0
 */
object UtilKAppCompatDelegate {
    @JvmStatic
    fun getDefaultNightMode(): Int =
        AppCompatDelegate.getDefaultNightMode()

    ////////////////////////////////////////////////////////////////

    /**
     * 检测是否是浅色主题
     */
    @JvmStatic
    fun isLightMode(): Boolean =
        getDefaultNightMode() == CAppCompatDelegate.MODE_NIGHT_NO

    @JvmStatic
    fun isNightMode(): Boolean =
        getDefaultNightMode() == CAppCompatDelegate.MODE_NIGHT_YES

    ////////////////////////////////////////////////////////////////

    @JvmStatic
    fun setDefaultNightMode(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }

    @JvmStatic
    fun applyLightMode() {
        if (isLightMode()) return
        setDefaultNightMode(CAppCompatDelegate.MODE_NIGHT_NO)
    }

    @JvmStatic
    fun applyNightMode() {
        if (isNightMode()) return
        setDefaultNightMode(CAppCompatDelegate.MODE_NIGHT_YES)
    }

    @JvmStatic
    fun toggleUiMode() {
        if (isLightMode())
            applyNightMode()
        else applyLightMode()
    }
}