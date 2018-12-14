package com.freiheit.trainings.kotlin.syntax

/**
 * Some simple class.
 */
class ASimpleClass(val myName: String)

/**
 * Some simple class with private field.
 */
class ASimpleClassWithPrivateFields(private val myPrivateName: String)

/**
 * Some simple class with private ctor.
 */
class SimpleClassWithAPrivateCtor private constructor(val port: Int = 8080)

/**
 * A class with two constructors and default values for named parameters.
 */
class SimpleClassWithTwoCtors(val port: Int = 8080, val myName: String, val mySecondName: String) {
    constructor (myName: String) : this(port = 7070, myName = myName, mySecondName = "MySecondName")
}

/**
 * Notice: You need to add open to a class in order to inherit from it.
 * Notice: You need to add open to a function in order to override it.
 *
 * @DO: Only add open to classes and functions if really needed.
 * + Decision to introduce inheritance is explicit! You can even write a comment why the class is open!
 */
open class Widget(val key: String) {
    open fun jsonKey() = "{\"jsonKey\": \"$key\"}"
    fun printKey() = println(jsonKey())
}

class MyWidget(key: String) : Widget(key) {
    override fun jsonKey() = "{\"jsonKey\": \"my-$key\"}"
}

/**
 * Kotlin has interfaces and they can have functions.
 *
 * Notice: No need to add open to interfaces or interface functions in order to implement them or override their
 * functions.
 */
interface IWidget {
    fun jsonKey() = "{\"jsonKey\": \"IWidget\"}"
}

/**
 * Implement an interface.
 */
class MyIWidget : IWidget

/**
 * Implement class and interface.
 *
 * Notice: Like Java, Kotlin has no multi-inheritance of classes. Also like Java, you can extend a class and implement
 * several interfaces.
 */
class MyIAndMoreWidget : IWidget, Widget(key = "MyIAndMoreWidget") {
    /**
     * NOTICE: Unlike Java override is a keyword
     */
    override fun jsonKey(): String {
        //You will have to make which super explicit by providing the type.
        //Reason: name clashes.
        //Kotlin also has super.
        return super<IWidget>.jsonKey()
    }
}

fun main(args: Array<String>) {
    /**
     * NOTICE (unlike Java): no new needed in Kotlin!
     */
    val myWidget = MyWidget("my jsonKey")
    println(myWidget.key)
    myWidget.printKey()

    val myIW = MyIWidget()
    println(myIW.jsonKey())

    val myIAndMoreWidget = MyIAndMoreWidget()
    println("myIAndMoreWidget ${myIAndMoreWidget.jsonKey()}")
}
