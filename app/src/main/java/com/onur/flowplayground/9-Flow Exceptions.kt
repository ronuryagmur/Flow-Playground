package com.onur.flowplayground

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun flow6(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // emit next value
    }
}

////Everything is caught. Exceptions in the emitter, terminal operators or intermediate operators
//fun main() = runBlocking<Unit> {
//    try {
//        flow6().collect { value ->
//            println(value)
//            check(value <= 1) { "Collected $value" }
//        }
//    } catch (e: Throwable) {
//        println("Caught $e")
//    }
//}


//fun main() = runBlocking<Unit> {
//    flow6()
//        .catch { e -> println("caught $e") }
//        .collect { value ->
//        println(value)
//    }
//}

fun main() = runBlocking<Unit> {
    flow6()
        .onEach { value ->
            println(value) }
        .catch { e -> println("caught $e") }
        .collect()
}