package com.yobo.yobo_algorithms.test2_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-18
 */
public class MergeX {

    private static final int MIN = 7;

    public static void sort(double[] a) {
        double[] aux = a.clone();
        sort(a, aux, 0, a.length - 1);
    }

    public static void sort(double[] a, double[] aux, int lo, int hi) {
        if (hi <= lo + MIN) {
            sortInsertion(a, lo, hi);

        }else {
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            if (a[mid + 1] < a[mid]) {
                merge(a, aux, lo, mid, hi);
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

    private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (aux[i] < aux[j])
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
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
            System.out.print((int)item + ",");
        }
    }

    public static void main(String[] args) {
        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        sort(a);
        show(a);

    }
}
