package com.yobo.yobo_algorithms.test2_5;

import java.util.Arrays;
import java.util.HashMap;

public class MidSelect {
    public static double select(double[] a ,int k){
        int lo=0;
        int hi=a.length-1;
        while (hi>lo){
            int j=partition(a,lo,hi);
            if (k==j) return a[k];
            if (k<j) hi=j-1;
            if (k>j) lo=j+1;
        }
        return a[k];
    }
    private static int partition(double[] a, int lo, int hi) {
        double key=a[lo];
        int left=lo;
        int right=hi+1;

        while (true){
            while (key > a[++left])  if (left == hi) break;
            while (key < a[--right]) if (right == lo) break;
            if (left>=right)break;
            exch(a,left,right);

        }
        exch(a,lo,right);
        return right;
    }
    private static void exch(double[] a, int left, int right) {

        double temp=a[left];
        a[left]=a[right];
        a[right]=temp;
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
        double mid=select(a,a.length/2);
        show(a);
        System.out.println("mid="+mid);
    }
}
