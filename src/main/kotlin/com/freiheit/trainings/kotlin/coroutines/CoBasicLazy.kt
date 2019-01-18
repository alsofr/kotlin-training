package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    val helloLazy: Deferred<String> = GlobalScope.async(start = CoroutineStart.LAZY) {
        delay(2000L)
        println("done hello (lazy)")
        return@async "Hello"
    }

    val worldLazy: Deferred<String> = GlobalScope.async(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("done world (lazy)")
        return@async "World"
    }

    runBlocking {
        println("${helloLazy.await()}, ${worldLazy.await()}")
    }
}
