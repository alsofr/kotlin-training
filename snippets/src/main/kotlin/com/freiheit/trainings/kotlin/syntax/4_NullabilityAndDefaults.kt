package com.freiheit.trainings.kotlin.syntax

/**
 * Kotlin has default values for functions and it als supports named parameters <3.
 *
 * @SHOULD You should not create default instances of "complex" components such as services or DAOs. These components
 * usually handle a lot of work, do the heavy lifting, and as such they tend to deal with external systems.
 *
 * @DO: Use named parameters when calling a function having many parameters, because it makes your code easier to follow
 * during code reviews.
 *
 * @DO: Initialize collections empty, because you avoid nullable collections.
 */
data class Scatch(val name: String, val parent: Scatch? = null, val links: Set<Scatch> = emptySet())

/**
 * Kotlin's type system is nullsafe.
 *
 * In Java a String and a null can by definition call the functions of their type. In Kotlin this is well defined.
 * A Type_?_ (with "?") has same meaning than in Java. Either a null or an instance. To take a decision Java needs
 * Optional types. In Kotlin the type is an optional. A Type with no question cannot be null. The compiler(!) gives
 * this guarantee.
 *
 */

/**
 * Of course, sometimes parameters can be null.
 * Initializing them with null is also possible to get a simple default ctor.
 */
class SearchScatchRequest(val name: String? = null, val child: Scatch? = null)

fun searchScatch(request: SearchScatchRequest = SearchScatchRequest()): Scatch? {
    if (request.name != null) {
        return Scatches.byName(request.name)
    }

    // Use "?" to unwrap.
    val lengthOrNull: Int? = request.name?.length

    // Use "?" to unwrap (even along pathes).
    val lastCode: Int? = request.name?.toInt()?.div(1)


    /**
     * Use bang bang "!!" to throw NPE if null
     * @TRY Not to just throw NPE. Better catch and wrap them to deal with them more structured.
     */
    val length : Int = request.name!!.length

    // :(
    return null
}

object ScatchFactory {
    fun fromFile() {
        /**
         * path is of type String! (platform type). It is defined as String! := (String? xor String)
         *
         * @DO Make path better "String?" and catch controlled.
         */
        val path = System.getProperty("09210990293023xPATH_HANDLE")
    }
}

object Scatches {
    val mickey = Scatch("mickey")
    val daisy = Scatch("daisy", parent = mickey)
    val kids = setOf(Scatch("tick"), Scatch("trick"), Scatch("track"))
    val SCRATCHES: Set<Scatch> = setOf(daisy).plus(kids)
    fun byName(name: String): Scatch? = SCRATCHES.find { it.name == name }
}