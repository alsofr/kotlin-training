package com.freiheit.trainings.kotlin.syntax

// Declaration
private val foo = { s: String -> s[69] }

private val bar: (String) -> Char = { it[69] }


// Passing functions
private fun times(count: Int = 1, block: () -> Unit) = (0..count).forEach { block() }

private val times69 = times(69) { print("foo") }


// `this` reference
private fun execute(block: String.(String) -> String) = block("a", "b")

private val concatinated = execute { plus(it) }

