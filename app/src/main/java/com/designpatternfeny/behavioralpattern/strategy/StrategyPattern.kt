package com.designpatternfeny.behavioralpattern.strategy

// Strategy interface
interface PaymentStrategy {
    fun pay(amount: Double)
}

// Concrete Strategies
class CreditCardPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount with Credit Card")
    }
}

class PayPalPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount with PayPal")
    }
}

class BankTransferPayment : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount with Bank Transfer")
    }
}

// Context
class PaymentContext(var paymentStrategy: PaymentStrategy) {
    fun changePaymentStrategy(newPaymentStrategy: PaymentStrategy) {
        paymentStrategy = newPaymentStrategy
    }

    fun processPayment(amount: Double) {
        paymentStrategy.pay(amount)
    }
}

// Client (Usage)
fun main() {
    val creditCardPayment = CreditCardPayment()
    val payPalPayment = PayPalPayment()

    val paymentContext = PaymentContext(creditCardPayment)

    // Process payment with Credit Card
    paymentContext.processPayment(50.0)

    // Change payment strategy to PayPal
    paymentContext.changePaymentStrategy(payPalPayment)

    // Process payment with PayPal
    paymentContext.processPayment(30.0)
}