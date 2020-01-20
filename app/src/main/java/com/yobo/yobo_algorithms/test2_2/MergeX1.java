package com.yobo.yobo_algorithms.test2_2;//

import edu.princeton.cs.algs4.StdOut;

public class MergeX1 {
    private static final int CUTOFF = 7;

    public static void sort(double[] a) {
        double[] aux = (double[]) a.clone();
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(double[] a, double[] aux, int lo, int hi) {
        if (hi <= lo + 7) {
            insertionSort(a, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;
            sort(aux, a, lo, mid);
            sort(aux, a, mid + 1, hi);
            if (aux[mid + 1] > aux[mid]) {
                System.arraycopy(aux, lo, a, lo, hi - lo + 1);
            } else {
                merge(aux, a, lo, mid, hi);
            }
        }
    }

    private static void insertionSort(double[] a, int lo, int hi) {
        for (int i = lo; i <= hi; ++i) {
            for (int j = i; j > lo && a[j] < a[j - 1]; --j) {
                exch(a, j, j - 1);
            }
        }
    }

    private static void merge(double[] aux, double[] a, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; ++k) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void exch(double[] a, int i, int j) {
        double swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(double[] a) {
        for (int i = 0; i < a.length; ++i) {
            StdOut.print((int) a[i] + ",");
        }

    }

    public static void main(String[] args) {
        double[] a = { 55d, 43d, 23d, 12d, 13d, 11d, 7d, 8d, 88d, 6d, 4d, 2d, 3d, 1d, 9d, 8d, 7d,
                11d, 56d, 45d, 22d, 23d, 45d, 66d };
        sort(a);
        show(a);
    }
}
