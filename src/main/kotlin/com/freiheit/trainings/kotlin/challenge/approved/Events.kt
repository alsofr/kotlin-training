package com.freiheit.trainings.kotlin.challenge.approved

sealed class Event {
    abstract val cartId: String
}

sealed class CreationEvent: Event()
sealed class InteractionEvent: Event()

data class CartCreatedEvent(override val cartId: String) : CreationEvent()
data class ItemAddedEvent(override val cartId: String, val itemId: String, val quantity: Int) : InteractionEvent()
data class ItemDeletedEvent(override val cartId: String, val itemId: String) : InteractionEvent()
data class CartDeletedEvent(override val cartId: String) : InteractionEvent()