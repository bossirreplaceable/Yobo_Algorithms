package com.yobo.yobo_algorithms.test5_1;

import java.util.Random;

/**
 * Created by ZhangBoshi
 * on 2020-03-14
 */
public class MSD {

    private static int R = 127; //基数，字符的最大数值
    private static String aux[]; //辅助数组

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {

        if (hi <= lo)
            return;
        int[] count = new int[R + 2];
        // 第一步：频率统计
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        // 第二步：频率转换成索引
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }
        // 第三步：数据分组排序,前面count+2，这里count+1
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        // 第四步：回写排序好的数据
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }
    /**
     * 如果该字符串的第d个字符为null，那么我们就需要将
     */
    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
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
