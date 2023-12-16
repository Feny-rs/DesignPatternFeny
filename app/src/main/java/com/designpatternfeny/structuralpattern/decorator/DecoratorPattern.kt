package com.designpatternfeny.structuralpattern.decorator

// Component Interface
interface TextView {
    fun draw(): String
}

// Concrete Component
class SimpleTextView : TextView {
    override fun draw(): String {
        return "Simple Text"
    }
}

// Decorator
abstract class TextViewDecorator(private val decoratedTextView: TextView) : TextView {
    override fun draw(): String {
        return decoratedTextView.draw()
    }
}

// Concrete Decorator
class ColoredTextViewDecorator(decoratedTextView: TextView, private val color: String) : TextViewDecorator(decoratedTextView) {
    override fun draw(): String {
        val originalText = super.draw()
        return "Colored ($color) $originalText"
    }
}

// Concrete Decorator
class BoldTextViewDecorator(decoratedTextView: TextView) : TextViewDecorator(decoratedTextView) {
    override fun draw(): String {
        val originalText = super.draw()
        return "Bold $originalText"
    }
}

// Client
fun main() {
    // Creating a simple text view
    val simpleTextView: TextView = SimpleTextView()

    // Decorating the simple text view with color and bold decorators
    val coloredBoldTextView: TextView = ColoredTextViewDecorator(BoldTextViewDecorator(simpleTextView), "#FFFFF")

    // Displaying the result
    println("Simple Text View: ${simpleTextView.draw()}")
    println("Colored Bold Text View: ${coloredBoldTextView.draw()}")
}