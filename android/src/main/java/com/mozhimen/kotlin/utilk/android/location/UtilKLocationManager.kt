package com.mozhimen.kotlin.utilk.android.location

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.location.cons.CLocationManager
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_COARSE_LOCATION
import com.mozhimen.kotlin.lintk.optins.manifest.uses_permission.OUsesPermission_ACCESS_FINE_LOCATION
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContextGet
import com.mozhimen.kotlin.utilk.android.util.d
import com.mozhimen.kotlin.utilk.commons.IUtilK


/**
 * @ClassName UtilKLocationManager
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2023/8/15 16:03
 * @Version 1.0
 */
object UtilKLocationManager : IUtilK {
    @JvmStatic
    fun get(context: Context): LocationManager =
        UtilKContextGet.getSystemService_LOCATION(context)

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun getLastKnownLocation(provider: String, context: Context): Location? =
        get(context).getLastKnownLocation(provider)

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun getLastKnownLocation_ofGps(context: Context): Location? =
        getLastKnownLocation(CLocationManager.GPS_PROVIDER, context)

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun getLastKnownLocation_ofNetwork(context: Context): Location? =
        getLastKnownLocation(CLocationManager.NETWORK_PROVIDER, context)

    @JvmStatic
    fun getProviders(enableOnly: Boolean, context: Context): List<String> =
        get(context).getProviders(enableOnly)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isProviderEnabled(provider: String, context: Context): Boolean =
        get(context).isProviderEnabled(provider)

    @JvmStatic
    fun isProviderEnabled_ofGps(context: Context): Boolean =
        isProviderEnabled(CLocationManager.GPS_PROVIDER, context).also { "isProviderEnabledGps $it".d(TAG) }

    @JvmStatic
    fun isProviderEnabled_ofNetwork(context: Context): Boolean =
        isProviderEnabled(CLocationManager.NETWORK_PROVIDER, context).also { "isProviderEnabledNetwork $it".d(TAG) }

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates(provider: String, minTimeMs: Long, minDistanceM: Float, context: Context, listener: LocationListener) {
        get(context).requestLocationUpdates(provider, minTimeMs, minDistanceM, listener)
    }

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates(provider: String, minTimeMs: Long, minDistanceM: Float, looper: Looper, context: Context, listener: LocationListener) {
        get(context).requestLocationUpdates(provider, minTimeMs, minDistanceM, listener, looper)
    }

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates_ofNetwork(minTimeMs: Long, minDistanceM: Float, context: Context, listener: LocationListener) {
        requestLocationUpdates(CLocationManager.NETWORK_PROVIDER, minTimeMs, minDistanceM, context, listener)
    }

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates_ofNetwork(minTimeMs: Long, minDistanceM: Float, looper: Looper, context: Context, listener: LocationListener) {
        requestLocationUpdates(CLocationManager.NETWORK_PROVIDER, minTimeMs, minDistanceM, looper, context, listener)
    }

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OUsesPermission_ACCESS_COARSE_LOCATION
    @OUsesPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun removeUpdates(listener: LocationListener, context: Context) {
        get(context).removeUpdates(listener)
    }
}