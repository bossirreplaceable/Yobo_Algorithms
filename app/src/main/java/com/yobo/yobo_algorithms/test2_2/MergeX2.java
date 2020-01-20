package com.yobo.yobo_algorithms.test2_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ZhangBoshi
 * on 2020-01-19
 */
public class MergeX2 {
    public static void mergeSort(double[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(double[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(double[] arr, int L, int mid, int R) {
        double[] temp = new double[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }



    public static void main(String[] args) {
        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        mergeSort(a);
        show(a);

    }

    private static void show(double[] a) {
        for (int i = 0; i < a.length; ++i) {
            StdOut.print((int) a[i] + ",");
        }

    }
}