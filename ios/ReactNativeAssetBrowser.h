
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNReactNativeAssetBrowserSpec.h"

@interface ReactNativeAssetBrowser : NSObject <NativeReactNativeAssetBrowserSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ReactNativeAssetBrowser : NSObject <RCTBridgeModule>
#endif

@end
