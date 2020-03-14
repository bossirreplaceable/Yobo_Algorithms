package com.yobo.yobo_algorithms.test4_4;


import edu.princeton.cs.algs4.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-12
 */
public class AcyclicSP {

    private final DirectedEdge[] edgeTo;
    private final double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G,int s){

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        Topological top=new Topological(G);
        for (int v : top.order()) {
            relax(G,v);
        }
    }
    private void relax(EdgeWeightedDigraph G, int v) {

        for (DirectedEdge e : G.adj(v)) {
            int w=e.to();
            if (distTo[v] + e.weight() < distTo[w]) {
                distTo[w]=distTo[v]+e.weight();
                edgeTo[w]=e;
            }
        }
    }
    /**
     * 是否有通往v点的最短路径
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * 通往v最短路径的权值之和，如果没有最短路径就会返回无穷大
     */
    public double distTo(int v) {
        return distTo[v];
    }
    /**
     * 返回从s点到v点的最短路径的所有边
     */
    public Iterable<DirectedEdge> pathTo(int v){

        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path=new Stack<>();
        for (DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }
}
