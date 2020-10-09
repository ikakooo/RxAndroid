package com.example.rxkotlin

import android.util.Log.d
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
val tag = "TestCpuSpeed"
object CPUtest {

    suspend fun cpu()= coroutineScope{
    var counter = 0
    val numberOfThreads = 1_000_000
    val time = measureTimeMillis {
        for (i in 1..numberOfThreads) {
            async{
                counter += 1

            }
        }
    }
        d(tag,"threadname: "+Thread.currentThread().name.toString())
    d(tag,"Created ${numberOfThreads} threads in ${time}ms.")}

    suspend fun cpuTestCoroutines()= coroutineScope{
        var counter = 0
        val numberOfCoroutines = 1_000_000
        val time = measureTimeMillis {
            for (i in 1..numberOfCoroutines) {
                launch { counter += 1 }
            }
        }
        d(tag,"Created ${numberOfCoroutines} OfCoroutines $counter in ${time}ms.")
    }
}