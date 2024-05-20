package com.onur.flowplayground

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val firstFlow = flowOf(1,2,5).collect{value ->
        println("flowOf Builder: $value")
    }

    val secondFlow = listOf(1,2,3).asFlow()

    secondFlow.collect{value ->
        println("asFlow Builder: $value")
    }

    val thirdFlow = flow {
        delay(1000)
        emit("emitted something after 1000ms")

        secondFlow.collect {
            delay(1000)
            emit(it)
        }
    }.collect {value ->
        println("flow Builder: $value")
    }
}