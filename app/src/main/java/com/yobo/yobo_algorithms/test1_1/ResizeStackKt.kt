package com.yobo.yobo_algorithms.test1_1

/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */
class ResizeStack1<T> : Iterable<T> {
    private var a = arrayOfNulls<Any>(2) as Array<T?>
    private var N = 0 // 栈内元素的数量
    /**
     * 将元素添加到栈顶
     */
    fun push(t: T) {
        if (N == a.size) {
            resize(a.size * 2)
        }
        a[N++] = t
    }

    /**
     * 将元素从栈顶删除
     */
    fun pop(): T? {
        val item = a[--N]
        a[N]=null
        if (N > 0 && N <= a.size / 4) {
            resize(a.size / 2)
        }
        return item
    }

    val isEmpty: Boolean
        get() = N == 0

    fun size(): Int {
        return N
    }

    fun stackSize(): Int {
        return a.size
    }

    private fun resize(size: Int) {
        val temp = arrayOfNulls<Any>(size) as Array<T?>
        for (i in 0 until N) {
            temp[i] = a[i]
        }
        a = temp
    }

    override fun iterator(): Iterator<T> {
        return object : MutableIterator<T> {
            private var i = N
            override fun hasNext(): Boolean {
                return i > 0
            }

            override fun next(): T{
                return a[--i]!!
            }

            override fun remove() {

            }
        }
    }
}