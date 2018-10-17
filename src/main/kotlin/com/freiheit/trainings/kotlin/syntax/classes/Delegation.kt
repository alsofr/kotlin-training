package com.freiheit.trainings.kotlin.syntax.classes

/**
 * Delegation.
 * @DO: if you need delegation and also for testing.
 */
class MyList<T>(l: List<T> = emptyList()) : List<T> by l {
    override val size: Int
        get() = 0
}

fun main(args: Array<String>) {
    val l: MyList<String> = MyList(l = listOf("A", "B", "C"))
    println(l.size)
    println(l.map { it })
}

