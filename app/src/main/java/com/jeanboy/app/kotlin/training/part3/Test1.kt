package com.jeanboy.app.kotlin.training.part3

import java.lang.StringBuilder

/**
 * Created by jianbo on 2022/1/5 17:23.
 */
class Test1 {
    /**
     * 【1】创建集合
     */
    fun main(args: Array<String>) {
        val set = hashSetOf<Int>(1, 7, 53)
        val list = arrayListOf(1, 7, 53)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        val strings = listOf("first", "second", "fourteenth")
    }

    /**
     * 【2】扩展函数
     */
    fun test() {
        println("kotlin".lastChar())
    }

    /**
     *【3】扩展属性
     */
    fun test2() {
        println("kotlin".firstChar)
    }

    /**
     *【4】可变扩展属性
     */
    fun test3() {
        val sb = StringBuilder("kotlin")
        sb.firstChar = '!'
        println(sb)
    }

    /**
     *【5】可变参数
     */
    fun test4(vararg values: String) {
        // * 为展开运算符，展开数组的内容
        val list = listOf("args:", *values)
        println(list)
    }
}