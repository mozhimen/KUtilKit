package com.mozhimen.kotlin.utilk.android.location

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.mozhimen.kotlin.elemk.android.location.cons.CLocationManager
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_COARSE_LOCATION
import com.mozhimen.kotlin.lintk.optins.permission.OPermission_ACCESS_FINE_LOCATION
import com.mozhimen.kotlin.elemk.android.cons.CPermission
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
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
        UtilKContext.getLocationManager(context)

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun getLastKnownLocation(context: Context, provider: String): Location? =
        get(context).getLastKnownLocation(provider)

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun getLastKnownLocation_ofGps(context: Context): Location? =
        getLastKnownLocation(context, CLocationManager.GPS_PROVIDER)

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun getLastKnownLocation_ofNetwork(context: Context): Location? =
        getLastKnownLocation(context, CLocationManager.NETWORK_PROVIDER)

    @JvmStatic
    fun getProviders(context: Context, enableOnly: Boolean): List<String> =
        get(context).getProviders(enableOnly)

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    fun isProviderEnabled(context: Context, provider: String): Boolean =
        get(context).isProviderEnabled(provider)

    @JvmStatic
    fun isProviderEnabled_ofGps(context: Context): Boolean =
        isProviderEnabled(context, CLocationManager.GPS_PROVIDER).also { "isProviderEnabledGps $it".d(TAG) }

    @JvmStatic
    fun isProviderEnabled_ofNetwork(context: Context): Boolean =
        isProviderEnabled(context, CLocationManager.NETWORK_PROVIDER).also { "isProviderEnabledNetwork $it".d(TAG) }

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates(context: Context, provider: String, minTimeMs: Long, minDistanceM: Float, listener: LocationListener) {
        get(context).requestLocationUpdates(provider, minTimeMs, minDistanceM, listener)
    }

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates(context: Context, provider: String, minTimeMs: Long, minDistanceM: Float, listener: LocationListener, looper: Looper) {
        get(context).requestLocationUpdates(provider, minTimeMs, minDistanceM, listener, looper)
    }

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates_ofNetwork(context: Context, minTimeMs: Long, minDistanceM: Float, listener: LocationListener) {
        requestLocationUpdates(context, CLocationManager.NETWORK_PROVIDER, minTimeMs, minDistanceM, listener)
    }

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun requestLocationUpdates_ofNetwork(context: Context, minTimeMs: Long, minDistanceM: Float, listener: LocationListener, looper: Looper) {
        requestLocationUpdates(context, CLocationManager.NETWORK_PROVIDER, minTimeMs, minDistanceM, listener, looper)
    }

    /////////////////////////////////////////////////////////////////////

    @JvmStatic
    @OPermission_ACCESS_COARSE_LOCATION
    @OPermission_ACCESS_FINE_LOCATION
    @RequiresPermission(allOf = [CPermission.ACCESS_COARSE_LOCATION, CPermission.ACCESS_FINE_LOCATION])
    fun removeUpdates(context: Context, listener: LocationListener) {
        get(context).removeUpdates(listener)
    }
}