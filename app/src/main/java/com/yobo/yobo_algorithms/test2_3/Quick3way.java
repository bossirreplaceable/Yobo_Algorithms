package com.yobo.yobo_algorithms.test2_3;

/**
 * Created by ZhangBoshi
 * on 2020-01-19
 * //        System.out.println(String.format("%"+count+"s", ":")+"lo=" + lo + ",hi=" + hi);
 */
public class Quick3way {


    public static void sort(double[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(double[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        double key = a[lo];
        int left = lo;
        int right = hi;
        int  i=lo+1;
        while (i<=right) {

            if (a[i]<key)exch(a,i++,left++); //将比key小的放在子数组的前面
            else if (a[i]>key)exch(a,i,right--);//将比key大的放在子数组的后面
            else   i++;//如果等于，就跳过继续下一个
        }

        sort(a, lo, left - 1);// {3,2,1,4,4,4,4,9,8,7}继续递归{3,2,1}的部分
        sort(a, right + 1, hi);// {3,2,1,4,4,4,4,9,8,7}继续递归{9,8,7}的部分
    }

    private static void exch(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
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
//        double[]a ={4,3,9,7,6,1,2,5};
        sort(a);
        show(a);
    }
}