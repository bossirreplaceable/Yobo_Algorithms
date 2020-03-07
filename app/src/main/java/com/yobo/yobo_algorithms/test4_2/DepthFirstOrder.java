package com.yobo.yobo_algorithms.test4_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class DepthFirstOrder {

    private final boolean[] marked;
    private final Queue<Integer> pre;
    private final Queue<Integer> post;
    private final Stack<Integer> reversePost;


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
        pre.enqueue(v);
        for (int w : D.adj(v)) {
            if (!marked(w)) {
                dfs(D, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
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
