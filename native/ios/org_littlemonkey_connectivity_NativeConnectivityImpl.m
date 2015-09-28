#import "org_littlemonkey_connectivity_NativeConnectivityImpl.h"
#import "Reachability.h"
@implementation org_littlemonkey_connectivity_NativeConnectivityImpl

-(int)getConnectionStatus{
 Reachability *reachability = [Reachability reachabilityForInternetConnection];


NetworkStatus status = [reachability currentReachabilityStatus];

if (status == ReachableViaWiFi)
{
    return 2;
}
else if (status == ReachableViaWWAN) 
{
   return 1;
}
return 0;
}

-(BOOL)isSupported{
    return YES;
}

@end
