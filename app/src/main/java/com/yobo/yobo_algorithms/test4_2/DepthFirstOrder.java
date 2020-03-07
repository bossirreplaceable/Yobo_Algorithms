package com.yobo.yobo_algorithms.test4_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class DepthFirstOrder {

    private final boolean[] marked;
    private final Queue<Integer> pre; //前序
    private final Queue<Integer> post; //后序
    private final Stack<Integer> reversePost; //逆后序

    public DepthFirstOrder(Digraph D) {

        marked = new boolean[D.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        for (int v = 0; v < D.V(); v++) {
            if (!marked(v)) {
                dfs(D,v);
            }
        }
    }

    private void dfs(Digraph D, int v) {

        marked[v] = true;
        pre.enqueue(v);               //在递归调用之前将顶点加入队列。
        for (int w : D.adj(v)) {
            if (!marked(w)) {
                dfs(D, w);
            }
        }
        post.enqueue(v);               //在递归调用之后将顶点加入队列。
        reversePost.push(v);           //在递归调用之后将顶点压入栈。
    }

    private boolean marked(int w) {
        return marked[w];
    }
    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
