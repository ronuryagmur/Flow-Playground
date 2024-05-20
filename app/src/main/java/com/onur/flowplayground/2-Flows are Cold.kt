package com.onur.flowplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/***
 *
 * Flows are cold streams similar to sequences — the code inside a flow builder does not run until the flow is collected.
 *
 */

fun main() = runBlocking<Unit> {
    println("1-Calling simple function...")
    val flow = flow1()
    println("2-Calling collect...")
    flow.collect { value -> println(value) }
    println("3-Calling collect again...")
    flow.collect { value -> println(value) }
}

fun flow1(): Flow<Int> = flow {
    println("4-Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}