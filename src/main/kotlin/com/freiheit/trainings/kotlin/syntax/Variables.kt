package com.freiheit.trainings.kotlin.syntax

/**
 * Kotlin has val, var, and const. bal is an immutable variable, var is mutable and const is contstan, but
 * only works for simple types.
 *
 * @DO: use val whenever possible, because val is immutable.
 * @DO: use const whenever possible, because it is cheap.
 */
fun valIsImmutable() {
    println("val is immutable...")
    val a = 5

    // Does not work
    // a = 5
    val immuList = listOf("hello", "kotlin")
    println("immuList $immuList")

    // val mutList : MutableList...

    val immuList1 = immuList.plus("I am immutable")
    println("immuList1 $immuList1")

    // you can do operator overloading in Kotlin (https://kotlinlang.org/docs/reference/operator-overloading.html)
    val immuList2 = immuList + ("I am still immutable")
    println("immuList2 $immuList2")
}

/**
 * @DO: Initialize values globally if they are global. See below make them even static.
 * @DONT: Global variables, because somebody may change it!
 *
 * Notice: The scope is the current file, i.e., they can be imported via file name.
 */
val immuList = listOf("hello", "kotlin")
//DONT!
var varString = "hello"
const val DEFAULT_PORT: Int = 8080
