package com.freiheit.trainings.testing

data class MyToDos(val user: User, val toDos: Set<ToDo>)

class ToDoService(val userDao: UserDao, val toDoDao: ToDoDao) {
    fun readToDos(userId: UserId): MyToDos? {
        val user = userDao.readUser(userId) ?: return null
        val toDos = toDoDao.read(userId)
        return MyToDos(user, toDos)
    }
}