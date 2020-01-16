package com.yobo.yobo_algorithms.test1_2

/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */
class LinkedStack1<T> {
    private var first: Node? = null
    private var N = 0 // 集合的数量

    // 结点
    internal inner class Node {
        var item: T? = null
        var next: Node? = null
    }

    fun push(t: T) {
        val oldFirst = first
        first = Node()
        first!!.item = t
        first!!.next = oldFirst
        N++
    }

    fun pop(): T? {
        val item: T? = first?.item
        first = first!!.next
        N--
        return item
    }

    val isEmpty: Boolean
        get() = N == 0

    fun size(): Int {
        return N
    }
}