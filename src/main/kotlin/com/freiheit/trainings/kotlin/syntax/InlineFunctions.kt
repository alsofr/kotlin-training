package com.freiheit.trainings.kotlin.syntax

private inline fun measure(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}

private fun bar() {
    val duration = measure { repeat(9001) {} }
    println(duration)
}

/*  Compiled to:

    val start = System.currentTimeMillis()
    repeat(9001) {}
    val duration = System.currentTimeMillis() - start
    println(duration)
 */

