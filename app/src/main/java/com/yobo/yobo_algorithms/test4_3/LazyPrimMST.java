package com.yobo.yobo_algorithms.test4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class LazyPrimMST {

    private boolean[] marked; //判断是否已经走过该点
    private Queue<Edge> mst; //存储最小生成树的边
    private MinPQ<Edge> pq; //优先队列，每次从队列中取出最短的边

    public LazyPrimMST(EdgeWeightedGraph G) {

        marked = new boolean[G.V()];
        mst=new Queue<>();
        pq = new MinPQ<>();
        
        visit(G,0);
        while (!pq.isEmpty()){

            Edge e=pq.delMin(); //取出最短的边
            int v=e.either();
            int w=e.other(v);
            if (marked[v]&&marked[w]) continue;//如果边的两个顶点走过了就进行下一次循环
            mst.enqueue(e);

            if (!marked[v]) visit(G,v); //将没有放入优先队列的边添加进去
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
