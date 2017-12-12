package com.song.ads.unit1;

/**
 * Created by 00013708 on 2017/8/31.
 */
public class DLNode<T> {

    private DLNode<T> prev;

    private DLNode<T> next;

    private T t;

    public DLNode() {
        this.t = t;
    }

    public DLNode(T t) {
        this.t = t;
    }

    public void setPrev(DLNode<T> prev) {
        this.prev = prev;
    }

    public DLNode<T> getNext() {
        return next;
    }

    public void setNext(DLNode<T> next) {
        this.next = next;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public DLNode<T> getPrev() {
        return prev;
    }
}
