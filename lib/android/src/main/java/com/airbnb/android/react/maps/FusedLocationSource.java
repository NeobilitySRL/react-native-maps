package com.airbnb.android.react.maps;

import android.content.Context;
import android.location.Location;
import android.os.Looper;

import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.maps.LocationSource;

public class FusedLocationSource implements LocationSource {

    private final FusedLocationProviderClient fusedLocationClientProviderClient;
    private final LocationRequest locationRequest;
    private LocationCallback locationCallback;

    public FusedLocationSource(Context context){
        fusedLocationClientProviderClient =
                LocationServices.getFusedLocationProviderClient(context);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
    }

    public void setPriority(int priority){
        locationRequest.setPriority(priority);
    }

    public void setInterval(int interval){
        locationRequest.setInterval(interval);
    }

    public void setFastestInterval(int fastestInterval){
        locationRequest.setFastestInterval(fastestInterval);
    }

    @Override
    public void activate(final OnLocationChangedListener onLocationChangedListener) {
        fusedLocationClientProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    onLocationChangedListener.onLocationChanged(location);
                }
            }
        });
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                for (Location location : locationResult.getLocations()) {
                    onLocationChangedListener.onLocationChanged(location);
                }
            }
        };
        fusedLocationClientProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
    }

    @Override
    public void deactivate() {
        fusedLocationClientProviderClient.removeLocationUpdates(locationCallback);
    }
}
