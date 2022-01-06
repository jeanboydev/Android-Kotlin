package com.jeanboy.app.kotlin.training.part4

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
