package com.freiheit.trainings.kotlin.challenge

import com.freiheit.trainings.kotlin.challenge.fixed.PricesClient

object Service {
    private val db = EventStore()
    private val pricesClient = PricesClient

    fun getCart(cartId: String): Cart? {
       TODO()
    }

    fun addItem(cartId: String, itemId: String, quantity: Int): Cart? {
        TODO()
    }

    fun deleteItem(cartId: String, itemId: String): Cart? {
        TODO()
    }

    fun deleteCart(cartId: String): Boolean {
        TODO()
    }
}