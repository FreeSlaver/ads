package com.song.ads.unit2;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/2/3.
 */
public class ArrayQueue2<T> implements Queue<T> {
    private int front;
    private int rear;
    private T[] array;
    private int size;

    public ArrayQueue2(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public int enQueue(T t) {
        if (size == array.length) {
            throw new IndexOutOfBoundsException("queue full");
        }
        if (size == 0) {
            array[++rear] = t;
            front = 0;
        }
        return ++size;
    }

    @Override
    public T deQueue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        T t = array[front];
        array[front] = null;
        ++front;
        --size;
        if(size==0){
            front= -1;
            rear = -1;
        }
        return t;
    }

    @Override
    public String display() {
        if (size == 0) {
            return null;
        }
        return Arrays.toString(array);

    }


    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}
