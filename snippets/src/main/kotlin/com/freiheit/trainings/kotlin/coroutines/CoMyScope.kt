package com.freiheit.trainings.kotlin.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.UUID
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

class RequestScope(private val requestContext: RequestContext = RequestContext()) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = requestContext
}

class RequestContext(val requestId: String = UUID.randomUUID().toString()) : AbstractCoroutineContextElement(Key) {
    // this is necessary to mark this as an coroutine context
    //
    // launch(requestContext) /* <- requires Request context to be a CoroutineContext */  {...}
    object Key : CoroutineContext.Key<RequestContext>
}

fun CoroutineScope.requestId(): String {
    val requestContext = coroutineContext[RequestContext.Key]
    return requestContext?.requestId ?: throw IllegalStateException("No request ID present")
}

suspend fun requestArticleData() = withContext(Dispatchers.IO) {
    println(requestId())
    return@withContext """
        {"articleId": "12345"}
    """.trimIndent()
}

fun main() {
    val scope = RequestScope()
    val result = scope.async {
        return@async requestArticleData()
    }

    runBlocking {
        println(result.await())
    }
}