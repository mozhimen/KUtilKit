package com.mozhimen.kotlin.utilk.kotlin

import com.mozhimen.kotlin.utilk.org.json.UtilKJSONArrayFormat
import org.json.JSONArray
import org.json.JSONObject

/**
 * @ClassName UtilKStrJson
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 1:48
 * @Version 1.0
 */
fun String.strJson2jSONObject(): JSONObject =
    UtilKStrJson.strJson2jSONObject(this)

fun String.strJson2jSONArray(): JSONArray =
    UtilKStrJson.strJson2jSONArray(this)

fun String.strJson2strArray(): Array<String?> =
    UtilKStrJson.strJson2strArray(this)

//////////////////////////////////////////////////////////////////////

object UtilKStrJson {
    @JvmStatic
    fun strJson2jSONObject(strJson: String): JSONObject =
        JSONObject(strJson)

    @JvmStatic
    fun strJson2jSONArray(strJson: String): JSONArray =
        JSONArray(strJson)

    @JvmStatic
    fun strJson2strArray(strJson: String): Array<String?> {
        val jsonArray = JSONArray(strJson.trim { it <= ' ' })
        val length = jsonArray.length()
        val strArray = Array<String?>(length) { "" }
        for (i in 0 until length)
            strArray[i] = jsonArray[i] as? String?
        return strArray
    }
}