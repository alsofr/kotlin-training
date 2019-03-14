package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicReference

// could be a function as well...
val helloIdiomaticExc: Deferred<String> = GlobalScope.async {
    delay(1000L)
    throw Exception("hello failed")
}

var hello : AtomicReference<String?> = AtomicReference(null)
fun helloIdiomaticLaunchExc() = GlobalScope.launch {
    delay(1000L)
    hello.getAndSet("hello")
    throw Exception("hello with launch failed")
}

// could be a function as well...
val worldIdiomaticExc: Deferred<String> = GlobalScope.async {
    delay(2000L)
    println("done world")
    return@async "World"
}

fun main(): Unit = runBlocking<Unit> {
//    try {
//        println("${helloIdiomaticExc.await()}, ${worldIdiomaticExc.await()}")
//    } catch (e: Exception) {
//        println("Caught Exception: ${e.message}")
//    }

    try {
        helloIdiomaticLaunchExc()
        println(", ${worldIdiomaticExc.await()}")
    } catch (e: Exception) {
        println("Caught Exception: ${e.message}")
    }
}