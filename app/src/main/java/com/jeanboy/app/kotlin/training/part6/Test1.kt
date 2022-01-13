package com.jeanboy.app.kotlin.training.part6

import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

/**
 * 【1】可空类型
 */
var s: String? = null

/**
 * 【2】安全调用运算符 ?.
 */
fun test(s: String?) {
    var result = s?.toUpperCase()

    // 等同于
    if (s != null) {
        result = s.toUpperCase()
    } else {
        result = null
    }
}

/**
 * 【3】Elvis 运算符 ?:
 */
fun test2(s: String?) {
    // 如果 s 为空 返回 ""
    val result = s ?: ""
}

/**
 * 【4】安全装换 as?
 */
fun test3(s: String?) {
    // 尝试把值装换成给定的类型，如果类型不合返回 null
    val result = s as? Any
}

/**
 * 【5】let 函数
 */
fun test4(s: String?) {
    s?.let {
        // 不为空
    } ?: run {
        // 为空
    }
}

/**
 * 【6】延迟初始化属性 lateinit
 */
private lateinit var name: String

/**
 *【7】Any 和 Object
 */
val a: Any? = null
val o: Object = Object()