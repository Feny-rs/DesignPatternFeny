package com.designpatternfeny.behavioralpattern.memento

// Memento
data class TextEditorMemento(val text: String)

// Originator
class TextEditor(var text: String) {
    fun createMemento(): TextEditorMemento {
        return TextEditorMemento(text)
    }

    fun restoreMemento(memento: TextEditorMemento) {
        text = memento.text
    }

    fun displayText() {
        println("Current Text: $text")
    }
}

// Caretaker
class History {
    private val mementos = mutableListOf<TextEditorMemento>()

    fun saveMemento(memento: TextEditorMemento) {
        mementos.add(memento)
    }

    fun getMemento(index: Int): TextEditorMemento? {
        return mementos.getOrNull(index)
    }
}

// Client (Usage)
fun main() {
    val textEditor = TextEditor("Hello, World!")
    val history = History()

    // Save the initial state
    val initialState = textEditor.createMemento()
    history.saveMemento(initialState)

    // Modify the text
    textEditor.text = "New Text"
    textEditor.displayText()

    // Save the modified state
    val modifiedState = textEditor.createMemento()
    history.saveMemento(modifiedState)

    // Restore the initial state
    val restoredState = history.getMemento(0)
    restoredState?.let {
        textEditor.restoreMemento(it)
        textEditor.displayText()
    }
}