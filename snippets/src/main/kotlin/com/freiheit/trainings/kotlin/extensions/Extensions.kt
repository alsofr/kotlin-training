package com.freiheit.trainings.kotlin.extensions

/**
 * Extensions are static functions that can be called directly on the extended object
 */
fun Any?.toJson() = "{\"description\": \"You can call this function on all objects and null from anywhere\"}"


/**
 * @DONT Monkey patch foreign objects
 *  - Kotlin provides a huge set of useful extensions on Java objects already
 *  - Your extension might collide with future implementations in the stdlib
 */
fun String.capitalize(): String = TODO()

val upperCase = "filterEvents".capitalize()


/**
 * @DO Use extension in a very restricted scope
 * @DONT Leak narrow-use-case extensions into the global scope
 */
data class Todo(val id: String, val assignee: String) {
    init {
        if (!id.isValidId()) throw IllegalArgumentException()
    }

    private fun String.isValidId() = matches("[0-9]".toRegex())
}

// Everyone can see and use this
fun String.toValidTodoServicePort(): Int = toInt()


/**
 * @DO Use extensions to decorate scope specific logic to models
 *     (if you and your team feel like it)
 */
object Logic {
    fun Todo.assign(assignee: String): Todo = copy(assignee = assignee)
    fun Todo.getRanking(): Int = (Math.random() * 100 / id.length + (69.takeIf { assignee.startsWith("E") } ?: 42)).toInt()
}