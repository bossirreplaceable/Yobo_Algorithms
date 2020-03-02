package com.yobo.yobo_algorithms.test4_1;

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */
public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked(w)) {
                dfs(G, w);
            }
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
