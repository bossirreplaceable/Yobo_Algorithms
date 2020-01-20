package com.yobo.yobo_algorithms.test2_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-18
 */
public class MergeInsertion {

    private static double[] aux;
    private static int min=15;



    public static void sort(double[] a ){
        aux=new double[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(double[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;

        if (hi-lo<=min){
            sortInsertion(a,lo,mid);
            sortInsertion(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }else {
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }
    }
    private static void sortInsertion(double[] a, int lo, int hi) {
        for (int i = lo+1; i <=hi; i++) {
            for (int j = i; j > lo; j--) {
                if (a[j] < a[j - 1]) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void merge(double[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)               a[k] = aux[j++];
            else if (j > hi)           a[k] = aux[i++];
            else if (aux[i] < aux[j])  a[k] = aux[i++];
            else                       a[k] = aux[j++];
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
