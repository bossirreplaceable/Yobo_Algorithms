package com.yobo.yobo_algorithms.test4_1;

import org.jetbrains.annotations.Nullable;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by ZhangBoshi
 * on 2020-03-02
 */
public class BreadthFirstSearch {

    private boolean[] marked;//标记走过的顶点
    private final int[] edgeTo;//记录路径
    private int s;//起点

    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s); //1、将起点（0）加入到队列中

        while (!queue.isEmpty()) {

            int v = queue.dequeue();//2、依次从队尾取出顶点 （0）
            for (int w : G.adj(v)) {//3、然后检查该点0时候还有其他相邻点（0-1、0-2、0-3）
                if (!marked[w]) {//4、如果有将每个顶点（1、2、3）加入到队列中
                    edgeTo[w] = v;
                    queue.enqueue(w);//5、将每个顶点都加入到队头中，然后进行下一次循环
                }
            }
        }
    }

    private boolean hasPathTo(int w) {
        return marked[w];
    }

    @Nullable
    private Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v))
            return null;

        Stack<Integer> path = new Stack<>();
        for (int w = edgeTo[v]; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }
}
