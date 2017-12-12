package com.song.ads.unit1;

/**
 * Created by 00013708 on 2017/8/22.
 */
public class Node<T> {

    private T data;

    private Node<T> next;


    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * 肯定是要这个方法的，但是这个地方是用Node还是T?
     * 这里应该是private方法
     *
     * @return
     */
    public boolean hasNext() {
        return this == null ? false : this.getNext() == null ? false : true;
    }
}
