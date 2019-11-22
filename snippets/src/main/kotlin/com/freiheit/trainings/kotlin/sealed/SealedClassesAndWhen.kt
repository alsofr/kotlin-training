package com.freiheit.trainings.kotlin.sealed

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

/**
 * The [when] keyword can be used as a multi-branch if
 */
fun getDescriptionLengthLimit(userType: String, specialOfferDays: Boolean): Int {
    return when {
        userType == "anonymous" -> 100
        userType == "normal" && specialOfferDays -> 500
        userType == "normal" -> 250
        userType == "premium" -> 1000
        else -> 0
    }
}


/**
 * [sealed] classes allow restricted class hierarchies
 *
 * @DO Use [sealed] classes for state modelling
 */
sealed class Todo
object Blank: Todo()
data class InProgress(val assignee: String, val description: String): Todo()
data class Completed(val assignee: String, val description: String): Todo()


object OtherScope {
//    "Inheritance from sealed classes is restricted to the scope!"
//    class MyTodo(val someValue: Any) : Todo()
}

// Sealed classes are abstract and cannot be instantiated
//val impossible = Todo()


/**
 * [sealed] classes are like enums on steroids
 *
 * @DO Use the [when] statement to switch over sealed types
 * @DONT Define an else branch if the logic does not explicitly require it,
 *       otherwise you will loose the safety
 *
 * Notice: Together with the [when] statements you can createTodo state machines,
 *         which makes your code hard to break by preventing it from getting
 *         into insensible or unhandled states.
 */
private fun assign(todo: Todo, assignee: String): Todo {
    return when (todo) {
        Blank -> throw IllegalStateException()                 // match by reference
        is InProgress -> {                             // match by type
           todo.copy(assignee = assignee)                           // smart-cast
        }
        is Completed -> throw IllegalStateException()  //The when expression on sealed types has to be exhaustive!
    }
}


/**
 * [is] and [as] can be used for type checks and casts
 *
 * @DO Use the [is] keyword for type checking and smart-casting
 * @DONT Use the [as] keyword, especially without making the result optional
 */
private fun getDescription(todo: Todo): String {
    (todo as? InProgress)?.description // Does something if value could be casted

    (todo as Completed).description    // This can throw!

    return if (todo is InProgress || todo is Completed) {
        todo.description
    } else {
        throw IllegalArgumentException()
    }
}