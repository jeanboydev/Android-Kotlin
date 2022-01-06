package com.jeanboy.app.kotlin.training.part3

import java.lang.StringBuilder


/**
 * 【2】扩展函数
 * 如果一个类的成员函数和扩展函数有相同的签名，成员函数往往会被优先使用
 */
fun String.lastChar(): Char = this[this.length - 1]

/**
 *【3】扩展属性
 */
val String.firstChar: Char
    get() = get(0)

/**
 *【4】可变扩展属性
 */
var StringBuilder.firstChar: Char
    get() = get(0)
    set(value: Char) {
        this.setCharAt(0, value)
    }