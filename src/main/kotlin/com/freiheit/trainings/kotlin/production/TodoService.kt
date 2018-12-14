package com.freiheit.trainings.kotlin.production

import com.freiheit.trainings.kotlin.production.Command.AssignTodo
import com.freiheit.trainings.kotlin.production.Command.CreateTodo
import java.util.UUID

/**
 * More infos about object and delegations
 *
 * @see com.freiheit.trainings.kotlin.syntax.Objects.kt
 * @see com.freiheit.trainings.kotlin.syntax.DelegationAndLazy.kt
 */
object TodoStore : IStore<Todo> by InMemoryStore()

/**
 * More infos about variables, types, defaults and nullability
 *
 * @see com.freiheit.trainings.kotlin.syntax.Variables.kt
 * @see com.freiheit.trainings.kotlin.syntax.TypeInference.kt
 * @see com.freiheit.trainings.kotlin.syntax.NullabilityAndDefaults.kt
 */
val todoService = TodoService(store = TodoStore)


/**
 * Lambdas:
 * @see com.freiheit.trainings.kotlin.syntax.lambda
 *
 * Strings:
 * @see com.freiheit.trainings.kotlin.syntax.string
 */
private val request = {
    todoService.process(CreateTodo(UserId("Eugen"), """
        1. Create grocery list
        2. Buy
        3. Profit
    """.trimIndent())
    )
}


/**
 * More infos about classes and interfaces
 *
 * @see com.freiheit.trainings.kotlin.syntax.ClassesAndInterfaces.kt
 * @see com.freiheit.trainings.kotlin.syntax.DataClasses.kt
 */
class TodoService(private val store: IStore<Todo>) {

    /**
     * Type system:
     * @see com.freiheit.trainings.kotlin.syntax.stringWithoutTyp
     *
     * When:
     * @see com.freiheit.trainings.kotlin.syntax.multiBranch
     *
     * Sealed classes:
     * @see com.freiheit.trainings.kotlin.syntax.MyType
     *
     * Extensions:
     * @see com.freiheit.trainings.kotlin.syntax.extension
     *
     * Inline functions:
     * @see com.freiheit.trainings.kotlin.syntax.measure
     *
     * Scoping:
     * @see com.freiheit.trainings.kotlin.scoping
     *
     */
    fun process(command: Command): Todo {
        return withLogging {
            when (command) {
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
            }?.also { todo -> store.save(todo.id, todo) } ?: throw IllegalArgumentException("Todo does not exist.")
        }
    }

    private inline fun <V> withLogging(block: () -> V): V {
        println("starting operation at ${System.currentTimeMillis()}")
        return block().also { println("finishing operation at ${System.currentTimeMillis()}") }
    }

    /**
     * More infos about collections
     *
     * @see com.freiheit.trainings.kotlin.collections.Collections.kt
     * @see com.freiheit.trainings.kotlin.collections.Sequences.kt
     */
    fun assignAndFilterForUser(commands: List<Command.AssignTodo>, user: UserId): List<Todo> {
        return commands.map { c -> process(c) }
                .filter { it.data.assignee == user }
    }

    private fun generateId() = "${UUID.randomUUID()}"

    private fun Todo.assign(user: UserId): Todo = when (this) {
        // data class, copy Tim
        is Todo.Open -> Todo.Open(id = id, data = data.copy(assignee = user))
        is Todo.InProgress -> Todo.InProgress(id = id, data = data.copy(assignee = user), startedAt = startedAt)
        is Todo.Completed -> throw IllegalStateException("Cannot assign an already completed TODO.")
    }

    private fun Todo.complete(): Todo = when (this) {
        is Todo.Open -> throw IllegalStateException("Cannot complete a TODO that was not started.")
        // default parameters Tim
        is Todo.InProgress -> Todo.Completed(id = id, data = data, startedAt = startedAt)
        is Todo.Completed -> throw IllegalStateException("TODO was already completed.")
    }
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
