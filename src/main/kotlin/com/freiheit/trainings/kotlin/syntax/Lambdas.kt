package com.freiheit.trainings.kotlin.syntax

/**
 * Lambdas are declared with curlies
 */
private val foo = { s: String -> s[69] }


/**
 * Single argument lambdas can omit giving [it] a name
 */
private val bar: (String) -> Char = { it[69] }


/**
 * Functions are first class citizens and can be passed around like other objects
 */
private fun times(count: Int = 1, block: () -> Unit) = (0..count).forEach { block() }


/**
 * If a function is passed as the last argument, it can be defined outside of the parentheses
 */
private val times69 = times(69) { print("foo") }


/**
 * Lambdas can have a specific [this] reference using the dot notation
 *
 * @DONT Just use the scope to pass less arguments. Being in the scope of something has to make sense.
 */
private fun execute(block: String.(String) -> String) = block("a", "b")

private val concatinated = execute { plus(it) }

