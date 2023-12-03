package com.deviceadmin;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = DeviceAdminModule.NAME)
public class DeviceAdminModule extends ReactContextBaseJavaModule {

  public static final String NAME = "DeviceAdmin";

  public DeviceAdminModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void disableDeviceAdmin() {
    DeviceAdminReceiverImpl.disableDeviceAdmin(getReactApplicationContext());
  }

  @ReactMethod
  public void isAdminActive() {
    boolean isActive = DeviceAdminReceiverImpl.isAdminActive(
      getReactApplicationContext()
    );

    getReactApplicationContext()
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit("isAdminActive", isActive);
  }
}
