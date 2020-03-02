package com.yobo.yobo_algorithms.test3_1;

/**
 * 与 官方代码中的SequentialSearchST 对应
 */
public class NodeMap<Key, Value> {

    private Node first;//头结点

    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) { //如果链表中含有相同的key更新对应的value即可
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);//链表中没有该key的话，利用该键值对创建新的头结点
    }

    public Value get(Key key) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
               return x.value;
            }
        }
        return null;
    }

}
