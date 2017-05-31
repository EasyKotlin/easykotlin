package com.easy.kotlin

/**
 * Created by jack on 2017/5/30.
 */

data class User(val name: String, val id: Int, val password: String)


fun main(args: Array<String>) {
    val user = getUser()
    println("name = ${user.name}, id = ${user.id}, password = ${user.password}")

    val (name, id) = getUser()
    println("name = $name, id = $id")
    println("name = ${getUser().component1()}, id = ${getUser().component2()}")
}

fun getUser(): User {
    return User("Alex", 1, "123456")
}
