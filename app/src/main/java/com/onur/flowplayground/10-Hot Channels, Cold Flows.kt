package com.onur.flowplayground

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun coldFlow() = flow {
    println("flow started..")
    for (i in 1..5) {
        println("sending $i")
        emit(i)
        delay(300)
    }
}

fun CoroutineScope.hotChannel() = produce {
    println("channel started..")
    for (i in 1..5) {
        println("sending $i")
        send(i)
        delay(300)
    }
}


/***
 * Channels, as hot data streams, produce elements independently of their consumption and then keep them. They do not care how many receivers there are.
 * Since each element can be received only once, after the first receiver consumes all the elements, the second one will find a channel that is empty and closed already.
 */
fun main() = runBlocking<Unit> {
    val channel = hotChannel()
    val flow = coldFlow()


    channel.consumeAsFlow().collect {
        println("1-consumed: $it")
    }

    channel.consumeAsFlow().collect {
        println("2-consumed: $it")
    }
}