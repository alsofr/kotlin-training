package com.freiheit.trainings.kotlin.production

import com.freiheit.trainings.kotlin.production.Command.AssignTodo
import com.freiheit.trainings.kotlin.production.Command.CreateTodo
import java.util.*

interface TodoStore {
    fun save(todo: Todo)
    fun load(id: String): Todo?
}

class TodoService(private val store: TodoStore) {

    fun process(command: Command): Todo {
        return when (command) {
            is CreateTodo -> Todo.Open(Todo.Data(id = generateId(), assignee = command.assignee, description = command.description))
                .also { store.save(it) }
            is AssignTodo -> store.forceLoad(command.id)
                .assign(command.assignee)
                .also { store.save(it) }
            is Command.MarkCompleted -> store.forceLoad(command.id)
                .complete()
                .also { store.save(it) }
        }
    }

    private fun generateId() = "${UUID.randomUUID()}"

    private fun Todo.assign(user: UserId): Todo = when (this) {
        is Todo.Open -> Todo.Open(data.assign(user))
        is Todo.InProgress -> Todo.InProgress(data = data.assign(user), startedAt = startedAt)
        is Todo.Completed -> throw IllegalStateException("Cannot assign an already completed TODO.")
    }

    private fun Todo.complete(): Todo = when (this) {
        is Todo.Open -> throw IllegalStateException("Cannot complete a TODO that was not started.")
        is Todo.InProgress -> Todo.Completed(data = data, startedAt = startedAt)
        is Todo.Completed -> throw IllegalStateException("TODO was already completed.")
    }

    private fun Todo.Data.assign(user: UserId) = copy(assignee = user)

    private fun TodoStore.forceLoad(id: String): Todo = load(id) ?: throw IllegalArgumentException("Todo [$id] does not exist.")
}

sealed class Command {
    data class CreateTodo(val assignee: UserId, val description: String) : Command()
    data class AssignTodo(val id: String, val assignee: UserId) : Command()
    data class MarkCompleted(val id: String) : Command()
}


sealed class Todo(val data: Data) {
    data class Data(val id: String, val assignee: UserId, val description: String)

    class Open(data: Data) : Todo(data)

    class InProgress(data: Data, val startedAt: Long = System.currentTimeMillis()) : Todo(data)

    class Completed(data: Data, val startedAt: Long, val completedAt: Long = System.currentTimeMillis()) : Todo(data)
}

inline class UserId(val id: String)