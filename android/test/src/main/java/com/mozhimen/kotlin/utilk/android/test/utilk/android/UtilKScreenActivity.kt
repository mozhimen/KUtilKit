package com.mozhimen.kotlin.utilk.android.test.utilk.android

import android.os.Bundle
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.uik.databinding.bases.viewdatabinding.activity.BaseActivityVDB
import com.mozhimen.kotlin.utilk.android.view.UtilKDecorView
import com.mozhimen.kotlin.utilk.android.view.UtilKWindowManager
import com.mozhimen.kotlin.utilk.wrapper.UtilKScreen
import com.mozhimen.kotlin.utilk.android.test.databinding.ActivityUtilkScreenBinding
//import com.mozhimen.adaptk.systembar.annors.AAdaptKSystemBarProperty
//import com.mozhimen.adaptk.systembar.cons.CProperty


/**
 * @ClassName UtilKScreenActivity
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2022/11/24 14:35
 * @Version 1.0
 */
//@AAdaptKSystemBarProperty(CProperty.IMMERSED_HARD_STICKY)
class UtilKScreenActivity : BaseActivityVDB<ActivityUtilkScreenBinding>() {
    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        UtilKLogWrapper.d(TAG, "initData: 获取屏幕宽度")
        UtilKLogWrapper.d(TAG, "initData: getWidth ${UtilKScreen.getWidth()}")//1080
        UtilKLogWrapper.d(TAG, "initData: getWidth_ofDisplayMetrics_ofSys ${UtilKScreen.getWidth_ofDisplayMetrics_ofSys()}")//1080
        UtilKLogWrapper.d(TAG, "initData: getWidth_ofDefMetrics ${UtilKScreen.getWidth_ofDisplayMetrics_ofDef()}")//1080
        UtilKLogWrapper.d(TAG, "initData: getWidth_ofRealMetrics ${UtilKScreen.getWidth_ofDisplayMetrics_ofReal()}")//1080
        UtilKLogWrapper.d(TAG, "initData: getWidth_ofDefDisplay ${UtilKScreen.getWidth_ofDisplay_ofDef()}")//1080
        UtilKLogWrapper.d(TAG, "initData: getWidth_ofSizeDefDisplay ${UtilKScreen.getWidth_ofDisplay_ofDefSize()}")//1080
        UtilKLogWrapper.d(TAG, "initData: getWidth_ofRealSizeDefDisplay ${UtilKScreen.getWidth_ofDisplay_ofDefSizeReal()}")//1080

        UtilKLogWrapper.d(TAG, "initData: 获取屏幕高度")
        UtilKLogWrapper.d(TAG, "initData: getHeight ${UtilKScreen.getHeight()}")//2400
        UtilKLogWrapper.d(TAG, "initData: getHeight_ofDisplayMetrics_ofSys ${UtilKScreen.getHeight_ofDisplayMetrics_ofSys()}")//2237
        UtilKLogWrapper.d(TAG, "initData: getHeight_ofDefMetrics ${UtilKScreen.getHeight_ofDisplayMetrics_ofDef()}")//2237
        UtilKLogWrapper.d(TAG, "initData: getHeight_ofRealMetrics ${UtilKScreen.getHeight_ofDisplayMetrics_ofReal()}")//2400
        UtilKLogWrapper.d(TAG, "initData: getHeight_ofDefDisplay ${UtilKScreen.getHeight_ofDisplay_ofDef()}")//2237
        UtilKLogWrapper.d(TAG, "initData: getHeight_ofSizeDefDisplay ${UtilKScreen.getHeight_ofDisplay_ofDefSize()}")//2237
        UtilKLogWrapper.d(TAG, "initData: getHeight_ofRealSizeDefDisplay ${UtilKScreen.getHeight_ofDisplay_ofDefSizeReal()}")//2400

        UtilKLogWrapper.d(TAG, "initData: 获取屏幕方向")
        UtilKLogWrapper.d(TAG, "initData: isOrientationPortrait_ofSysConfig ${UtilKScreen.isOrientationPortrait_ofSysConfig()}")
        UtilKLogWrapper.d(TAG, "initData: isOrientationPortrait_ofDefDisplay ${UtilKScreen.isOrientationPortrait_ofDefDisplay(this)}")//不准确
        UtilKLogWrapper.d(TAG, "initData: isOrientationPortrait_ofSysMetrics ${UtilKScreen.isOrientationPortrait_ofSysMetrics()}")
    }
}