package com.designpatternfeny.structuralpattern.proxy

// Subject Interface
interface Server {
    fun request(): String
}

// RealSubject
class RealServer : Server {
    override fun request(): String {
        return "RealServer: Handling the request"
    }
}

// Proxy
class ProxyServer(private val realServer: RealServer) : Server {
    override fun request(): String {
        // Additional access control logic can be added here
        return "ProxyServer: ${realServer.request()}"
    }
}

// Client (Usage)
fun main() {
    val realServer = RealServer()
    val proxyServer = ProxyServer(realServer)

    // The proxy adds additional access control logic
    val result = proxyServer.request()
    println(result)
}