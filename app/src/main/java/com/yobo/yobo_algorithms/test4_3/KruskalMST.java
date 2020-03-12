package com.yobo.yobo_algorithms.test4_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Created by ZhangBoshi
 * on 2020-03-09
 */
public class KruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1.0E-12D;
    private double weight;
    private final Queue<Edge> mst = new Queue<>();

    public KruskalMST(EdgeWeightedGraph G) {

        MinPQ<Edge> pq = new MinPQ<>();

        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UF uf = new UF(G.V());

        while (!pq.isEmpty() && this.mst.size() < G.V() - 1) {
            Edge e = (Edge) pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w);
                this.mst.enqueue(e);
                this.weight += e.weight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return this.mst;
    }

    public double weight() {
        return this.weight;
    }
}
