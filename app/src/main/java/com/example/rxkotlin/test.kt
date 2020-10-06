package com.example.rxkotlin

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toCompletable
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.rxkotlin.toObservable



fun main() {
    val observable = listOf(1, 1, 2, 3).toObservable()
    observable.test().assertValues(1, 1, 2, 3)
    val flowable = listOf(1, 1, 2, 3).toFlowable()
    flowable.buffer(2).test().assertValues(listOf(1, 1), listOf(2, 3))
    var value = 0
    val completable = { value = 3 }.toCompletable()
   

    test("ggfgf".toCharArray())

}

fun test(args: CharArray) {
    val source = listOf("A", "B", "C").toObservable()
        .filter { it == "B" }
        .subscribeBy(
            onNext = { println(it) }
        )
}