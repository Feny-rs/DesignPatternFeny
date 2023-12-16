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
