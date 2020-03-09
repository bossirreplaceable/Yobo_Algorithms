package com.yobo.yobo_algorithms.test4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class LazyPrimMST {

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {

        marked = new boolean[G.V()];
        mst=new Queue<>();
        pq = new MinPQ<>();
        
        visit(G,0);
        while (!pq.isEmpty()){

            Edge e=pq.delMin();
            int v=e.either();
            int w=e.other(v);
            if (marked[v]&&marked[w]) continue;
            mst.enqueue(e);

            if (!marked[v]) visit(G,v);
            if (!marked[w]) visit(G,w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    private Iterable<Edge> mst() {
        return mst;
    }


}
