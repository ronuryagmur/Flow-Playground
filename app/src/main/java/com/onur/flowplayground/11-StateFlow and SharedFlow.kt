package com.onur.flowplayground

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * A StateFlow is a hot flow that represents a state, holding a single value at a time. It is also a conflated flow, meaning that when a new value is emitted, the most recent value is retained and immediately emitted to new collectors.
 * It is useful when you need to maintain a single source of truth for a state and automatically update all the collectors with the latest state.
 * It always has an initial value and only stores the latest emitted value.
 */
//fun main() = runBlocking<Unit> {
//    val flow = MutableStateFlow(0)
//
//    launch {
//        flow.collect{
//            println("1- collected: $it")
//        }
//    }
//
//    launch {
//        delay(1200)
//        flow.collect{
//            println("2- collected: $it")
//        }
//    }
//
//    for (i in 1..5) {
//        delay(100)
//        flow.value = i
//    }
//}


///**
// * A SharedFlow is a hot flow that can have multiple collectors. It can emit values independently of the collectors, and multiple collectors can collect the same values from the flow.
// * It’s useful when you need to broadcast a value to multiple collectors or when you want to have multiple subscribers to the same stream of data.
// * It does not have an initial value, and you can configure its replay cache to store a certain number of previously emitted values for new collectors.
// */
fun main() = runBlocking<Unit> {
    val flow = MutableSharedFlow<Int>()

    launch {
        flow.collect{
            println("1- collected: $it")
        }
    }

    launch {
        delay(1200)
        flow.collect{
            println("2- collected: $it")
        }
    }

    for (i in 1..5) {
        delay(100)
        flow.emit(i)
    }
}