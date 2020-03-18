package com.yobo.yobo_algorithms.test5_1;

import java.util.Random;

/**
 * Created by ZhangBoshi
 * on 2020-03-17
 */
public class Quick3string {

    public static void sort(String[] a) {
        int N = a.length;
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {

        if (hi<=lo) return;
        int left = lo, right = hi;
        int i = lo+1;
        int v = chartAt(a[lo], d);

        while (i <= right) {

            int w = chartAt(a[i], d);
            if (w > v) {
                exch(a, i, right--);
            } else if (w < v) {
                exch(a, i++, left++);
            } else {
                i++;
            }
        }

        sort(a, lo, left - 1, d);
        if (v >= 0) {
            sort(a, left, right, d + 1);
        }
        sort(a, right + 1, hi, d);

    }

    private static void exch(String[] a, int v, int w) {
        String temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }

    private static int chartAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1;
    }

    public static void main(String[] args) {

        String[] a = new String[20];
        for (int i = 0; i < 20; i++) {
            a[i] = getCharAndNumr((int) (6 * Math.random() + 1));
        }
        for (String s : a) {
            System.out.println(" " + s);
        }
        sort(a);
        System.out.println("----------------");
        for (String s : a) {
            System.out.println(" " + s);
        }
    }
    /**
     * 随机生成指定长的字符串
     */
    public static String getCharAndNumr(int length) {
        Random random = new Random();
        StringBuilder valSb = new StringBuilder();
        String charStr = "ABCDE";
        int charLength = charStr.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            valSb.append(charStr.charAt(index));
        }
        return valSb.toString();
    }
}
