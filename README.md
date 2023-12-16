# Android Design Patterns

This repository contains examples of design patterns commonly used in Android development. Understanding and applying design patterns can help improve the structure, maintainability, and scalability of your Android applications.

## Table of Contents

1. [Introduction](#introduction)
2. [Creational Patterns](#creational-patterns)
    - [Singleton](#singleton)
    - [Builder](#builder)
    - [Factory Method](#factory-method)
    - [Abstract Factory](#abstract-factory)
    - [Prototype](#prototype)
3. [Structural Patterns](#structural-patterns)
    - [Adapter](#adapter)
    - [Decorator](#decorator)
    - [Facade](#facade)
    - [Composite](#composite)
    - [Bridge](#bridge)
    - [Flyweight](#flyweight)
    - [Proxy](#proxy)
4. [Behavioral Patterns](#behavioral-patterns)
    - [Observer](#observer)
    - [Strategy](#strategy)
    - [Template Method](#template-method)
    - [Memento](#memento)
    - [Visitor](#visitor)
    - [Chain of Responsibility](#chain-of-responsibility)
    - [Command](#command)
    - [Iterator](#iterator)
    - [Mediator](#mediator)
    - [State](#state)

## Introduction

Design patterns are proven solutions to common problems encountered in software design. They provide a template for solving certain types of problems and help create software that is more modular, maintainable, and scalable.

This repository demonstrates the implementation of various design patterns in Android development.

## Creational Patterns

### Singleton

The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

```kotlin
// Example of Singleton in Kotlin
object SingletonExample {
    // Singleton members and methods...
}
```
### Builder

The Builder pattern is used to construct a complex object step by step. It allows the construction of different types of objects using the same construction process.

```kotlin
// Example of Builder in Kotlin
class ProductBuilder {
    // Builder methods...
    fun build(): Product {
        // Build the product...
    }
}
```

### Factory Method

The Factory Method pattern defines an interface for creating an object, but leaves the choice of its type to the subclasses, creating an instance of one or more derived classes.

```kotlin
// Example of Factory Method in Kotlin
interface ProductFactory {
    fun createProduct(): Product
}
```

### Abstract Factory

The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

```kotlin
// Example of Abstract Factory in Kotlin
interface AbstractFactory {
    fun createProductA(): ProductA
    fun createProductB(): ProductB
}
```

### Prototype

The Prototype pattern creates new objects by copying an existing object, known as the prototype.

```kotlin
// Example of Prototype in Kotlin
interface Prototype {
    fun clone(): Prototype
}
```

## Structural Patterns

### Adapter

The Adapter pattern allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code.

```kotlin
// Example of Adapter in Kotlin
class Adapter : Target {
    private val adaptee: Adaptee = Adaptee()

    override fun request() {
        adaptee.specificRequest()
    }
}
```

### Decorator

The Decorator pattern allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class.

```kotlin
// Example of Decorator in Kotlin
class ConcreteDecorator(component: Component) : Decorator(component) {
    override fun operation() {
        super.operation()
        // Additional behavior...
    }
}
```

### Facade

The Facade pattern provides a simplified interface to a set of interfaces in a subsystem, making it easier to use.

```kotlin
// Example of Facade in Kotlin
class SubsystemFacade {
    private val subsystem1: Subsystem1 = Subsystem1()
    private val subsystem2: Subsystem2 = Subsystem2()

    fun operation() {
        subsystem1.operation()
        subsystem2.operation()
    }
}
```

### Composite

The Composite pattern lets clients treat individual objects and compositions of objects uniformly.

```kotlin
// Example of Composite in Kotlin
interface Component {
    fun operation()
}

class Leaf : Component {
    override fun operation() {
        println("Leaf operation")
    }
}

class Composite : Component {
    private val children: MutableList<Component> = mutableListOf()

    fun add(component: Component) {
        children.add(component)
    }

    override fun operation() {
        for (child in children) {
            child.operation()
        }
    }
}
```

### Bridge

The Bridge pattern separates abstraction from implementation so that the two can vary independently.

```kotlin
// Example of Bridge in Kotlin
interface Implementor {
    fun operationImp()
}

class ConcreteImplementor : Implementor {
    override fun operationImp() {
        println("Concrete Implementor operation")
    }
}

class Abstraction(private val implementor: Implementor) {
    fun operation() {
        implementor.operationImp()
    }
}
```

### Flyweight

The Flyweight pattern minimizes memory usage or computational expenses by sharing as much as possible with related objects.

```kotlin
// Example of Flyweight in Kotlin
class Flyweight(private val intrinsicState: String) {
    fun operation(extrinsicState: String) {
        println("Flyweight: Intrinsic [$intrinsicState], Extrinsic [$extrinsicState]")
    }
}

class FlyweightFactory {
    private val flyweights: MutableMap<String, Flyweight> = mutableMapOf()

    fun getFlyweight(key: String): Flyweight {
        return flyweights.computeIfAbsent(key) { Flyweight(it) }
    }
}
```

### Proxy

The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

```kotlin
// Example of Proxy in Kotlin
interface Subject {
    fun request()
}

class RealSubject : Subject {
    override fun request() {
        println("RealSubject: Handling request")
    }
}

class Proxy(private val realSubject: RealSubject) : Subject {
    override fun request() {
        println("Proxy: Pre-processing request")
        realSubject.request()
        println("Proxy: Post-processing request")
    }
}
```

## Behavioral Patterns

### Observer

The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

```kotlin
// Example of Observer in Kotlin
class ConcreteSubject : Subject() {
    // Subject implementation...
}
```

### Strategy

The Strategy pattern defines a family of algorithms, encapsulates each algorithm, and makes the algorithms interchangeable. It lets the algorithm vary independently from clients that use it.

```kotlin
// Example of Strategy in Kotlin
class Context(private val strategy: Strategy) {
    fun executeStrategy() {
        strategy.algorithm()
    }
}
```

### Template Method

The Template Method pattern defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

```kotlin
// Example of Template Method in Kotlin
abstract class AbstractClass {
    fun templateMethod() {
        primitiveOperation1()
        primitiveOperation2()
    }

    protected abstract fun primitiveOperation1()
    protected abstract fun primitiveOperation2()
}
```
### Memento

The Memento pattern provides the ability to restore an object to its previous state.

```kotlin
// Example of Memento in Kotlin
class Originator(var state: String) {
    fun createMemento(): Memento {
        return Memento(state)
    }

    fun restoreMemento(memento: Memento) {
        state = memento.state
    }
}
```

### Visitor

The Visitor pattern represents an operation to be performed on the elements of an object structure. It lets you define a new operation without changing the classes of the elements.

```kotlin
// Example of Visitor in Kotlin
interface Visitor {
    fun visitElementA(elementA: ElementA)
    fun visitElementB(elementB: ElementB)
}
```

### Chain of Responsibility

The Chain of Responsibility pattern passes requests along a chain of handlers, each handling the request or passing it along the chain.

```kotlin
// Example of Chain of Responsibility in Kotlin
abstract class Handler {
    var successor: Handler? = null

    abstract fun handleRequest(request: String)
}

class ConcreteHandlerA : Handler() {
    override fun handleRequest(request: String) {
        if (request == "A") {
            println("ConcreteHandlerA handling request A")
        } else {
            successor?.handleRequest(request)
        }
    }
}

class ConcreteHandlerB : Handler() {
    override fun handleRequest(request: String) {
        if (request == "B") {
            println("ConcreteHandlerB handling request B")
        } else {
            successor?.handleRequest(request)
        }
    }
}
```

### Command

The Command pattern encapsulates a request as an object, allowing for parameterization of clients with different requests, queuing of requests, and logging of the requests.

```kotlin
// Example of Command in Kotlin
interface Command {
    fun execute()
}

class ConcreteCommand(private val receiver: Receiver) : Command {
    override fun execute() {
        receiver.action()
    }
}

class Receiver {
    fun action() {
        println("Receiver performing action")
    }
}

class Invoker {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun executeCommand() {
        command?.execute()
    }
}
```

### Iterator

The Iterator pattern provides a way to access elements of an aggregate object sequentially without exposing its underlying representation.

```kotlin
// Example of Iterator in Kotlin
interface Iterator {
    fun hasNext(): Boolean
    fun next(): String
}

class ConcreteIterator(private val collection: ConcreteAggregate) : Iterator {
    private var index = 0

    override fun hasNext(): Boolean {
        return index < collection.size()
    }

    override fun next(): String {
        return if (hasNext()) {
            val element = collection.getElement(index)
            index++
            element
        } else {
            throw NoSuchElementException()
        }
    }
}

class ConcreteAggregate {
    private val elements: MutableList<String> = mutableListOf()

    fun addElement(element: String) {
        elements.add(element)
    }

    fun createIterator(): Iterator {
        return ConcreteIterator(this)
    }

    fun size(): Int {
        return elements.size
    }

    fun getElement(index: Int): String {
        return elements[index]
    }
}
```

### Mediator

The Mediator pattern defines an object that centralizes communication between objects in a system.

```kotlin
// Example of Mediator in Kotlin
interface Mediator {
    fun notify(sender: Colleague, event: String)
}

class ConcreteMediator : Mediator {
    private lateinit var colleagueA: ColleagueA
    private lateinit var colleagueB: ColleagueB

    fun setColleagueA(colleagueA: ColleagueA) {
        this.colleagueA = colleagueA
    }

    fun setColleagueB(colleagueB: ColleagueB) {
        this.colleagueB = colleagueB
    }

    override fun notify(sender: Colleague, event: String) {
        when (sender) {
            is ColleagueA -> colleagueB.handleEvent(event)
            is ColleagueB -> colleagueA.handleEvent(event)
        }
    }
}

abstract class Colleague(private val mediator: Mediator) {
    abstract fun sendEvent(event: String)

    abstract fun handleEvent(event: String)
}

class ColleagueA(mediator: Mediator) : Colleague(mediator) {
    override fun sendEvent(event: String) {
        mediator.notify(this, event)
    }

    override fun handleEvent(event: String) {
        println("ColleagueA handling event: $event")
    }
}

class ColleagueB(mediator: Mediator) : Colleague(mediator) {
    override fun sendEvent(event: String) {
        mediator.notify(this, event)
    }

    override fun handleEvent(event: String) {
        println("ColleagueB handling event: $event")
    }
}
```

### State

The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

```kotlin
// Example of State in Kotlin
interface State {
    fun handleState(context: Context)
}

class ConcreteStateA : State {
    override fun handleState(context: Context) {
        println("Handling state A")
        context.state = ConcreteStateB()
    }
}

class ConcreteStateB : State {
    override fun handleState(context: Context) {
        println("Handling state B")
        context.state = ConcreteStateA()
    }
}

class Context(var state: State) {
    fun request() {
        state.handleState(this)
    }
}
```
