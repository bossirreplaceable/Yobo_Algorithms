package com.yobo.yobo_algorithms.test4_2;

import com.yobo.yobo_algorithms.test4_1.Stack;

/**
 * Created by ZhangBoshi
 * on 2020-03-05
 */
public class DirectedCycle {


    private final boolean[] marked;
    private final boolean[] onStack;
    private final int[] edge;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph D) {

        marked=new boolean[D.V()];
        onStack=new boolean[D.V()];
        edge=new int[D.V()];

        for (int i=0;i<D.V();i++){
            if (!marked(i)){
                dfs(D,i);
            }
        }
    }


    private void dfs(Digraph D,int v){

        marked[v]=true;
        onStack[v]=true;

        for (int w:D.adj(v)){
            if (!marked(w)){
                edge[w]=v;
                dfs(D,w);
            }else if (onStack[w]){
                cycle=new Stack<>();
                for (int k=edge[w];k!=w;k=edge[k]){
                    cycle.push(k);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v]=false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

    private boolean marked(int w){
        return marked[w];
    }

}
