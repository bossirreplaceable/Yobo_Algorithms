package com.yobo.yobo_algorithms.test5_3;

/**
 * Created by ZhangBoshi
 * on 2020-03-20
 */
public class KMP {

    private String pat;       // 需要查找的字符串
    private int[][] dfa;      // 预处理的二维数组
    private int R = 256;      // 字母表的大小

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        dfa = new int[R][M];

        dfa[pat.charAt(0)][0] = 1;             //0、预处理pat的第一个字符

        for (int X = 0, j = 1; j < M; j++) {

            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];         //1、复制匹配失败情况下的值
            }
            dfa[pat.charAt(j)][j] = j + 1;     //2、设置匹配情况下的值
            X = dfa[pat.charAt(j)][X];         //3、更新重启状态,这里主要是给 pat="aaabc" 前面的三个a或者更多的a更新重启状态，b、c字母会重启为0

             System.out.print(" dfa[" + pat.charAt(j) + "][" + j + "]=" + dfa[pat.charAt(j)][j]);
             X = dfa[pat.charAt(j)][X];
             System.out.print(" X= dfa[" + pat.charAt(j) + "][" + X + "]=" + dfa[pat.charAt(j)][X]);
             System.out.println("-----++++++++++++++++++-----------------");
        }

    }


    public int search(String txt) {
        int i, j;
        int N = txt.length(), M = pat.length();

        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M)
            return i - M;
        else
            return N;
    }

    public static void main(String[] args) {
        String pat = "aaaabbcc";
        String txt = "sjosajofajfiajsessaaaaaaaaaaabbccbabaaaababsfofkokokofj";
        KMP kmp = new KMP(pat);
        for (int i = 90; i < kmp.R; i++) {
            for (int j = 0; j < pat.length(); j++) {
                System.out.print("   dfa[" + i + "][" + j + "]=" + kmp.dfa[i][j]);
            }
            System.out.println("--------------------------------------");
        }

        int offset = kmp.search(txt);
        System.out.println("offset=" + offset);
        System.out.println("txt.length=" + txt.length());
    }
}
