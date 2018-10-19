package com.freiheit.trainings.kotlin.challenge

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.math.BigDecimal
import java.util.*
import kotlin.test.*

object ServiceSpec : Spek({
    describe("Service") {
        val service by memoized { Service }

        beforeEachTest { service.db.drop() }

        context("creation") {
            it("creates a cart") {
                val cartId = service.createCart()
                val cart = service.getCart(cartId)

                assertNotNull(cart)
                assertEquals(cartId, cart.cartId)
                assertTrue { cart.items.isEmpty() }
                assertEquals(BigDecimal.ZERO, cart.price?.amount)
            }
        }

        context("item addition") {
            it("adds an item") {
                val cart = service.createCart()
                    .let { service.addItem(it, "1", 69) }

                assertNotNull(cart)
                assertTrue { cart.items.containsKey("1") }

                val item = cart.items["1"]
                assertNotNull(item)
                assertEquals("1", item.itemId)
                assertEquals(69, item.quantity)
                assertEquals(item.quantity.toBigDecimal(), item.price?.amount)
            }

            it("changes the quantity") {
                val cart = service.createCart()
                    .let {
                        service.addItem(it, "1", 69)
                        service.addItem(it, "1", 42)
                    }

                assertNotNull(cart)
                assertEquals(42, cart.items["1"]?.quantity)
            }

            it("throws if invalid quantity") {
                assertFailsWith<IllegalArgumentException> {
                    service.createCart()
                        .let { service.addItem(it, "1", -1) }
                }
            }
        }

        context("item removal") {
            it("removes an item") {
                val cart = service.createCart()
                    .let { service.addItem(it, "1", 69) }
                    ?.let { service.deleteItem(it.cartId, "1") }

                assertNotNull(cart)
                assertTrue { cart.items.isEmpty() }
                assertEquals(BigDecimal.ZERO, cart.price?.amount)
            }
        }

        context("deletion") {
            it("deletes the cart") {
                val cartId = service.createCart()
                service.deleteCart(cartId)
                assertNull(service.getCart(cartId))
            }
        }
    }
})