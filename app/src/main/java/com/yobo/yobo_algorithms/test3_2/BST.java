package com.yobo.yobo_algorithms.test3_2;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    class Node {
        Key key;
        Value value;
        Node left, right;//左右子结点
        int N;//以该结点为父结点的所有子结点的数量

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 先递归向下寻找key所在的位置，如果有则更新对应的value，
     * 如果没有，当在树的底部添加了一个新结点之后，还需要
     * 从下往上更新所有父结点的N的值。
     */
    private Node put(Node node, Key key, Value value) {

        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 使用递归的方式，从根节出发，不断向下查找
     */
    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    /**
     * 获取二叉查找树最大的key值
     */
    public Key max() {
        if (root == null) return null;
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }
    /**
     * 获取二叉查找树最小的key值
     */
    public Key min() {
        if (root == null) return null;
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }



    /**
     * 返回小于等于key 的最大的key
     */
    public Key floor(Key key) {

        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node floor(Node x, Key key) {

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    /**
     * 返回大于等于key 的最小的key
     */
    public Key ceiling(Key key) {

        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }
    private Node ceiling(Node x, Key key) {

        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0) ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;
    }

    /**
     * 返回排名为index的key
     */
    public Key select(int index) {

        Node x = select(root, index);
        if (x == null) return null;
        return x.key;
    }
    private Node select(Node x, int index) {

        if (x == null) return null;
        int k = size(x.left);
        if (k > index) {
            return select(x.left, index);
        } else if (k < index) {
            return select(x.right, index - k - 1);
        } else return x;
    }

    /**
     * 返回比key小的结点的数量
     */
    public int rank(Key key) {
       return rank(root, key);
    }

    private int rank(Node x, Key key) {

        if (x == null) return 0;
        int cmp=key.compareTo(x.key);

        if (cmp<0) return rank(x.left,key);
        else if (cmp>0) return 1+size(x.left)+rank(x.right,key);
        else return size(x.left);

    }

    public void deleteMin(){
       root= deleteMin(root);
    }

    /**
     * 删除最小的元素
     */
    private Node deleteMin(Node x) {

        if(x.left==null) return x.right;
        x.left=deleteMin(x.left);
        x.N=size(x.left)+size(x.right)+1;
        return x;
    }

    public void delete(Key key){
        root=delete(root,key);
    }

    public Node delete(Node x,Key key){

        if (x==null) return null;
        int cmp=key.compareTo(x.key);
        if (cmp<0) x.left=delete(x.left,key);
        else if (cmp>0) x.right=delete(x.right,key);
        else {
            if (x.right==null) return x.left;
            if (x.left==null) return x.right;
            Node t=x;
            x=min(t.right);
            x.right=deleteMin(t.right);
            x.left=t.left;
        }

        x.N=size(x.left)+size(x.right)+1;
        return x;
    }




}
