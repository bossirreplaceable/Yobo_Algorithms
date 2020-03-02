package com.yobo.yobo_algorithms.test4_1;

import org.jetbrains.annotations.Nullable;

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */
public class DepthFirstPaths {

    private boolean[] marked;//这个顶点上调用过dfs()了
    private int[] edgeTo;//从起点到一个顶点的已知路径的最后一个顶点
    private int count;
    private int s; //起点

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo=new int[g.V()];
        this.s=s;

    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!hasPathTo(w)) {
                edgeTo[w]=v;
                dfs(G, w);
            }
        }
    }

    private boolean hasPathTo(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    @Nullable
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
