package com.yobo.yobo_algorithms.test4_4;

/**
 * Created by ZhangBoshi
 * on 2020-03-12
 */
public class DijkstraAllPairsSP {
  private   DijkstraSP[] all;

    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {

        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v]=new DijkstraSP(G,v);
        }
    }

    public Iterable<DirectedEdge> path(int s, int v) {
        return all[s].pathTo(v);
    }

    public double dist(int s,int v) {
        return all[s].distTo(v);
    }
}
