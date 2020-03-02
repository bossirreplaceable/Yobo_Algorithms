package com.yobo.yobo_algorithms.test3_1;

public class BinarySearchArray<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;//存储键值对的数量

    public BinarySearchArray(int size) {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    public void put(Key key, Value value) {
        /*
         * 先查找keys数组中是否用相同的key如果有更新它对应的value就行
         */
        int k = rank(key);
        if (k < N && key.compareTo(keys[k]) == 0) {
            values[k] = value;
            return;
        }
        /*
         * 如果keys数组没有对应key，就需要将这个键值对插入到下标为k的位置，
         * 然后将原来数组下标为k以及k后面的元素平移到后面。
         */
        for (int i = N; i > k; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[k] = key;
        values[k] = value;
        N++;
    }

    public Value get(Key key) {

        if (N == 0) return null;
        int k = rank(key);
        if (k < N && key.compareTo(keys[k]) == 0) {
            return values[k];
        }
        return null;
    }
    /**
     * 获取到key所在keys数组对应的下标,如果没有则返回大于该key的最小key的下标
     * 就比如数组keys{1，3，4，7，9}，我要利用二分查找法寻找5这个key，并返回大于等于5的最小的key的下标。
     * 第一步：mid=0+(4-0)/2=2;          keys[2]<5;      lo=2+1=3;
     * 第二步：mid=3+(4-3)/2=3;          keys[3]>5;      hi=4-1=3;
     * 第三步：mid=3+(3-3)/2=3;          keys[3]>5;      hi=3-1=2;lo=3;
     * 第四步：hi<lo跳出while循环，返回lo=3, 7就是大于等于5的最小key
     */
    private int rank(Key key) {
        int lo = 0;
        int hi = N;
        while (lo <= hi) {
            int mid = (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
