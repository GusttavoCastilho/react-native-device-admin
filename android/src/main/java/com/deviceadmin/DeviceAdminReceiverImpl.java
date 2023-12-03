package com.deviceadmin;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class DeviceAdminReceiverImpl extends DeviceAdminReceiver {

  @Override
  public void onDisabled(Context context, Intent intent) {
    super.onDisabled(context, intent);
    DevicePolicyManager mDPM = (DevicePolicyManager) context.getSystemService(
      Context.DEVICE_POLICY_SERVICE
    );
    ComponentName mDeviceAdmin = new ComponentName(
      context,
      DeviceAdminReceiverImpl.class
    );
    mDPM.removeActiveAdmin(mDeviceAdmin);
  }

  public static ComponentName getComponentName(Context context) {
    return new ComponentName(
      context.getApplicationContext(),
      DeviceAdminReceiverImpl.class
    );
  }

  public static void disableDeviceAdmin(Context context) {
    DevicePolicyManager mDPM = (DevicePolicyManager) context.getSystemService(
      Context.DEVICE_POLICY_SERVICE
    );
    ComponentName mDeviceAdmin = new ComponentName(
      context,
      DeviceAdminReceiverImpl.class
    );
    mDPM.removeActiveAdmin(mDeviceAdmin);
  }

  public static boolean isAdminActive(Context context) {
    DevicePolicyManager mDPM = (DevicePolicyManager) context.getSystemService(
      Context.DEVICE_POLICY_SERVICE
    );
    ComponentName mDeviceAdmin = new ComponentName(
      context,
      DeviceAdminReceiverImpl.class
    );
    return mDPM.isAdminActive(mDeviceAdmin);
  }
}
