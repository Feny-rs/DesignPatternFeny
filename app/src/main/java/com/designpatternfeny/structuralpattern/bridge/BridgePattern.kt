package com.designpatternfeny.structuralpattern.bridge

// Abstraction
abstract class Shape(protected val color: Color) {
    abstract fun draw(): String
}

// Refined Abstractions
class Circle(color: Color) : Shape(color) {
    override fun draw(): String {
        return "Drawing Circle with ${color.fillColor()}"
    }
}

class Square(color: Color) : Shape(color) {
    override fun draw(): String {
        return "Drawing Square with ${color.fillColor()}"
    }
}

// Implementor
interface Color {
    fun fillColor(): String
}

// Concrete Implementors
class RedColor : Color {
    override fun fillColor(): String {
        return "Red Color"
    }
}

class BlueColor : Color {
    override fun fillColor(): String {
        return "Blue Color"
    }
}

// Client
fun main() {
    val redCircle: Shape = Circle(RedColor())
    val blueSquare: Shape = Square(BlueColor())

    println(redCircle.draw())
    println(blueSquare.draw())
}