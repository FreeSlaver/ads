package com.song.ads.unit2;

/**
 * Created by 00013708 on 2017/9/12.
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] t;

    public ArrayQueue() {
        this.t = (T[]) new Object[64];
    }

    public int enQueue(T t) {

        return 0;
    }

    public T deQueue() {
        T result = t[0];
//        Arrays.copyOf()
        return null;
    }

    public void display() {

    }
}
