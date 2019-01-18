package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// async is a builder to construct a coroutine
val helloIdiomatic: Deferred<String> = GlobalScope.async {
    delay(2000L)
    println("done hello")
    return@async "Hello"
}

val worldIdiomatic: Deferred<String> = GlobalScope.async {
    delay(1000L)
    println("done world")
    return@async "World"
}

fun main(): Unit = runBlocking<Unit> {
    println("${helloIdiomatic.await()}, ${worldIdiomatic.await()}")
}