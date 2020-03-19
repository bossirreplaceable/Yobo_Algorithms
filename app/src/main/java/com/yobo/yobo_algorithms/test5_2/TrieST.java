package com.yobo.yobo_algorithms.test5_2;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by ZhangBoshi
 * on 2020-03-18
 */
public class TrieST<Value> {

    private static int R=256; //字符串中有256个字符，取值为0到255
    private static Node root;
    private static class Node {
        Object val;
        Node[] next = new Node[R];
    }
    /**
     * 插入字符串
     */
    public void put(String key,Value val) {
        root=put(root,key,val,0);
    }
    /**
     *
     * @param x   当前字符所在的结点
     * @param key 插入的字符串
     * @param val 插入的字符串对应的值
     * @param d   走到了该字符串的第几个字符
     * @return    返回当前结点的引用，给前一个字符所在的结点，这样就能保持按照字符顺序形成链接
     */
    private Node put(Node x,String key,Value val,int d) {

        if (x==null) x= new Node();                     //1、如果沿着插入字符串的树枝走的时候，发现树枝后面没有该字符就给该树枝添加新的结点
        if (d==key.length())  { x.val=val; return x; }  //2、如果走到了尾字符所在的结点，更新对应的值

        char n=key.charAt(d);                           //3、获取当前结点保存的对下一个结点的引用
        x.next[n]= put(x.next[n],key,val,d+1);       //4、走向树枝下一个结点，并更新对下一个结点的引用
        return x;
    }

    /**
     * 获取字符串key对应值
     */
    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x==null) return null;
        return (Value) x.val;
    }

    public Node get(Node x, String key, int d){
        if (x==null) return null;                   //1、如果没有该分支就返回null
        if (d==key.length()) return x;              //2、如果走到了与key字符串长度相等的位置，返回当前结点，至于是否有val值在上面的get判断

        char n=key.charAt(d);                       //3、获取当前结点保存的对下一个结点的引用
        return get(x.next[n],key,d+1);          //4、走向树枝下一个结点，并返回最后一个结点的结果
    }


    /**
     * 获取单词查找树中所有的字符串。
     * 这里通过获取前缀字符串的方法来获取所有字符串，当以空字符串为前缀的时候，
     * 得到的是根结点，这样遍历根结点就获取所有字符串了。
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    /**
     * 获取所有以pre字符串为前缀的字符串，
     * she、shells、hello、by 以sh为前缀的字符串有she、shells
     */
    public Iterable<String> keysWithPrefix(String pre) {

        Queue<String> queue=new Queue<>();
        Node start=get(root,pre,0);   //获取到前缀字符串 sh h所在的结点。

        collect(start,pre,queue);
        return queue;
    }
    private void collect(Node x, String pre, Queue<String> queue) {

        if (x==null) return;                      //1、如果遇到空结点，就返回
        if (x.val!=null) queue.enqueue(pre);      //2、如果该结点的值不为空，那么该字符串存在加入到队列中

        for (char c = 0; c < R; c++) {            //3、遍历该结点的所有可能存在的下一个结点，重复上面的1、2步将所有以pre 为前缀的字符串加入到队列中
            collect(x.next[c],pre+c,queue);
        }
    }
    /**
     * 获取所有与pat匹配的字符串 （其中 . 可以代表任意字符）
     */
    public Iterable<String> keysThatMatch(String pat) {

        Queue<String> queue=new Queue<>();
        collect(root,"",pat,queue);
        return queue;
    }
    private void collect(Node x, String pre, String pat, Queue<String> q) {

        int d=pre.length();
        if (x==null) return;
        if (d==pat.length()&&x.val!=null) q.enqueue(pre);
        if (d==pat.length()) return;

        char next=pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next =='.'||c==next){
                collect(x.next[c],pre+c,pat,q);
            }
        }
    }
    /**
     * 获取给定字符串的最长键前缀
     */
    public String longestPrefixOf(String s) {

        int length=search(root,s,0,0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if(x==null) return length;
        if (x.val!=null) length=d;
        if (d==s.length()) return length;
        char c=s.charAt(d);
        return search(x.next[c],s,d+1,length);
    }


    /**
     * 删除指定的String 键
     */
    public void delete(String key) {
        root=delete(root,key,0);
    }

    /**
     * 删除指定String字符串 会有两种情况：
     * 一种是该字符串树枝后面还有其他字符串，这样将该结点的val值置空就可以了
     * 第二种是删除的字符串单独占着一个树枝，这样就需要将这个树枝上所有的字符结点置空
     * @param x    查询到当前结点
     * @param key  删除的字符串
     * @param d    走到key的第一个字符
     * @return     将本结点的信息返回给上一个结点。
     */
    private Node delete(Node x, String key, int d) {

        if (x==null)return  null;
        if (d == key.length()) {
            x.val=null;
        }else {
            char c=key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val!=null) return x;

        for (char c = 0; c < R; c++) {
            if (x.next[c].val!=null) return x;
        }
        return null;
    }


}
