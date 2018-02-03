package com.song.ads.unit2;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/2/3.
 */
public class ArrayQueue2<T> implements Queue<T> {
    private int front;
    private int rear;
    private T[] array;
    private int capacity;

    public ArrayQueue2(int capacity) {
        this.front = 0;
        this.rear = 0;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public int enQueue(T t) {
        if (size() == capacity) {
            throw new IndexOutOfBoundsException("queue full");
        }
        array[rear++] = t;
        return size();
    }

    @Override
    public T deQueue() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        T t = array[front++];
        return t;
    }

    @Override
    public String display() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        return Arrays.toString(array);
    }

    public int size() {
        return rear - front;
    }

    @Override
    public T get(int index) {
        int size = size();
        if (index < 0) {
            index = index % size + size;
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}
