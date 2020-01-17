package com.yobo.yobo_algorithms.test1_3

import com.yobo.yobo_algorithms.test1_2.LinkedStack1


/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */


fun main() {
    val stack: LinkedQueue<Int> = LinkedQueue()

    println("stackSize1=${stack.size()}")
    stack.enqueue(1)
    stack.enqueue(2)
    stack.enqueue(3)
    stack.enqueue(4)
    println("stackSize2=${stack.size()}")
    println(stack.dequeue())
    println(stack.dequeue())
    println(stack.dequeue())
    println(stack.dequeue())
    println("stackSize3=${stack.size()}")

}

