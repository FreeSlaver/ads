package com.song.ads.unit2;

import java.util.Arrays;

/**
 * Created by 00013708 on 2017/9/1.
 */
public class ArrayStack<T> implements Stack<T> {

    private T[] arr;

    private int size;

    private int capacity;

    public ArrayStack() {
        capacity = 64;
        arr = (T[]) new Object[capacity];
    }

    @SuppressWarnings("Since15")
    public void push(T t) {
        if (size == capacity) {
            capacity = capacity * 2 + 1;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[size++] = t;
        return;
    }

    public T pop() {
        return arr[--size];
    }

    public void display() {
        int num = size;
        for (int i = 0; i < num; i++) {
            System.out.println(pop());
        }
    }

}
