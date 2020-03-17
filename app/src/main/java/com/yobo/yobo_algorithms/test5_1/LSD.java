package com.yobo.yobo_algorithms.test5_1;

import java.util.Random;

/**
 * Created by ZhangBoshi
 * on 2020-03-14
 */
public class LSD {

    public static void sort(String[] s,int W) {

        int N = s.length;
        int R = 127;  //字母和数字的字符最大的数字为127
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            //第一步：频率统计
            for (int i = 0; i < N; i++) {
                count[s[i].charAt(d) + 1]++;
            }
            //第二步：频率转换成索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            //第三步：数据分组排序
            for (int i = 0; i < N; i++) {
                aux[count[s[i].charAt(d)]++] = s[i];
            }
            //第四步：回写排序好的数据
            for (int i = 0; i < N; i++) {
                s[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {

        String[] a = new String[20];
        for (int i = 0; i < 20; i++) {
            a[i]=getCharAndNumr(5);
        }
        for (String s : a) {
            System.out.println(" "+s);
        }
        sort(a,5);
        System.out.println("----------------");
        for (String s : a) {
            System.out.println(" "+s);
        }
    }
    /**
     * 随机生成指定长的字符串
     */
    public static String getCharAndNumr(int length) {

        Random random = new Random();
        StringBuilder valSb = new StringBuilder();
//        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";
        String charStr = "ABCDE";
        int charLength = charStr.length();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            valSb.append(charStr.charAt(index));
        }
        return valSb.toString();
    }
}



