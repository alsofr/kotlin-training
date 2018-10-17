package com.freiheit.trainings.kotlin.syntax


class AnonymousPerson(name: String)

val anonMike = AnonymousPerson("mike")
// does not work unless you make name a val
//val nameMike = mike.name;


class ImmutablePerson(val name: String)

val mike = ImmutablePerson("mike")
/**
 * You cannot access an attribute that is not a val.
 * There are no getters and setter in Kotlin.
 */

val oldName = mike.name

// does not work, because name is a val
//p.name = "$oldName + updated"

// name has to be a var in order to reassign it.
class MutablePerson(var name: String)

val mutableMike = MutablePerson("mutable mike")

fun reassignName(p: MutablePerson) {
    val oldMutableName = mutableMike.name
    mutableMike.name = "$oldMutableName + updated"
}

/**
 * @DO: Only add open to classes and functions if really needed.
 *
 * Notice: You need to add open to a class in order to inherit from it.
 * Notice: You need to add open to a function in order to override it.
 */
open class Widget(val key: String) {
    open fun jsonKey() = "{\"key\": \"$key\"}"
    fun printKey() = println(jsonKey())
}

class MyWidget(key: String) : Widget(key) {
    override fun jsonKey() = "{\"key\": \"my-$key\"}"
}

/**
 * Kotlin has interfaces and they can have functions.
 * Notice: No need to add open to interfaces or interface functions in order to implement them or override their
 * functions.
 */
interface IWidget {
    fun key() = "IWidget"
}

class MyIWidget : IWidget

fun main(args: Array<String>) {
    /**
     * NOTICE (unlike Java): no new needed in Kotlin!
     */
    val myWidget = MyWidget("my key")
    println(myWidget.key)
    myWidget.printKey()

    val myIW = MyIWidget()
    println(myIW.key())
}

