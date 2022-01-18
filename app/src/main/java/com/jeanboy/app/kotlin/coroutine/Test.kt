package com.jeanboy.app.kotlin.coroutine

import android.util.Log
import kotlinx.coroutines.*

object Test {
    fun main() {
        Log.e("Test", "main()  ----- start ----- Thread：${Thread.currentThread().name}")
        GlobalScope.launch {
            Log.e("Test", "GlobalScope ----- start ----- Thread：${Thread.currentThread().name}")
            val image = getImage()
            downloadFile(image)
            Log.e("Test", image)
            Log.e("Test", "GlobalScope ----- end ----- Thread：${Thread.currentThread().name}")
        }
        Log.e("Test", "hello")
        Log.e("Test", "main()  ----- end ----- Thread：${Thread.currentThread().name}")
    }
}

suspend fun getImage(): String {
    Log.e("Test", "getImage() ----- start -----  Thread：${Thread.currentThread().name}")
    withContext(Dispatchers.IO) {
        Log.e("Test", "getImage() Dispatchers.IO ----- start ----- Thread：${Thread.currentThread().name}")
        delay(100)
        Log.e("Test", "getImage")
        Log.e("Test", "getImage() Dispatchers.IO ----- end ----- Thread：${Thread.currentThread().name}")
    }
    Log.e("Test", "getImage() ----- end -----  Thread：${Thread.currentThread().name}")
    return "image"
}

suspend fun downloadFile(url: String) {
    Log.e("Test", "downloadFile() ----- start ----- Thread：${Thread.currentThread().name}")
    withContext(Dispatchers.IO) {
        Log.e("Test", "downloadFile() Dispatchers.IO ----- start ----- Thread：${Thread.currentThread().name}")
        delay(100)
        Log.e("Test", "downloadFile")
        Log.e("Test", "downloadFile() Dispatchers.IO ----- end ----- Thread：${Thread.currentThread().name}")
    }
    Log.e("Test", "downloadFile() ----- end ----- Thread：${Thread.currentThread().name}")
}