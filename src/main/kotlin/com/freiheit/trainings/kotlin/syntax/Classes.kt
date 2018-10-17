package com.freiheit.trainings.kotlin.syntax


class AnonymousPerson(name: String)

val anonMike = AnonymousPerson("mike")
// does not work unless you make name a val
//val nameMike = mike.name;


class ImmutablePerson(val name: String)

val mike = ImmutablePerson("mike")
/**
 * You cannot access an attribute that is not a val.
 * There are no getters and setter in Kotlin.
 */

val oldName = mike.name

// does not work, because name is a val
//p.name = "$oldName + updated"

// name has to be a var in order to reassign it.
class MutablePerson(var name: String)

val mutableMike = MutablePerson("mutable mike")

fun reassignName(p: MutablePerson) {
    val oldMutableName = mutableMike.name
    mutableMike.name = "$oldMutableName + updated"
}

/**
 * @DO: Only add open to classes and functions if really needed.
 *
 * Notice: You need to add open to a class in order to inherit from it.
 * Notice: You need to add open to a function in order to override it.
 */
open class Widget(val key: String) {
    open fun jsonKey() = "{\"jsonKey\": \"$key\"}"
    fun printKey() = println(jsonKey())
}

class MyWidget(key: String) : Widget(key) {
    override fun jsonKey() = "{\"jsonKey\": \"my-$key\"}"
}

/**
 * Kotlin has interfaces and they can have functions.
 * Notice: No need to add open to interfaces or interface functions in order to implement them or override their
 * functions.
 */
interface IWidget {
    fun jsonKey() = "{\"jsonKey\": \"IWidget\"}"
}

class MyIWidget : IWidget

class MyIAndMoreWidget : IWidget, Widget(key = "MyIAndMoreWidget") {
    override fun jsonKey(): String {
        //You will have to make which super explicit by providing the type.
        //Reason: name clashes.
        return super<IWidget>.jsonKey()
    }
}


/**
 * DATA CLASSES:
 * @DO: Use them for data!
 * @DO: Do not simply rely on equals etc. even though it is generated code. Make sure you still test it.
 */
data class CustomerData(val name: String, val relatives: Map<String, CustomerData> = emptyMap())

fun workingWithCustomerData() {
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

/***
 * Objects are, like Scala, singletons.
 * @DO: Use them for Singletons!
 * Notice: There is not ctor, but init.
 */
object MySingletonService {
    private var port: Int? = 8080

    init {
        port = System.getProperty("PORT")!!.toInt()
    }

    fun getData(): CustomerData {
        println(port)
        return CustomerData(name = "max")
    }
}

/**
 * Companion Objects
 */
open class MyService(val port: Int = 8080) {
    companion object {
        /**
         * @DONT: default here and in the ctor. Stick to one default.
         */
        fun create(port: Int = 8080): MyService {
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

/**
 * Sealed Classes
 * TODO!
 */


/**
 * Delegation.
 * @DO: if you need delegation and also for testing.
 */
class MyList<T>(l: List<T> = emptyList()) : List<T> by l {
    override val size: Int
        get() = 0
}

fun main(args: Array<String>) {
    /**
     * NOTICE (unlike Java): no new needed in Kotlin!
     */
    val myWidget = MyWidget("my jsonKey")
    println(myWidget.key)
    myWidget.printKey()

    val myIW = MyIWidget()
    println(myIW.jsonKey())

    val myIAndMoreWidget = MyIAndMoreWidget()
    println("myIAndMoreWidget ${myIAndMoreWidget.jsonKey()}")

    print("workingWithCustomerData():")
    workingWithCustomerData()

    val l: MyList<String> = MyList(l = listOf("A", "B", "C"))
    println(l.size)
    println(l.map { it })

}

