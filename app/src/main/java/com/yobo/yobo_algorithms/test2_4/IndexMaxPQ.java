//package com.yobo.yobo_algorithms.test2_4;
//
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdRandom;
//
//public class IndexMaxPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
//    private int maxN;
//    private int n;
//    private int[] pq;
//    private int[] qp;
//    private Key[] keys;
//
//    public IndexMaxPQ(int maxN) {
//        if (maxN < 0) {
//            throw new IllegalArgumentException();
//        } else {
//            this.maxN = maxN;
//            this.n = 0;
//            this.keys = (Comparable[])(new Comparable[maxN + 1]);
//            this.pq = new int[maxN + 1];
//            this.qp = new int[maxN + 1];
//
//            for(int i = 0; i <= maxN; ++i) {
//                this.qp[i] = -1;
//            }
//
//        }
//    }
//
//    public boolean isEmpty() {
//        return this.n == 0;
//    }
//
//    public boolean contains(int i) {
//        this.validateIndex(i);
//        return this.qp[i] != -1;
//    }
//
//    public int size() {
//        return this.n;
//    }
//
//    public void insert(int i, Key key) {
//        this.validateIndex(i);
//        if (this.contains(i)) {
//            throw new IllegalArgumentException("index is already in the priority queue");
//        } else {
//            ++this.n;
//            this.qp[i] = this.n;
//            this.pq[this.n] = i;
//            this.keys[i] = key;
//            this.swim(this.n);
//        }
//    }
//
//    public int maxIndex() {
//        if (this.n == 0) {
//            throw new NoSuchElementException("Priority queue underflow");
//        } else {
//            return this.pq[1];
//        }
//    }
//
//    public Key maxKey() {
//        if (this.n == 0) {
//            throw new NoSuchElementException("Priority queue underflow");
//        } else {
//            return this.keys[this.pq[1]];
//        }
//    }
//
//    public int delMax() {
//        if (this.n == 0) {
//            throw new NoSuchElementException("Priority queue underflow");
//        } else {
//            int max = this.pq[1];
//            this.exch(1, this.n--);
//            this.sink(1);
//
//            assert this.pq[this.n + 1] == max;
//
//            this.qp[max] = -1;
//            this.keys[max] = null;
//            this.pq[this.n + 1] = -1;
//            return max;
//        }
//    }
//
//    public Key keyOf(int i) {
//        this.validateIndex(i);
//        if (!this.contains(i)) {
//            throw new NoSuchElementException("index is not in the priority queue");
//        } else {
//            return this.keys[i];
//        }
//    }
//
//    public void changeKey(int i, Key key) {
//        this.validateIndex(i);
//        if (!this.contains(i)) {
//            throw new NoSuchElementException("index is not in the priority queue");
//        } else {
//            this.keys[i] = key;
//            this.swim(this.qp[i]);
//            this.sink(this.qp[i]);
//        }
//    }
//
//    /** @deprecated */
//    @Deprecated
//    public void change(int i, Key key) {
//        this.validateIndex(i);
//        this.changeKey(i, key);
//    }
//
//    public void increaseKey(int i, Key key) {
//        this.validateIndex(i);
//        if (!this.contains(i)) {
//            throw new NoSuchElementException("index is not in the priority queue");
//        } else if (this.keys[i].compareTo(key) == 0) {
//            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the priority queue");
//        } else if (this.keys[i].compareTo(key) > 0) {
//            throw new IllegalArgumentException("Calling increaseKey() with a key that is strictly less than the key in the priority queue");
//        } else {
//            this.keys[i] = key;
//            this.swim(this.qp[i]);
//        }
//    }
//
//    public void decreaseKey(int i, Key key) {
//        this.validateIndex(i);
//        if (!this.contains(i)) {
//            throw new NoSuchElementException("index is not in the priority queue");
//        } else if (this.keys[i].compareTo(key) == 0) {
//            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
//        } else if (this.keys[i].compareTo(key) < 0) {
//            throw new IllegalArgumentException("Calling decreaseKey() with a key that is strictly greater than the key in the priority queue");
//        } else {
//            this.keys[i] = key;
//            this.sink(this.qp[i]);
//        }
//    }
//
//    public void delete(int i) {
//        this.validateIndex(i);
//        if (!this.contains(i)) {
//            throw new NoSuchElementException("index is not in the priority queue");
//        } else {
//            int index = this.qp[i];
//            this.exch(index, this.n--);
//            this.swim(index);
//            this.sink(index);
//            this.keys[i] = null;
//            this.qp[i] = -1;
//        }
//    }
//
//    private void validateIndex(int i) {
//        if (i < 0) {
//            throw new IllegalArgumentException("index is negative: " + i);
//        } else if (i >= this.maxN) {
//            throw new IllegalArgumentException("index >= capacity: " + i);
//        }
//    }
//
//    private boolean less(int i, int j) {
//        return this.keys[this.pq[i]].compareTo(this.keys[this.pq[j]]) < 0;
//    }
//
//    private void exch(int i, int j) {
//        int swap = this.pq[i];
//        this.pq[i] = this.pq[j];
//        this.pq[j] = swap;
//        this.qp[this.pq[i]] = i;
//        this.qp[this.pq[j]] = j;
//    }
//
//    private void swim(int k) {
//        while(k > 1 && this.less(k / 2, k)) {
//            this.exch(k, k / 2);
//            k /= 2;
//        }
//
//    }
//
//    private void sink(int k) {
//        while(true) {
//            if (2 * k <= this.n) {
//                int j = 2 * k;
//                if (j < this.n && this.less(j, j + 1)) {
//                    ++j;
//                }
//
//                if (this.less(k, j)) {
//                    this.exch(k, j);
//                    k = j;
//                    continue;
//                }
//            }
//
//            return;
//        }
//    }
//
//    public Iterator<Integer> iterator() {
//        return new edu.princeton.cs.algs4.IndexMaxPQ.HeapIterator();
//    }
//
//    public static void main(String[] args) {
//        String[] strings = new String[]{"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
//        edu.princeton.cs.algs4.IndexMaxPQ<String> pq = new edu.princeton.cs.algs4.IndexMaxPQ(strings.length);
//
//        int i;
//        for(i = 0; i < strings.length; ++i) {
//            pq.insert(i, strings[i]);
//        }
//
//        Iterator var6 = pq.iterator();
//
//        int i;
//        while(var6.hasNext()) {
//            i = (Integer)var6.next();
//            StdOut.println(i + " " + strings[i]);
//        }
//
//        StdOut.println();
//
//        for(i = 0; i < strings.length; ++i) {
//            if (StdRandom.uniform() < 0.5D) {
//                pq.increaseKey(i, strings[i] + strings[i]);
//            } else {
//                pq.decreaseKey(i, strings[i].substring(0, 1));
//            }
//        }
//
//        while(!pq.isEmpty()) {
//            String key = (String)pq.maxKey();
//            i = pq.delMax();
//            StdOut.println(i + " " + key);
//        }
//
//        StdOut.println();
//
//        for(i = 0; i < strings.length; ++i) {
//            pq.insert(i, strings[i]);
//        }
//
//        int[] perm = new int[strings.length];
//
//        for(i = 0; i < strings.length; perm[i] = i++) {
//            ;
//        }
//
//        StdRandom.shuffle(perm);
//
//        for(i = 0; i < perm.length; ++i) {
//            String key = (String)pq.keyOf(perm[i]);
//            pq.delete(perm[i]);
//            StdOut.println(perm[i] + " " + key);
//        }
//
//    }
//
//    private class HeapIterator implements Iterator<Integer> {
//        private edu.princeton.cs.algs4.IndexMaxPQ<Key> copy;
//
//        public HeapIterator() {
//            this.copy = new edu.princeton.cs.algs4.IndexMaxPQ(edu.princeton.cs.algs4.IndexMaxPQ.this.pq.length - 1);
//
//            for(int i = 1; i <= IndexMaxPQ.this.n; ++i) {
//                this.copy.insert(this.pq[i], this.keys[edu.princeton.cs.algs4.IndexMaxPQ.this.pq[i]]);
//            }
//
//        }
//
//        public boolean hasNext() {
//            return !this.copy.isEmpty();
//        }
//
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//
//        public Integer next() {
//            if (!this.hasNext()) {
//                throw new NoSuchElementException();
//            } else {
//                return this.copy.delMax();
//            }
//        }
//    }
//}
