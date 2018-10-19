package com.freiheit.trainings.testing

import io.mockk.Called
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import io.mockk.verifyAll
import io.mockk.verifyOrder
import io.mockk.verifySequence
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

/**
 * See https://github.com/mockk/mockk/blob/master/README.md#verification-order
 */
class Calculator {
    fun sum(a: Int, b: Int) = a + b
}

val calculator = mockk<Calculator>()
val slot = slot<Int>()

object VerificationOrderSpec : Spek({
    given("A calculator") {
        beforeEachTest {
            clearMocks(calculator)
        }

        context("calling sum") {
            it("should remain the order") {

                every {
                    calculator.sum(any(), capture(slot))
                } answers {
                    1 + firstArg<Int>() + slot.captured
                }

                calculator.sum(1, 2) // returns 4
                calculator.sum(1, 3) // returns 5
                calculator.sum(2, 2) // returns 5

                verifyAll {
                    calculator.sum(1, 3)
                    calculator.sum(1, 2)
                    calculator.sum(2, 2)
                }

                verifySequence {
                    calculator.sum(1, 2)
                    calculator.sum(1, 3)
                    calculator.sum(2, 2)
                }

                verifyOrder {
                    calculator.sum(1, 2)
                    calculator.sum(2, 2)
                }

                val obj2 = mockk<Calculator>()
                val obj3 = mockk<Calculator>()
                verify {
                    listOf(obj2, obj3) wasNot Called
                }
            }
        }
    }
})
