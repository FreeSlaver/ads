package com.song.ads.unit2;

import com.song.ads.unit1.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/2/3.
 * 可以在头部
 */
public class DoubleEndedQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public DoubleEndedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public int enQueueFront(T t) {
        Node<T> node = new Node<T>(t);
        if (size == 0) {
            front = node;
            rear = node;
        } else {
            node.setNext(front);
            front = node;
        }
        return ++size;
    }

    public int enQueueRear(T t) {
        Node<T> node = new Node<T>(t);
        if (size == 0) {
            front = node;
            rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
        return ++size;
    }

    public T deQueueFront() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        T t = front.getData();
        front = front.getNext();
        --size;
        return t;
    }

    public T deQueueRear() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        T t = rear.getData();
        Node<T> travel = front;
        for (int i = 0; i < size - 1; i++) {
            travel = travel.getNext();
        }
        travel.setNext(null);
        rear = travel;
        --size;
        return t;
    }


    @Override
    public int enQueue(T t) {
        throw new RuntimeException("use enQueueFront or enQueueRear");
    }

    @Override
    public T deQueue() {
        throw new RuntimeException("use deQueueFront or deQueueRear");
    }

    @Override
    public String display() {
        if (size == 0) {
            return null;
        }
        List<T> list = new ArrayList<>();
        Node<T> travel = front;
        for (int i = 0; i < size; i++) {
            list.add(travel.getData());
            travel = travel.getNext();
        }
        return Arrays.toString(list.toArray());
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> travel = front;
        for (int i = 0; i < index; i++) {
            travel = travel.getNext();
        }
        return travel.getData();
    }
}


