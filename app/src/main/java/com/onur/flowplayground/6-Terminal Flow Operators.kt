package com.onur.flowplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking {
//    flow3().collect{
//        println("----emitted value $it")
//    }
//}

fun flow3() = flow {

    delay(100)

    println("emitting first value")
    emit(1)

    delay(100)

    println("emitting second value")
    emit(2)

    delay(100)

    println("emitting third value")
    emit(3)
}

fun main() = runBlocking {
//    val item = flow3().first()
//    val item = flow3().first{it > 1}
//    val item = flow3().last()
//    val item = flow3().single()
//    val item = flow3().toSet()
//    val item = flow3().toList()

//    val item = flow3().fold(10) { acc, value ->
//        acc + value
//    }

    val item = flow3().reduce() { accumulator, value ->
        accumulator + value
    }

    println("emitted value: $item")
}