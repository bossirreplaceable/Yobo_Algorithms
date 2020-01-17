package com.yobo.yobo_algorithms.test2_1

/**
 * Created by ZhangBoshi
 * on 2020-01-16
 */

object Selection1 {
    fun sort(a: IntArray): IntArray {
        var min: Int
        for (i in a.indices) {
            min = i
            for (j in i + 1 until a.size) {
                if (a[min] > a[j]) {
                    min = j
                }
            }
            exch(a, i, min)
        }
        return a
    }

    private fun exch(a: IntArray, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

    fun show(a: IntArray) {
        for (item in a) {
            print("$item,")
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val a = intArrayOf(
            1,
            3,
            2,
            11,
            22,
            33,
            44,
            55,
            22,
            12,
            11,
            13,
            12,
            15,
            45,
            7,
            8,
            68,
            56,
            43,
            55,
            78
        )
        val result = sort(a)
        show(result)
    }
}