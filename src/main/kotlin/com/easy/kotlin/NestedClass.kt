package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

class Outer {
    private val bar: Int = 1

    class Nested {
        fun foo1() = 2
        //fun foo11() = bar// 访问不到
    }

    inner class Inner {
        fun foo2() = bar // inner class 能够访问外部类的成员
    }
}


open class AA(x: Int) {
    open val y: Int = x
}

interface BB {}

val ab: AA = object : AA(1), BB {
    override val y = 100
}


class  Hoc{
    fun adHocf() {
        val adHoc = object {
            var x: Int = 0
            var y: Int = 0
        }

        println("adHoc.x + adHoc.y = " + (adHoc.x + adHoc.y))
    }
}



fun main(args: Array<String>) {
    val nestedDemo = Outer.Nested().foo1()
    val innerDemo = Outer().Inner().foo2()

    println(nestedDemo)// 2
    println(innerDemo)// 1

    val h = Hoc()
    println(h.adHocf())
    val a = AA(1)
    println(a.y) //1
    println(ab.y) // 15
}

