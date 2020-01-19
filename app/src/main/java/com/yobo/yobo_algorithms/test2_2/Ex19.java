package com.yobo.yobo_algorithms.test2_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-18
 */
public class Ex19 {

    private static double[] aux;
    private static int count;



    public static void sort(double[] a ){
        aux=new double[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(double[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(double[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if      (i > mid) {
                a[k] = aux[j++];
                count++;
            }
            else if (j > hi)           a[k] = aux[i++];
            else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else       {
                a[k] = aux[j++];
                count++;
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
            System.out.print(item + ",");
        }
    }

    public static void main(String[] args) {
        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        Double[] b = { 55d, 43d, 23d, 12d, 13d, 11d, 7d, 8d, 88d, 6d, 4d, 2d, 3d, 1d, 9d, 8d, 7d, 11d, 56d, 45d, 22d, 23d,
                45d, 66d };
        sort(a);
        show(a);
        System.out.println("\ncount=" + count);
        System.out.println("\ncount1=" +com.jimmysun.algorithms.chapter2_2.Ex19.count(b));


    }
}
