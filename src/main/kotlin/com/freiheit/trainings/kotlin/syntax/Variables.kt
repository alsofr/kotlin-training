package com.freiheit.trainings.kotlin.syntax

import java.lang.Exception
import java.lang.NullPointerException

// (DO) val is immutable
fun valIsImmutable() {
    println("val is immutable...")
    val a = 5
// Does not work
// a = 5

    val immuList = listOf("hello", "kotlin")
    print(immuList)
    val immuList1 = immuList.plus("I am mutable")
    println(immuList1)
}

// vals and vars can be assigned outside of functions
val immuList = listOf("hello", "kotlin")
val varString = "hello"

// does not work
//varString = "world"

// but you can only reassign vars in functions
fun reassign() {
    println("var is mutable...")
    var b = 3
    b = 5
    println(b == 5)
}

const val MY_CONST = "MY_CONST_VALUE"

fun constDoesNotWorkLocal() {
    // const does not work local.
//    const val a = "test"
}

// Kotlin infers types
val stringWithoutTyp = "kotlinKnowsItIsAString"
val listWithoutType = listOf("A", "B")

fun typeInferenceWillFail() {
    var listWithoutTypeVar = listOf("A", "B")
    // does not work, because List<String> != List<Int>
    //listWithoutTypeVar = listOf(1, 2)
}


val listWithType = listOf<String>("A", "B")
// unlike Java, the type declaration comes after the variable name
val listWithMoreTypes: List<String> = listOf<String>("A", "B")

// Do this if used in APIs!
val stringWithTyp: String = "kotlinKnowsItIsAString"

val nullStringInferred = null
val nullString: String? = null

// does not work
// val nonNullString : String = null


// Kotlin allows default values and supports named parameters <3
// DON'T: If you define defaults make sure they are reasonable. Likely, the following is a bad example:
// class PersonDao()
// class PersonService(personDao : PersonDao = PersonDao())

// to initialize the list employees as emptyList() is a DO. The list will be never null!
// DON'T: employess: List<String>? or even List<String?>?
class Dept(val name: String, val dept: Dept?, val employees: List<String> = emptyList())

class SearchParameter(val title: String?, val dept: Dept?)

fun workingWithNulls() {
    val nullString: String? = null

    // bang bang !! throws NPW if nullString is null
    try {

        if (nullString!!.length > 0) {
            println("length > 0")
        }
    } catch (e: Exception) {
        // Kotlin has no multi catch
        when (e) {
            is NullPointerException -> println("NPE: \n ${e.message}")
            is IllegalArgumentException -> println("IAE: \n ${e.message}")
            else -> println(e::class)
        }
    }

    println("${nullString?.isEmpty()} - isEmpty is an extension: CharSequence.isEmpty()")


    if (nullString.isNullOrEmpty()) {
        println("isNullOrEmpty is an extension: CharSequence?.isNullOrEmpty()")
    }

    // create an instance without new
    val searchParameter = SearchParameter(title = "Coffee Makers <3", dept = Dept("Bean makers", dept = null))

    val name = searchParameter.dept?.name
    val name2 = searchParameter.dept?.dept?.name

    println("name: $name, name2: $name2")

    // systemValue is of type String! (platform type).
    // type is defined as String! := (String? or String) (wtf?!)
    val systemValue = System.getProperty("KOTLIN_IS_GREAT")
    println(systemValue)
}

fun main(args: Array<String>) {
    valIsImmutable()
    reassign()
    workingWithNulls()
}
