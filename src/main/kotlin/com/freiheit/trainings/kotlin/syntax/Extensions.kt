package com.freiheit.trainings.kotlin.syntax

data class DumbModel(val version: Long, val payload: Map<String, Any>)
private val data = DumbModel(1, mapOf("status" to "Failure"))

// Simple private extension
private fun DumbModel.nextVersion() = version.inc()


// Global scope
fun String.isValidArticleId() = "A-[0-9]+".toRegex().matches(this)

fun Int.toString(): String = null!!
private val s = 1.toString()

fun <K, V> Map<K, V>.update(key: K, fn: (V?) -> V): Map<K, V> = plus(key to fn(this[key]))
