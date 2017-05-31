package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

/*
Kotlin 程序的入口是名为"main"的函数。
命令行参数通过这个方法的数组参数传递。
*/
fun main(args: Array<String>) {
    /*
    声明变量可以用"var" 或者 "val"。
    用"val"声明的参数不能重新赋值，但用"var"声明的可以。
    */
    val fooVal = 10 // 不能再赋别的值给fooVal
    //fooVal = 11 // Val cannot be reassigned
    var fooVar = 10
    fooVar = 20 // fooVar可以重新赋值

    /*
    大部分情况下，Kotlin 可以判断变量的类型，所以不用每次都显式声明。
    我们也可以像下面这样显式声明一个变量的类型：
    */
    val foo: Int = 7

    /*
    字符串可以用与Java类似的方式表示。
    用反斜杠转义。
    */
    val fooString = "My String Is Here!"
    val barString = "Printing on a new line?\nNo Problem!"
    val bazString = "Do you want to add a tab?\tNo Problem!"
    println(fooString)
    println(barString)
    println(bazString)

    /*
    原始字符串(raw string)由三重引号（“”“）分隔。
    原始字符串可以包含换行符和任何其他字符。
    */
    val fooRawString = """
fun helloWorld(val name : String) {
   println("Hello, world!")
}
"""
    println(fooRawString)

    /*
    字符串可以包含模板表达式。
    模板表达式以美元符号（$）开始。
    */
    val fooTemplateString = "$fooString has ${fooString.length} characters"
    println(fooTemplateString)

    /*
    要使变量保持为null，必须将其显式指定为可空。
    在变量类型后面加上 ? 符号，即声明为可空。
    用 ?. 运算符来访问一个可空的变量。
    用 ?: 运算符来指定当该变量为空时的替代值
    */
    var fooNullable: String? = "abc"
    println(fooNullable?.length) // => 3
    println(fooNullable?.length ?: -1) // => 3
    fooNullable = null
    println(fooNullable?.length) // => null
    println(fooNullable?.length ?: -1) // => -1

    /*
    用“fun”关键字声明函数。
    函数参数在函数名后面的括号中指定。
    函数参数可以选择具有默认值。
    函数返回类型（如果需要的话）在参数之后指定。
    */
    fun hello(name: String = "world"): String {
        return "Hello, $name!"
    }
    println(hello("foo")) // => Hello, foo!
    println(hello(name = "bar")) // => Hello, bar!
    println(hello()) // => Hello, world!

    /*
    用“vararg”关键字标记函数参数，
    则允许将可变数量的参数传递给函数。
    */
    fun varargExample(vararg names: Int) {
        println("Argument has ${names.size} elements")
    }
    varargExample() // => Argument has 0 elements
    varargExample(1) // => Argument has 1 elements
    varargExample(1, 2, 3) // => Argument has 3 elements

    /*
    当函数由单个表达式组成时，可以省略大括号，
    直接在 = 符号后写函数体。
    */
    fun odd(x: Int): Boolean = x % 2 == 1
    println(odd(6)) // => false
    println(odd(7)) // => true

    // 如果可以推断出返回类型，那么不需要显式声明它。
    fun even(x: Int) = x % 2 == 0
    println(even(6)) // => true
    println(even(7)) // => false

    // 一个函数可以接受另一个函数作为参数，也可以返回一个函数。
    fun not(f: (Int) -> Boolean): (Int) -> Boolean {
        return { n -> !f.invoke(n) }
    }
    // 用 :: 操作符把一个命名函数用作参数。
    val notOdd = not(::odd)
    val notEven = not(::even)
    // Lambda 表达式可以当作参数。
    val notZero = not { n -> n == 0 }
    /*
    如果lambda只有一个参数，
    那么它的声明可以（与 -> 一起）省略。
    单个参数的名称将是“it”。
    */
    val notPositive = not { it > 0 }
    for (i in 0..4) {
        println("${notOdd(i)} ${notEven(i)} ${notZero(i)} ${notPositive(i)}")
    }

    // "class" 关键字用于类声明。
    class ExampleClass(val x: Int) {
        fun memberFunction(y: Int): Int {
            return x + y
        }

        infix fun infixMemberFunction(y: Int): Int {
            return x * y
        }
    }
    /*
    调用构造函数来创建一个实例。
    注意，Kotlin没有 “new” 这个关键字。
    */
    val fooExampleClass = ExampleClass(7)
    // 可以使用 . 符号来调用成员函数。
    println(fooExampleClass.memberFunction(4)) // => 11
    /*
    如果一个函数用 “infix” 关键字标记，称为中缀标记。
    */
    println(fooExampleClass infixMemberFunction 4) // => 28

    /*
    数据类是创建一种只用于保存数据的类的简洁方法。
    “hashCode”、“equals”和“toString”方法都是自动生成的。
    */
    data class DataClassExample(val x: Int, val y: Int, val z: Int)

    val fooData = DataClassExample(1, 2, 4)
    println(fooData) // => DataClassExample(x=1, y=2, z=4)

    // 数据类有一个“copy”方法。
    val fooCopy = fooData.copy(y = 100)
    println(fooCopy) // => DataClassExample(x=1, y=100, z=4)

    // 对象可以被解构成多个变量。
    val (a, b, c) = fooCopy
    println("$a $b $c") // => 1 100 4

    // 解构声明用于for循环中
    for ((a, b, c) in listOf(fooData)) {
        println("$a $b $c") // => 1 100 4
    }

    val mapData = mapOf("a" to 1, "b" to 2)
    // Map.Entry 也被解构了
    for ((key, value) in mapData) {
        println("$key -> $value")
    }

    // "with" 方法与JavaScript中的 "with" 声明类似.
    data class MutableDataClassExample(var x: Int, var y: Int, var z: Int)

    val fooMutableData = MutableDataClassExample(7, 4, 9)
    with(fooMutableData) {
        x -= 2
        y += 2
        z--
    }
    println(fooMutableData) // => MutableDataClassExample(x=5, y=6, z=8)

    /*
    可以用 "listOf" 方法创建一个list。
    这个list是不可变的 —— 不能增加或删除元素。
    */
    val fooList = listOf("a", "b", "c")
    println(fooList.size) // => 3
    println(fooList.first()) // => a
    println(fooList.last()) // => c
    // 可以通过序号获取list中的元素。
    println(fooList[1]) // => b

    // 用 "mutableListOf" 方法创建可变列表.
    val fooMutableList = mutableListOf("a", "b", "c")
    fooMutableList.add("d")
    println(fooMutableList.last()) // => d
    println(fooMutableList.size) // => 4

    // 用 "setOf" 方法创建集合.
    val fooSet = setOf("a", "b", "c")
    println(fooSet.contains("a")) // => true
    println(fooSet.contains("z")) // => false

    // 用 "mapOf" 方法创建 map.
    val fooMap = mapOf("a" to 8, "b" to 7, "c" to 9)
    // 在map中，通过 kep 来获取 value.
    println(fooMap["a"]) // => 8

    //用 "generateSequence" 方法创建一个序列.
    val fooSequence = generateSequence(1, { it + 1 })
    val x = fooSequence.take(10).toList()
    println(x) // => [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    // 用序列生成斐波那契数的例子。
    fun fibonacciSequence(): Sequence<Long> {
        var a = 0L
        var b = 1L

        fun next(): Long {
            val result = a + b
            a = b
            b = result
            return a
        }

        return generateSequence(::next)
    }

    val y = fibonacciSequence().take(10).toList()
    println(y) // => [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]

    // Kotlin 提供了更高级的功能来处理集合。
    val z = (1..9).map { it * 3 }
            .filter { it < 20 }
            .groupBy { it % 2 == 0 }
            .mapKeys { if (it.key) "even" else "odd" }
    println(z) // => {odd=[3, 9, 15], even=[6, 12, 18]}

    // "for" 循环可以用于任何有迭代器的东西.
    for (c in "hello") {
        println(c)
    }

    // "while" 循环与其它语言中用法一样.
    var ctr = 0
    while (ctr < 5) {
        println(ctr)
        ctr++
    }
    do {
        println(ctr)
        ctr++
    } while (ctr < 10)

    /*
    “if” 表达式可以直接返回值。
    因此，Kotlin 不需要三元运算符 ?:
    */
    val num = 5
    val message = if (num % 2 == 0) "even" else "odd"
    println("$num is $message") // => 5 is odd

    // "when" 可以代替 "if-else if".
    val i = 10
    when {
        i < 7 -> println("first block")
        fooString.startsWith("hello") -> println("second block")
        else -> println("else block")
    }

    // "when" 可以带参数.
    when (i) {
        0, 21 -> println("0 or 21")
        in 1..20 -> println("in the range 1 to 20")
        else -> println("none of the above")
    }

    // "when" 可以当作函数，并返回值.
    var result = when (i) {
        0, 21 -> "0 or 21"
        in 1..20 -> "in the range 1 to 20"
        else -> "none of the above"
    }
    println(result)

    /*
    可以用“is”运算符检查对象是否是特定类型。
    如果对象通过了类型检查，就可以把它当作这个类型来用，无需显示转换。
    */
    fun smartCastExample(x: Any): Boolean {
        if (x is Boolean) {
            // x is automatically cast to Boolean
            return x
        } else if (x is Int) {
            // x is automatically cast to Int
            return x > 0
        } else if (x is String) {
            // x is automatically cast to String
            return x.isNotEmpty()
        } else {
            return false
        }
    }
    println(smartCastExample("Hello, world!")) // => true
    println(smartCastExample("")) // => false
    println(smartCastExample(5)) // => true
    println(smartCastExample(0)) // => false
    println(smartCastExample(true)) // => true

    // Smartcast 也可以用于 when。
    fun smartCastWhenExample(x: Any) = when (x) {
        is Boolean -> x
        is Int -> x > 0
        is String -> x.isNotEmpty()
        else -> false
    }

    /*
    扩展是向类里添加新功能的一种方法。
    这与C＃的扩展方法类似。
    */
    fun String.remove(c: Char): String {
        return this.filter { it != c }
    }
    println("Hello, world!".remove('l')) // => Heo, word!

    println(EnumExample.A) // => A
    println(ObjectExample.hello()) // => hello
}

// 枚举类与Java的枚举类型相似.
enum class EnumExample {
    A, B, C
}

/*
"object" 关键字可用于创建单例对象。
我们不能实例化它，但我们可以通过它的名称来引用它的唯一实例。
这与Scala的单例对象类似。
*/
object ObjectExample {
    fun hello(): String {
        return "hello"
    }
}

fun useObject() {
    ObjectExample.hello()
    val someRef: Any = ObjectExample // 可以直接使用对象名称
}


//
//fun main(args: Array<String>) {
//
//    println(sum1(1, 1))
//    println(sum2(1, 1))
//    printSum1(1, 1)
//    println()
//
//    val s1 = getStringLength1("")
//    println("s1=" + s1)
//    val s2 = getStringLength1("abc")
//    println("s2=" + s2)
//
//    println(getStringLength2(""))
//    println(getStringLength2("abc"))
//
//    //in关键字的使用
//    //如果一个数字是在某一个区间内，可以使用in关键字
//    val y = 10
//    val x = 3
//    //打印y次OK
//    if (x in 1..y - 1)
//        println("OK")
//
//
//    //打印1到5
//    for (x in 1..5)
//        println(x)
//
//    //遍历集合(类似于Java中的for(String name : names))
//    val names = arrayOf("abc", "123", "甲乙丙丁")
//    for (name in names)
//        println(name)
//
//
//
//
//}


//定义函数方法

//例1：方法包含两个Int参数并返回Int类型值

fun sum1(a: Int, b: Int): Int {
    return a + b
}

//例2：方法体只有一条语句，并且自动推测返回类型
fun sum2(a: Int, b: Int) = a + b

// 返回void，Kotlin跟Scala中一样使用Unit
fun printSum1(a: Int, b: Int): Unit {
    print(a + b)
}

//使用nullable值以及空值检测

//引用或函数返回值如果可能为null值，则必须显式标记nullable。
//(在类型后面跟一个问号表示这个对象可能为空，跟两个感叹号表示这个类型一定不为空)

//类型检测并自动转换

//is关键字的用法(类似于Java中的instanceof关键字)
fun getStringLength1(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }

    //在这里还有一种方法，与Java中instanceof不同，使用!is
    // if (obj !is String){
    //   // XXX
    // }

    // 这里的obj仍然是Any类型的引用
    return null
}

fun getStringLength2(obj: Any): Int? {
    // 在左侧obj已经被判断为String类型，所以在&&的右侧可以直接将obj当成String类型来使用
    if (obj is String && obj.length >= 0) {
        return obj.length
    }
    return null
}


//when表达式（类似于Java中的switch）
fun cases(obj: Any) {
    when (obj) {
        1 -> print("第一项")
        "hello" -> print("这个是字符串hello")
        is Long -> print("这是一个Long类型数据")
        !is String -> print("这不是String类型的数据")
        else -> print("else类似于Java中的default")
    }
}
