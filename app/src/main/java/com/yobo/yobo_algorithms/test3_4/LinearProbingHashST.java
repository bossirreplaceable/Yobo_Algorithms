package com.yobo.yobo_algorithms.test3_4;

import org.omg.CORBA.Object;

/**
 * Created by ZhangBoshi
 * on 2020-02-22
 */
public class LinearProbingHashST<Key, Value> {

    private int N;// 存储键值对的实际数量
    private int M;// 数组大小
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int m) {
        M = m;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value) {

        if (N>=M/2) resize(2*M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key))
            return;

        int i = hash(key);
        while (!keys[i].equals(key)) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;
        N--;
        i = (i + 1) % M;
        while (keys[i] != null) {

            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }

        if (N>0&&N==M/8) resize(M/2);
    }

    public boolean contains(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                return true;
            }
        }
        return false;
    }


    private void resize(int size){

        LinearProbingHashST st=new LinearProbingHashST(size);
        for (int i=0;i<M;i++){

            if (keys[i]!=null){
                st.put(keys[i],values[i]);
            }
        }
        keys= (Key[]) st.keys;
        values= (Value[]) st.values;
        M=st.M;
    }
}
