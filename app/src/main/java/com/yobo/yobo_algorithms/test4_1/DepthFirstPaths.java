package com.yobo.yobo_algorithms.test4_1;

import org.jetbrains.annotations.Nullable;

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */
public class DepthFirstPaths {

    private boolean[] marked;//标记走过的点
    private int[] edgeTo;//从起点到一个顶点的已知路径的最后一个顶点
    private int s; //起点

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo=new int[g.V()];
        this.s=s;
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!hasPathTo(w)) {
                edgeTo[w]=v; //记录w点前一个点是v，这样就能通过edgeTo倒退来找回整条路径
                dfs(G, w);
            }
        }
    }

    private boolean hasPathTo(int w) {
        return marked[w];
    }

    /**
     * 从v点出发，不断倒退，找到从起点到v点的路径
     */
    public Iterable<Integer> pathTo(int v){

        if (!hasPathTo(v)) return null;
        Stack<Integer> path=new Stack<>();
        int w=edgeTo[v];
        for (int i=w;i!=s;i=edgeTo[i]) {
            path.push(i);

        }
        path.push(s);
        return path;
    }
}
