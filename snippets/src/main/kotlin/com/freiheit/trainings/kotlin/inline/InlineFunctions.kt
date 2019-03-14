package com.freiheit.trainings.kotlin.inline

import kotlinx.coroutines.delay

/**
 * Inline functions are compiled directly into the caller location
 *
 * @DO Use inline functions for small wrapping logic
 * @DO Follow IntelliJ's suggestions
 * @DONT Make arbitrary functions [inline] to save performance.
 *       Things can get very bad, if you are not entirely sure what you are doing.
 */
inline fun measure(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

object Todo

suspend fun indexTodo(todo: Todo) = delay(50)

private suspend fun indexAllTodos(todoList: List<Todo>) {
    val duration = measure {
        todoList.forEach { indexTodo(it) }
    }
    println(duration)
}