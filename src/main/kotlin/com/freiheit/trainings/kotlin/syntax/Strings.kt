package com.freiheit.trainings.kotlin.syntax

/**
 * Strings are beside primitive the only types eligible being compile-time constants
 *
 * @DO Reduce bytecode overhead by declaring static strings as constants
 */
private const val foo = "foo"

object Bar {
    const val value = "bar"
}

/**
 * Kotlin understands string substitution à la JavaScript.
 *
 * @DO Use substitution instead of concatenation or String.format()
 *
 * Notice: Unlike JavaScript, no special quotes are requires. The usual double-quote supports substitution.
 *         Single quotes are used to define special chars in names and to distinguish keywords from colliding function names.
 */
private const val substitution = "$foo bar"
// use curlies, if there is no whitespace between the variable name and the rest of the string
private const val trimmedSubstitution = "${foo}bar"
// use curlies, if nested calls are required
private const val substitutionNested = "$foo ${Bar.value}"


/**
 * Kotlin supports Python like multiline strings.
 *
 * @DO Use multiline strings instead of \n for better readability
 */
private val multiline = """Fist line
    |next line
    |$foo
    |...
    |last line""".trimMargin()