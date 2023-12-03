
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNDeviceAdminSpec.h"

@interface DeviceAdmin : NSObject <NativeDeviceAdminSpec>
#else
#import <React/RCTBridgeModule.h>

@interface DeviceAdmin : NSObject <RCTBridgeModule>
#endif

@end
