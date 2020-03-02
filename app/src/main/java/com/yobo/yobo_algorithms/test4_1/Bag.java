package com.yobo.yobo_algorithms.test4_1;

/*
 * Created by ZhangBoshi
 * on 2020-03-02
 */

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Bag<Item> implements Iterable<Item> {
    private Node first = null;
    private int n = 0;

    public Bag() {
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = this.first;
        this.first = new Node();
        this.first.item = item;
        this.first.next = oldfirst;
        ++this.n;
    }

    @NotNull
    public Iterator<Item> iterator() {
        return new  Bag.ListIterator(this.first);
    }



    private class ListIterator implements Iterator<Item> {
        private  Bag.Node<Item> current;

        ListIterator(Bag.Node<Item> first) {
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

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        private Node() {
        }
    }
}
