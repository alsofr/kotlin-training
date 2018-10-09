package com.freiheit.trainings.kotlin.scoping

import java.math.BigDecimal

val foo = 1
    .takeIf { it % 2 == 0 }
    ?.let { BigDecimal(it) }