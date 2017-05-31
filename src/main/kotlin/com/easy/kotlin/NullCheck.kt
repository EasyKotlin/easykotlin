package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

fun main(args: Array<String>) {
    val s: String? = null
    println(s?.length)

    var fooNullable: String? = "abc"
    println(fooNullable?.length) // => 3
    println(fooNullable?.length ?: -1) // => 3
    fooNullable = null
    println(fooNullable?.length) // => null
    println(fooNullable?.length ?: -1) // => -1

    testNullSafeOperator(null)
    testNullSafeOperator("12345678901")
    testNullSafeOperator("123")

}


fun testNullSafeOperator(string: String?) {
    println(string?.toCharArray()?.getOrNull(10)?.hashCode())
}

fun toString(any:Any): String{
  return any?.toString()
}
