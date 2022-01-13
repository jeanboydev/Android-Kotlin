package com.jeanboy.app.kotlin.training.part10

import kotlin.reflect.KClass

/**
 * Created by jianbo on 2022/1/13 14:51.
 */
class Test1 {
    @Deprecated("Use removeAt(index) instead", ReplaceWith("removeAt(index)"))
    fun remove(index: Int) {

    }

    fun removeAt(index: Int) {

    }

    // 改变由 Kotlin 生成的 Java 方法或字段的名称
    @JvmName("testJVM")
    fun test() {
        remove(1)
    }

    companion object {
        // 应用于属性，把这个属性暴露成一个没有访问器的公有 Java 字段
        @JvmField
        var a: String = ""

        // 能被用在对象声明或者伴生对象的方法上，把它们暴露成 Java 的静态方法
        @JvmStatic
        fun Test() {
        }
    }
}

// 声明注解
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
annotation class MyTest(val name: String) {
//    val sClass: KClass<out String<*>>
}


