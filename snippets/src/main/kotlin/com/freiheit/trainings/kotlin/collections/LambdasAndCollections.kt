package com.freiheit.trainings.kotlin.collections

import java.util.UUID


/**
 * Lambdas are declared with curlies
 */
val lambda = { s: String -> s[69] }

/**
 * Single argument lambdas can omit giving [it] a name
 */
private val foo: (String) -> Char = { it[69] }

/**
 * Functions are first class citizens and can be passed around like other objects
 */
private fun times(count: Int = 1, block: () -> Unit) = (0..count).forEach { block() }

/**
 * If a function is passed as the last argument, it can be defined outside of the parentheses
 */
private val times69 = times(69) { print("foo") }

/** COLLECTION EXAMPLES **/
data class ToDo(val name: String, val roughEstimate: Int = 0)

fun main(args: Array<String>) {
    val toDoCleanKitchen = ToDo("clean the kitchen")
    val toDoDrawPicture = ToDo("draw funny picture of my team")
    val toDos = listOf(toDoCleanKitchen, toDoDrawPicture)

    val toDosById = toDos.map { UUID.randomUUID() to it }.toMap()

    val improvedEstimations = toDos.map { it.copy(roughEstimate = it.roughEstimate.inc()) }

    (1..1000).reduce { a, b -> a + b }


    /**
     * @DONT Use "regular collections" for many chained operations.
     */
    toDos.map { it.copy(roughEstimate = it.roughEstimate.inc()) }
            .filter { it.roughEstimate > 0 }
            .map { it.roughEstimate }
            .reduce { l, r -> l + r }

    /**
     * @DO Use sequences for many chained operations.
     */
    toDos.asSequence()
            .map { it.copy(roughEstimate = it.roughEstimate.inc()) }
            .filter { it.roughEstimate > 0 }
            .map { it.roughEstimate }
            .reduce { l, r -> l + r }
}
