package com.yobo.yobo_algorithms.test4_1;

/*
 * Created by ZhangBoshi
 * on 2020-03-02
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private Stack.Node<Item> first = null;
    private int n = 0;

    private static class Node<Item> {
        private Item item;
        private Stack.Node<Item> next;

        private Node() {
        }
    }

    public Stack() {
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.n;
    }

    public void push(Item item) {
        Stack.Node<Item> oldfirst = this.first;
        this.first = new Stack.Node();
        this.first.item = item;
        this.first.next = oldfirst;
        ++this.n;
    }

    public Item pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        } else {
            Item item = this.first.item;
            this.first = this.first.next;
            --this.n;
            return item;
        }
    }

    public Item peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        } else {
            return this.first.item;
        }
    }

    public Iterator<Item> iterator() {
        return new Stack.ListIterator(this.first);
    }

    private class ListIterator implements Iterator<Item> {
        private Stack.Node<Item> current;

        public ListIterator(Stack.Node<Item> first) {
            this.current = first;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = this.current.item;
                this.current = this.current.next;
                return item;
            }
        }
    }


}
