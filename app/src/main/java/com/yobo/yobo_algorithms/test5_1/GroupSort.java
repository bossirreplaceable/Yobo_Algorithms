package com.yobo.yobo_algorithms.test5_1;

/**
 * Created by ZhangBoshi
 * on 2020-03-14
 */
public class GroupSort {

    static class Student {
        String name;
        int key; // 组号
        public Student(String name, int key) {
            this.name = name;
            this.key = key;
        }
        public int key() {
            return key;
        }
    }

    public static void sort(Student[] s) {

        int N = s.length;
        int R = 5;
        int[] count = new int[R + 1];
        Student[] aux = new Student[N];
        //第一步：频率统计
        for (int i = 0; i < N; i++) {
            count[s[i].key + 1]++;
        }
        //第二步：频率转换成索引
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        //第三步：数据分组排序
        for (int i = 0; i < N; i++) {
            aux[count[s[i].key]++] = s[i];
        }
        //第四步：回写排序好的数据
        for (int i = 0; i < N; i++) {
            s[i] = aux[i];
        }
    }

    public static void main(String[] args) {

        Student[] a = new Student[30];
        for (int i = 0; i < 30; i++) {
            a[i] = new Student("小子" + i, (int) (Math.random() * 4+1));
        }
        for (Student s : a) {
            System.out.println("name:" + s.name + "-key:" + s.key);
        }
        System.out.println("----------------");
        sort(a);
        for (Student s : a) {
            System.out.println("name:" + s.name + "-key:" + s.key);
        }
    }
}
