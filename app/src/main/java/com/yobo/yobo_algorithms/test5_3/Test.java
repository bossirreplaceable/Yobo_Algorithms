package com.yobo.yobo_algorithms.test5_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhangBoshi
 * on 2020-03-24
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 1、子字符串的查找匹配
         */
        String pat = ".*NEEDLE.*";
        String txt = "A HAYSTACK NEEDLE IN";
        // 方式1：String 的 matches 方法
        boolean isHas1 = txt.matches(pat);
        // 方式2：Pattern 对象的 matches 方法
        boolean isHas2 = Pattern.matches(pat, txt);
        // 方式3： Matcher 对象的 matches 方法
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(txt);
        boolean isHas3 = m.matches();
        System.out.println("txt中是否含有pat1=" + isHas1);
        System.out.println("txt中是否含有pat2=" + isHas2);
        System.out.println("txt中是否含有pat3=" + isHas3);

        /**
         * 账号密码的匹配
         */
        String pat1 = "[0-9]*";
        String txt1="1491984910";
        String txt2="8998aba";

        Pattern p1=Pattern.compile(pat1);
        Matcher m1 = p1.matcher(txt1);
        Matcher m2 = p1.matcher(txt2);

        System.out.println("txt1文本是否符合pat1要求的字符="+m1.matches());
        System.out.println("txt2文本是否符合pat1要求的字符="+m2.matches());
    }
}
