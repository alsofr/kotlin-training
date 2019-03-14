package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class ArticleId(val id: String)
data class Article(val id: ArticleId)
data class Price(val netPrice: Double)


val art = Article(ArticleId("1"))
val pr = Price(1.0)
//val myScope = RequestScope()

fun writeArticleData(article: Article) = runBlocking {
    //no explicit scope needed!
    launch {
        println("writing $article.id")
    }
}

fun writePriceAndArticleData(article: Article, price: Price) = runBlocking {
    //no explicit scope needed!
    launch {
        delay(500)
        println("writing $article.id")
    }

    // create a new scope
    coroutineScope {
        delay(500)
        println("writing price $price")
    }


    println("done writing article and price")
}

fun main() {
//    runBlocking {
//        writeArticleData(art)
//    }

    writePriceAndArticleData(art, pr)


}