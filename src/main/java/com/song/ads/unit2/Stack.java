package com.song.ads.unit2;

/**
 * Created by 00013708 on 2017/9/1.
 * 特性后进，先出，只在最top的位置操作
 * 只在尾部操作
 */
public interface Stack<T> {

    void push(T t);

    T pop();

    void display();
}
