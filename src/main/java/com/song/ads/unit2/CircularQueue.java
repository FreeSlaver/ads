package com.song.ads.unit2;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/2/3.
 * 其实就只有一个区别，如果deQueue了之后，会有空间剩余出来
 * 其实很简单，我们可以将整个功能的逻辑演练一遍，比如长度为5的一个数组，不断添加，A,B,C,D,E，满了，然后再添加，报错。
 * 然后deQueue删除前3个元素，没问题，再来添加，没问题，怎么判断没问题？(front >0?那么rear就跑到前面去了，然后不断添加，直到rear比front小1，那么说明也满了。
 * 如果是空数组，进行删除，报错；
 * rear是不断加，然后对capacity取莫好，还是大于capacity之后减去capacity？
 * TMge B，
 */
public class CircularQueue<T> implements Queue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        array = (T[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * @param t
     * @return
     */
    @Override
    public int enQueue(T t) {
        if (size == array.length) {
            throw new IndexOutOfBoundsException("queue full");
        }
        if (size == 0) {
            array[++rear % array.length] = t;
            front = 0;
        }else{
            array[++rear % array.length] = t;
        }
        return ++size;
    }

    @Override
    public T deQueue() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("queue empty");
        }
        T t = array[front % array.length];
        array[front] = null;
        ++front;
        --size;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return t;
    }

    /*public int size(){
        return  rear-front;
    }
    public int capacity(){
        return array.length;
    }*/

    @Override
    public String display() {
        if (size == 0) {
            return null;
        }
//        return Arrays.toString(array);
        T[] arrTemp = (T[]) new Object[size];
        for (int i = front; i <= rear; i++,front++) {
            arrTemp[i%array.length] = array[front%array.length];
        }
        /*for(int i=0;i<size;i++){
            arrTemp[i] = array[front++];
        }*/
        return Arrays.toString(arrTemp);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
}
