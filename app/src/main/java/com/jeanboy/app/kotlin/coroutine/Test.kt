package com.jeanboy.app.kotlin.coroutine

import kotlinx.coroutines.*

class Test {

    fun main() {
        GlobalScope.launch {
            val image = getImage()
            println(image)
        }
    }
}

suspend fun getImage(): String {
    withContext(Dispatchers.IO) {
        delay(100)
    }
    return "image"
}