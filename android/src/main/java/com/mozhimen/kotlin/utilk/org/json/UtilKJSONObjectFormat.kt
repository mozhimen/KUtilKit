package com.mozhimen.kotlin.utilk.org.json

import com.mozhimen.kotlin.utilk.java.lang.UtilKSystemGet
import org.json.JSONObject

/**
 * @ClassName UtilKJSONObjectWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/12/9
 * @Version 1.0
 */
fun JSONObject.jSONObject2strDump(): String =
    UtilKJSONObjectFormat.jSONObject2strDump(this)

/////////////////////////////////////////////////////////////////

object UtilKJSONObjectFormat {
    @JvmStatic
    fun jSONObject2strDump(jSONObject: JSONObject): String =
        try {
            UtilKSystemGet.getProperty_line_separator() + jSONObject.toString(2)
        } catch (throwable: Throwable) {
            jSONObject.toString()
        }
}