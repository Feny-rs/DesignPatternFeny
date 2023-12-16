package com.designpatternfeny.creationalpattern.builder

interface FormBuilder {
    fun getRequiredDataBiller(): DataBiller
    fun buildTextInputView()
    fun buildTextView()
    fun buildTnCView()
    fun buildSofView()
    fun buildButtonNextView()
}

class PaymentFormBuilder: FormBuilder {
    private val dataBiller = DataBiller()
    override fun getRequiredDataBiller(): DataBiller {
        return dataBiller
    }

    override fun buildTextInputView() {
        dataBiller.titleBiller = "Input your number bill"
    }

    override fun buildTextView() {
        dataBiller.titleBiller = "Here your bill"
    }

    override fun buildTnCView() {
        dataBiller.haveTnC = true
    }

    override fun buildSofView() {
        dataBiller.indexSof = 1
    }

    override fun buildButtonNextView() {
        dataBiller.isEnabled = false
    }
}

class PurchaseFormBuilder: FormBuilder {
    private val dataBiller = DataBiller()
    override fun getRequiredDataBiller(): DataBiller {
        return dataBiller
    }

    override fun buildTextInputView() {
        dataBiller.titleBiller = "Input your topup number"
    }

    override fun buildTextView() {
        dataBiller.titleBiller = "Here your nominal of top up"
    }

    override fun buildTnCView() {
        dataBiller.haveTnC = true
    }

    override fun buildSofView() {
        dataBiller.indexSof = 1
    }

    override fun buildButtonNextView() {
        dataBiller.isEnabled = true
    }
}

data class DataBiller(var titleBiller: String = "", var haveTnC: Boolean = false, var isEnabled: Boolean = false, var indexSof: Int = 0)

class FormDirector {
    fun construct(builder: FormBuilder) {
        builder.buildSofView()
        builder.buildTextView()
        builder.buildTextInputView()
        builder.buildTnCView()
        builder.buildButtonNextView()
    }
}

fun main() {
    val director = FormDirector()

    val formPaymentBuilder = PaymentFormBuilder()
    director.construct(formPaymentBuilder)
    val formPayment = formPaymentBuilder.getRequiredDataBiller()
    println("Form Payment: $formPayment")

    val formPurchaseBuilder = PurchaseFormBuilder()
    director.construct(formPurchaseBuilder)
    val formPurchase = formPurchaseBuilder.getRequiredDataBiller()
    println("Form Purchase: $formPurchase")
}