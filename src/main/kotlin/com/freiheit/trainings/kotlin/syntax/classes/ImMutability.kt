package com.freiheit.trainings.kotlin.syntax.classes

class AnonymousPerson(name: String)

val anonMike = AnonymousPerson("mike")
// does not work unless you make name a val in the ctor
//val nameMike = mike.name;

class ImmutablePerson(val name: String)
val mike = ImmutablePerson("mike")

/**
 * There are no getters and setter in Kotlin.
 */
val oldName = mike.name

// does not work, because name is a val
//p.name = "$oldName + updated"

// name has to be a var in order to reassign it.
class MutablePerson(var name: String)
val mutableMike = MutablePerson("mutable mike")

fun reassignName(): MutablePerson {
    val oldMutableName = mutableMike.name
    mutableMike.name = "$oldMutableName + updated"
    return mutableMike
}

fun main(args: Array<String>) {
    println("reassignName to Mike: ${reassignName().name}")
}
