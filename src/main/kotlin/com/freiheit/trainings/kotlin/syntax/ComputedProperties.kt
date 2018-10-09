package com.freiheit.trainings.kotlin.syntax

import javax.inject.Inject
import kotlin.random.Random

// Functions as properties
val yearsUntilRelease get() = Random.nextInt(1, 10)


// Annotations and visibility modifiers
var iWriteUnreadabeSoftware = true
    @Inject private set


// Computed setters and backing fields
var articleId: String = "A-69"
    set(value) {
        if (value.isValidArticleId()) field = value
    }