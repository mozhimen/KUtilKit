package com.mozhimen.kotlin.lintk.annors

import androidx.annotation.IntDef
import com.mozhimen.kotlin.elemk.java.util.cons.CDateFormat

/**
 * @ClassName AFormatStyle
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/14
 * @Version 1.0
 */
@IntDef(CDateFormat.FULL, CDateFormat.LONG, CDateFormat.MEDIUM, CDateFormat.SHORT)
annotation class AFormatStyle
