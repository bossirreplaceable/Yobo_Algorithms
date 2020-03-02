package com.yobo.yobo_algorithms.test3_4;




/**
 * Created by ZhangBoshi
 * on 2020-02-21
 */
public class SeparateChainingHashST<Key,Value> {

    private int M;//散列表的数组大小
    private int N;//存放键值对的实际数量
    private SequentialSearchST<Key,Value>[] st;//存储链表对象的数组

    public SeparateChainingHashST() {
        this(111);
    }
    private SeparateChainingHashST(int m) {
        this.M = m;
        st=(SequentialSearchST<Key,Value>[]) new Object[M];

        for (int i=0;i<M;i++){
            st[i]=new SequentialSearchST<>();
        }
    }
    //散列函数，将key转换成数组st索引
    public int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    public void put(Key key,Value value){
        st[hash(key)].put(key,value);
    }

    public Value get(Key key){
      return   st[hash(key)].get(key);
    }

}
