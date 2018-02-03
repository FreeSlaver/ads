package com.song.ads.unit2;

import com.song.ads.unit1.LinkedList;
import com.song.ads.unit1.SingleLinkedList;

/**
 * Created by 001844 on 2018/1/25.
 */
public class LinkedListQueue<T> implements Queue<T> {

    private LinkedList<T> linkedList;

    public LinkedListQueue() {
        this.linkedList = new SingleLinkedList<T>();
    }

    public int enQueue(T t) {
        this.linkedList.addEnd(t);
        return 0;
    }

    public T deQueue() {
        return null;
    }

    public String display() {
        return null;
    }

    @Override
    public T get(int index) {
        if(index<0||index>linkedList){
            throw new IndexOutOfBoundsException();
        }
        return linkedList.get(index);
    }
}
