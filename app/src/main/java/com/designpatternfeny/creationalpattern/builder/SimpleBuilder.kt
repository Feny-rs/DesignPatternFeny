package com.designpatternfeny.creationalpattern.builder

data class Person(
    val name: String,
    val age: Int,
    val address: String,
    val email: String
)

class PersonBuilder(
    var name: String = "",
    var age: Int = 0,
    var address: String? = null,
    var email: String? = null) {
    fun build(): Person {
        return Person(name, age, address ?: "", email ?: "")
    }
}

fun main() {
    val person = PersonBuilder().apply {
        name = "Feny"
        age = 24
        address = "World"
        email = "feny@teknologi.ai"
        }
        .build()
    println(person)
}