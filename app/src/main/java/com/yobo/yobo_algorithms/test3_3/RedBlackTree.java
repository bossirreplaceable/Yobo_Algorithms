package com.yobo.yobo_algorithms.test3_3;


/**
 * 对应RedBlackBST
 */

public class RedBlackTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private Node root;
    class Node{
        Key key;
        Value val;
        int N;//这棵子树的结点总数
        Node left,right;
        boolean color;

        public Node(Key key,Value val,int N,boolean color){
            this.key=key;
            this.val=val;
            this.N=N;
            this.color=color;
        }
    }

    public void put(Key key,Value value){

      root=put(root,key,value);
      root.color=BLACK;//根节点永远是黑色

    }
    /**
     * 1、 如果右子结点是红色的而左子结点是黑色 的，进行左旋转；
     * 2、 如果左子结点是红色的且它的左子结点也是红色的，进行右旋转；
     * 3、 如果左右子结点均为红色，进行颜色转换。
     */
    private Node put(Node h, Key key, Value value) {

        if (h==null) return new Node(key,value,1,RED);

        int cmp=key.compareTo(h.key);
        if (cmp<0) h.left=put(h.left,key,value);
        else if (cmp>0) h.right=put(h.right,key,value);
        else h.val=value;

        if (isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
        if (isRed(h.left)&&isRed(h.left.left))h=rotateRight(h);
        if (isRed(h.left)&&isRed(h.right)) flipColors(h);

        h.N=size(h.left)+size(h.right)+1;
        return h;

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
            return node.val;
        }
    }

    private void flipColors(Node h){
        h.color= RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    private  Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=size(h.left)+size(h.right)+1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        x.color=h.color;
        h.color=RED;
        x.N=h.N;
        h.N=size(h.left)+size(h.right)+1;
        return x;
    }

    public int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }
    private boolean isRed(Node x){
        if (x==null) return false;//树最底部空结点都是黑色链接
        return x.color==RED;
    }

}
