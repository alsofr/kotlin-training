package com.freiheit.trainings.kotlin.syntax.classes

class ASimpleClass(val myName: String)
class ASimpleClassWithPrivateFields(private val myPrivateName: String)

// a class with a private constructor
class MyClassWithAPrivateCtor private constructor(val port: Int = 8080)

// a class with a two constructors
class MyClass(val port: Int = 8080, val myName: String, val mySecondName: String) {
    constructor (myName: String) : this(port = 7070, myName = myName, mySecondName = "MySecondName")
}


/**
 * @DO: Only add open to classes and functions if really needed.
 *
 * Notice: You need to add open to a class in order to inherit from it.
 * Notice: You need to add open to a function in order to override it.
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
 * Notice: No need to add open to interfaces or interface functions in order to implement them or override their
 * functions.
 */
interface IWidget {
    fun jsonKey() = "{\"jsonKey\": \"IWidget\"}"
}

class MyIWidget : IWidget

class MyIAndMoreWidget : IWidget, Widget(key = "MyIAndMoreWidget") {
    override fun jsonKey(): String {
        //You will have to make which super explicit by providing the type.
        //Reason: name clashes.
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
