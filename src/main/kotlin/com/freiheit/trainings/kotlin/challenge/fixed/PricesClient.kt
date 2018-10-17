package com.freiheit.trainings.kotlin.challenge.fixed

import com.freiheit.trainings.kotlin.challenge.Cart

object PricesClient {
    fun getPrices(cart: Cart): Prices {
        return cart.items
            .mapValues { Cart.Price("EUR", 1.toBigDecimal()) }
            .let { articles -> Prices(articles, Cart.Price("EUR", articles.size.toBigDecimal())) }
    }
}

data class Prices(val articles: Map<String, Cart.Price>, val total: Cart.Price)