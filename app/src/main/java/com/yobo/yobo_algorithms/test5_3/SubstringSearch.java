package com.yobo.yobo_algorithms.test5_3;

/**
 * Created by ZhangBoshi
 * on 2020-03-23
 */
public class SubstringSearch {
    /**
     * 实现一，正循环
     */
    public static int search(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (pat.charAt(j) != txt.charAt(i + j))
                    break;
            }
            if (j == M)
                return i; // 找到匹配
        }
        return N; // 未找到匹配
    }
    /**
     * 实现二，显示回退
     * 这段代码中的 i 值相当于上一段代码中的 i+j:它指向的是文本中已经匹配过的字 符序列的末端(i 以前指向的是这个序列的开头)。
     * 如果 i 和 j 指向的字符不匹配了，那么需要回 退这两个指针的值:将 j 重新指向模式的开头，将 i 指向本次匹配的开始位置的下一个字符。
     */
    public static int search1(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();
        int i,j;
        for (i = 0, j = 0; i < N && j < M; i++) {

            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        if (j==M) return i-M;// 找到匹配
        else  return N; // 未找到匹配
    }

    public static void main(String[] args) {
        String pat = "abab";
        String txt = "sjosajofajfiajsessasabacababfofkokokofj";
        int result = search(pat, txt);
        int result1 = search1(pat, txt);
        System.out.println("result=" + result+",result1="+result1);
        System.out.println("txt.length=" + txt.length());
    }
}
