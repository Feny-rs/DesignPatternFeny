package com.designpatternfeny.structuralpattern.flyweight

// Flyweight interface
interface Image {
    fun display(x: Int, y: Int)
}

// Concrete Flyweight
class SharedImage(private val name: String) : Image {
    override fun display(x: Int, y: Int) {
        println("Displaying image '$name' at position ($x, $y)")
    }
}

// Flyweight Factory
class ImageFactory {
    private val sharedImages: MutableMap<String, Image> = mutableMapOf()

    fun getImage(name: String): Image {
        return sharedImages.computeIfAbsent(name) { SharedImage(name) }
    }
}

// Client (Usage)
fun main() {
    val imageFactory = ImageFactory()

    val image1 = imageFactory.getImage("icon.png")
    image1.display(10, 20)

    val image2 = imageFactory.getImage("icon.png")
    image2.display(30, 40)

    val image3 = imageFactory.getImage("background.png")
    image3.display(50, 60)
}