package com.designpatternfeny.creationalpattern.factorypattern

/**
 * Abstract factory can make a family or relations
 */

//Abstract Product 1
interface Transport {
    fun choose()
}

class Land: Transport {
    override fun choose() {
        println("Choose the car please")
    }
}

class Water: Transport {
    override fun choose() {
        println("Choose the ship please")
    }
}

class Air: Transport {
    override fun choose() {
        println("Choose the plan please")
    }
}

//Abstract product 2
interface Color {
    fun select()
}

class BlackColor: Color {
    override fun select() {
        println("Your transportation is black")
    }
}

class WhiteColor: Color {
    override fun select() {
        println("Your transportation is white")
    }
}

//Abstract Factory
interface AbstractFactory {
    fun chooseTransportation(): Transport
    fun selectTransportationColor(): Color
}

//Concrete factory 1
class LandTransportFactory: AbstractFactory {
    override fun chooseTransportation(): Transport {
        return Land()
    }

    override fun selectTransportationColor(): Color {
        return BlackColor()
    }
}

class WaterTransportFactory: AbstractFactory {
    override fun chooseTransportation(): Transport {
        return Water()
    }

    override fun selectTransportationColor(): Color {
        return WhiteColor()
    }
}

class AirTransportFactory: AbstractFactory {
    override fun chooseTransportation(): Transport {
        return Air()
    }

    override fun selectTransportationColor(): Color {
        return WhiteColor()
    }
}

//implement
fun main() {
    //Use abstract factory for made a family
    val landFactory: AbstractFactory = LandTransportFactory()
    val waterFactory: AbstractFactory = WaterTransportFactory()
    val airFactory: AbstractFactory = AirTransportFactory()

    val landTrans: Transport = landFactory.chooseTransportation()
    val waterTrans: Transport = waterFactory.chooseTransportation()
    val airTrans: Transport = airFactory.chooseTransportation()

    val blackTrans: Color = landFactory.selectTransportationColor()
    val whiteTrans: Color = landFactory.selectTransportationColor()

    landTrans.choose()
    waterTrans.choose()
    airTrans.choose()

    blackTrans.select()
    whiteTrans.select()
}