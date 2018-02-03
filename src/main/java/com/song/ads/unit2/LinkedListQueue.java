package com.song.ads.unit2;

import com.song.ads.unit1.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/1/25.
 */
public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public int enQueue(T t) {
        Node<T> node = new Node<T>(t);
        if (size == 0) {//queue empty
            rear = node;
            front = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
        return ++size;
    }

    public T deQueue() {
        if (size == 0) {
            throw new RuntimeException("queue empty");
        }
        T t = front.getData();
        --size;
        if (size == 0) {
            front = null;
            rear = null;
        } else {
            front = front.getNext();
        }
        return t;
    }

    public String display() {
        if(size==0){
            return null;
        }
        Node<T> travel = front;
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(travel.getData());
            travel = travel.getNext();
        }
        return Arrays.toString(list.toArray());
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> travel = front;
        for (int i = 0; i < index; i++) {
            travel = travel.getNext();
        }
        return travel.getData();
    }
}
