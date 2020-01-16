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

    println("------------------------")
    val iterator=stack.iterator()
    while (iterator.hasNext()){
        println("stack.item=${iterator.next()}")
    }
    println("------------------------")

    stack.pop()
    stack.pop()
    stack.pop()
    stack.pop()
    println("stackSize3=${stack.stackSize()}")



}



