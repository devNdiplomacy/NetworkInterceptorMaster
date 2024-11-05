package com.devndiplomacy.networkinterceptormaster

import android.util.Log
import okhttp3.Call
import okhttp3.Connection
import okhttp3.EventListener
import okhttp3.Handshake
import okhttp3.Protocol
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy

class CustomOkhttpEventListener: EventListener() {

    private val TAG = javaClass.simpleName

    override fun connectStart(call: Call, inetSocketAddress: InetSocketAddress, proxy: Proxy) {
        super.connectStart(call, inetSocketAddress, proxy)
        Log.d(
            TAG,
            "connectStart() called with: call = $call, inetSocketAddress = $inetSocketAddress, proxy = $proxy"
        )
    }

    override fun connectEnd(
        call: Call,
        inetSocketAddress: InetSocketAddress,
        proxy: Proxy,
        protocol: Protocol?
    ) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol)
        Log.d(
            TAG,
            "connectEnd() called with: call = $call, inetSocketAddress = $inetSocketAddress, proxy = $proxy, protocol = $protocol"
        )
    }

    override fun secureConnectStart(call: Call) {
        super.secureConnectStart(call)
        Log.d(TAG, "secureConnectStart() called with: call = $call")
    }

    override fun secureConnectEnd(call: Call, handshake: Handshake?) {
        super.secureConnectEnd(call, handshake)
        Log.d(TAG, "secureConnectEnd() called with: call = $call, handshake = $handshake")
    }

    override fun connectionAcquired(call: Call, connection: Connection) {
        super.connectionAcquired(call, connection)
        Log.d(TAG, "connectionAcquired() called with: call = $call, connection = $connection")
    }

    override fun connectFailed(
        call: Call,
        inetSocketAddress: InetSocketAddress,
        proxy: Proxy,
        protocol: Protocol?,
        ioe: IOException
    ) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe)
        Log.d(
            TAG,
            "connectFailed() called with: call = $call, inetSocketAddress = $inetSocketAddress, proxy = $proxy, protocol = $protocol, ioe = $ioe"
        )
    }

    override fun connectionReleased(call: Call, connection: Connection) {
        super.connectionReleased(call, connection)
        Log.d(TAG, "connectionReleased() called with: call = $call, connection = $connection")
    }
}