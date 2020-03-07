package com.yobo.yobo_algorithms.test4_2;

import org.jetbrains.annotations.Nullable;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edge;
    private int s;

    public BreadthFirstPath(Digraph D,int s) {
        marked = new boolean[D.V()];
        edge = new int[D.V()];
        this.s=s;
        bfs(D,s);
    }

    private void bfs(Digraph D,int s){

        Queue<Integer> queue=new Queue<>();
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v=queue.dequeue();
            for (int w:D.adj(v)){
                if (!marked[w]){
                    edge[w]=v;
                    marked[w]=true;
                    queue.enqueue(w);
                }
            }
        }
    }
    private boolean hasPathTo(int v){
        return marked[v];
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
