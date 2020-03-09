package com.yobo.yobo_algorithms.test4_3;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class EdgeWeightedGraph {

    private int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        V = v;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    private void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    public Iterable<Edge> edges() {
        Bag<Edge> edges = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (Edge w : adj(v)) {
                if (w.other(v) > v) { //因为每条边会被存储两次，这个判断是为了筛选出一次
                    edges.add(w);
                }
            }
        }
        return edges;
    }

}
