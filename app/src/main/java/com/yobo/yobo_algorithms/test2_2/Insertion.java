package com.yobo.yobo_algorithms.test2_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-16
 */
public class Insertion {
    static int count =0;

    private static int[] sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0; j--) {
                if (a[j] < a[j-1]) {
                    count++;
                    exch(a,j,j-1);
                }else {
                    break;
                }
            }
        }
        return a;
    }
    private static int[] sort1(int[] a) {
        int count =0;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >0; j--) {
                if (a[j] < a[j-1]) {
                    count++;
                    exch(a,j,j-1);
                }else {
                    break;
                }
            }
        }
        return a;
    }
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(int[] a) {
        for (int item:a){
            System.out.print(item+",");
        }
    }
    public static void main(String[] args) {
        int[] a= {1,3,2,11,22,33,44,55,22,12,11,13,12,15,45,7,8,68,56,43,55,78};
        int[] result=sort(a);
        show(result);
        System.out.println("\ncount="+count);
    }
}
