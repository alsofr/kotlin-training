package com.freiheit.trainings.kotlin.syntax

/**
 * Delegation.

 * NOTICE: Only works for interfaces!
 *
 * @DO: if you need delegation and also for testing.
 *
 * + not needed to write dispatching code
 */
class MyList<T>(list: List<T> = emptyList()) : List<T> by list {
    override val size: Int
        get() = 0
}

/**
 * Lazy.
 *
 * @DONT Don't be lazy because you can, try to be eager, because lazy makes compile time issues to runtime issues.
 *
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

class DatabaseConnector() {
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
 * @DONT / @DO: Recommendation is DONT, because it evaluation may lead to runtime issues. Again, try to be eager.
 */
val lazyList = listOf(lazyComputation(), lazyComputation())


fun main(args: Array<String>) {
    val l: MyList<String> = MyList(list = listOf("A", "B", "C"))
    println(l.size)
    println(l[0])

    lazyList.map { println(it) }
}
