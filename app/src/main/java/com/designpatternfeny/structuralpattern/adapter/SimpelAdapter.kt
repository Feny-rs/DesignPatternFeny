package com.designpatternfeny.structuralpattern.adapter

// Target Interface
interface Target {
    fun request(): String
}

// Adaptee (Existing class with incompatible interface)
class Adaptee {
    fun specificRequest(): String {
        return "Specific request from Adaptee"
    }
}

// Adapter
class Adapter(private val adaptee: Adaptee) : Target {
    override fun request(): String {
        // Using the existing method of Adaptee
        return "Adapter: ${adaptee.specificRequest()}"
    }
}

// Client
fun main() {
    // Using the Adapter to make the Adaptee compatible with Target
    val adaptee = Adaptee()
    val adapter = Adapter(adaptee)

    // Now calling the Target interface through the Adapter
    println("Using Adapter: ${adapter.request()}")
}
