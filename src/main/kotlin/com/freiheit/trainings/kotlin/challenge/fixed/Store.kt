package com.freiheit.trainings.kotlin.challenge.fixed

interface IStore<V> {
    fun load(key: String): List<V>
    fun save(key: String, value: V)
}

class Store<V>: IStore<V> {
    private val db = mutableMapOf<String, List<V>>()

    override fun load(key: String) = db[key] ?: listOf()

    override fun save(key: String, value: V) {
        db[key] = (db[key] ?: listOf()) + value
    }
}