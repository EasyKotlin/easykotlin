package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

class Functions {
    fun fvoid1(){return Unit}
    fun fvoid2(){}

    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b


}

/**
 * hhhh
 * /**
 *  fff
 *  /**
 *    ggggg
 *  */
 * */
 *
 * abc
 *
 */
fun main(args:Array<String>){
    val f = Functions()
    println(f.fvoid1())
    println(f.fvoid2())
    println(f.sum1(1,1))
    println(f.sum2(1,1))
}
