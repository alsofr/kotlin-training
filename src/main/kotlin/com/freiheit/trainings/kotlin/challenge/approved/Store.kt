package com.freiheit.trainings.kotlin.challenge.approved

interface IStore<V> {
    fun load(key: String): V?
    fun save(key: String, value: V)
    fun drop()
}

class Store<V>: IStore<V> {
    private val db = mutableMapOf<String, V>()

    override fun load(key: String) = db[key]

    override fun save(key: String, value: V) {
        db[key] = value
    }

    override fun drop() = db.clear()
}