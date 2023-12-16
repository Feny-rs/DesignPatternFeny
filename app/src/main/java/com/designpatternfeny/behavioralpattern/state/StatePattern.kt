package com.designpatternfeny.behavioralpattern.state

// State interface
interface TrafficLightState {
    fun handleRequest(trafficLight: TrafficLight)
}

// Concrete States
class RedState : TrafficLightState {
    override fun handleRequest(trafficLight: TrafficLight) {
        println("Red Light")
        trafficLight.currentState = GreenState()
    }
}

class GreenState : TrafficLightState {
    override fun handleRequest(trafficLight: TrafficLight) {
        println("Green Light")
        trafficLight.currentState = YellowState()
    }
}

class YellowState : TrafficLightState {
    override fun handleRequest(trafficLight: TrafficLight) {
        println("Yellow Light")
        trafficLight.currentState = RedState()
    }
}

// Context
class TrafficLight(var currentState: TrafficLightState = RedState()) {
    fun changeState() {
        currentState.handleRequest(this)
    }
}

// Client (Usage)
fun main() {
    val trafficLight = TrafficLight()

    // Simulate traffic light changes
    trafficLight.changeState()  // Red
    trafficLight.changeState()  // Green
    trafficLight.changeState()  // Yellow
    trafficLight.changeState()  // Red
}