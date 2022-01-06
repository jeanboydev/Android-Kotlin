package com.jeanboy.app.kotlin.training.part2

/**
 * Created by jianbo on 2021/12/23 16:09.
 */
class Test1 {

    /**
     * 【1】字符串拼接
     */
    fun main(args: Array<String>) {
        print("Hello ${if (args.isNotEmpty()) args[0] else "someone"}!")
    }

    /**
     * 【2】if 是表达式，而不是语句。表达式有值，语句总是包围着它的代码块中的顶层元素，没有自己的值
     */
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    /**
     * 【3】成员变量
     */
    class Person {
        val name: String? = null // 只读属性：生成一个字段和一个简单的 getter
        var age = 0 // 可写属性：生成一个 getter 和一个 setter
    }

    /**
     * 【4】枚举
     */
    enum class Color {
        RED, ORANGE, YELLOW, GREEN, BLUE
    }

    enum class Color2(
        val red: Int,
        val green: Int,
        val blue: Int
    )

    /**
     * 【5】when
     */
    fun evalWithLogging(e: String): Int =
        when (e) {
            "1" -> {
                e.hashCode()
            }
            "2" -> {
                2
            }
            else -> -1
        }

    /**
     * 【6】for
     */
    fun testFor() {
        for (i in 1..100) {
            print("i = ${i}")
        }

        for (i in 100 downTo 1 step 2) {
            print("i = ${i}")
        }

        val list = arrayListOf<String>("10", "11", "1001")
        for ((index, element) in list.withIndex()) {
            print("index = ${index}, $element")
        }

        val map = mutableMapOf<String, String>()
        map["1"] = "1"
        map["2"] = "2"
        map["3"] = "3"
        for ((key, value) in map) {
            print("k = ${key}, v = ${value}")
        }
    }

    /**
     * 【7】异常
     */
    fun exception() {
        try {
            val a = 100 / 0
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            print("finally")
        }

        val a = try {
            100 / 0
        } catch (e: Exception) {
            e.printStackTrace()
            -1
        }
    }
}