package com.onur.flowplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking<Unit> {
//    (1..5).asFlow() // a flow of requests
//        .filter { it % 2 == 0 }
//        .map { request -> performRequest(request) }
//        .collect { response -> println(response) }
//}

suspend fun performRequest(request: Int): String {
    delay(1000) // imitate long-running asynchronous work
    return "response $request"
}

//fun main() = runBlocking<Unit> {
//    (1..5).asFlow() // a flow of requests
//        .transform {
//            if (it % 2 == 0) {
//                emit(performRequest(it))
//                emit(performRequest(it))
//            }
//        }
//        .collect { response -> println(response) }
//}



//fun numbers() = flow {
//    try {
//        emit(1)
//        emit(2)
//        println("This line will not execute")
//        emit(3)
//    } finally {
//        println("Finally in numbers")
//    }
//}
//
//
///**
// * Cancellation in coroutines is always performed by throwing an exception,
// * so that all the resource-management functions (like try { ... } finally { ... } blocks) operate normally in case of cancellation:
// */
//fun main() = runBlocking<Unit> {
//    numbers()
//        .take(2) // take only the first two
//        .collect { value -> println(value) }
//}


fun main() = runBlocking<Unit> {
//    val nums = (1..3).asFlow().onEach { delay(200) } // numbers 1..3
//    val strs = flowOf("one", "two", "three").onEach { delay(400) } // strings
//    nums.zip(strs) { a, b -> "$a -> $b" } // compose a single string
//        .collect { println(it) } // collect and print


    val nums = (1..3).asFlow().onEach { delay(200) } // numbers 1..3
    val strs = flowOf("one", "two", "three").onEach { delay(400) } // strings
    nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string
        .collect { println(it) } // collect and print
}