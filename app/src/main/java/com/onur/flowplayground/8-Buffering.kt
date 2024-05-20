package com.onur.flowplayground

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun flow5(): Flow<Int> = flow<Int> {
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 500 ms
        emit(i) // emit next value
    }
    println("DONE")
}

//fun main() = runBlocking<Unit> {
//    val time = measureTimeMillis {
//        flow5().collect { value ->
//            delay(500) // pretend we are process{ing it for 500 ms
//            println("$value +  ---  + ${Thread.currentThread().name}")
//        }
//    }
//    println("Collected in $time ms")
//}



//conflate won't process each value, it will process only the most recent ones
fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        flow5().conflate().collect { value ->
            delay(500) // pretend we are processing it for 500 ms
            println("$value +  ---  + ${Thread.currentThread().name}")
            println(value)
        }
    }
    println("Collected in $time ms")
}