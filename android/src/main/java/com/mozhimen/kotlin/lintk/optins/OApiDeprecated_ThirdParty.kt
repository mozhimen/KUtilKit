package com.mozhimen.kotlin.lintk.optins

/**
 * @ClassName AOptInOfficialDeprecated
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
@RequiresOptIn("The api is deprecated by third party (or maybe no longer maintain). 被第三方弃用的API", RequiresOptIn.Level.WARNING)
annotation class OApiDeprecated_ThirdParty
