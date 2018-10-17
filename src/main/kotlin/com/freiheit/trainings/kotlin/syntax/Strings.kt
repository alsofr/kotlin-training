package com.freiheit.trainings.kotlin.syntax

private const val foo = "foo"

object Bar {
    const val value = "bar"
}


// Substitution
private const val substitution = "$foo bar"
private const val trimmedSubstitution = "${foo}bar"
private const val substitutionNested = "$foo ${Bar.value}"


// Multiline
private val multiline = """Fist line
    |next line
    |$foo
    |...
    |last line""".trimMargin()