package com.easy.kotlin

/**
 * Created by jack on 2017/5/29.
 */

fun main(args: Array<String>) {

    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    println(oneMillion)
    println(creditCardNumber)
    println(socialSecurityNumber)
    println(hexBytes)
    println(bytes)

    val d = 123.4
    println(d)
    println(d::class)
    println(d::class.java)

    val l = 3L + 1
    println(l)
    println(l::class)
    println(l::class.java)

    val c: Int = 'c'.toInt()
    println(c)


    val c1 = 'c'
    val c2 = "cc"
    println(c1::class)
    println(c2::class)
    println(c1::class.java)
    println(c2::class.java)

    val ch: Char = 'a'
    println(ch::class.java)//char

    val s = "abc"
    println(s::class.java)//class java.lang.String

    val text = """
    for (c in "foo")
        print(c)
"""
    println(text)

    val text2 = """
    for (c in "foo")
        print(c)

    """.trim()

    println(text2)

    val text3 = """
    |About.
    |Kotlin.
    |Easy Learning.
    |(Jason Chen)
    """.trimMargin("|")

    println(text3)

    val intArray: IntArray = intArrayOf(1, 3, 4);
    val longArray: LongArray = longArrayOf(1L, 2L)
    println(intArray)//[I@2dda6444
    println(longArray)//[J@5e9f23b4
    val str: Array<String> = Array(5, { index -> index.toString() })
    println(str)//[Ljava.lang.String;@4783da3f

}
