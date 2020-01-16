package com.yobo.yobo_algorithms.test1_3

import com.yobo.yobo_algorithms.test1_2.LinkedStack1


/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */


fun main() {
    val stack: LinkedQueue<Int> = LinkedQueue()

    println("stackSize1=${stack.size()}")
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println("stackSize2=${stack.size()}")
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println("stackSize3=${stack.size()}")

}

