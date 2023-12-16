package com.designpatternfeny.creationalpattern.singleton


//with no argument
object JustSingleton {
    init {
        println("This is just singleton")
    }

    fun doSomething() {
        println("what just happened?")
    }
}

//fun main() {
//    JustSingleton.doSomething()
//    JustSingleton.doSomething() //Singleton only have single initialisation
//}

//with argument
class Singleton private constructor(private val nameValue: String) {
    init {
        println("Hello $nameValue")
    }

    fun getName(): String {
        return "Feny"
    }

    companion object {
        private var instance: Singleton? = null

        fun getInstance(nameValue: String): Singleton {
            return instance ?: synchronized(this) {
                instance ?: Singleton(nameValue).also {
                    instance = it
                }
            }
        }
    }
}

fun main() {
    //using singleton with argument
    val configName = Singleton.getInstance("CO-WOODZ")
    println("Config name from singleton : ${configName.getName()}")

    val configAgain = Singleton.getInstance("COCO")
}
