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
const val testUserId1 = "471142"
const val testUserId2 = "0471142"
val testUser1 = User(userId = testUserId1)
val testUser2 = User(userId = testUserId2)

const val testVehicleId1 = "1"
const val testVehicleId2 = "2"

val testVehicle1 = Vehicle(vehicleId = testVehicleId1)
val testVehicle2 = Vehicle(vehicleId = testVehicleId2)

val testGarage1 = Garage(user = testUser1, vehicles = listOf(testVehicle1, testVehicle2))
val testGarage2 = Garage(user = testUser2, vehicles = listOf(testVehicle1, testVehicle2))

object GarageSpek : Spek({
    given("A garage service") {
        val userDao = mockk<UserDao>()
        //NOTICE: Mockk is strict, i.e., per default a method has to be mocked if called.
//        val userDao = mockk<UserDao>(relaxed = true)
//        val userDao = mockk<UserDao>(relaxUnitFun= true)
        val vehicleDao = mockk<VehicleDao>()

        val garageService = GarageService(userDao = userDao, vehicleDao = vehicleDao)

        // @DO: reuse mocks! Otherwise your test may get very slow.
        // see https://www.youtube.com/watch?v=RX_g65J14H0&feature=youtu.be&t=940
        beforeEachTest {
            clearMocks(userDao, vehicleDao)
        }


        context("read garage") {
            it("should return a garage") {
                every {
                    userDao.readUser(any())
                } returns testUser1

                every {
                    vehicleDao.readVehicles(any())
                } returns listOf(testVehicle1, testVehicle2)

                assertEquals(garageService.readGarage(testUserId1), testGarage1)
            }

            // Matching
            it("should return a garage for certain users only") {
                // list of matchers
                // https://github.com/mockk/mockk#matchers

                every {
                    userDao.readUser(match { it.startsWith("0") })
                } returns testUser2

                every {
                    vehicleDao.readVehicles(any())
                } returns listOf(testVehicle1, testVehicle2)

                assertEquals(garageService.readGarage(testUserId2), testGarage2)
            }

            // Capturing
            it("should call the dao with correct parameters") {
                val slot = slot<String>()
                every {
                    userDao.readUser(userId = capture(slot))
                } returns testUser1

                every {
                    vehicleDao.readVehicles(any())
                } returns listOf(testVehicle1, testVehicle2)


                garageService.readGarage(userId = "test1")
                garageService.readGarage(userId = "test2")
                verify(exactly = 2) { userDao.readUser(userId = or("test1", "test2")) }
            }
        }

    }
})