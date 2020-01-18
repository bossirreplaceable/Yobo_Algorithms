package com.yobo.yobo_algorithms.test2_2;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ZhangBoshi
 * on 2020-01-16
 */
public class Insertion {
    static int count = 0;
    static int countX = 0;
    static int countY = 0;

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    count++;
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
            show(a);
        }
    }

    private static void sortX(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int temp = a[i];
            int j = i;
            for (; j > 0; j--) {
                if (temp < a[j - 1]) {
                    countX++;
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = temp;
            show(a);
        }
    }
    public static void sortY(int[] a) {
        int N = a.length;
        boolean isExchanged = false;
        for (int i = N - 1; i > 0; i--) {
            if (a[i]<a[i - 1]) {
                exch(a, i, i - 1);
                countY++;
                isExchanged = true;
            }
        }
        show(a);
        if (!isExchanged) {
            return;
        }
        for (int i = 2; i < N; i++) {
            for (int j = i; a[j]<a[j - 1]; j--) {
                exch(a, j, j - 1);
                countY++;
            }
            show(a);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(int[] a) {
        System.out.println("\n");
        for (int item : a) {
            System.out.print(item + ",");
        }
    }

    public static void main(String[] args) {
        int[] a = {55,43,23,12,13,11,7,8,88 ,6,4,2,3,1,9,8,7,11,56,45,22,23,45,66};
        show(a);
        sort(a);
//        System.out.println("\n-------------------------");
//        int[] b = { 6,4,2,3,1,9,8,7};
//        show(b);
//        sortX(b);
//        System.out.println("\n-------------------------");
//        int[] c = { 6,4,2,3,1,9,8,7};
//        show(c);
//        sortY(c);
        System.out.println("\n-------------------------");
        System.out.println("\ncount=" + count);
        System.out.println("\ncountX=" + countX);
        System.out.println("\ncountY=" + countY);
    }

}
