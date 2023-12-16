package com.designpatternfeny.structuralpattern.proxy

// RealSubject
class RealImage(private val filename: String) {
    init {
        loadFromDisk()
    }

    fun display() {
        println("Displaying image '$filename'")
    }

    private fun loadFromDisk() {
        println("Loading image '$filename' from disk")
    }
}

// Proxy
class ImageProxy(private val filename: String) {
    private var realImage: RealImage? = null

    fun display() {
        if (realImage == null) {
            realImage = RealImage(filename)
        }
        realImage?.display()
    }
}

// Client (Usage)
fun main() {
    val imageProxy = ImageProxy("sample.jpg")

    // The real image is not loaded until display() is called
    imageProxy.display()

    // The real image is already loaded, so this won't reload it
    imageProxy.display()
}