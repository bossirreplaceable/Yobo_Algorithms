package com.yobo.yobo_algorithms.test4_2;

import com.yobo.yobo_algorithms.test4_1.Bag;

import edu.princeton.cs.algs4.In;

/**
 * Created by ZhangBoshi
 * on 2020-03-04
 */
public class Digraph {

    private int V; // 顶点的总数
    private int E; // 边的总数
    private Bag<Integer>[] adj; // 存放所有顶点的邻接表

    public Digraph(int V) {

        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Digraph(In in) {

        V = in.readInt();
        adj = new Bag[V];

        int E;
        for (E = 0; E < this.V; ++E) {
            this.adj[E] = new Bag<>();
        }

        E = in.readInt();
        for (int i = 0; i < E; ++i) {
            int v = in.readInt(); //将同一行的两个数字 连成一条边
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public int E() {
        return E;
    }
    public int V() {
        return V;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 反向图
     */
    public Digraph reverse() {

        Digraph D = new Digraph(V);

        for (int v = 0; v < D.V; v++) {
            for (int w : adj(v)) {
                D.addEdge(w, v);
            }
        }
        return D;
    }

}
