package com.designpatternfeny.creationalpattern.prototype

interface Prototype {
    fun clone(): Prototype
}

data class ConcretePrototype(
    var property1: String,
    var property2: Int,
    var property3: List<String>
) : Prototype {
    override fun clone(): Prototype {
        return ConcretePrototype(property1, property2, property3.toMutableList())
    }
}

fun main() {
    val prototype = ConcretePrototype("Value1", 1, mutableListOf("Item1, Item2, Item3"))

    val copy1 = prototype.clone() as ConcretePrototype
    val copy2 = prototype.clone() as ConcretePrototype

    copy1.property1 = "Value2"
    copy2.property2 = 2
    println(copy1)
    println(copy2)
}