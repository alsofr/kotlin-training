package com.freiheit.trainings.testing

data class UserId(val id: String)
data class User(val id: UserId)
data class ToDo(val id: String, val note: String, val userId: UserId)

class UserDao {
    private val db: MutableMap<String, User> = mutableMapOf()
    fun readUser(userId: UserId): User? = db[userId.id]
}

class ToDoDao {
    private val db: Map<UserId, Set<ToDo>> = emptyMap()
    fun read(userId: UserId): Set<ToDo> = db[userId] ?: emptySet()
}
