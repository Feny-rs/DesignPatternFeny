package com.designpatternfeny.behavioralpattern.mediator

// Mediator interface
interface UIControlMediator {
    fun notify(sender: UIControl, event: String)
}

// Colleague interface
interface UIControl {
    fun setMediator(mediator: UIControlMediator)
}

// Concrete Mediator
class UIComponentMediator : UIControlMediator {
    private lateinit var button: Button
    private lateinit var textView: TextView

    fun setButton(button: Button) {
        this.button = button
    }

    fun setTextView(textView: TextView) {
        this.textView = textView
    }

    override fun notify(sender: UIControl, event: String) {
        when (sender) {
            is Button -> {
                println("Button clicked, updating TextView")
                textView.displayText("Button clicked!")
            }
            // Handle other UI events if needed
        }
    }
}

// Concrete Colleagues
class Button : UIControl {
    private lateinit var mediator: UIControlMediator

    override fun setMediator(mediator: UIControlMediator) {
        this.mediator = mediator
    }

    fun click() {
        println("Button clicked, notifying mediator")
        mediator.notify(this, "click")
    }
}

class TextView : UIControl {
    private lateinit var mediator: UIControlMediator

    override fun setMediator(mediator: UIControlMediator) {
        this.mediator = mediator
    }

    fun displayText(text: String) {
        println("TextView: $text")
    }
}

// Client (Usage)
fun main() {
    val mediator = UIComponentMediator()

    val button = Button()
    val textView = TextView()

    button.setMediator(mediator)
    textView.setMediator(mediator)

    mediator.setButton(button)
    mediator.setTextView(textView)

    // Simulate a button click
    button.click()
}