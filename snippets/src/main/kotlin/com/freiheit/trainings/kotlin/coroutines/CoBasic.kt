package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * THE VERY BEGINNING...
 */
fun readHello(): String {
    // blocks the thread!
    Thread.sleep(200)
    return "Hello"
}

fun readWorld(): String {
    // blocks the thread!
    Thread.sleep(1000)
    return "World"
}

// blocks
fun readHelloWorld(): String {
    return "${readHello()}, ${readWorld()}"
}

//fun main() {
//    //blocks
//    print(readHelloWorld())
//}

//... lets make this non blocking...

fun main() {
    // launch new coroutine in background and continue
    // launch is a so called builder
    // GlobalScope does not sound right. Let's fix this later.
    val job: Job = GlobalScope.launch {
        // non-blocking delay for 1 second (default time unit is ms)
        delay(1000L)
        // print after delay
        println("World!")
    }
    println("Hello,") // main thread continues while coroutine is delayed (no thread is blocked!)
runBlocking {
    job.join()

}

    // block main thread for 2 seconds to keep JVM alive
//    Thread.sleep(2000L)

//    runBlocking {
//        delay(2000L)
//    }

}