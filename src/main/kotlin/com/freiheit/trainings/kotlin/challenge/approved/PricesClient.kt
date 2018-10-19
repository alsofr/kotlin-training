package com.freiheit.trainings.kotlin.challenge.approved

import com.freiheit.trainings.kotlin.challenge.Cart
import java.math.BigDecimal

object PricesClient {
    fun getPrices(cart: Cart): Prices {
        return cart.items
            .mapValues { (_, item) -> Cart.Price("EUR", item.quantity.toBigDecimal()) }
            .let { articles ->
                val total = articles.map { it.value.amount }
                    .takeUnless { it.isEmpty() }
                    ?.reduce { acc, amount -> acc + amount }
                    ?: BigDecimal.ZERO
                Prices(articles, Cart.Price("EUR", total))
            }
    }
}

data class Prices(val articles: Map<String, Cart.Price>, val total: Cart.Price)