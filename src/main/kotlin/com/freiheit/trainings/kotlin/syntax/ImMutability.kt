package com.freiheit.trainings.kotlin.syntax

/**
 * Notice: This is a class in Kotlin (see InheritanceAndInterfaces.kt).
 */
class AnonymousPerson(name: String)

val anonMike = AnonymousPerson("mike")
// does not work unless you make name a val in the ctor
//val nameMike = mike.name;

/**
 * @DO: Make class fields immutable.
 */
class ImmutablePerson(val name: String)
val mike = ImmutablePerson("mike")

/**
 * Notice: There are no getters and setter in Kotlin.
 */
val oldName = mike.name

fun reassignNameVal() {
//    Does not work
//    mike.name = 'newMike'
}

/**
 * Notice: name has to be a var in order to reassign it.
 *
 * @DONT: do not use vars as class attributes.
 */
class MutablePerson(var name: String)
val mutableMike = MutablePerson("mutable mike")

fun reassignNameVar(): MutablePerson {
    val oldMutableName = mutableMike.name
    mutableMike.name = "$oldMutableName + updated"
    return mutableMike
}

fun main(args: Array<String>) {
    println("reassignName to Mike: ${reassignNameVar().name}")
}
