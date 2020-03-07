package com.yobo.yobo_algorithms.test4_2;

/**
 * Created by ZhangBoshi
 * on 2020-03-07
 */
public class Topological {

    private Iterable<Integer> order;

    public Topological(Digraph D) {

        DirectedCycle cycle = new DirectedCycle(D);
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(D);
            this.order = depthFirstOrder.reversePost();
        }
    }
    public Iterable<Integer> order(){
        return order;
    }
    /**
     * 是否是有向无环图
     */
    public boolean isDAG() {
        return order!=null;
    }
}
