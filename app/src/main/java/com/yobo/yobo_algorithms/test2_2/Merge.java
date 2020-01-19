package com.yobo.yobo_algorithms.test2_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-18
 */
public class Merge {
    private static double[] aux;

    public static void sort(double[] a) {
        aux = new double[a.length];
        sort(a, 0, a.length - 1);
    }
    /**
     * 递归拆分
     */
    public static void sort(double[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if (a[mid + 1] < a[mid]) {
            merge(a, lo, mid, hi);
        }
    }
    /**
     * 将子数组合并
     */
    private static void merge(double[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)          a[k] = aux[j++];//如果i>mid了说明lo-mid之间的元素已经全部合并到a数组中了，剩下的就是mid+1-hi的元素依次放进去就行了
            else if (j > hi)           a[k] = aux[i++];//如果j>mid了，说明mid+1-hi之间的元素已经全部放入a数组中了
            else if (aux[i] < aux[j])  a[k] = aux[i++];//如果mid前面的数组元素比后面的数组元素小，优先把mid前面的元素放进去
            else                       a[k] = aux[j++];//如果mid后面的数组元素比前面的数组元素小，优先放mid后面的元素进入到a中
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
