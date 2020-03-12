package com.yobo.yobo_algorithms.test4_4;

/**
 * Created by ZhangBoshi
 * on 2020-03-12
 */
public class DirectedEdge {
    private final int v;            // 边的起点
    private final int w;            // 边的终点
    private final double weight;    // 边的权重

    public DirectedEdge(int w, int v, double weight) {
        this.w = w;
        this.v = v;
        this.weight = weight;
    }

    public int from() {
        return v;
    }
    public int to() {
        return w;
    }
    public double weight() {
        return weight;
    }
}
