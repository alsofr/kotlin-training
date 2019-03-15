package com.freiheit.trainings.kotlin.syntax

/**
 * A simple user class.
 *
 * Unlike Java, the constructor is part of the class' header.
 */
class User(val name: String, val eMail: String)

/**
 * A system user hiding its ctor and accessLevel.
 */
class SystemUser private constructor(
        private val accessLevel: String,
        val name: String,
        val eMail: String) {
    constructor (name: String) : this(accessLevel = "HIDDEN", name = "Daisy Duck", eMail = "daisy.duck@disney.com")
}

/**
 * Notice: You need to add open to a class in order to inherit from it.
 * Notice: You need to add open to a function in order to override it.
 *
 * @DO: Only add open to classes and functions if really needed.
 * + Decision to introduce inheritance is explicit! You can even write a comment why the class is open!
 */
open class ToDo(val key: String) {
    open fun identity() = "Todo: $key"
    fun trackToDo() = println("tracking ToDo ${identity()}")
}

class MyToDo(key: String, val radius: Double) : ToDo(key) {
    override fun identity(): String {
        return "My-Todo: $key"
    }
}

/**
 * Kotlin has interfaces and they can have functions. No need to add open to interfaces.
 */
interface AssignToDoService {
    fun assignToDo(todo: ToDo, userName: String)
}

/**
 * Implement class and interface.
 *
 * Notice: Like Java, Kotlin has no multi-inheritance of classes. Also like Java, you can extend a class and implement
 * several interfaces.
 */

/**
 * Singleton.
 */
object ToDoServiceSingleton : AssignToDoService {
    override fun assignToDo(todo: ToDo, userName: String) {
        //To change body of created functions use File | Settings | File Templates.
        TODO("not implemented")
    }
}

/**
 * No Singleton, but can have custom ctors.
 */
class ToDoService(config: Config) : AssignToDoService {
    class Config(val url: String) {
        companion object {
            fun sysEnv() = Config(url = System.getProperty("ToDoServiceUrl"))
        }
    }

    override fun assignToDo(todo: ToDo, userName: String) {
        //To change body of created functions use File | Settings | File Templates.
        TODO("not implemented")
    }
}

/**
 * Singleton and global, with ctor!
 */
val toDoService : ToDoService = ToDoService(ToDoService.Config(url="https://asval"))