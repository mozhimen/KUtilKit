package com.mozhimen.kotlin.elemk.android.app.cons

import android.app.PendingIntent
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.lintk.optins.OApiDeprecated_Official_AfterV_31_11_S

/**
 * @ClassName CPendingIntent
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/8/4 0:31
 * @Version 1.0
 */
object CPendingIntent {
    @Deprecated(
        """
        Targeting S+ (version 31 and above) requires that one of FLAG_IMMUTABLE or FLAG_MUTABLE be specified when creating a PendingIntent.
        Strongly consider using FLAG_IMMUTABLE, only use FLAG_MUTABLE if some functionality depends on the PendingIntent being mutable, e.g. if it needs to be used with inline replies or bubbles.
    """
    )
    @OApiDeprecated_Official_AfterV_31_11_S
    const val FLAG_NONE = 0

    const val FLAG_UPDATE_CURRENT = PendingIntent.FLAG_UPDATE_CURRENT

    /**
     * 作用：
     *
     * 安全性：使用 FLAG_IMMUTABLE 可以提高安全性。因为当一个 PendingIntent 是不可变的，其他应用或组件无法修改其内容（例如，无法改变包含的 Intent 对象或请求代码），这就避免了潜在的安全漏洞。
     * 防止意外更改：在某些情况下，我们希望 PendingIntent 的行为是确定的，不会因为其他应用的干扰而改变。使用 FLAG_IMMUTABLE 可以确保这一点。
     * 与 FLAG_MUTABLE 的区别：
     *
     * FLAG_MUTABLE：允许 PendingIntent 的内容可以被更改。
     * FLAG_IMMUTABLE：禁止任何对 PendingIntent 内容的更改
     */
    const val FLAG_IMMUTABLE = PendingIntent.FLAG_IMMUTABLE
    const val FLAG_MUTABLE = PendingIntent.FLAG_MUTABLE
    const val FLAG_NO_CREATE = PendingIntent.FLAG_NO_CREATE
    const val FLAG_ONE_SHOT = PendingIntent.FLAG_ONE_SHOT
    @RequiresApi(CVersCode.V_34_14_UDC)
    const val FLAG_ALLOW_UNSAFE_IMPLICIT_INTENT = PendingIntent.FLAG_ALLOW_UNSAFE_IMPLICIT_INTENT
    const val FLAG_CANCEL_CURRENT = PendingIntent.FLAG_CANCEL_CURRENT
}