package com.song.ads.unit1;

/**
 * Created by 00013708 on 2017/8/22.
 */
public interface LinkedList<T> {

    void addBegin(T t);

    void addEnd(T t);

    void add(T t, int index);

    T remove(int index);

    int remove(T t);

    void display();
}
