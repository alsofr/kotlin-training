package com.freiheit.trainings.kotlin.scoping


data class Todo(val description: String, val assignee: User) {
    fun setDescription(description: String): Todo = copy(description = description)
    fun assign(user: User): Todo = copy(assignee = user)
}

data class User(val subscriptionType: SubscriptionType)

enum class SubscriptionType {
    NORMAL, PREMIUM
}

interface TodoService {
    fun fetchUserData(): User
    fun setDescription(todo: Todo, description: String): Todo
    fun setAssignee(todo: Todo, assignee: User): Todo
    fun loadTodo(): Todo?
    fun createTodo(): Todo
    fun save(todo: Todo)
    fun track(todo: Todo)
}

class Logic(private val service: TodoService) {

    /**
     * @DONT Write machine code
     *
     * + readable processing sequence
     * - verbose
     * - mutable references
     * - single-use variables
     *     - creative names required
     *     - pollute autocompletion
     *     - easily mixed up
     */
    fun processC(description: String): Todo {
        var todo = service.loadTodo()
        if (todo == null) {
            todo = service.createTodo()
        }
        val withDescription = service.setDescription(todo, description)
        val user = service.fetchUserData()
        val assignedTodo = service.setAssignee(withDescription, user)
        service.save(assignedTodo)
        service.track(assignedTodo)
        return assignedTodo
    }


    /**
     * @DONT Write deeply nested calls
     *
     * + shorter function
     * + no unnecessary variables
     * + immutable
     * - hard to read
     * - indentation gets ugly once the line is long enough
     */
    fun processLisp(description: String): Todo {
        val todo = service.setAssignee(service.setDescription(service.loadTodo() ?: service.createTodo(), description), service.fetchUserData())
        service.save(todo)
        service.track(todo)
        return todo
    }


    fun scoping() {
        /* .let {}
            - pipe-/map-like
            - operand as parameter
            - returns result
         */

        val withDesciption = service.loadTodo()?.let {
            service.setDescription(it, "description")
        }

        /* .also {}
            - operand as parameter
            - returns operand
            - handy for side-effects
         */

        val trackedTodo = service.createTodo().also {
            service.track(it)
        }

        /* .run {}
            - pipe-/map-like
            - operand as context (`this`)
            - returns result
         */

        val assignedTodo = service.createTodo().run {
            setDescription("description")
            assign(service.fetchUserData())
        }

        /* .apply {}
            - operand as context (`this`)
            - returns operand
            - handy for assignments
         */
        val todo = service.loadTodo()?.apply {
            print(description)
        }

        /* with(context) {}
            - similar to .run {}
            - global function instead of an extension
            - not null safe
            - only "semantic" difference:
                - .run {} maps an object into another object
                - with() {} uses an object to execute operations and return
         */
        with(service) {
            loadTodo() ?: createTodo()
        }

    }

    /**
     * @DONT Mis-/overuse scoping functions
     *
     * + readable processing sequence
     * + no unnecessary variables
     * + immutable
     * + functional style
     * - boilerplate
     */
    fun processScoping(description: String): Todo {
        return (service.loadTodo() ?: service.createTodo())
            .let { service.setDescription(it, description) }
            .run { service.setAssignee(this, service.fetchUserData()) }
            .also { service.save(it) }
            .also { service.track(it) }
    }

    /**
     * @DONT Nest scoping functions. If something has to be used multiple times independently,
     *       just declare an old-school variable.
     */
    fun processNestedScope(description: String) {
        service.loadTodo()
            .let { it ?: service.createTodo() }
            .let { todo ->
                service.setDescription(todo, description)
                    .let {
                        service.fetchUserData()
                            .run { it.assign(this) }
                    }
                    .also { service.track(it) }
            }
    }

    /**
     * @DO Use the right scoping function for the right job
     * @DO Use simple function nesting (if you feel like it)
     * @DO Combine simultaneous side effects if the same block
     * @DO Scoping with context in the right situation
     * @DONT Use the [with] function, if the object is accessed only a few times
     * @DONT Use the [with] function, if an interface delegation makes more sense
     *
     * + readable processing sequence
     * + no unnecessary variables
     * + immutable
     * + functional style
     * + no boilerplate
     */
    fun processWithContext(service: TodoService, description: String) = with(service) {
        val todo = loadTodo() ?: createTodo()

        return@with setDescription(todo, description)
            .let { setAssignee(it, fetchUserData()) }
            .also {
                save(it)
                track(it)
            }
    }
}


