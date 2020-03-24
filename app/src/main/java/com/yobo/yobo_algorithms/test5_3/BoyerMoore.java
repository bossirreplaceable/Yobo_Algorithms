package com.yobo.yobo_algorithms.test5_3;

/**
 * Created by ZhangBoshi
 * on 2020-03-23
 */
public class BoyerMoore {

    private String pat;
    private int[] right;

    /**
     * 计算跳跃表 right
     */
    public BoyerMoore(String pat) {
        this.pat = pat;
        int R = 256;
        int M = pat.length();
        right = new int[R];

        for (int c = 0; c < R; c++) {
            right[c] = -1; // 不包含在模式字符串中字符的值为-1
        }
        for (int j = 0; j < M; j++) {
            right[pat.charAt(j)] = j; // 包含在模式字符串中的字符的值为它出现在模式字符串中最右的位置，
                                      // 就比如 pat="aaa" right[a]=2；不是0和1
        }
    }
    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();

        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip=0;
            for (int j = M - 1; j >= 0; j--) {                 //1、每次从pat的最右边的字符开始与txt比较
                if (pat.charAt(j) != txt.charAt(j + i)) {      //2、如果第 j+i个字符和pat不匹配，进行跳转
                    skip = j - right[txt.charAt(j + i)];       //3、跳转的距离等于
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return N;
    }

    public static void main(String[] args) {
        String pat = "aaaabbcc";
        String txt = "sjosajofajfiajsessaaaaaaaaaaabbccbabaaaababsfofkokokofj";
        BoyerMoore bm = new BoyerMoore(pat);

        int offset = bm.search(txt);
        System.out.println("offset=" + offset);
        System.out.println("txt.length=" + txt.length());
    }

}
