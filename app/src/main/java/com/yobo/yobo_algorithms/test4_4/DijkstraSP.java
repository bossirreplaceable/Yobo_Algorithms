package com.yobo.yobo_algorithms.test4_4;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-12
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo; //保存最短路径的所有边
    private double[] distTo;       //保存通往v点的最短路径的权值之和
    private IndexMinPQ<Double> pq; //索引优先队列，存放通往各个顶点的最短路径的权值之和，并且每次可以拿到最小的权值之和

    public DijkstraSP(EdgeWeightedDigraph G, int s) {

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int i = 0; i < distTo.length; i++) { // 1、先将通往每个顶点的路径权值设为无无穷大
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0.0; // 2、初始化起点，并添加到优先队列中
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) { // 3、不断的从优先队列中取路径之和最小的那条。并返回路径通往的v点
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {

        for (DirectedEdge e : G.adj(v)) {//遍历从v点通往的所有w点

            int w = e.to();
            if (distTo[v] + e.weight() < distTo[w]) {//如果通往w点的路径比之前那个v点通往的路径之和短，那我们就将通往w点的路径换成从这个v点出发。

                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
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
