package com.yobo.yobo_algorithms.test1_2


/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */


fun main() {
    val stack: LinkedStack1<Int> = LinkedStack1()

    println("stackSize1=${stack.size()}")
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println("stackSize2=${stack.size()}")
    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()
    println("stackSize3=${stack.size()}")

}

