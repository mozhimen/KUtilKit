package com.mozhimen.kotlin.lintk.optins.api

/**
 * @ClassName AOptLazyInit
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Version 1.0
 */
@RequiresOptIn("The api need init in application. 需要在Application初始化的API", RequiresOptIn.Level.WARNING)
annotation class OApiInit_InApplication
