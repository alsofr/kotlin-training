package com.freiheit.trainings.kotlin.syntax

/**
 * For interfaces, delegation is simple in Kotlin
 *
 * @DO: if you need delegation, which is also great for testing.
 * + not needed to write dispatching code
 */
class MyList<T>(list: List<T> = emptyList()) : List<T> by list {
    override val size: Int
        get() = 0
}

/**
 * Lazy.
 *
 * @DONT Don't be lazy because you can, try to be eager, because lazy makes start time issues to runtime issues.
 * + lazy is thread safe (you can set by lazy(mode = LazyThreadSafetyMode.PUBLICATION)) if you don't need thread
 * safety.
 *
 */
val dbConnector by lazy {
    DatabaseConnector()
}

val connection by lazy {
    dbConnector.connect()
}

class DatabaseConnector {
    class Connection

    fun connect(): Connection = Connection()
}

/**
 * [Lazy] is a type
 */
val l: Lazy<String> = lazyOf(lazyComputation())

fun lazyComputation(): String {
    Thread.sleep(2000)
    return "lazy..."
}

/**
 * @DONT: Evaluation may lead to runtime issues. Try to be eager if possible.
 */
val lazyList = listOf(lazyComputation(), lazyComputation())