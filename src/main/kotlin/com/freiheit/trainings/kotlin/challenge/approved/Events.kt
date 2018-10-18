package com.freiheit.trainings.kotlin.challenge.approved

sealed class Event {
    abstract val cartId: String
}

data class CartCreatedEvent(override val cartId: String) : Event()
data class ItemAddedEvent(override val cartId: String, val itemId: String, val quantity: Int) : Event()
data class ItemDeletedEvent(override val cartId: String, val itemId: String) : Event()
data class CartDeletedEvent(override val cartId: String) : Event()