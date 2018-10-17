package com.freiheit.trainings.kotlin.scoping

import com.freiheit.trainings.kotlin.challenge.Cart

interface Service {
    fun fetchArticles(cart: Cart): Cart
    fun fetchPrices(cart: Cart): Cart
    fun addItem(cart: Cart, id: String, quantity: Int): Cart
    fun load(): Cart?
    fun create(): Cart
    fun save(cart: Cart)
    fun track(cart: Cart)
}

class Logic(private val service: Service) {

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
    fun processC(id: String, quantity: Int): Cart? {
        var cart = service.load()
        if (cart == null) {
            cart = service.create()
        }
        val withItem = service.addItem(cart, id, quantity)
        val withUpdatedItems = service.fetchArticles(withItem)
        val withPrices = service.fetchPrices(withUpdatedItems)
        service.save(withPrices)
        service.track(withPrices)
        return withPrices
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
    fun processLisp(id: String, quantity: Int): Cart {
        val cart = service.fetchPrices(service.fetchArticles(service.addItem(service.load() ?: service.create(), id, quantity)))
        service.save(cart)
        service.track(cart)
        return cart
    }


    fun scoping() {
        /* .let {}
            - pipe-/map-like
            - operand as parameter
            - returns result
         */

        val halloWelt = "Hallo,".let {
            "$it Welt!"
        }

        /* .also {}
            - operand as parameter
            - returns operand
            - handy for side-effects
         */

        val stillHalloWelt = halloWelt.also { print(it) }

        /* .run {}
            - pipe-/map-like
            - operand as context (`this`)
            - returns result
         */

        val cartWithPrices = service.run {
            fetchPrices(create())
        }

        /* .apply {}
            - operand as context (`this`)
            - returns operand
            - handy for assignments
         */
        Cart().apply {
            items = mapOf("id" to Cart.Item("id", 42, null))
            price = Cart.Price("EUR", 69.toBigDecimal())
        }

        /* with {}
            - similar to .run {}
            - global function instead of an extension
            - not null safe
            - only "semantic" difference
         */
        with(service) {
            fetchPrices(create())
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
    fun processScoping(id: String, quantity: Int): Cart {
        return (service.load() ?: service.create())
            .let { service.addItem(it, id, quantity) }
            .run { service.fetchArticles(this) }
            .let { service.fetchPrices(it) }
            .also { service.save(it) }
            .also { service.track(it) }
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
    fun processWithContext(service: Service, id: String, quantity: Int) = with(service) {
        addItem(load() ?: create(), id, quantity)
            .let { fetchPrices(fetchArticles(it)) }
            .also {
                save(it)
                track(it)
            }
    }
}


