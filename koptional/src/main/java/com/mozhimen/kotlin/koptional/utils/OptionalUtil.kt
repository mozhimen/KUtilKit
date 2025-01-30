package com.mozhimen.kotlin.koptional.utils

import com.gojuno.koptional.None
import com.gojuno.koptional.Optional
import com.gojuno.koptional.toOptional
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * @ClassName UtilKOptional
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/9
 * @Version 1.0
 */
fun <T : Any> Maybe<T>.toSingleAsOptional(): Single<Optional<T>> =
    OptionalUtil.toSingleAsOptional(this)

//////////////////////////////////////////////////////

object OptionalUtil {
    @JvmStatic
    fun <T : Any> toSingleAsOptional(maybe: Maybe<T>): Single<Optional<T>> =
        maybe.map { it.toOptional() }.toSingle(None)
}