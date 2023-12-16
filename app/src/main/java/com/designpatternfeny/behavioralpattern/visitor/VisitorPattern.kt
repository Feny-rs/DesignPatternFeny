package com.designpatternfeny.behavioralpattern.visitor

// Element interface
interface ViewElement {
    fun accept(visitor: Visitor)
}

// Concrete Elements
class Button : ViewElement {
    override fun accept(visitor: Visitor) {
        visitor.visitButton(this)
    }

    // Additional methods and properties specific to Button...
}

class TextView : ViewElement {
    override fun accept(visitor: Visitor) {
        visitor.visitTextView(this)
    }

    // Additional methods and properties specific to TextView...
}

// Visitor interface
interface Visitor {
    fun visitButton(button: Button)
    fun visitTextView(textView: TextView)
}

// Concrete Visitor
class HighlightVisitor : Visitor {
    override fun visitButton(button: Button) {
        println("Highlighting Button")
        // Implement highlighting logic for Button...
    }

    override fun visitTextView(textView: TextView) {
        println("Highlighting TextView")
        // Implement highlighting logic for TextView...
    }
}

// Client (Usage)
fun main() {
    val elements: List<ViewElement> = listOf(Button(), TextView())
    val highlightVisitor = HighlightVisitor()

    for (element in elements) {
        element.accept(highlightVisitor)
    }
}