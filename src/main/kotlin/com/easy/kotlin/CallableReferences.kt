package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */


/**
 * "Callable References" or "Feature Literals", i.e. an ability to pass
 * named functions or properties as values. Users often ask
 * "I have a foo() function, how do I pass it as an argument?".
 * The answer is: "you prefix it with a `::`".
 */

fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))
}

fun isOdd(x: Int) = x % 2 != 0
