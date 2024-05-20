package com.onur.flowplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger

/**
* A suspending function asynchronously returns a single value, but how can we return multiple asynchronously computed values? This is where Kotlin Flows come in.
*
* */

private fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    launch {
        calcFactorial(5).forEach{
            val endTime = System.currentTimeMillis()
            println("fact: $it  timePassed: ${endTime - startTime}  --------  ${Thread.currentThread().name}")
        }
    }

    launch {
        println("not blocked! ------------ ${Thread.currentThread().name}")
    }
}

fun calcFactorial(number: Int): List<BigInteger> = buildList {
    var result = 1
    for (i in 1..number) {
        Thread.sleep(100)
        result *= i
        add(BigInteger.valueOf(result.toLong()))
    }
}

//fun calcFactorial(number: Int): Sequence<BigInteger> = sequence {
//    var result = 1
//    for (i in 1..number) {
//        Thread.sleep(100)
//        result *= i
//        yield(BigInteger.valueOf(result.toLong()))
//    }
//}

//suspend fun calcFactorial(number: Int) = buildList {
//    var result = 1
//    for (i in 1..number) {
//        delay(100)
//        result *= i
//        add(BigInteger.valueOf(result.toLong()))
//    }
//}

//fun calcFactorial(number: Int) = flow {
//    var result = 1
//    for (i in 1..number) {
//        delay(100)
//        result *= i
//        emit(BigInteger.valueOf(result.toLong()))
//    }
//}
