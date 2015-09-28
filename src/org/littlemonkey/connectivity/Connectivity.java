/**
The MIT License (MIT)
Copyright (c) 2014 LittleMonkey Ltd.
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package org.littlemonkey.connectivity;

import com.codename1.system.NativeInterface;
import com.codename1.system.NativeLookup;

/**
 *
 * @author nick
 */
public class Connectivity {

    static NativeConnectivity connectionManager;

    public enum ConnectionState {
        DISCONNECTED,
        WIFI,
        MOBILE
    };

    public static boolean isConnected() {
        return getConnectionState() != ConnectionState.DISCONNECTED;
    }

    public static ConnectionState getConnectionState() {
        int status = getConnectionManager().getConnectionStatus();
        switch(status) {
            case 0:
            default:
                return ConnectionState.DISCONNECTED;
            case 1:
                return ConnectionState.MOBILE;
            case 2:
                return ConnectionState.WIFI;
        }
    }

    private static NativeConnectivity getConnectionManager() {
        if (connectionManager == null) {
            try {
                NativeInterface ni = NativeLookup.create(NativeConnectivity.class);
                if (ni != null) {
                    connectionManager = (NativeConnectivity) ni;
                }
            } catch (Exception e) {

            }
        }
        if (connectionManager == null || !connectionManager.isSupported()) {
            connectionManager = new SimulatorConnectionManager();
        }
        return connectionManager;
    }

}
