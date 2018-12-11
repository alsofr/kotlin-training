package com.freiheit.trainings.kotlin.production

import com.freiheit.trainings.kotlin.production.Command.AssignTodo
import com.freiheit.trainings.kotlin.production.Command.CreateTodo
import java.util.*

object TodoStore : IStore<Todo> by InMemoryStore()

val todoService = TodoService(store = TodoStore)

class TodoService(private val store: IStore<Todo>) {

    fun process(command: Command): Todo {
        return when (command) {
            is CreateTodo -> Todo.Open(
                id = generateId(),
                data = Todo.Data(assignee = command.assignee, description = command.description)
            )
            is AssignTodo -> store
                .load(command.id)
                ?.assign(command.assignee)
            is Command.MarkCompleted -> store
                .load(command.id)
                ?.complete()
        }?.also { store.save(it.id, it) } ?: throw IllegalArgumentException("Todo does not exist.")
    }

    private fun generateId() = "${UUID.randomUUID()}"

    private fun Todo.assign(user: UserId): Todo = when (this) {
        is Todo.Open -> Todo.Open(id = id, data = data.assign(user))
        is Todo.InProgress -> Todo.InProgress(id = id, data = data.assign(user), startedAt = startedAt)
        is Todo.Completed -> throw IllegalStateException("Cannot assign an already completed TODO.")
    }

    private fun Todo.complete(): Todo = when (this) {
        is Todo.Open -> throw IllegalStateException("Cannot complete a TODO that was not started.")
        is Todo.InProgress -> Todo.Completed(id = id, data = data, startedAt = startedAt)
        is Todo.Completed -> throw IllegalStateException("TODO was already completed.")
    }

    private fun Todo.Data.assign(user: UserId) = copy(assignee = user)
}

sealed class Command {
    data class CreateTodo(val assignee: UserId, val description: String) : Command()
    data class AssignTodo(val id: String, val assignee: UserId) : Command()
    data class MarkCompleted(val id: String) : Command()
}

sealed class Todo(val id: String, val data: Data) {
    data class Data(val assignee: UserId, val description: String)

    class Open(id: String, data: Data) : Todo(id, data)

    class InProgress(id: String, data: Data, val startedAt: Long = System.currentTimeMillis()) : Todo(id, data)

    class Completed(id: String, data: Data, val startedAt: Long, val completedAt: Long = System.currentTimeMillis()) :
        Todo(id, data)
}

inline class UserId(val id: String)