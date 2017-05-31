package com.easy.kotlin


/**
 * Created by jack on 2017/5/30.
 */

//    Lambda 表达式
val fsum0 = { x: Int, y: Int ->  x + y  }
val fsum1 = { x: Int, y: Int -> { x + y } }
val fsum2 = fun(x: Int, y: Int): Int = x + y
val fsum3 = fun Int.(other: Int): Int = this + other


fun main(args: Array<String>) {
    println(fsum0(1, 1))
    println(fsum0.invoke(1,1))

    println(fsum1(1, 1).invoke())
    println(fsum2(1, 1))
    println(1.fsum3(1))

    val ints = intArrayOf(-1, -2, 3, 4, 5, 6)
    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum = it.fsum3(sum)
        //sum += it;
    }
    println(sum)//18

    val doubled = ints.map { value -> value * 2 }
    println(doubled)

}
