package com.mozhimen.kotlin.elemk.android.opengl.annors

import androidx.annotation.IntDef

/**
 * @ClassName AMatrixType
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
@IntDef(value = [AMatrixType.MATRIX_FIT_XY, AMatrixType.MATRIX_CENTER_CROP, AMatrixType.MATRIX_CENTER_IN_SIDE, AMatrixType.MATRIX_FIT_START, AMatrixType.MATRIX_FIT_END])
annotation class AMatrixType {
    companion object {
        const val MATRIX_FIT_XY = 0
        const val MATRIX_CENTER_CROP = 1
        const val MATRIX_CENTER_IN_SIDE = 2
        const val MATRIX_FIT_START = 3
        const val MATRIX_FIT_END = 4
    }
}
