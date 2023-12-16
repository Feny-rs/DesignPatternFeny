package com.designpatternfeny.behavioralpattern.chainofresponsibility

// Handler Interface
interface ClickHandler {
    fun handleClick(): Boolean
}

// Concrete Handlers
class ButtonClickHandler : ClickHandler {
    override fun handleClick(): Boolean {
        println("Button Clicked")
        return false // Handling complete, stop propagation
    }
}

class DialogClickHandler : ClickHandler {
    private var nextHandler: ClickHandler? = null

    fun setNextHandler(handler: ClickHandler) {
        nextHandler = handler
    }

    override fun handleClick(): Boolean {
        println("Dialog Clicked")
        // Try to handle, otherwise propagate to the next handler
        return nextHandler?.handleClick() ?: false
    }
}

class ActivityClickHandler : ClickHandler {
    private var nextHandler: ClickHandler? = null

    fun setNextHandler(handler: ClickHandler) {
        nextHandler = handler
    }

    override fun handleClick(): Boolean {
        println("Activity Clicked")
        // Try to handle, otherwise propagate to the next handler
        return nextHandler?.handleClick() ?: false
    }
}

// Client (Usage)
fun main() {
    val buttonHandler = ButtonClickHandler()
    val dialogHandler = DialogClickHandler()
    val activityHandler = ActivityClickHandler()

    // Set the chain of responsibility
    dialogHandler.setNextHandler(activityHandler)

    // Handling the click event
    val clickHandled = buttonHandler.handleClick()

    if (!clickHandled) {
        println("Click event not handled by any handler.")
    }
}