# codenameone-connectivity
Simple library for getting basic connection information on codename one

## Installation
Just install as any other cn1lib, copy the file to the libs folder of your project and refresh libs.
If the build hints don't merge automatically these are the lines to add to codename_settings.properties

```
codename1.arg.android.xpermissions=<uses-permission android\:name\="android.permission.ACCESS_NETWORK_STATE"/>
codename1.arg.ios.add_libs=SystemConfiguration.framework
```

## Usage
There are only two methods here is an example of each

Check for any connection
```
if (Connectivity.isConnected()) {
    //we have some connection
} else {
    // we have no connection
}
```

Check what type of connection
```
        ConnectionState status = Connectivity.getConnectionState();
        switch (status) {
            case DISCONNECTED:
                Log.p("Disconnected");
                break;
            case WIFI:
                Log.p("On Wifi");
                break;
            case MOBILE:
                Log.p("On Mobile Data");
                break;
            default:
                //shouldn't be possible

        }
```

## Note
This doesn't mean you can connect to a particular host, but helps check that a connection is available and lets you provide friendly messages to the user before attempting connection requests.  Also you can use the connection type to warn about large downloads over mobile data etc.,

On Android and iOS uses native code to check and return the values.  On other platforms including the simulator it just makes a connection request to NetworkManager.getAutoDetectURL().  On platforms other than iOS and Android Connectivity.getConnectionState() will only return DISCONNECTED or WIFI.  WIFI means connected regardless of connection method.
