package com.jeanboy.app.kotlin.training.part7

import java.lang.reflect.Type
import kotlin.properties.Delegates

/**
 * 【1】重载运算符
 */
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// 扩展函数重载
operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

fun test1() {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
}

/**
 * 【二元运算符】+ - * / %
 * 【复合运算符】+= -+ *= /= %=
 * 【一元运算符】+a -a !a ++a a++ --a a--
 * 【比较运算符】== != > <
 * 【等号运算符】equals ==
 * 【排序运算符】compareTo
 * 【集合区间】下标访问：get set []；区间：in until rangeTo；for 循环 iterator
 */

/**
 * 【2】解构与组件函数
 */
fun test2(){
    val p = Point(10, 30)
    val (x, y) = p // 声明变量 x、y 然后用 p 的组件来初始化
}
/**
 * 【3】委托
 */
class Foo{
    /**
     * 属性 p 将它的访问器逻辑委托给了另一个对象：这里是 Delegates 类的一个新实例。
     * 通过关键字 by 对其后的表达式求值来获取这个对象，关键字 by 可以用于任何符合委托约定规则的对象。
     * 编译器会创建一个隐藏的辅助属性，并使用委托对象的实例进行初始化，初始属性 p 会委托给该实例。
     */
    var p:Type by Delegates.notNull()
}

/*
class Foo{
    private val delegate = Delegates.notNull<String>()

    // p 的访问都会调用对应的 delegate 的 getValue 和 setValue 方法
    var p:Type
        set(value) = delegate.setValue(value)
        get() = delegate.getValue()
}*/
/**
 * 【4】by lazy
 */
class Person(val name:String){
    /*
    lazy 函数返回一个对象，该对象具有一个名为 getValue 且签名正确的方法，因此可以把它与 by 关键字一起使用来创建一个委托属性。
    lazy 的参数是一个 lambda，可以调用它来初始化这个值。默认情况下，lazy 函数是线程安全的，如果需要可以设置其他选项来告诉它要使用哪个锁，或者完全避开同步
     */
    val emails by lazy { loadEmail(this) }

    private fun loadEmail(person: Person) {

    }
}