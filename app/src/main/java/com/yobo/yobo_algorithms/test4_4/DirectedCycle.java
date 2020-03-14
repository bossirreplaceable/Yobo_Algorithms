package com.yobo.yobo_algorithms.test4_4;

import com.yobo.yobo_algorithms.test4_1.Stack;
import com.yobo.yobo_algorithms.test4_2.Digraph;

/**
 * Created by ZhangBoshi
 * on 2020-03-05
 */
public class DirectedCycle {

    private final boolean[] marked; //是否走过该点
    private final boolean[] onStack;  //对递归路径上的点存入栈中（true），当该路径没有环时改为false
    private  DirectedEdge[] edgeTo; // s-w 路径上 w 的上一个顶点
    private Stack<DirectedEdge> cycle;  //存放有向环的所有顶点

    public DirectedCycle(EdgeWeightedDigraph D) {
        marked=new boolean[D.V()];
        onStack=new boolean[D.V()];
        edgeTo=new DirectedEdge[D.V()];

        for (int i=0;i<D.V();i++){
            if (!marked(i)){
                dfs(D,i);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph D,int v){

        marked[v]=true;
        onStack[v]=true;

        for (DirectedEdge e:D.adj(v)){
            int w=e.to();
            if (!marked(w)){
                edgeTo[w]=e;
                dfs(D,w);
            }else if (onStack[w]){
                cycle=new Stack<>();
                DirectedEdge f;
                for(f = e; f.from() != w; f = edgeTo[f.from()]) {
                    cycle.push(f);
                }
                cycle.push(f);
                return;
            }
        }
        onStack[v]=false; //-------记住退出递归之后要释放该点，以防下条路径有环并且含有该点
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<DirectedEdge> cycle(){
        return cycle;
    }

    private boolean marked(int w){
        return marked[w];
    }
}
