package com.yobo.yobo_algorithms.test4_1;

/**
 * Created by ZhangBoshi
 * on 2020-03-03
 */
public class CC {

    private boolean[] marked; // 是否被标示过
    private int[] id; // 连通分量的标识符 1-第一个连通分量、2-第二个连通分量
    private int count; // 连通分量的数量

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked(v)) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
    public int id(int v) {
        return id[v];
    }
    public int count() {
        return count;
    }
    private boolean marked(int w) {
        return marked[w];
    }
}
