package com.song.ads.unit2;

/**
 * Created by 00013708 on 2017/9/12.
 */
public interface Queue<T> {

    int enQueue(T t);

    T deQueue();

    void display();
}
