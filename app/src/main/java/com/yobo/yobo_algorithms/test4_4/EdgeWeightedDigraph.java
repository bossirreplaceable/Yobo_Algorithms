package com.yobo.yobo_algorithms.test4_4;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by ZhangBoshi
 * on 2020-03-12
 */
public class EdgeWeightedDigraph {

    private final int V; // 顶点的数量
    private int E; // 边的数量
    private final Bag<DirectedEdge>[] adj; // 邻接表

    public EdgeWeightedDigraph(int v) {
        V = v;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }
    /**
     * 将边添加到 邻接表中
     */
    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        adj[v].add(edge);
        E++;
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
    /**
     * 将有向图中的所有边都存储到一个Bag中并返回
     */
    public Iterable<DirectedEdge> edges(){
        Bag<DirectedEdge> edges=new Bag<>();

        for (int i=0;i<V;i++){
            for (DirectedEdge e:adj[i]){
                edges.add(e);
            }
        }
        return edges;
    }
}
