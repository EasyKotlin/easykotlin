package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

class Empty


class Book1 constructor(val name: String, val author: String) {
    override fun toString(): String {
        return "Book1(name='$name', author='$author')"
    }
}

class Book2(var name: String, val author: String) {
    init {
        println("Book2 initialized with value (name= ${name}, author=${author})")
        name = name.toUpperCase()
    }

    override fun toString(): String {
        return "Book2(name='$name', author='$author')"
    }


}

annotation class Inject
//当主构造函数有注解或者可见性修饰符，需加 constructor 关键字。
class Book3 @Inject constructor(var name: String, val author: String) {
    init {
        println("Book3 initialized with value (name= ${name}, author=${author})")
        name = name.toUpperCase()
    }

    override fun toString(): String {
        return "Book2(name='$name', author='$author')"
    }

}


open class Person {

    var name: String = ""
    var age: Int = 0

    constructor() {
        println("constructor 1 called!")

    }

    constructor(name: String) : this() {
        println("constructor 2 called!")
        this.name = name

    }

    constructor(name: String, age: Int) : this(name) {
        println("constructor 3 called!")
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }

    open fun sayHi() {
        val name = this.name
        println("${name} say Hi to u!")
        val b = Book("Easy Kotlin")
        println(b)
    }

    fun sayNo() {
        val name = this.name
        println("${name} say NO to u!")
        val b = Book("Easy Kotlin")
        println(b)
    }


    class Book {
        var name: String = ""

        constructor() {

        }

        constructor(name: String) : this() {
            this.name = name
        }

        override fun toString(): String {
            return "Book(name='$name')"
        }


    }

}

class Student : Person {
    var id: String = ""
    var sex: String = ""

    constructor() {
    }

    constructor(id: String, sex: String) : super() {
        this.id = id
        this.sex = sex
    }

    constructor(name: String, id: String, sex: String) : super(name) {
        this.id = id
        this.sex = sex
    }

    constructor(name: String, age: Int, id: String, sex: String) : super(name, age) {
        this.id = id
        this.sex = sex
    }

    override fun toString(): String {
        return "Student(id='$id', sex='$sex', name=${super.name}, age = ${super.age})"
    }

    override fun sayHi() {
        super.sayHi()
        println("Child SayHi Called!")
    }
//
//    override fun sayNo(){ // sayNo in Person is final(not open), so it cannot be override
//
//    }


}

open class Base {
    open fun v() {}
    fun notopenv() {}
}

class Derived : Base() {
    override fun v() {}
//    override fun notopenv(){}// 'notopenv' in 'Base' is final, so it cannot be overridden
//    fun notopenv() {} // 这样写也是不允许的
}


abstract class A {
    abstract fun fa()
    abstract fun f()
}

interface B {
    fun fb() {
        print("FB")
    }

    fun f() {
        print("B")
    }
}

class C : A, B {
    override fun fa() {
    }

    override fun fb() {
    }

    override fun f() {
    }

    constructor() {

    }


}


open class BaseC {
    open fun f() {}
}

abstract class Derived2 : BaseC() {
    override abstract fun f()
}


fun main(args: Array<String>) {
    println(Empty())
    println(Book1("Easy Kotlin", "Jack"))
    println(Book2("Easy Kotlin", "Jack"))

    println(Person())
    println(Person("Jack"))
    println(Person("Jack", 29))

    val p = Person("Rose", 20)
    p.sayHi()


    val student = Student(name = "Jack", age = 20, id = "007", sex = "Male")
    println(student)
    student.sayHi()
    student.sayNo()

}
