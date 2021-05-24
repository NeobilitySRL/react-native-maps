package com.airbnb.android.react.maps;

import com.facebook.react.bridge.ReactApplicationContext;
import com.huawei.hms.maps.HuaweiMapOptions;

public class AirMapLiteManager extends AirMapManager {

  private static final String REACT_CLASS = "AIRMapLite";

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  public AirMapLiteManager(ReactApplicationContext context) {
    super(context);
    this.googleMapOptions = new HuaweiMapOptions().liteMode(true);
  }

}
