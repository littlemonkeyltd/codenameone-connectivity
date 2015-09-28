(function(exports){

var o = {};

    o.getConnectionStatus_ = function(callback) {
        callback.error(new Error("Not implemented yet"));
    };

    o.isSupported_ = function(callback) {
        callback.complete(false);
    };

exports.org_littlemonkey_connectivity_NativeConnectivity= o;

})(cn1_get_native_interfaces());
