package com.freiheit.trainings.testing


class GarageService(val userDao: UserDao, val vehicleDao: VehicleDao) {
    fun readGarage(userId: String): Garage? {
        val user = userDao.readUser(userId) ?: return null
        val readVehicles = vehicleDao.readVehicles(userId)
        return Garage(user, readVehicles)
    }
}