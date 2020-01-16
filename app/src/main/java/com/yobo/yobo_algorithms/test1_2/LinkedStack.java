package com.yobo.yobo_algorithms.test1_2;

/**
 * Created by ZhangBoshi
 * on 2020-01-15
 */
public class LinkedStack<T> {

    private Node first;
    private int N = 0;// 集合的数量
    // 结点
    class Node {
        T item;
        Node next;
    }
    /**
     * 将元素放入栈顶
     */
    public void push(T t) {
        Node oldFirst = first;
        first = new Node();
        first.item = t;
        first.next = oldFirst;
        N++;
    }
    /**
     * 将元素从栈顶删除
     */
    public T pop() {
        T item=first.item;
        first=first.next;
        N--;
        return item;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
}
