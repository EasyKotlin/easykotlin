package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

class Box<T>(t: T) {
    var value = t
}



abstract class Source<out T> {
    abstract fun nextT(): T
}

fun outDemo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
    // ...
    println(objects)

}
// 类型别名
typealias Predicate<T> = (T) -> Boolean

fun foo1(p: Predicate<Int>) = p(1)
fun foo2(p: Predicate<Int>) = p(-1)

fun main(args: Array<String>) {
    val box1 = Box<String>("easy kotlin")
    println(box1.value)

    // 1 的类型是 Int,  编译器可以推断出泛型T的类型是Int
    val box2 = Box(1)
    println(box2.value)

    val f: (Int) -> Boolean = { it > 0 }
    println(foo1(f)) // 输出 "true"
    println(foo2(f)) // 输出 "false"

    val fn : (Int) -> Boolean = {it < 0}
    println(foo1(fn)) // 输出 "false"
    println(foo2(fn)) // 输出 "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // 输出 "[1]"
}
