package com.mozhimen.kotlin.lintk.optins

/**
 * @ClassName AOptInUnstableApi
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
@RequiresOptIn("The api will remove. 将移除的API", RequiresOptIn.Level.WARNING)
annotation class OApiUnSupport