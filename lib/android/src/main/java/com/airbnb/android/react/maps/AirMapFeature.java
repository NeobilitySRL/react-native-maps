package com.airbnb.android.react.maps;

import android.content.Context;

import com.facebook.react.views.view.ReactViewGroup;
import com.huawei.hms.maps.HuaweiMap;

public abstract class AirMapFeature extends ReactViewGroup {
  public AirMapFeature(Context context) {
    super(context);
  }

  public abstract void addToMap(HuaweiMap map);

  public abstract void removeFromMap(HuaweiMap map);

  public abstract Object getFeature();
}
