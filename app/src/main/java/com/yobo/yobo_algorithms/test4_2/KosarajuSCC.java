package com.yobo.yobo_algorithms.test4_2;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class KosarajuSCC {

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph D) {

        marked=new boolean[D.V()];
        id=new int[D.V()];

        DepthFirstOrder order=new DepthFirstOrder(D.reverse());
        for (int v:order.reversePost()){
            if (!marked(v)){
                dfs(D,v);
                count++;
            }
        }
    }

    private void dfs(Digraph D, int v) {
        marked[v]=true;
        id[v]=count;

        for (int w:D.adj(v)){
            if (!marked(w)){
                dfs(D,w);
            }
        }
    }

    private boolean marked(int w) {
        return marked[w];
    }
    public boolean stronglyConnected(int v,int w){
        return id[v]==id[w];
    }
    public int id(int v){
        return id[v];
    }
    private int count() {
        return count;
    }
}
