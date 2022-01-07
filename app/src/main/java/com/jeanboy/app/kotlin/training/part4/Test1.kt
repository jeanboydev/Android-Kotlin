package com.jeanboy.app.kotlin.training.part4

import android.view.View
import android.widget.TextView
import java.util.*

/**
 * 【1】接口
 */
interface Clickable {
    fun click()

    // 默认实现的方法
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")

    // 默认实现的方法
    fun showOff() = println("I'm focusable!")
}


// 实现接口
class Button : Clickable, Focusable {
    override fun click() {
        println("I was clicked")
    }

    /**
     * 如果同样的继承成员有不止一个实现，必须提供一个显式实现
     */
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

/**
 * open 其他类可以继承
 */
open class RichButton : Clickable {
    fun disable() {} // 默认是 final 不能在子类中重写

    open fun animate() {} // 函数是 open 可以在子类中重写

    //    override fun click() {} // 重写了一个 open 函数并且它本身同样是 open 的
    final override fun click() {} // 如果想禁止在子类中重写，可以加 final 关键字
}

// Kotlin 默认省略了修饰符，声明就是 public，internal 只在模块内可见，一组一起编译的 Kotlin 文件
// Java 默认可见性 包私有

/**
 * 【2】内部类
 */
class Parent {
    class Child { // 默认不会隐式持有外部类引用
//        val parent = this@Parent
    }

    inner class Child2 { // inner 修饰符，变成一个内部类持有外部类引用
        val parent = this@Parent
    }
}

/**
 * 【3】密闭类
 */

sealed class Expr {
    // 密闭类，所有的子类必须嵌套在父类中，在 when 表达式中处理所有 sealed 类的子类，不需要再提供默认的 else 分支
    class Num(val value: Int) : Expr()
    class Sum(val left: Int, val right: Int) : Expr()
}

/**
 * 【4】构造方法
 */
class User constructor(val nickname: String)

// User 与 User1 等同
class User1 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

/**
 * 【5】== 与 equals
 * 在 Java 中，== 用于比较基本数据类型和引用类型，基本数据类型 == 比较的是值，引用类型 == 比较的是引用，所以引用类型总是使用 equals
 * 在 Kotlin 中，== 是通过 equals 来比较两个值的，想要进行引用比较，可以使用 ===
 */
fun test1() {
    val b = "1" == "2"
    val b2 = "1" === "1"
}

/**
 * 【6】数据类，自动重写 equals、hashCode、toString
 */
data class Client(val name: String, val age: Int)

/**
 * 【7】委托 by
 */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) :
    MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

/**
 * 【8】object 关键字
 * 1. 创建单例
 * 2. 伴生对象
 * 3. 对象表达式用来代替 Java 的匿名内部类
 */
object Test1 {

}

class A {
    // 伴生对象
    companion object {
        // 调用方式 A.bar()
        fun bar() {}
    }
}

fun test2() {
    val textView = TextView(null)
    textView.setOnClickListener(
        // 匿名对象
        object : View.OnClickListener {
        override fun onClick(v: View?) {

        }
    })
}

