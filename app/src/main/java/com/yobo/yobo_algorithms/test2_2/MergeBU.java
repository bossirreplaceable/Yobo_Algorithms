package com.yobo.yobo_algorithms.test2_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-18
 */
public class MergeBU {
    private static double[] aux;

    public static void sort(double[] a ){
        aux=new double[a.length];
        int N=a.length;
        
        for (int t=1;t<N;t=t+t){
            
            for (int k=0;k<N;k+=t+t){
                merge(a,k,k+t-1,Math.min(k+t+t-1,N-1));
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
            System.out.print(item + ",");
        }
    }
    public static void main(String[] args) {
        double[] a = { 55, 43, 23, 12, 13, 11, 7, 8, 88, 6, 4, 2, 3, 1, 9, 8, 7, 11, 56, 45, 22, 23,
                45, 66 };
        sort(a);
        show(a);
    }
}
