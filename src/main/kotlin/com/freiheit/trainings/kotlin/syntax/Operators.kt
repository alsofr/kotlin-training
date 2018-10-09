package com.freiheit.trainings.kotlin.syntax

// Operator function
private operator fun String.minus(other: String): String {
    return if (endsWith(other)) {
        dropLast(other.length)
    } else {
        this
    }
}

private val stripped = "abc" - "c" // "ab"


// Infix function
private infix fun Any?.`🕺`(default: Any) = this ?: default

private val theKing = null `🕺` "Suspicious Minds"