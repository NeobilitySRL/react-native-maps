package com.airbnb.android.react.maps;

import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Tile;
import com.huawei.hms.maps.model.TileProvider;

public final class CompatUtils {
    public static com.google.android.gms.maps.model.LatLng convertLatLng(LatLng latLng) {
        return new com.google.android.gms.maps.model.LatLng(latLng.latitude, latLng.longitude);
    }

    public static LatLng convertLatLng(com.google.android.gms.maps.model.LatLng latLng) {
        return new LatLng(latLng.latitude, latLng.longitude);
    }

    public static TileProvider convertTileProvider(final com.google.android.gms.maps.model.TileProvider tileProvider) {
        return new TileProvider() {
            @Override
            public Tile getTile(int i, int i1, int i2) {
                com.google.android.gms.maps.model.Tile tile = tileProvider.getTile(i, i1, i2);
                return new Tile(tile.width, tile.height, tile.data);
            }
        };
    }
}
