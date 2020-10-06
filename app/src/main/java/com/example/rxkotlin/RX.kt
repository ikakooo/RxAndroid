package com.example.rxkotlin

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
val source2: Observable<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).toObservable()
val source = listOf("A", "B", "C", "B", "k", "b").toObservable()

fun main(args: Array<String>) {
    source.map { it == "B" }
        .subscribeBy(
            onNext = { println(it) }
        )
    source2
        .subscribeOn(Schedulers.io())
        .map { it * 7 }
        .filter { it <= 225 }
        .subscribeBy { println(it) }
//    source2.map { "->>> ".repeat(it) }
//        .filter { it.length <= 25 }
//        .subscribeBy { println(it) }


    exampleOf("hjfsdhf dsfdf") {
        val popular: Observable<String> = Observable.just("fdggdf")
        val observable = Observable.just("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd")
        val observable2 = Observable.just(listOf("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd"))
        val observable3 = Observable.fromIterable(listOf("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd"))
        val observable4 = listOf("dffd", "dfdsf", "dfsdf", "fdsdf", "dsfd").toObservable()
        observable3
            .subscribeOn(Schedulers.io())
            .map { "->>>/ ".repeat(3) }
            .subscribeBy(
                onNext = { println(it) }
            )
    }

}
