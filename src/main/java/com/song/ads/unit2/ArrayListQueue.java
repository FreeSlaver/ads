package com.song.ads.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 00013708 on 2017/9/12.
 */
public class ArrayListQueue<T> implements  Queue<T> {
    private List<T> arrayList;

    public ArrayListQueue() {
        this.arrayList = new ArrayList<T>();
    }

    public int enQueue(T t) {
        arrayList.add(t);
        return arrayList.size()-1;
    }

    public T deQueue() {
        return arrayList.remove(0);
    }

    public void display() {
        System.out.println(Arrays.toString(arrayList.toArray()));
    }
}
