package com.freiheit.trainings.kotlin.challenge.approved

import com.freiheit.trainings.kotlin.challenge.ActiveCart
import java.math.BigDecimal

object PricesClient {
    fun getPrices(cart: ActiveCart): Prices {
        return cart.items
            .mapValues { (_, item) -> ActiveCart.Price("EUR", item.quantity.toBigDecimal()) }
            .let { articles ->
                val total = articles.map { it.value.amount }
                    .takeUnless { it.isEmpty() }
                    ?.reduce { acc, amount -> acc + amount }
                    ?: BigDecimal.ZERO
                Prices(articles, ActiveCart.Price("EUR", total))
            }
    }
}

data class Prices(val articles: Map<String, ActiveCart.Price>, val total: ActiveCart.Price)