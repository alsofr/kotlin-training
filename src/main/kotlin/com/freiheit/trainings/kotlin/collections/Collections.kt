package com.freiheit.trainings.kotlin.collections


/**
 * Collections...
 *
 * @DO: Read the docu and release notes!
 */
fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    val mutabList = mutableListOf(1, 2, 3)

    // will this fail?
    val map = mapOf("Key2" to 1, "Key1" to 2, "Key2" to 2)
    println(map)

    //you can also use pair
    val pair1 = Pair("key2", 2)
    val pair2 = Pair("key1", 1)
    val map2 = mapOf(pair1, pair2)
    println(map2)

    val set1 = setOf(1, 2, 1)
    println(set1)


    val incrList = list.map { it + 1 }//.toList()
    println("incrList $incrList")
    list.findLast { it % 2 == 1 }
    list.filter { it % 2 == 1 }
    (1..1000).reduce { a, b -> a + b }
    mapOf("1" to 1, "2" to 2, "3" to 3).map { v -> v.value }
}