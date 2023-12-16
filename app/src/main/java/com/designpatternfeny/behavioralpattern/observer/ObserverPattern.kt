package com.designpatternfeny.behavioralpattern.observer

import java.util.*

// Subject
class DataSubject : Observable() {
    private var data: Int = 0

    fun setData(newValue: Int) {
        data = newValue
        setChanged()
        notifyObservers(data)
    }

    fun getData(): Int {
        return data
    }
}

// Observer
class DataObserver : Observer {
    override fun update(o: Observable?, arg: Any?) {
        if (o is DataSubject) {
            val newData = arg as Int
            println("DataObserver: Received update. New data value: $newData")
        }
    }
}

// Client (Usage)
fun main() {
    val dataSubject = DataSubject()
    val dataObserver = DataObserver()

    // Register observer
    dataSubject.addObserver(dataObserver)

    // Set new data value, and observer will be notified
    dataSubject.setData(42)

    // Unregister observer
    dataSubject.deleteObserver(dataObserver)

    // No notification after unregistering
    dataSubject.setData(99)
}