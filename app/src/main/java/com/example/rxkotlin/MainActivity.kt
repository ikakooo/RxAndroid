package com.example.rxkotlin

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.icu.util.TimeUnit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.util.Log.d
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val tag = "jdfskhfjhfsd"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        d(tag,"threadname: "+Thread.currentThread().name.toString())
        jdkfsfhjhdjsID.setOnClickListener {


        }
    }



    private fun init() = runBlocking{
        //mainn()
        CPUtest.cpu()
             //val ikako = async {CPUtest.cpuTestCoroutines()}
        d(tag,"threadname: "+Thread.currentThread().name.toString())




    }
    private suspend fun setTextAfterDelay(seconds: Long, text: String) {
        delay(seconds)
        jdkfsfhjhdjsID.text = text
    }
    @SuppressLint("CheckResult")
    fun mainn() {
        var counter = 0
        val numberOfThreads = 1000

        val source2: Observable<Number> = listOf(
            NUMBERED,
            IKAKOO,
            1,
            7564546500000000000000000000000000000000000.6,
            2,
            6666666,
            7777,
            4,
            44555,
            7564546500000000000000000000000000000000000.6
        ).toObservable()
        val source = listOf("A", "B", "C", "B", "k", "b").toObservable()
//    source.map { it == "B" }
//        .subscribeBy(
//            onNext = { println(it) }
//        )
//    source2
//        .subscribeOn(Schedulers.io())
//        .map { it.toDouble() * 7.toLong() }
//        .subscribeBy {
//            println(it)
//            println(Thread.currentThread().name.toString())
//            //Thread.sleep(500)
//
//        }

        source2
            .subscribeOn(Schedulers.io())
            .map { "->>> ".repeat(3) }
            .subscribeBy(onError = {
                Thread.sleep(500)
                println("onError")
                println(Thread.currentThread().name.toString())
            }, onNext = {
                Thread.sleep(2000)
                d(tag,"onNext")
                d(tag,it)
                d(tag,Thread.currentThread().name.toString())
                d(tag,Thread.currentThread().toString())
            },
                onComplete = {
                    Thread.sleep(500)
                    d(tag,"onComplete")
                    d(tag,Thread.currentThread().name.toString())

                })
        //Thread.sleep(5000)
//    source2.map { "->>> ".repeat(it) }
//        .filter { it.length <= 25 }
//        .subscribeBy { println(it) }
        d(tag,Thread.currentThread().name.toString())
        d(tag,"\n --------- Example of: $String  --------")
        d(tag,Thread.currentThread().toString())
        Thread.sleep(1000)
        d(tag,"\n --------- Example of: $String  --------")



    val time = measureTimeMillis {
        for (i in 1..numberOfThreads) {
            thread() {
                counter += 1
            }
        }
    }
        d(tag,"Created ${numberOfThreads} threads $counter in ${time}ms.")
}
}