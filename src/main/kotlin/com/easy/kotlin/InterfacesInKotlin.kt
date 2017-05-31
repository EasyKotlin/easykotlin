package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

interface Clickable {
    fun click()
}
class Button : Clickable {
    override fun click() = println("I was clicked")
}

fun main(args: Array<String>) {
    Button().click()
}
