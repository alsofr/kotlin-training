package com.freiheit.trainings.kotlin.collections

import kotlin.system.measureTimeMillis

//taken from https://blog.kotlin-academy.com/effective-kotlin-use-sequence-for-bigger-collections-with-more-than-one-processing-step-649a15bb4bf
fun main(args: Array<String>) {
    val seq = sequenceOf(1, 2, 3)
    println(seq.filter { it % 2 == 1 })

    println(seq.filter { it % 2 == 1 }.toList())

    val list = listOf(1, 2, 3)
    println(list.filter { it % 2 == 1 })

    println("\n")

    sequenceOf(1, 2, 3)
            .filter { println("Filter $it, "); it % 2 == 1 }
            .map { println("Map $it, "); it * 2 }
            .toList()

    println("\n")

    listOf(1, 2, 3)
            .filter { println("Filter $it, "); it % 2 == 1 }
            .map { println("Map $it, "); it * 2 }

    var exTimeSeq: Long = 0
    for (i in 1..30) {
        exTimeSeq += processSequence()
    }
    println("Execution time sequence ${exTimeSeq/30}")

    var exTimeList: Long = 0
    for (i in 1..30) {
        exTimeList += processList()
    }
    println("Execution time list ${exTimeList/30}")
}

fun processSequence(): Long {
    return measureTimeMillis {
        createSeq()
                .filter { it % 2 == 1 }
                .map { it * 3 }
                .filter { it % 5 == 0 }
                .forEach(::print)

    }
}

fun processList(): Long {
    return measureTimeMillis {
        createSeq()
                .toList()
                // check warning in IDEA
                .filter { it % 2 == 1 }
                .map { it * 3 }
                .filter { it % 5 == 0 }
                .forEach(::print)

    }
}

fun createSeq(): Sequence<Int> {
    return generateSequence(1) { it + 1 }
            .map { it * 2 }
            .take(1000000)
}