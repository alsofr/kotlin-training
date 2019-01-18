package com.freiheit.trainings.kotlin.syntax


/**
 * Unlike Java, Kotlin infers types
 */
val stringWithoutTyp = "kotlinKnowsItIsAString"
val sub = stringWithoutTyp.substring(3)
val listWithoutType : List<String> = listOf("A", "B")
val listWithType = listOf<String>("A", "B")

fun typeInferenceWillFail() {
    var listWithoutTypeVar = listOf("A", "B")
    // does not work, because List<String> != List<Int>
//    listWithoutTypeVar = listOf(1, 2)
}

/**
 * @DO: Make type explicit if the variable is exposed, e.g., API.
 */
val stringWithTyp: String = "kotlinKnowsItIsAString"

/**
 * You must always define the return type of functions, unless...
 */
fun returnSomething(str: String): String {
    return str
}

/**
 * ...your function can be a single expression.
 */
fun returnSomethingSingleExpression(str: String) = if(str.startsWith("r")) str else str + 1