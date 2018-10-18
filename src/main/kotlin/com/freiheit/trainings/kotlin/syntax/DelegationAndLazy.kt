package com.freiheit.trainings.kotlin.syntax

/**
 * Delegation.
 * - Only works for interfaces!
 *
 * @DO: if you need delegation and also for testing.
 */
class MyList<T>(list: List<T> = emptyList()) : List<T> by list {
    override val size: Int
        get() = 0
}


/**
 * Lazy.
 * @DONT Don't be lazy because you can, try to be eager, because lazy makes compile time issues to runtime issues.
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

val l: Lazy<String> = lazyOf(lazyComputation())

fun lazyComputation(): String {
    Thread.sleep(2000)
    return "lazy..."
}


fun main(args: Array<String>) {
    val l: MyList<String> = MyList(list = listOf("A", "B", "C"))
    println(l.size)
    println(l[0])

    val lazyList = listOf(lazyComputation(), lazyComputation())
    lazyList.map { println(it) }
}
