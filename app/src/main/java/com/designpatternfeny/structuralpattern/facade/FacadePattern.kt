package com.designpatternfeny.structuralpattern.facade

// Subsystem 1
class Camera {
    fun turnOn() {
        println("Camera: Turning on")
    }

    fun takePicture() {
        println("Camera: Taking a picture")
    }

    fun turnOff() {
        println("Camera: Turning off")
    }
}

// Subsystem 2
class GPS {
    fun enable() {
        println("GPS: Enabling")
    }

    fun getCurrentLocation(): String {
        return "GPS: Current location is (latitude, longitude)"
    }

    fun disable() {
        println("GPS: Disabling")
    }
}

// Subsystem 3
class Sensor {
    fun start() {
        println("Sensor: Starting")
    }

    fun measure() {
        println("Sensor: Measuring")
    }

    fun stop() {
        println("Sensor: Stopping")
    }
}

// Facade
class MobilePhoneFacade(
    private val camera: Camera,
    private val gps: GPS,
    private val sensor: Sensor
) {
    fun takePictureWithLocation() {
        camera.turnOn()
        gps.enable()
        sensor.start()

        val location = gps.getCurrentLocation()
        println("Capturing picture with location: $location")

        sensor.stop()
        gps.disable()
        camera.turnOff()
    }
}

// Client (Usage)
fun main() {
    val camera = Camera()
    val gps = GPS()
    val sensor = Sensor()

    val mobilePhone = MobilePhoneFacade(camera, gps, sensor)

    mobilePhone.takePictureWithLocation()
}