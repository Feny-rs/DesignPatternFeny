package com.designpatternfeny.behavioralpattern.templatemethod

// Template Method Pattern
abstract class BaseActivity {

    // Metode templat untuk siklus hidup
    fun performActivity() {
        onCreate()
        onStart()
        onResume()
        // ... other lifecycle methods ...
        onPause()
        onStop()
        onDestroy()
    }

    // Metode yang dapat dioverride oleh subkelas
    open fun onCreate() {
        println("BaseActivity: onCreate")
    }

    open fun onStart() {
        println("BaseActivity: onStart")
    }

    open fun onResume() {
        println("BaseActivity: onResume")
    }

    open fun onPause() {
        println("BaseActivity: onPause")
    }

    open fun onStop() {
        println("BaseActivity: onStop")
    }

    open fun onDestroy() {
        println("BaseActivity: onDestroy")
    }
}

// Subkelas pertama
class MainActivity : BaseActivity() {
    override fun onCreate() {
        super.onCreate()
        println("MainActivity: Custom onCreate")
    }
}

// Subkelas kedua
class SecondActivity : BaseActivity() {
    override fun onResume() {
        super.onResume()
        println("SecondActivity: Custom onResume")
    }
}

// Client (Usage)
fun main() {
    val mainActivity = MainActivity()
    mainActivity.performActivity()

    println("\n")

    val secondActivity = SecondActivity()
    secondActivity.performActivity()
}