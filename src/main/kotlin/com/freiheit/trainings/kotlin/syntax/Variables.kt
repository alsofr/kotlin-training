package com.freiheit.trainings.kotlin.syntax

import java.lang.Exception
import java.lang.IllegalStateException
import java.lang.NullPointerException

/************ val, var and const ***************************/
/**
 * val is an immutable variable, var is mutable.
 * @DO: use val whenever possible, because val is immutable.
 */
fun valIsImmutable() {
    println("val is immutable...")
    val a = 5
// Does not work
// a = 5
    val immuList = listOf("hello", "kotlin")
    println("immuList $immuList")

    val immuList1 = immuList.plus("I am immutable")
    println("immuList1 $immuList1")

    // you can do operator overloading in Kotlin (https://kotlinlang.org/docs/reference/operator-overloading.html)
    val immuList2 = immuList + ("I am still immutable")
    println("immuList2 $immuList2")
}

/**
 * @DO: Initialize values globally if they are global. See below make them even static.
 * @DONT: Global variables, because somebody may change it!
 * Notice: The scope is the current file, i.e., they can be imported via file name.
 */
val immuList = listOf("hello", "kotlin")
var varString = "hello"


/**
 * Notice: you can only reassign vars in functions.
 */
// does not work
//varString = "world"
fun reassign() {
    println("var is mutable...")
    var b = 3
    b = 5
    println(b == 5)
}

/**
 * @DO: Even better, make global values constant!
 */
const val MY_CONST = "MY_CONST_VALUE"

/**
 * Notice: const is not supported in functions.
 */
fun constDoesNotWorkLocal() {
    // const does not work local.
//    const val a = "test"
}

/**
 * @DO: Use objects to group constants.
 * Notice: const is supported by objects (see Objects.kt).
 */
object Constants {
    const val MY_GLOBAL_CONSTANT = "tea time"
}


/************ type inference and nulls ***************************/
/** Notice:  Kotlin infers types */

val stringWithoutTyp = "kotlinKnowsItIsAString"
val listWithoutType = listOf("A", "B")

fun typeInferenceWillFail() {
    var listWithoutTypeVar = listOf("A", "B")
    // does not work, because List<String> != List<Int>
    //listWithoutTypeVar = listOf(1, 2)
}

val listWithType = listOf<String>("A", "B")
/**
 * NOTICE (unlike Java): The type declaration comes after the variable name.
 */
val listWithMoreTypes: List<String> = listOf<String>("A", "B")

/**
 * @DO: Make type explicit if the variable is exposed, e.g., API.
 */
val stringWithTyp: String = "kotlinKnowsItIsAString"


// does not work
//varString = "world"

/**
 * NOTICE: You must always define the return type of functions, unless...
 */
fun returnSomething(): String {
    return "something"
}

/**
 * ...your function can be a single expression.
 */
fun returnSomethingSingleExpression() = "something"

// DOES NOT WORK!
//fun returnSomething() {
//    return "something"
//}

/**
 * Kotlin has [Nothing] as type.
 */
fun neverReturnsAndAlwaysThrows(): Nothing {
    throw IllegalStateException()
}

/**
 * What is the inferred type of null?
 */
fun reassignNullInferred() {
    var nullInferred = null
    // nope!
//    nullInferred=0
}

/**
 * Notice: Nothing is handy for lambdas, for example.
 */
fun nothingIsHandyForLambdas(v: String, f: (a: String) -> Nothing) {
    f(v)
}

/**
 * Kotlin also has [Any] as type.
 * @DONT: Avoid [Any] as return type ;)
 */
fun returnsAny(): Any {
    return 1
}

/************ more nulls, named parameters and default values ***************************/

/**
 * Kotlin has default values for functions and ctors and supports named parameters <3.
 * Make sure you do not use default values everywhere. It should be always clear why code behaves as called.
 * Good examples are:
 * - init lists as empty (to avoid null lists)
 * - init config values, such as port = 8080
 */

// class PersonDao()
// class PersonService(personDao : PersonDao = PersonDao())

/**
 * @DONT: Define defaults, because you can. It get's hard to understand why something is working out of the box.
 * @DO: Use named parameters when calling a function or class, because it increases the readability in particular
 * during code reviews.
 * @DO: initialize the list employees as emptyList(). The list will be never null!
 * @DONT: employess: List<String>? or even List<String?>?
 */
class Dept(val name: String, val dept: Dept?, val employees: List<String> = emptyList())

// needed below...
class SearchParameter(val title: String?, val dept: Dept?)

/**
 * Put this example here, because I needed defaults, which is more related to functions.
 */
fun workingWithNulls() {
    val nullString: String? = null

    // bang bang !! throws NPW if nullString is null
    try {

        if (nullString!!.length > 0) {
            println("length > 0")
        }
    } catch (e: Exception) {
        // Kotlin has no multi catch (may change with 1.3)
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

    // Use bang bang if you want to throw an NPE
    try {
        println("${nullString!!.isEmpty()} - isEmpty is an extension: CharSequence.isEmpty()")
    } catch (e: NullPointerException) {
        e.printStackTrace()
    }
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
