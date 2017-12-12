package com.song.ads.unit2;

import java.util.LinkedList;

/**
 * Created by 00013708 on 2017/9/1.
 */
public class LinkedListStack<T> implements Stack<T> {
    //先用官方的实现以下
    private LinkedList<T> list;

    public LinkedListStack() {
        this.list = new LinkedList<T>();
    }

    public void push(T t) {
        list.addLast(t);
    }

    public T pop() {
        return list.removeLast();
    }

    public void display() {
        int num = list.size();
        for(int i=0;i<num;i++){
            System.out.println(pop());
        }
    }
}
