package com.freiheit.trainings.kotlin.challenge

import com.freiheit.trainings.kotlin.challenge.approved.PricesClient

/**
 * Welcome to the fancy new Shopping Cart Service!
 *
 * We already started with the implementation, but were interrupted by some meetings.
 * With your help, though, we can still deliver the feature on time.
 * You are ones of the greatest minds and surely never do mistakes, but just to be sure,
 * there are a couple of tests already in place that the code has to fulfill.
 *
 *
 * This is the basic idea behind the new service:
 *
 * The persistence of the cart is backed by events.
 * The cart state shall be replayable to any given version.
 * No actual cart model is ever persisted.
 *
 * Hint: In Event Sourcing, the aggregation logic is best implemented
 *       as a left fold operation over all Events.
 *       (Cart, Event) -> Cart
 *
 * Todo:
 * ----------
 * Any Java classes shall be exorcised and converted to Kotlin.
 *
 * Basic interactions - creation, retrieval, deletion, adding and removing items -
 * shall build the first feature set of the service.
 *
 * Test expectations have to be met.
 * ----------
 *
 *
 * Restrictions:
 * 1. The code in the approved package was already accepted by the PO and shall not be changed.
 * 2. Due to the security policy, no external dependencies can be used.
 *
 * P.S. Any bug induced costs are directly charged with your salary.
 */

object Service {
    private val pricesClient = PricesClient
    val db = EventStore()

    fun createCart(): String {
        TODO()
    }

    fun getCart(cartId: String): ActiveCart? {
        TODO()
    }

    fun getCart(cartId: String, version: Int): ActiveCart? {
        TODO()
    }

    fun addItem(cartId: String, itemId: String, quantity: Int): ActiveCart? {
        TODO()
    }

    fun deleteItem(cartId: String, itemId: String): ActiveCart? {
        TODO()
    }

    fun deleteCart(cartId: String) {
        TODO()
    }
}