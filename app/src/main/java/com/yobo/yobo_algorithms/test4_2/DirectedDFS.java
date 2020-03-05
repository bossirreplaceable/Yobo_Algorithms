package com.yobo.yobo_algorithms.test4_2;

import com.yobo.yobo_algorithms.test4_1.Bag;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by ZhangBoshi
 * on 2020-03-05
 */
public class DirectedDFS {
    private final boolean[] marked; // 标记是否走过该点
    private int s;// 起点

    public DirectedDFS(Digraph D, int s) {
        marked = new boolean[D.V()];
        dfs(D, s);
    }
    public DirectedDFS(Digraph D, Iterable<Integer> sources) {
        marked = new boolean[D.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(D, s);
            }
        }
    }
    private void dfs(Digraph D, int v) {
        marked[v] = true;
        for (int w : D.adj(v)) {
            if (!marked(w)) {
                dfs(D, w);
            }
        }
    }
    private boolean marked(int w) {
        return marked[w];
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++)
            sources.add(Integer.parseInt(args[i]));
        DirectedDFS reachable = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++) //将能到达的点都打印出来
            if (reachable.marked(v))
                StdOut.print(v + " ");
        StdOut.println();
    }
}
