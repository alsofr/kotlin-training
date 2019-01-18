package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope


suspend fun helloWithSu(): String {
    delay(500)
    throw Exception("hello failed")
}

suspend fun worldWithSu(): String {
    try {
        delay(1000)
        return "world"
    } catch (e: Exception) {
        println("world failed due to ${e.message}")
        throw e
    }
}

val handler = CoroutineExceptionHandler { _, exception ->
    println("Caught original $exception")
}

//val myScope = RequestScope()

suspend fun helloWorldWithSu(): String = coroutineScope {
    var hello: String? = null

    supervisorScope {
        launch(handler) {
            hello = helloWithSu()
        }
    }

    println("parent is still running - 1")
    val world = async { worldWithSu() }

    return@coroutineScope "$hello, ${world.await()}"
}


fun main(): Unit = runBlocking {
    println(helloWorldWithSu())
}
