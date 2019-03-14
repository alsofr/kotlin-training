package com.freiheit.trainings.kotlin.collections

import kotlin.system.measureTimeMillis

/**
 * @DO: Use Sequences whenever you process larger collections. Sequences are much faster in particular when you
 * compose single chained operations on each element. With lists, for instance, the list is completely consumed
 * for each single operation.
 */
fun main(args: Array<String>) {
    val seq = sequenceOf(1, 2, 3)
    println(seq.filter { it % 2 == 1 })

    println(seq.filter { it % 2 == 1 }.toList())

    val list = listOf(1, 2, 3)
    println(list.filter { it % 2 == 1 })

    println("\nElement processing with sequences:")

    sequenceOf(1, 2, 3)
            .filter { println("Filter $it, "); it % 2 == 1 }
            .map { println("Map $it, "); it * 2 }
            .toList()

    println("\nElement processing with lists:")

    listOf(1, 2, 3)
            .filter { println("Filter $it, "); it % 2 == 1 }
            .map { println("Map $it, "); it * 2 }

    println("\nSome little benchmark:")

    var exTimeSeq: Long = 0
    for (i in 1..30) {
        exTimeSeq += processSequence()
    }

    println("Execution time when using sequence ${exTimeSeq / 30}")

    var exTimeList: Long = 0
    for (i in 1..30) {
        exTimeList += processList()
    }

    println("Execution time when using list ${exTimeList / 30}")
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