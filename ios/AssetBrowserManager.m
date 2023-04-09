// AssetBrowserManager.m
#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(AssetBrowserManager, NSObject)

RCT_EXTERN_METHOD(show:(NSDictionary *)props)

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}

@end
