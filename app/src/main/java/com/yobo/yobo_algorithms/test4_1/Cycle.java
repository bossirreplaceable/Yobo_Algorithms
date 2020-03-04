package com.yobo.yobo_algorithms.test4_1;

/**
 * Created by ZhangBoshi
 * on 2020-03-03
 */
public class Cycle {

    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
          marked=new boolean[G.V()];

          for (int v=0;v<G.V();v++){
              if (!marked(v)){
                  dfs(G,v,v);
              }
          }
    }
    private void dfs(Graph G,int v,int u){

        marked[v]=true;
        for (int w:G.adj(v)){
            if (!marked(w)){
                dfs(G,w,v);
            }else if (w!=u){
                hasCycle=true;
            }
        }
    }
    public boolean hasCycle(){
        return hasCycle;
    }
    private boolean marked(int w){
        return marked[w];
    }
}
