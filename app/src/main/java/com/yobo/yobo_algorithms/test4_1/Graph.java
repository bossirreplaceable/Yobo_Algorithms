package com.yobo.yobo_algorithms.test4_1;

/*
 * Created by ZhangBoshi
 * on 2020-03-02
 */
import java.util.Iterator;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V; // 顶点数目
    private int E;// 边的数目
    private Bag<Integer>[] adj;// 邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (Bag[]) (new Bag[V]);

        for (int v = 0; v < V; ++v) {
            this.adj[v] = new Bag();
        }

    }

    public Graph(In in) {
        this.V = in.readInt();
        this.adj = (Bag[]) (new Bag[this.V]);

        int E;
        for (E = 0; E < this.V; ++E) {
            this.adj[E] = new Bag();
        }

        E = in.readInt();
        for (int i = 0; i < E; ++i) {
            int v = in.readInt();
            int w = in.readInt();
            this.addEdge(v, w);
        }

    }

    public Graph(Graph G) {
        this.V = G.V();
        this.E = G.E();
        this.adj = (Bag[]) (new Bag[this.V]);

        int v;
        for (v = 0; v < this.V; ++v) {
            this.adj[v] = new Bag();
        }

        for (v = 0; v < G.V(); ++v) {
            Stack<Integer> reverse = new Stack();
            Iterator var4 = G.adj[v].iterator();

            int w;
            while (var4.hasNext()) {
                w = (Integer) var4.next();
                reverse.push(w);
            }

            var4 = reverse.iterator();

            while (var4.hasNext()) {
                w = (Integer) var4.next();
                this.adj[v].add(w);
            }
        }

    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        ++this.E;
        this.adj[v].add(w);
        this.adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public int degree(int v) {
        return this.adj[v].size();
    }

}
