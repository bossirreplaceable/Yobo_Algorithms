package com.yobo.yobo_algorithms.test2_1;

/**
 * Created by ZhangBoshi
 * on 2020-01-16
 */
public class Selection {

    public static int[] sort(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
        return a;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(int[] a) {
        for (int item:a){
            System.out.print(item+",");
        }
    }
    public static void main(String[] args) {
        int[] a= {1,3,2,11,22,33,44,55,22,12,11,13,12,15,45,7,8,68,56,43,55,78};
        int[] result=sort(a);
        show(result);
    }
}
