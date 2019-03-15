package com.freiheit.trainings.kotlin.syntax

/**
 * Data classes are great. Immutable classes with copy helpers, pretty printing, and comparable.
 *
 * @DO: Use them for data!
 * @DONT: Use them for functional components such as service.
 *
 * + generated copy, equals, hash and toString (no overhead)
 * - it is easy to blindly rely the generated code and use them everywhere
 */
data class UserModel(val name: String, val friends: Map<String, UserModel> = emptyMap())

fun main() {
    val donald = UserModel(name = "Donald")
    val goofy = UserModel(name = "Goofy", friends = mapOf(donald.name to donald))
    val goofysToy = UserModel(name = "Toyfy", friends = mapOf(goofy.name to donald).plus(goofy.friends))

    // each data class generates a copy function
    val duck = donald.copy(name = "Duck")
    val goofyIsNotHisToy = goofysToy == goofy
}
