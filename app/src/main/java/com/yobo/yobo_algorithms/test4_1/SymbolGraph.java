package com.yobo.yobo_algorithms.test4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * 数据类型如下：用逗号隔开的相邻顶点
 * Bacon, Kevin
 * Woodsman,The(2004)
 * Grier,David Alan
 * Bewitched(2005)
 * Kidman, Nicole
 */
public class SymbolGraph {
    private ST<String, Integer> st; // 红黑树--存储 符号名--索引
    private String[] keys; // 将st中的索引放入keys中，用于进行图操作
    private Graph G; // 无向图数据存储，用户获取图的一些属性

    public SymbolGraph(String stream, String sp) {

        st = new ST<>();
        In in = new In(stream);
        while (in.hasNextLine()) {

            // 1、将读取到的数据存储到红黑树的键值对中
            String[] edge = in.readLine().split(sp);
            for (String point : edge) {
                if (!st.contains(point)) {
                    st.put(point, st.size());
                }
            }
        }
        // 2、将符号名--索引 反向存储到keys数组中
        keys = new String[st.size()];
        for (String key : st.keys()) {
            keys[st.get(key)] = key;
        }
        // 3、
        G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] edge = in.readLine().split(sp);
            int v = st.get(edge[0]);
            for (int i = 1; i < edge.length; i++) {
                G.addEdge(v, st.get(edge[i]));
            }
        }
    }
    public boolean contain(String key) {
        return st.contains(key);
    }
    public int index(String key) {
        return st.get(key);
    }
    public String name(int v) {
        return keys[v];
    }
    public Graph G() {
        return G;
    }
}
