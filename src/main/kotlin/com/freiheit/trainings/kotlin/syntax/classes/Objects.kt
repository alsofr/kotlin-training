package com.freiheit.trainings.kotlin.syntax.classes


/***
 * Objects are, like Scala, singletons.
 * @DO: Use them for Singletons!
 * Notice: There is not ctor, but init.
 */
object MySingletonService {
    var port: Int? = null

    init {
        // Try to avoid this situation. Although init is guaranteed to run always a first instruction,
        // you still need to check for null.
        port = 8080
    }

    fun getData(): CustomerData {
        return CustomerData(name = "max")
    }
}

/**
 * Companion Objects
 */
open class MyService(val port: Int = 8080) {
    companion object {
        /**
         * @DONT: default here and in the ctor. Stick to one default!
         */
        fun create(port: Int = 8081): MyService {
            return MyService(port)
        }
    }
}

/**
 * Create singletons from classes.
 * Notice: The empty implementation "{}" at the end.
 */
//val mySingletonService = object : MyService(System.getProperty("PORT")!!.toInt()) {}
//object MySingletonServiceAsObject : MyService(System.getProperty("PORT")!!.toInt())

/**
 *  @DO: As a factory and define the value in your main. (DISCUSSION)
 */
val myService = MyService.create(8080)

fun main(args: Array<String>) {
    // you need to deal with null here...
    println(MySingletonService.port?.let { print("port is $it") })
    println(MyService.create().port)
    println(MyService().port)
}