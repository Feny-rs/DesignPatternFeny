package com.designpatternfeny.behavioralpattern.command

// Command Interface
interface Command {
    fun execute()
}

// Concrete Commands
class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// Receiver
class Light {
    fun turnOn() {
        println("Light is ON")
    }

    fun turnOff() {
        println("Light is OFF")
    }
}

// Invoker
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

// Client (Usage)
fun main() {
    val light = Light()

    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)

    val remoteControl = RemoteControl()

    remoteControl.setCommand(lightOnCommand)
    remoteControl.pressButton()

    remoteControl.setCommand(lightOffCommand)
    remoteControl.pressButton()
}