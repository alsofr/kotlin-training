package com.freiheit.trainings.testing

data class User(val userId: String)
data class Vehicle(val vehicleId: String)
data class Garage(val user: User, val vehicles: List<Vehicle> = emptyList())

class UserDao {
    private val db: MutableMap<String, User> = mutableMapOf()
    fun readUser(userId: String): User? = db[userId]
}

class VehicleDao {
    private val db: MutableMap<String, List<Vehicle>> = mutableMapOf()
    fun readVehicles(userId: String): List<Vehicle> = db[userId] ?: emptyList()
}
