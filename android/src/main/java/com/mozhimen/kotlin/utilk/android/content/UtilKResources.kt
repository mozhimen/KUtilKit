package com.mozhimen.kotlin.utilk.android.content

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.content.res.TypedArray
import android.content.res.XmlResourceParser
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import androidx.annotation.AnimRes
import androidx.annotation.AnyRes
import androidx.annotation.ArrayRes
import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.annotation.StyleableRes
import androidx.annotation.XmlRes
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContext

/**
 * @ClassName UtilKResource
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/6/25 15:10
 * @Version 1.0
 */
object UtilKResources {

    @JvmStatic
    fun get_ofSys(): Resources =
        Resources.getSystem()

    @JvmStatic
    fun get_ofApp(context: Context): Resources =
        UtilKContext.getResources(context)

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getConfiguration(resources: Resources): Configuration =
        resources.configuration

    @JvmStatic
    fun getDisplayMetrics(resources: Resources): DisplayMetrics =
        resources.displayMetrics

    ////////////////////////////////////////////////////////////////////////////

    //获取系统Configuration
    @JvmStatic
    fun getConfiguration_ofSys(): Configuration =
        get_ofSys().configuration

    @JvmStatic
    fun getDisplayMetrics_ofSys(): DisplayMetrics =
        getDisplayMetrics(get_ofSys())

    @JvmStatic
    @SuppressLint("DiscouragedApi")
    fun getIdentifier_ofSys(name: String, defType: String, defPackage: String): Int =
        get_ofSys().getIdentifier(name, defType, defPackage)

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getConfiguration_ofApp(context: Context): Configuration =
        getConfiguration(get_ofApp(context))

    @JvmStatic
    fun getDisplayMetrics_ofApp(context: Context): DisplayMetrics =
        getDisplayMetrics(get_ofApp(context))

    @JvmStatic
    fun getAssets_ofApp(context: Context): AssetManager =
        get_ofApp(context).assets

    @JvmStatic
    fun getResourceEntryName_ofApp(@AnyRes intResAny: Int, context: Context): String =
        get_ofApp(context).getResourceEntryName(intResAny)

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getString_ofApp(@StringRes intResStr: Int, context: Context): String =
        get_ofApp(context).getString(intResStr)

    @JvmStatic
    fun getString_ofApp(@StringRes intResStr: Int, vararg formatArgs: Any, context: Context): String =
        get_ofApp(context).getString(intResStr, *formatArgs)

    @JvmStatic
    fun getStringArray_ofApp(@ArrayRes intResArray: Int, context: Context): Array<String> =
        get_ofApp(context).getStringArray(intResArray)

    @JvmStatic
    fun getColor_ofApp(@ColorRes intResColor: Int, context: Context): Int =
        get_ofApp(context).getColor(intResColor)

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColor_ofApp(@ColorRes intResColor: Int, theme: Theme?, context: Context): Int =
        get_ofApp(context).getColor(intResColor, theme)

    @SuppressLint("UseCompatLoadingForColorStateLists")
    @JvmStatic
    fun getColorStateList_ofApp(@ColorRes intResColor: Int, context: Context): ColorStateList =
        get_ofApp(context).getColorStateList(intResColor)

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColorStateList_ofApp(@ColorRes intResColor: Int, theme: Theme?, context: Context): ColorStateList =
        get_ofApp(context).getColorStateList(intResColor, theme)

    @JvmStatic
    @SuppressLint("UseCompatLoadingForDrawables")
    fun getDrawable_ofApp(@DrawableRes intResDrawable: Int, context: Context): Drawable =
        get_ofApp(context).getDrawable(intResDrawable)// ResourcesCompat.getDrawable()

    @RequiresApi(CVersCode.V_21_5_L)
    @SuppressLint("UseCompatLoadingForDrawables")
    @JvmStatic
    fun getDrawable_ofApp(@DrawableRes intResDrawable: Int, theme: Theme?, context: Context): Drawable =
        get_ofApp(context).getDrawable(intResDrawable, theme)

    @JvmStatic
    fun getDrawableForDensity_ofApp(@DrawableRes intResDrawable: Int, density: Int, context: Context): Drawable? =
        get_ofApp(context).getDrawableForDensity(intResDrawable, density)

    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getDrawableForDensity_ofApp(@DrawableRes intResDrawable: Int, density: Int, theme: Theme?, context: Context): Drawable? =
        get_ofApp(context).getDrawableForDensity(intResDrawable, density, theme)

    @JvmStatic
    fun getBoolean_ofApp(@BoolRes intResBool: Int, context: Context): Boolean =
        get_ofApp(context).getBoolean(intResBool)

    @JvmStatic
    fun getInteger_ofApp(@IntegerRes intResInt: Int, context: Context): Int =
        get_ofApp(context).getInteger(intResInt)

    @RequiresApi(CVersCode.V_29_10_Q)
    @JvmStatic
    fun getFloat_ofApp(@DimenRes intResDimen: Int, context: Context): Float =
        get_ofApp(context).getFloat(intResDimen)

    @JvmStatic
    fun getDimensionPixelOffset_ofApp(@DimenRes intResDimen: Int, context: Context): Int =
        get_ofApp(context).getDimensionPixelOffset(intResDimen)

    @JvmStatic
    fun getDimensionPixelSize_ofApp(@DimenRes intResDimen: Int, context: Context): Int =
        get_ofApp(context).getDimensionPixelSize(intResDimen)

    @JvmStatic
    fun getDimension_ofApp(@DimenRes intResDimen: Int, context: Context): Float =
        get_ofApp(context).getDimension(intResDimen)

    @JvmStatic
    fun getIntArray_ofApp(@ArrayRes intResArray: Int, context: Context): IntArray =
        get_ofApp(context).getIntArray(intResArray)

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun getXml_ofApp(@XmlRes intResXml: Int, context: Context): XmlResourceParser =
        get_ofApp(context).getXml(intResXml)

    @JvmStatic
    fun getAnimation_ofApp(@AnimRes intResAnim: Int, context: Context): XmlResourceParser =
        get_ofApp(context).getAnimation(intResAnim)

    @JvmStatic
    fun getLayout_ofApp(@LayoutRes intResLayout: Int, context: Context): XmlResourceParser =
        get_ofApp(context).getLayout(intResLayout)

    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getFont_ofApp(@FontRes intResFont: Int, context: Context): Typeface =
        get_ofApp(context).getFont(intResFont)

    ////////////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun obtainAttributes_ofApp(set: AttributeSet, @StyleableRes intArrayStyleable: IntArray, context: Context): TypedArray =
        get_ofApp(context).obtainAttributes(set, intArrayStyleable)

    @JvmStatic
    fun updateConfiguration_ofApp(configuration: Configuration, displayMetrics: DisplayMetrics, context: Context) {
        get_ofApp(context).updateConfiguration(configuration, displayMetrics)
    }
}