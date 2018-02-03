package com.song.ads.unit2;

import java.util.Arrays;

/**
 * Created by 00013708 on 2017/9/12.
 * 尾部添加，头部删除
 * 添加后，返回元素数量；
 * 删除后，返回删除额元素
 * display从前到后
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int size;

    public ArrayQueue() {
        this.array = (T[]) new Object[64];//数组
        this.size = 0;
    }

    //代码有好多问题，如果queue满了怎么办？
    public int enQueue(T t) {
        if (array.length == size) {
            throw new IndexOutOfBoundsException("queue full");
        }
        array[size++] = t;
        return size;
    }

    //如果是空的，怎么办?想想，使用front和rear有什么好处？
    public T deQueue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        T result = array[0];
        //就是将第一个元素删除，然后将后面的所有元素向前移动
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        --size;
        return result;
    }

    public String display() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}
