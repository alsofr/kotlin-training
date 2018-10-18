package com.freiheit.trainings.kotlin.challenge

import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object ServiceSpec : Spek({
    describe("Service") {
        val service by memoized { Service }

        beforeEach { service.db.drop() }

        context("creation") {
            it("creates a cart") {
                val cartId = service.createCart()
                val cart = service.getCart(cartId)

                assertNotNull(cart)
                assertEquals(cartId, cart.cartId)
                assertTrue { cart.items.isEmpty() }
                assertEquals(BigDecimal.ZERO, cart.price.amount)
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
                assertEquals(item.quantity.toBigDecimal(), item.price.amount)
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

            it("throws if no cart exists") {
                service.createCart()
                assertThrows<IllegalArgumentException> {
                    service.addItem("${UUID.randomUUID()}", "1", 5)
                }
            }

            it("throws if invalid quantity") {
                assertThrows<IllegalArgumentException> {
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
                assertEquals(BigDecimal.ZERO, cart.price.amount)
            }


            it("throws if no cart exists") {
                service.createCart()
                assertThrows<IllegalArgumentException> {
                    service.deleteItem("${UUID.randomUUID()}", "1")
                }
            }

            it("throws if no item exists") {
                assertThrows<IllegalArgumentException> {
                    service.createCart()
                        .let { service.deleteItem(it, "1") }
                }
            }
        }

        context("deletion") {
            it("deletes the cart") {
                val cartId = service.createCart()
                service.deleteCart(cartId)
                assertThrows<IllegalArgumentException> { service.getCart(cartId) }
            }

            it("throws if no cart exists") {
                service.createCart()
                assertThrows<IllegalArgumentException> {
                    service.deleteCart("${UUID.randomUUID()}")
                }
            }
        }

        context("event replaying") {
            it("returns the cart in the requested version") {
                val cartId = service.createCart()
                service.addItem(cartId, "1", 1)
                service.addItem(cartId, "2", 2)
                service.addItem(cartId, "1", 3)
                service.deleteItem(cartId, "2")

                fun assertCart(version: Int, itemCount: Int, totalPrice: BigDecimal) {
                    service.getCart(cartId, version)
                        .also {
                            assertEquals(itemCount, it?.items?.size)
                            assertEquals(totalPrice, it?.price?.amount)
                        }
                }
                assertCart(0, 0, 0.toBigDecimal())
                assertCart(1, 1, 1.toBigDecimal())
                assertCart(2, 2, 3.toBigDecimal())
                assertCart(3, 2, 5.toBigDecimal())
                assertCart(4, 1, 3.toBigDecimal())
            }
        }
    }
})