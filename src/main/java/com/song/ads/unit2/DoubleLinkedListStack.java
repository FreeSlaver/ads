package com.song.ads.unit2;

import com.song.ads.unit1.DoubleLinkedList;

/**
 * Created by 00013708 on 2017/9/1.
 */
public class DoubleLinkedListStack<T> {

    private DoubleLinkedList<T> list;

    public DoubleLinkedListStack() {
        this.list = new DoubleLinkedList<T>();
    }

    public void push(T t) {
        list.addEnd(t);
    }

    public T pop() {
        return list.removeEnd();
    }

    public void display() {
        list.display();
    }
}
