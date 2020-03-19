package com.yobo.yobo_algorithms.test5_2;

/**
 * Created by ZhangBoshi
 * on 2020-03-19
 */
public class TST<Value> {

    private Node root;

    private class Node {
        char c;
        Value val;
        Node left, mid, right;
    }

    /**
     * 插入某个键值对
     */
    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {

        if (x == null) {                                   //如果该分支没有后序字符，创建新的结点分支
            x = new Node();
            x.val = val;
        }
        char c = key.charAt(d);                            // 走到哪个字符了，并那该字符和结点中的值表，小于去左侧分支，大于去右侧分支找
        if (c < x.c) {
            x.left = put(x.left, key, val, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1) {                 //等于的话，如果没走到该字符的最后一个字符，还得继续往下找
            x.mid = put(x.mid, key, val, d + 1);
        } else {
            x.val = val;
        }
        return x;
    }

    public Value get(String key) {

        Node x = get(root, key, 0);
        if (x == null)
            return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {

        if (x == null)
            return null;

        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        }
        return x;
    }
}
