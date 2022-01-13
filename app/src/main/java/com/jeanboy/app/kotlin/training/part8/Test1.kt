package com.jeanboy.app.kotlin.training.part8

/**
 * 【1】lambda
 */
fun test1() {
    val sum = { x: Int, y: Int ->
        x + y
    }
    val action = {
        println(42)
    }
    // 有两个 Int 参数和 Int 返回值的函数
    val sum2: (Int, Int) -> Int = { x, y ->
        x + y
    }
    // 没有返回值和参数的函数
    val action2: () -> Unit = {
        println(42)
    }
}

fun test2(url: String, callback: (code: Int, content: String) -> Unit) {

}

/**
 * 【2】内联函数 inline
 */
inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {

}

/**
 * 【3】return@label
 */
fun test3() {
    val list = listOf<String>()
    list.forEach label@{
        if (it == "a") return@label
    }
}