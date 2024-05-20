package com.onur.flowplayground

import kotlinx.coroutines.cancel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


//fun main() = runBlocking<Unit> {
//    withTimeoutOrNull(250) { // Timeout after 250ms
//        flow2().collect { value -> println(value) }
//    }
//    println("Done")
//}
//
//fun flow2(): Flow<Int> = flow {
//    for (i in 1..3) {
//        delay(100)
//        println("Emitting $i")
//        emit(i)
//    }
//}




//fun main() = runBlocking<Unit> {
//    flow2().collect { value ->
//        if (value == 3) cancel()
//        println(value)
//    }
//}
//
//fun flow2(): Flow<Int> = flow {
//    for (i in 1..5) {
//        println("Emitting $i")
//        emit(i)
//    }
//}





/**
 * In the case where you have a busy loop with coroutines you must explicitly check for cancellation.
 * You can add .onEach { currentCoroutineContext().ensureActive() }, but there is a ready-to-use cancellable operator provided.
 */
fun main() = runBlocking<Unit> {
    (1..5).asFlow().cancellable().collect { value ->
        if (value == 3) cancel()
        println(value)
    }
}