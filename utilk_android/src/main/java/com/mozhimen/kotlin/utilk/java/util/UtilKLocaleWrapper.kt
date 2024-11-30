package com.mozhimen.kotlin.utilk.java.util

import android.util.Pair
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.util.UtilKLogWrapper
import com.mozhimen.kotlin.utilk.commons.IUtilK
import com.mozhimen.kotlin.utilk.kotlin.text.UtilKRegexGet
import java.util.Locale

/**
 * @ClassName UtilKLocaleWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/4
 * @Version 1.0
 */
object UtilKLocaleWrapper : IUtilK {
    @JvmStatic
    @RequiresApi(CVersCode.V_21_5_L)
    fun getOSLang(): Pair<String, String> {
        val language = Locale.getDefault().language
        var languageTag = Locale.getDefault().toLanguageTag().replace("-Hant", "")
        UtilKLogWrapper.d(TAG, "getOSLang: language $language toLanguageTag $languageTag");
        try {
            val tags = languageTag.split(UtilKRegexGet.get_strikethrough()).dropLastWhile { it.isEmpty() }.toTypedArray()
            var newTag = ""
            if (tags.size > 1) {
                newTag = "r" + tags[1]
            }
            languageTag = tags[0] + "-" + newTag
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val pair = Pair(language, languageTag)
        UtilKLogWrapper.d(TAG, "getOSLang: language " + pair.first + " " + pair.second)
        return pair
    }
}