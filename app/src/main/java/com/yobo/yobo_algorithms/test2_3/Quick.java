package com.yobo.yobo_algorithms.test2_3;

/**
 * Created by ZhangBoshi
 * on 2020-01-19
 * //        System.out.println(String.format("%"+count+"s", ":")+"lo=" + lo + ",hi=" + hi);
 */
public class Quick {

    private static int count = 1;

    public static void sort(double[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(double[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = partition(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid + 1, hi);
    }

    private static int partition(double[] a, int lo, int hi) {
        double key = a[lo];
        int left = lo;
        int right = hi + 1;
        while (true) {

            while (key > a[++left])  if (left == hi) break;
            while (key < a[--right]) if (right == lo) break;

            if (left >= right) break;
            exch(a, left, right);
        }

        exch(a, lo, right);
        show(a);
        return right;
    }

    private static void exch(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(double[] a) {
        System.out.println("\n");
        for (double item : a) {
            System.out.print((int) item + ",");
        }
    }

    public static void main(String[] args) {
//        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 3, 2, 4, 1, 9, 8, 7, 11, 56, 45, 22, 23,
//                45, 66 };
        double[]a ={4,3,9,7,6,1,2,5};
        sort(a);
        show(a);
    }
}