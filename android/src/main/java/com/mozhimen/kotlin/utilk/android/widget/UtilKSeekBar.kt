package com.mozhimen.kotlin.utilk.android.widget

import android.widget.SeekBar
import com.mozhimen.kotlin.elemk.commons.IA_Listener
import com.mozhimen.kotlin.elemk.android.view.commons.IOnSeekBarChangeListener

/**
 * @ClassName UtilKSeekBar
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/5/25 13:21
 * @Version 1.0
 */
fun SeekBar.applySeekBarChangeObserver(onSeekBarChange: IA_Listener<Int>/*(progress: Int) -> Unit*/) {
    UtilKSeekBar.applySeekBarChangeObserver(this, onSeekBarChange)
}

fun SeekBar.applySeekBarFinishObserver(onSeekBarChange: IA_Listener<Int>/*(progress: Int) -> Unit*/) {
    UtilKSeekBar.applySeekBarFinishObserver(this, onSeekBarChange)
}

object UtilKSeekBar {
    @JvmStatic
    fun applySeekBarChangeObserver(seekBar: SeekBar, listener: IA_Listener<Int>/*(progress: Int) -> Unit*/) {
        seekBar.setOnSeekBarChangeListener(object : IOnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                listener.invoke(progress)
            }
        })
    }

    @JvmStatic
    fun applySeekBarFinishObserver(seekBar: SeekBar, listener: IA_Listener<Int>/*(progress: Int) -> Unit*/) {
        seekBar.setOnSeekBarChangeListener(object : IOnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                listener.invoke(seekBar.progress)
            }
        })
    }
}