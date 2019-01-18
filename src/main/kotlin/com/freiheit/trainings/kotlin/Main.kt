package com.freiheit.trainings.kotlin

open class Dept(val name : String, val subDept : Dept? =null)
data class Person(val name: String, val dep : Dept? = null){
    companion object {
        fun create(): Person {
            return Person("foo bar")
        }
    }
}

object MyPerson: Dept("t")

fun main(args: Array<String>) {
    val d : Dept = Dept("fdc", Dept("hakking"))
    val p = Person("Marvin", dep = d)

    Person.create()
//    if(p.dep?.subDept?.name == null){
//
//    }
//    val property = System.getProperty("FOOBAR")
//    property.length
    println("Name is $p")
}


