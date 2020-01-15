package com.yobo.yobo_algorithms.test1_1;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class ResizeStack<T> implements Iterable<T> {

    private T[] a = (T[]) new Object[2];

    private int N = 0; // 栈内元素的数量

    /**
     * 将元素添加到栈顶
     */
    public void push(T t) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = t;
    }

    /**
     * 将元素从栈顶删除
     */
    public T pop() {
        T item = a[--N];
        a[N] = null; // 避免对象游离
        if (N>0&&N <= a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
    public int stackSize() {
        return a.length;
    }

    private void resize(int size) {
        T[] temp = (T[]) new Object[size];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return N > 0;
            }

            @Override
            public T next() {
                return a[--N];
            }
        };
    }
}
