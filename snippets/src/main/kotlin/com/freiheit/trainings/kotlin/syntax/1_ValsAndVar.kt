package com.freiheit.trainings.kotlin.syntax

/**
 * Kotlin supports val-, var-, and const- for types. val is an immutable variable, var is mutable and const is constant.
 * Const only supports simple types such as [Int] or [String].
 *
 * @DO: use val whenever possible, because val is immutable.
 * @DO: use const whenever possible, because it is a compiler optimization.
 */
fun assignTodo() {
    val userName: String = "Donald Duck"
    // re-assignment Does not work
//     userName = "Daisy Duck"

    val users: List<String> = listOf(userName)

    /**
     * @DONT Try not to use mutable structures. Synchronisation is "tricky".
     */
    val mutableUsers = mutableListOf(userName)
}

const val TODO_TITLE_HINT: String = "What is the name of your ToDo?"

/**
 * @DO: Initialize _values_ globally if they are global.
 * @DONT: Global _variables_, because somebody may change it!
 *
 * Notice: The scope is the current file, i.e., they can be imported via file name.
 */
//DONT!
val defaultUsers = listOf("Micky Mouse")

/**
 * Better scope in some object.
 */
private var defaultUser = "Goofy"


/**
 * Type Inference in Kotlin:
 */

/**
 * Unlike Java, Kotlin infers types. Most of the time no need to write them down.
 *
 * @DO Make type explicit for shared code.
 * @DONT Make type not explicit for shared code.
 */

/**
 * @DONT Globally, shared ... (define logical scopes do not use filenames).
 */
val title = "Mrs"

/**
 * @DO Make type explicit for shared code.
 */
val headline: String = "Headline"

/**
 * @DO Also for functions. Not necessarily for private ones.
 */
fun headline(): String {
    return "Headline"
}

fun main() {
    assignTodo()
}