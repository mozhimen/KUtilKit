package com.mozhimen.kotlin.utilk

import com.mozhimen.kotlin.utilk.kotlin.io.printlog
import com.mozhimen.kotlin.utilk.kotlin.io.UtilKConsole
import com.mozhimen.kotlin.utilk.kotlin.math.UtilKMathTriangle
import com.mozhimen.kotlin.utilk.kotlin.ranges.UtilK_Ranges
import org.junit.Test

/**
 * @ClassName TestUtilKNumber
 * @Description TODO
 * @Author Kolin Zhao / Mozhimen
 * @Date 2022/9/14 17:55
 * @Version 1.0
 */
class TestUtilKNumber {
    @Test
    fun normalize() {
        UtilKConsole.printlog(UtilK_Ranges.constraint(-1f, 0f, 10f).toString())
        UtilKConsole.printlog(UtilK_Ranges.constraint(1f, 0f, 10f).toString())
        UtilKConsole.printlog(UtilK_Ranges.constraint(11f, 0f, 10f).toString())
        UtilKConsole.printlog(UtilK_Ranges.constraint(0f, 0f, 0f).toString())
    }

    @Test
    fun angleSin() {
        UtilKConsole.printlog(UtilKMathTriangle.angleSin(1f, 2f).toString())
        UtilKConsole.printlog(UtilKMathTriangle.angleCos(1f, 2f).toString())
    }

    @Test
    fun percent() {
//        UtilKConsole.printlog(UtilKRanges.percent(0f, 0, 100).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(-1f, 0, 100).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(101f, 0, 100).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(50f, 0, 100).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(33f, 0, 100).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(23f, 0, 99).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(23f, 23, 99).toString())
//        UtilKConsole.printlog(UtilKRanges.percent(23f, 0, 0).toString())
        UtilK_Ranges.percent(23f, 33f, 44f).printlog()
        UtilK_Ranges.percent(-23f, 33f, 44f).printlog()
    }

    @Test
    fun getNewRotate() {
        val origin = 45f
        val last = 5f
        val current = 315f
        val temp = current - origin + when {
            (current - last) <= -180f -> 360f
            (current - last) >= 180f -> -360f
            else -> 0f
        }
        var real = 0f
        real += temp
        real.printlog()
    }
}