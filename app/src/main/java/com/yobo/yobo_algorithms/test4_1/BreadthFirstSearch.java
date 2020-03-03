package com.yobo.yobo_algorithms.test4_1;

import org.jetbrains.annotations.Nullable;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */
public class BreadthFirstSearch {

    private boolean[] marked;
    private final int[] edgeTo;
    private int s;

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {

        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);

        while (!queue.isEmpty()) {

            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    queue.enqueue(w);
                }
            }
        }
    }

    private boolean hasPathTo(int w) {
        return marked[w];
    }

    @Nullable
    private Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v))
            return null;

        Stack<Integer> path = new Stack<>();
        for (int w = edgeTo[v]; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        return path;

    }

}
