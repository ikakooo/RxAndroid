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
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val tag = "jdfskhfjhfsd"
    override fun onCreate(savedInstanceState: Bundle?) {
        init()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        d(tag,"threadname: "+Thread.currentThread().name.toString())
        jdkfsfhjhdjsID.setOnClickListener {


        }
    }



    private fun init() {
        //mainn()
       // CPUtest.cpu()
             //val ikako = async {CPUtest.cpuTestCoroutines()}
        d(tag,"threadname: "+Thread.currentThread().name.toString())
        corutineeee()



    }

    fun corutineeee()=runBlocking {
        val job= CoroutineScope(Job() + Dispatchers.IO)
        d("ggggwerergg",Thread.currentThread().name.toString())
        d("ggggwerergg","from launch coroutine top")
        job.launch {
            delay(7_000)
            d("ggggwerergg",Thread.currentThread().name.toString())
            d("ggggwerergg","from launch coroutine body")
        }
        //delay(5_000)
        d("ggggwerergg",Thread.currentThread().name.toString())
        d("ggggwerergg","from runblocking")


        val time = measureTimeMillis {
            val first = job.async { firstNumber() }
            val second = job.async { secondNumber() }
            val third = job.async { thirdNumber() }

            //val result = first.await() + second.await() + third.await()
        }

       // println(time) //prints 7 seconds
        d("ggggwerergg","TimeEEE: " + time.toString())
       // job.cancel()
    }

    private suspend fun firstNumber(): Int {
        delay(3_000) // 3 seconds delay
        d("ggggwerergg",Thread.currentThread().name.toString()+" 3_000")
        return 5
    }
    private suspend fun secondNumber(): Int {
        delay(5_000) // 5 seconds delay
        d("ggggwerergg",Thread.currentThread().name.toString()+" 5_000")
        return 8
    }
    private suspend fun thirdNumber(): Int {
        delay(7_000) // 7 seconds delay
        d("ggggwerergg",Thread.currentThread().name.toString()+" 7_000")
        return 10
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