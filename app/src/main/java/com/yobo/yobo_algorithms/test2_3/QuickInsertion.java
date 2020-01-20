package com.yobo.yobo_algorithms.test2_3;

/**
 * Created by ZhangBoshi
 * on 2020-01-19
 */
public class QuickInsertion {

    //建议5~15之间
    private static final  int MIN = 7;

    public static void sort(double[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(double[] a, int lo, int hi) {
        if (lo+ MIN>= hi) {
            sortInsertion1(a,lo,hi);
        }else {
            int mid = partition(a, lo, hi);
            sort(a, lo, mid - 1);
            sort(a, mid + 1, hi);
        }
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
//        show(a);
        return right;
    }
    public static void sortInsertion1(double[] a, int lo, int hi) {
//        System.out.println("lo=" + lo + ",hi=" + hi);
        for (int i = lo + 1; i < hi; i++) {
            for (int j = i; j > lo; j--) {
//                System.out.println("i=" + i + ",j=" + j);
                if ( a[j]< a[j-1]) {
                    exch(a, j, j - 1);
                }else {
                    break;
                }
            }
        }
    }
    private static void sortInsertion(double[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0; --j) {
                if (a[j] < a[j - 1]) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
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
        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 3, 2, 4, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
//        double[]a ={4,3,9,7,6,1,2,5};
        sort(a);
        show(a);
    }

}
