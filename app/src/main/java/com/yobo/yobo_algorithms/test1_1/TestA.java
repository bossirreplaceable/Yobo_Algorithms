package com.yobo.yobo_algorithms.test1_1;

import java.util.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */
public class TestA {

    public static void main(String[] args) {
        Stack<Integer> test=new Stack<>();
        test.push(11);        //自动装箱，（int -> Integer）
        int result=test.pop();      //自动拆箱，（Integer -> int）
        System.out.println("result="+test.size());

        Object[] a=new Object[4];

    }
}
