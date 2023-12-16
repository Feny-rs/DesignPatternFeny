package com.designpatternfeny.structuralpattern.composite

// Component
interface FileComponent {
    fun display(): String
}

// Leaf
class File(private val name: String) : FileComponent {
    override fun display(): String {
        return "File: $name"
    }
}

// Composite
class Directory(private val name: String) : FileComponent {
    private val files = mutableListOf<FileComponent>()

    fun addFile(file: FileComponent) {
        files.add(file)
    }

    override fun display(): String {
        val result = StringBuilder()
        result.append("Directory: $name\n")

        for (file in files) {
            result.append("  ${file.display()}\n")
        }

        return result.toString()
    }
}

// Client
fun main() {
    val rootDirectory = Directory("Root")

    val subDirectory1 = Directory("SubDirectory1")
    subDirectory1.addFile(File("File1"))
    subDirectory1.addFile(File("File2"))

    val subDirectory2 = Directory("SubDirectory2")
    subDirectory2.addFile(File("File3"))
    subDirectory2.addFile(File("File4"))

    rootDirectory.addFile(subDirectory1)
    rootDirectory.addFile(subDirectory2)

    // Displaying the entire directory structure
    println(rootDirectory.display())
}