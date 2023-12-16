package com.designpatternfeny.creationalpattern.factorypattern

/**
 * The different between Abstract method is this pattern focus on single object
 */

interface MethodofBill {
   fun onBill()
}

class PaymentType: MethodofBill {
    override fun onBill() {
        println("You must pay the bill!!")
    }
}

class PurchaseType: MethodofBill {
    override fun onBill() {
        println("You can also doing top up >.<")
    }
}

//Factory method for create object
interface BillerFactory {
    fun createBiller(): MethodofBill
}

//Implementation factory method for create Payment type
class PaymentFactory: BillerFactory {
    override fun createBiller(): MethodofBill {
        return PaymentType()
    }
}

//Implementation factory method for create Purchase type
class PurchaseFactory: BillerFactory {
    override fun createBiller(): MethodofBill {
        return PurchaseType()
    }
}

fun main() {
    //do factory method
    val paymentFactory: BillerFactory = PaymentFactory()
    val purchaseFactory: BillerFactory = PurchaseFactory()

    val paymentType: MethodofBill = paymentFactory.createBiller()
    val purchaseType: MethodofBill = purchaseFactory.createBiller()

    paymentType.onBill()
    purchaseType.onBill()
}