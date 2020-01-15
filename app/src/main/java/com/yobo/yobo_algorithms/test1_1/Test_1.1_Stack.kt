package com.yobo.yobo_algorithms.test1_1

/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */


fun main() {
    val stack:ResizeStack<Int> = ResizeStack()

    println("stackSize1=${stack.stackSize()}")
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println("stackSize2=${stack.stackSize()}")

    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()
    println("stackSize3=${stack.stackSize()}")


}



