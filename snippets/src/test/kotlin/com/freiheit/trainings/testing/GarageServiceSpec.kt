package com.freiheit.trainings.testing

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

/**
 * There were some discussions between the so called Kotlin experts about testing frameworks. This is still an
 * ongoing discussion. However, one outcome was:
 * - use Mockk (see https://github.com/mockk/mockk)
 * - use the assertion library of your choice (Strikt, Atrium, Hamkrest, Expekt, Kluent, AssertK)
 *
 * Available Testframeworks:
 * - Spek
 * - KotlinTest
 *
 * Available Mocking libraries:
 * - Mockk <3
 * - Mockito-Kotlin
 *
 * This example uses Spek (https://github.com/spekframework) (AFIK it is also maintained by Jetbrains). It is inspired
 * by test frameworks like Jasmine and RSpec.
 */
object GarageSpek : Spek({
    val idDaisy = UserId(id = "Daisy")
    val idDonald = UserId(id = "Donald")

    val daisy = User(id = idDaisy)
    val donald = User(id = idDonald)

    val goToSupermarket = ToDo(id = ToDoId("todo_1"), note = "buyinglist...", userId = idDaisy)
    val cleanTheToilet = ToDo(id = ToDoId("todo_2"), note = "Do not forget to also clean the mirror", userId = idDonald)

    given("A garage service") {
        val userDao = mockk<UserDao>()
        //NOTICE: Mockk is strict, i.e., per default a method has to be mocked if called.
        //val userDao = mockk<UserDao>(relaxed = true)
        //val userDao = mockk<UserDao>(relaxUnitFun= true)

        val toDoDao = mockk<ToDoDao>()
        val toDoService = ToDoService(userDao = userDao, toDoDao = toDoDao)

        /**
         * @DO: reuse mocks! Otherwise your test may get very slow.
         * see https://www.youtube.com/watch?v=RX_g65J14H0&feature=youtu.be&t=940
         *
         */
        beforeEachTest {
            clearMocks(userDao, toDoDao)
        }

        context("read ToDos") {
            it("should return Daisy's ToDos") {
                every {
                    userDao.readUser(idDaisy)
                } returns daisy

                every {
                    toDoDao.read(idDaisy)
                } returns setOf(goToSupermarket, cleanTheToilet)

                assertEquals(toDoService.readToDos(idDaisy), MyToDos(daisy, setOf(goToSupermarket, cleanTheToilet)))
            }

            // Matching
            it("should return todos for certain users only") {
                // list of matchers
                // https://github.com/mockk/mockk#matchers

                every {
                    userDao.readUser(match { it.id.startsWith("Do") })
                } returns donald

                every {
                    toDoDao.read(any())
                } returns setOf(cleanTheToilet)

                assertEquals(toDoService.readToDos(idDonald), MyToDos(donald, setOf(cleanTheToilet)))
            }

            // Capturing
            it("should call the dao with correct parameters") {
                val slot = slot<UserId>()
                every {
                    userDao.readUser(userId = capture(slot))
                } returns daisy

                every {
                    toDoDao.read(any())
                } returns setOf(goToSupermarket, cleanTheToilet)


                toDoService.readToDos(userId = idDaisy)
                toDoService.readToDos(userId = idDonald)
                verify(exactly = 2) {
                    userDao.readUser(userId = or(idDaisy, idDonald))
                }
            }
        }

    }
})