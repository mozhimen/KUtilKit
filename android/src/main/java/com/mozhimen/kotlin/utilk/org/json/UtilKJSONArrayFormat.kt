package com.mozhimen.kotlin.utilk.org.json

import com.mozhimen.kotlin.utilk.android.util.e
import com.mozhimen.kotlin.utilk.commons.IUtilK
import org.json.JSONArray
import org.json.JSONException

/**
 * @ClassName UtilKJSONFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2023/10/19 1:46
 * @Version 1.0
 */
fun JSONArray.jSONArray2strList(): ArrayList<String?>? =
    UtilKJSONArrayFormat.jSONArray2strList(this)

////////////////////////////////////////////////

object UtilKJSONArrayFormat: IUtilK {

    @JvmStatic
    fun jSONArray2strList(jsonArray: JSONArray): ArrayList<String?>? {
        val strs = ArrayList<String?>()
        for (i in 0 until jsonArray.length()) {
            try {
                val obj = jsonArray[i] as? String?
                strs.add(obj)
            } catch (e: JSONException) {
                e.printStackTrace()
                e.message?.e(TAG)
                return null
            }
        }
        return strs
    }
}