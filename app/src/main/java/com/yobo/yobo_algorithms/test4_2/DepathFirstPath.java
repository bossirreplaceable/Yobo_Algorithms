package com.yobo.yobo_algorithms.test4_2;

import org.jetbrains.annotations.Nullable;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class DepathFirstPath {

    private boolean[] marked; // 标记是否走过该点
    private int edge[]; // s-w 路径上 w 的上一个顶点
    private int s;

    public DepathFirstPath(Digraph D, int s) {
        marked = new boolean[D.V()];
        edge = new int[D.V()];
        this.s = s;
        dfs(D, s);
    }

    private void dfs(Digraph D, int v) {
        marked[v] = true;

        for (int w : D.adj(v)) {
            if (!marked[w]) {
                edge[w] = v;
                dfs(D, w);
            }
        }
    }
    public boolean hasPathTo(int w) {
        return marked[w];
    }
    @Nullable
    private Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();

        for (int w = edge[v]; w != s; w = edge[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }
}
