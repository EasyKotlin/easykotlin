package com.easy.kotlin

/**
 * Created by jack on 2017/5/29.
 */

import java.util.Date
import java.text.SimpleDateFormat

fun main(args: Array<String>) {
    println("Hello, world!")
    println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
}