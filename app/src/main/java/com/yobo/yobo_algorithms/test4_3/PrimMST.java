package com.yobo.yobo_algorithms.test4_3;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by ZhangBoshi
 * on 2020-03-08
 */
public class PrimMST {

    private boolean[] marked; //判断是否走过该点
    private Edge[] edgeTo;    //存放最小生成树的边
    private double[] distTo;  //存放每天边的权重
    private IndexMinPQ<Double> pq;  //索引优先队列，可以通过索引来更改存储的值

    public PrimMST(EdgeWeightedGraph G) {

        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()]; //顶点数量和最小生成树边的数量一致
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int i = 0; i < G.V(); i++) { //1、先讲每条边的权值设置为无穷大
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;           //2、起点0 的权值为0 ，并将起点0加入到优先队列中
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {    //3、每次从队列中取出最短的边，并返回边 v-->w 的顶点w
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {

        marked[v] = true;           //4、标记走过了该点
        for (Edge e : G.adj(v)) {   //5、遍历该点的所有邻边

            int w = e.other(v);
            if (marked[w])
                continue;
            if (e.weight() < distTo[w]) {  //6、如果该边 v-->w 的权值，比前面加入通往w的边的权值小，则替换

                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w))      //7、如果优先队列已经存了通往w的边，但不是最短的，则替换
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<>();
        for (int v = 0; v < this.edgeTo.length; ++v) {
            Edge e = this.edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
}
