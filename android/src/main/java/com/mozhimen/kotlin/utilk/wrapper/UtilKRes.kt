package com.mozhimen.kotlin.utilk.wrapper

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources.Theme
import android.content.res.XmlResourceParser
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.AnimRes
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
import androidx.annotation.XmlRes
import com.mozhimen.kotlin.elemk.android.os.cons.CVersCode
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import com.mozhimen.kotlin.utilk.android.content.UtilKContextCompat
import com.mozhimen.kotlin.utilk.android.content.UtilKResources
import com.mozhimen.kotlin.utilk.android.os.UtilKBuildVersion
import com.mozhimen.kotlin.utilk.androidx.core.UtilKResourcesCompat
import com.mozhimen.kotlin.utilk.bases.BaseUtilK

/**
 * @ClassName UtilKRes
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Version 1.0
 */
fun Context.gainString(@StringRes intResStr: Int): String =
    UtilKRes.gainString(intResStr, this)

fun Context.gainString(@StringRes intResStr: Int, vararg formatArgs: Any): String =
    UtilKRes.gainString(intResStr, this, *formatArgs)

fun Context.gainStringArray(@ArrayRes intResArray: Int): Array<String> =
    UtilKRes.gainStringArray(intResArray, this)

fun Context.gainColor(@ColorRes intResColor: Int): Int =
    UtilKRes.gainColor(intResColor, this)

fun Context.gainColor(@ColorRes intResColor: Int, theme: Theme?): Int =
    UtilKRes.gainColor(intResColor, theme, this)

fun Context.gainColorStateList(@ColorRes intResColor: Int): ColorStateList? =
    UtilKRes.gainColorStateList(intResColor, this)

fun Context.gainColorStateList(@ColorRes intResColor: Int, theme: Theme?): ColorStateList? =
    UtilKRes.gainColorStateList(intResColor, theme, this)

fun Context.gainDrawable(@DrawableRes intResDrawable: Int): Drawable? =
    UtilKRes.gainDrawable(intResDrawable, this)

fun Context.gainDrawable(@DrawableRes intResDrawable: Int, theme: Theme?): Drawable? =
    UtilKRes.gainDrawable(intResDrawable, theme, this)

fun Context.gainDrawableForDensity(@DrawableRes intResDrawable: Int, density: Int): Drawable? =
    UtilKRes.gainDrawableForDensity(intResDrawable, density, this)

fun Context.gainDrawableForDensity(@DrawableRes intResDrawable: Int, density: Int, theme: Theme?): Drawable? =
    UtilKRes.gainDrawableForDensity(intResDrawable, density, theme, this)

fun Context.gainBoolean(@BoolRes intResBool: Int): Boolean =
    UtilKRes.gainBoolean(intResBool, this)

fun Context.gainInteger(@IntegerRes intResInt: Int): Int =
    UtilKRes.gainInteger(intResInt, this)

fun Context.gainFloat(@DimenRes intResDimen: Int): Float =
    UtilKRes.gainFloat(intResDimen, this)

fun Context.gainDimensionPixelOffset(@DimenRes intResDimen: Int): Int =
    UtilKRes.gainDimensionPixelOffset(intResDimen, this)

fun Context.gainDimensionPixelSize(@DimenRes intResDimen: Int): Int =
    UtilKRes.gainDimensionPixelSize(intResDimen, this)

fun Context.gainDimension(@DimenRes intResDimen: Int): Float =
    UtilKRes.gainDimension(intResDimen, this)

fun Context.gainIntArray(@ArrayRes intResArray: Int): IntArray =
    UtilKRes.gainIntArray(intResArray, this)

fun Context.gainXml(@XmlRes intResXml: Int): XmlResourceParser =
    UtilKRes.gainXml(intResXml, this)

fun Context.gainAnimation(@AnimRes intResAnim: Int): XmlResourceParser =
    UtilKRes.gainAnimation(intResAnim, this)

fun Context.gainLayout(@LayoutRes intResLayout: Int): XmlResourceParser =
    UtilKRes.gainLayout(intResLayout, this)

fun Context.gainFont(@FontRes intResFont: Int): Typeface? =
    UtilKRes.gainFont(intResFont, this)

///////////////////////////////////////////////////////////////////////////////////

object UtilKRes : BaseUtilK() {

    @JvmStatic
    fun gainString(@StringRes intResStr: Int, context: Context = _context): String =
        getString_ofContext(intResStr, context)

    //////////////////////////

    @JvmStatic
    fun getString_ofContext(@StringRes intResStr: Int, context: Context = _context): String =
        UtilKContext.getString(intResStr, context)

    @JvmStatic
    fun getString_ofResources(@StringRes intResStr: Int, context: Context = _context): String =
        UtilKResources.getString_ofApp(intResStr, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainString(@StringRes intResStr: Int, context: Context = _context, vararg formatArgs: Any): String =
        getString_ofContext(intResStr, context, *formatArgs)

    //////////////////////////

    @JvmStatic
    fun getString_ofContext(@StringRes intResStr: Int, context: Context = _context, vararg formatArgs: Any): String =
        UtilKContext.getString(intResStr, context, *formatArgs)

    @JvmStatic
    fun getString_ofResources(@StringRes intResStr: Int, context: Context = _context, vararg formatArgs: Any): String =
        UtilKContext.getString(intResStr, context, *formatArgs)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainStringArray(@ArrayRes intResArray: Int, context: Context = _context): Array<String> =
        getStringArray_ofResources(intResArray, context)

    //////////////////////////

    @JvmStatic
    fun getStringArray_ofResources(@ArrayRes intResArray: Int, context: Context = _context): Array<String> =
        UtilKResources.getStringArray_ofApp(intResArray, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainColor(@ColorRes intResColor: Int, context: Context = _context): Int =
        if (UtilKBuildVersion.isAfterV_23_6_M()) getColor_ofContext(intResColor, context)
        else getColor_ofContextCompat(intResColor)

    //////////////////////////

    @JvmStatic
    @RequiresApi(CVersCode.V_23_6_M)
    fun getColor_ofContext(@ColorRes intResColor: Int, context: Context = _context): Int =
        UtilKContext.getColor(intResColor, context)

    @JvmStatic
    fun getColor_ofResources(@ColorRes intResColor: Int, context: Context = _context): Int =
        UtilKResources.getColor_ofApp(intResColor, context)

    @JvmStatic
    fun getColor_ofContextCompat(@ColorRes intResColor: Int, context: Context = _context): Int =
        UtilKContextCompat.getColor( intResColor,context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainColor(@ColorRes intResColor: Int, theme: Theme?, context: Context = _context): Int =
        if (UtilKBuildVersion.isAfterV_23_6_M()) getColor_ofResources(intResColor, theme, context)
        else getColor_ofResourcesCompat(intResColor, theme)

    //////////////////////////

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColor_ofResources(@ColorRes intResColor: Int, theme: Theme?, context: Context = _context): Int =
        UtilKResources.getColor_ofApp(intResColor, theme, _context)

    @JvmStatic
    fun getColor_ofResourcesCompat(@ColorRes intResColor: Int, theme: Theme?, context: Context = _context): Int =
        UtilKResourcesCompat.getColor(UtilKResources.get_ofApp(context), intResColor, theme)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainColorStateList(@ColorRes intResColor: Int, context: Context = _context): ColorStateList? =
        if (UtilKBuildVersion.isAfterV_23_6_M()) getColorStateList_ofContext(intResColor, context)
        else getColorStateList_ofContextCompat(intResColor)

    //////////////////////////

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColorStateList_ofContext(@ColorRes intResColor: Int, context: Context = _context): ColorStateList =
        UtilKContext.getColorStateList(intResColor, context)

    @JvmStatic
    fun getColorStateList_ofResources(@ColorRes intResColor: Int, context: Context = _context): ColorStateList =
        UtilKResources.getColorStateList_ofApp(intResColor, context)

    @JvmStatic
    fun getColorStateList_ofContextCompat(@ColorRes intResColor: Int, context: Context = _context): ColorStateList? =
        UtilKContextCompat.getColorStateList( intResColor,context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainColorStateList(@ColorRes intResColor: Int, theme: Theme?, context: Context = _context): ColorStateList? =
        if (UtilKBuildVersion.isAfterV_23_6_M()) getColorStateList_ofResources(intResColor, theme, context)
        else getColorStateList_ofResourcesCompat(intResColor, theme)

    //////////////////////////

    @RequiresApi(CVersCode.V_23_6_M)
    @JvmStatic
    fun getColorStateList_ofResources(@ColorRes intResColor: Int, theme: Theme?, context: Context = _context): ColorStateList =
        UtilKResources.getColorStateList_ofApp(intResColor, theme, context)

    @JvmStatic
    fun getColorStateList_ofResourcesCompat(@ColorRes intResColor: Int, theme: Theme?, context: Context = _context): ColorStateList? =
        UtilKResourcesCompat.getColorStateList(UtilKResources.get_ofApp(context), intResColor, theme)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDrawable(@DrawableRes intResDrawable: Int, context: Context = _context): Drawable? =
        if (UtilKBuildVersion.isAfterV_21_5_L()) getDrawable_ofContext(intResDrawable, context)
        else getDrawable_ofContextCompat(intResDrawable, context)

    //////////////////////////

    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getDrawable_ofContext(@DrawableRes intResDrawable: Int, context: Context = _context): Drawable? =
        UtilKContext.getDrawable(intResDrawable, context)

    @JvmStatic
    fun getDrawable_ofResources(@DrawableRes intResDrawable: Int, context: Context = _context): Drawable =
        UtilKResources.getDrawable_ofApp(intResDrawable, context)

    @JvmStatic
    fun getDrawable_ofContextCompat(@DrawableRes intResDrawable: Int, context: Context = _context): Drawable? =
        UtilKContextCompat.getDrawable( intResDrawable,context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDrawable(@DrawableRes intResDrawable: Int, theme: Theme?, context: Context = _context): Drawable? =
        if (UtilKBuildVersion.isAfterV_21_5_L()) getDrawable_ofResources(intResDrawable, theme, context)
        else getDrawable_ofContextCompat(intResDrawable, context)

    //////////////////////////

    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getDrawable_ofResources(@DrawableRes intResDrawable: Int, theme: Theme?, context: Context = _context): Drawable =
        UtilKResources.getDrawable_ofApp(intResDrawable, theme, context)

    @JvmStatic
    fun getDrawable_ofResourcesCompact(@DrawableRes intResDrawable: Int, theme: Theme?, context: Context = _context): Drawable? =
        UtilKResourcesCompat.getDrawable(UtilKResources.get_ofApp(context), intResDrawable, theme)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDrawableForDensity(@DrawableRes intResDrawable: Int, density: Int, context: Context = _context): Drawable? =
        getDrawableForDensity_ofResources(intResDrawable, density, context)

    //////////////////////////
    @JvmStatic
    fun getDrawableForDensity_ofResources(@DrawableRes intResDrawable: Int, density: Int, context: Context = _context): Drawable? =
        UtilKResources.getDrawableForDensity_ofApp(intResDrawable, density, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDrawableForDensity(@DrawableRes intResDrawable: Int, density: Int, theme: Theme?, context: Context = _context): Drawable? =
        if (UtilKBuildVersion.isAfterV_21_5_L()) getDrawableForDensity_ofResources(intResDrawable, density, theme, context)
        else getDrawableForDensity_ofResourcesCompat(intResDrawable, density, theme, context)

    //////////////////////////

    @RequiresApi(CVersCode.V_21_5_L)
    @JvmStatic
    fun getDrawableForDensity_ofResources(@DrawableRes intResDrawable: Int, density: Int, theme: Theme?, context: Context = _context): Drawable? =
        UtilKResources.getDrawableForDensity_ofApp(intResDrawable, density, theme, context)

    @JvmStatic
    fun getDrawableForDensity_ofResourcesCompat(@DrawableRes intResDrawable: Int, density: Int, theme: Theme?, context: Context = _context): Drawable? =
        UtilKResourcesCompat.getDrawableForDensity(UtilKResources.get_ofApp(context), intResDrawable, density, theme)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainBoolean(@BoolRes intResBool: Int, context: Context = _context): Boolean =
        getBoolean_ofResources(intResBool, context)

    //////////////////////////

    @JvmStatic
    fun getBoolean_ofResources(@BoolRes intResBool: Int, context: Context = _context): Boolean =
        UtilKResources.getBoolean_ofApp(intResBool, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainInteger(@IntegerRes intResInt: Int, context: Context = _context): Int =
        getInteger_ofResources(intResInt, context)

    //////////////////////////

    @JvmStatic
    fun getInteger_ofResources(@IntegerRes intResInt: Int, context: Context = _context): Int =
        UtilKResources.getInteger_ofApp(intResInt, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainFloat(@DimenRes intResDimen: Int, context: Context = _context): Float =
        if (UtilKBuildVersion.isAfterV_29_10_Q()) getFloat_ofResources(intResDimen, context)
        else getFloat_ofResourcesCompact(intResDimen, context)

    //////////////////////////

    @JvmStatic
    @RequiresApi(CVersCode.V_29_10_Q)
    fun getFloat_ofResources(@DimenRes intResDimen: Int, context: Context = _context): Float =
        UtilKResources.getFloat_ofApp(intResDimen, context)

    @JvmStatic
    fun getFloat_ofResourcesCompact(@DimenRes intResDimen: Int, context: Context = _context): Float =
        UtilKResourcesCompat.getFloat(UtilKResources.get_ofApp(context), intResDimen)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDimensionPixelOffset(@DimenRes intResDimen: Int, context: Context = _context): Int =
        getDimensionPixelOffset_ofResources(intResDimen, context)

    //////////////////////////

    @JvmStatic
    fun getDimensionPixelOffset_ofResources(@DimenRes intResDimen: Int, context: Context = _context): Int =
        UtilKResources.getDimensionPixelOffset_ofApp(intResDimen, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDimensionPixelSize(@DimenRes intResDimen: Int, context: Context = _context): Int =
        getDimensionPixelSize_ofResources(intResDimen, context)

    @JvmStatic
    fun gainDimensionPixelSize(@DimenRes intResDimen: Int): Int =
        gainDimensionPixelSize(intResDimen, _context)

    //////////////////////////
    @JvmStatic
    fun getDimensionPixelSize_ofResources(@DimenRes intResDimen: Int, context: Context = _context): Int =
        UtilKResources.getDimensionPixelSize_ofApp(intResDimen, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainDimension(@DimenRes intResDimen: Int, context: Context = _context): Float =
        getDimension_ofResources(intResDimen, context)

    //////////////////////////
    @JvmStatic
    fun getDimension_ofResources(@DimenRes intResDimen: Int, context: Context = _context): Float =
        UtilKResources.getDimension_ofApp(intResDimen, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainIntArray(@ArrayRes intResArray: Int, context: Context = _context): IntArray =
        getIntArray_ofResources(intResArray, context)

    //////////////////////////
    @JvmStatic
    fun getIntArray_ofResources(@ArrayRes intResArray: Int, context: Context = _context): IntArray =
        UtilKResources.getIntArray_ofApp(intResArray, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainXml(@XmlRes intResXml: Int, context: Context = _context): XmlResourceParser =
        getXml_ofResources(intResXml, context)

    //////////////////////////
    @JvmStatic
    fun getXml_ofResources(@XmlRes intResXml: Int, context: Context = _context): XmlResourceParser =
        UtilKResources.getXml_ofApp(intResXml, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainAnimation(@AnimRes intResAnim: Int, context: Context = _context): XmlResourceParser =
        getAnimation_ofResources(intResAnim, context)

    //////////////////////////
    @JvmStatic
    fun getAnimation_ofResources(@AnimRes intResAnim: Int, context: Context = _context): XmlResourceParser =
        UtilKResources.getAnimation_ofApp(intResAnim, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainLayout(@LayoutRes intResLayout: Int, context: Context = _context): XmlResourceParser =
        getLayout_ofResources(intResLayout, context)

    //////////////////////////
    @JvmStatic
    fun getLayout_ofResources(@LayoutRes intResLayout: Int, context: Context = _context): XmlResourceParser =
        UtilKResources.getLayout_ofApp(intResLayout, context)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun gainFont(@FontRes intResFont: Int, context: Context = _context): Typeface? =
        if (UtilKBuildVersion.isAfterV_26_8_O()) getFont_ofResources(intResFont, context)
        else getFont_ofResourcesCompat(intResFont, context)

    //////////////////////////

    @RequiresApi(CVersCode.V_26_8_O)
    @JvmStatic
    fun getFont_ofResources(@FontRes intResFont: Int, context: Context = _context): Typeface =
        UtilKResources.getFont_ofApp(intResFont, context)

    @JvmStatic
    fun getFont_ofResourcesCompat(@FontRes intResFont: Int, context: Context = _context): Typeface? =
        UtilKResourcesCompat.getFont( intResFont,context)
}