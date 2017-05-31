package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */
/**
 * Here we have a class with a primary constructor and a member function.
 * Note that there's no `new` keyword used to create an object.
 * See http://kotlinlang.org/docs/reference/classes.html#classes
 */

class Greeter(val name: String) {
    fun greet() {
        println("Hello, ${name}");
    }
}

fun main(args: Array<String>) {
    Greeter("Jack").greet() // Kotlin创建对象，不再使用`new` keyword
}
