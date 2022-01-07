package com.jeanboy.app.kotlin.training.part5

import java.lang.StringBuilder

/**
 * 【1】Lambda 表达式
 *
 * 每一个 Lambda 表达式都会创建一个匿名内部类
 *
 * ::绑定成员引用
 */
val age = {
    print("-------")
    1 // 最后一行为结果
}

data class Person(val name: String, val age: Int)

fun test() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    println(list.map { it * it })

    val list2 = listOf(Person("Alice", 29), Person("Bob", 31))
    println(list2.filter { it.age > 30 })
    println(list2.map { it.name })
}

/**
 * all：是否所有元素都满足判断式
 * any：检查集合中是否至少存在一个匹配的元素
 * count：检查有多少个元素满足了判断式
 * find：找一个满足判断式的元素
 * groupBy：把列表转换成分组的 map
 * flatMap：现根据判断映射，再合成集合
 */

/**
 * 【2】序列
 */
fun test2() {
    val list2 = listOf(Person("Alice", 29), Person("Bob", 31))
    list2.asSequence().filter { it.age > 30 }.map { it.name }.toList()

    generateSequence(age) { it + 1 }
}

/**
 * 【3】带接受者的 lambda：with 与 apply
 */
fun test3() {
    // with 返回执行结果，即最后一行
    val alphabet = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        toString()
    }
    // apply 创建一个对象实例并需要初始化它的一些属性
    val alphabet2 = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
    }.toString()
}