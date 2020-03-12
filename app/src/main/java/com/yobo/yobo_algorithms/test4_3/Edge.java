package com.yobo.yobo_algorithms.test4_3;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class Edge implements  Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }
    public int either() {
        return v;
    }
    public int other(int vertex){
        if (vertex==v) return w;
        else if (vertex==w) return v;
        else return 0; //这里应该抛出异常
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight>that.weight) return 1;
        else if (this.weight<that.weight) return -1;
        else return 0;
    }
}
