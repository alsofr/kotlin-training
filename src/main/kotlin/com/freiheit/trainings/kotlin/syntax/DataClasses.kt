package com.freiheit.trainings.kotlin.syntax


/**
 * Data classes.
 *
 * @DO: Use them for data!
 * @DO: Do not simply rely on equals etc. even though it is generated code. Make sure you still test it.
 * @DONT: Use them for functional components such as service.
 *
 * + generated equals, hash and toString (no overhead)
 * - it is easy to blindly rely the generated code and use them everywhere
 */
data class CustomerData(val name: String, val relatives: Map<String, CustomerData> = emptyMap())

fun workingWithDataClasses() {
    val moritz = CustomerData(name = "Moritz")
    val max = CustomerData(name = "Max", relatives = mapOf("Moritz" to moritz))
    val maxN = CustomerData(name = "Max", relatives = mapOf("Moritz" to moritz))

    // you can replace equals with ==
    val maxEqMoritz = moritz.equals(max)
    val maxEqMaxN = max == maxN

    val customers = setOf(max, moritz, maxN)
    println("Moritz $moritz eqauls Max $max? $maxEqMoritz")
    println("Max $max eqauls MaxN $maxN? $maxEqMaxN")
    println("customers $customers has ${customers.size} elements...")
    println("customers $customers contains max? ${customers.contains(max)}")
    println("customers $customers contains moritz? ${customers.contains(moritz)}")
    println("customers $customers contains maxN? ${customers.contains(maxN)}")
}

fun main(args: Array<String>) {
    workingWithDataClasses()
}

