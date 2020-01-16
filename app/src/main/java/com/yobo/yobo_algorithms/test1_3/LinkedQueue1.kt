package com.yobo.yobo_algorithms.test1_3

/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */
class LinkedQueue1<T> {
    private var first // 指向最早添加的结点的链接
            : Node? = null
    private var last // 指向最近添加的结点的链接
            : Node? = null
    private var N = 0 // 集合的数量

    // 结点
    internal inner class Node {
        var item: T? = null
        var next: Node? = null
    }

    /**
     * 将元素放入队尾
     */
    fun enqueue(t: T) {
        val oldLast = last
        last = Node()
        last!!.item = t
        last!!.next = null
        if (isEmpty()) {
            first = last
        } else {
            oldLast!!.next = last
        }
        N++
    }

    /**
     * 将元素从队头删除
     */
    fun dequeue(): T? {
        val item: T? = first?.item
        first = first!!.next
        N--
        if (isEmpty()) last = null
        return item
    }

    fun isEmpty(): Boolean {
        return N == 0
    }

    fun size(): Int {
        return N
    }
}
