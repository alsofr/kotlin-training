package com.freiheit.trainings.kotlin.syntax

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

private fun bar() {
    val duration = measure { repeat(9001) { print(it)} }
    println(duration)
}