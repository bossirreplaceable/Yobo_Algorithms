package com.yobo.yobo_algorithms.test4_1;

/**
 * Created by ZhangBoshi
 * on 2020-03-03
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor=true;

    public TwoColor(Graph G) {
        marked=new boolean[G.V()];
        color=new boolean[G.V()];

        for (int v=0;v<G.V();v++){
            if (!marked(v)){
                dfs(G,v);
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v]=true;

        for (int w:G.adj(v)){
            if (!marked(w)){
                color[w]=!color[v];
                dfs(G,w);
            }else if (color[w]==color[v]){
                isTwoColor=false;
            }
        }

    }
    public boolean isTwoColor(){
        return isTwoColor;
    }
    private boolean marked(int w){
        return marked[w];
    }
}
