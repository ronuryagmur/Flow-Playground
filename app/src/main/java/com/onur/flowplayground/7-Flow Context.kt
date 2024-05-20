package com.onur.flowplayground

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Collection of a flow always happens in the context of the calling coroutine.
 * So, by default, code in the flow { ... } builder runs in the context that is provided by a collector of the corresponding flow
 *
 * There is a common pitfall when using withContext. Changing the context of flow should be done by flowOn operator.
 */

fun main() = runBlocking<Unit> {
    flow4().collect { value -> println("Collected $value  ---threadName: ${Thread.currentThread().name}") }
}

fun flow4(): Flow<Int> = flow {
    println("Started simple flow   ---threadName: ${Thread.currentThread().name}")
    for (i in 1..3) {
        emit(i)
    }
}.flowOn(Dispatchers.Default)