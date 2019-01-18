package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class HelloFailedException : Exception("hello failed")

suspend fun hello(): String {
    delay(500)
    throw HelloFailedException()
//    return "hello"
}

suspend fun world(): String?  {
    try {
        delay(1000)
        return "world"
    } catch (e: Exception) {
        println("world failed")
        e.printStackTrace()
        return null
    }
}

suspend fun helloWorld(): String = coroutineScope {
    try {
        val world = async { world() }
        val hello = async { hello() }
        return@coroutineScope "${hello.await()}, ${world.await()}"
    }catch (e: Exception){
        print("helloWorld ${e.message}")
        throw e
    }
}


fun main(): Unit = runBlocking {
    println(helloWorld())
}
