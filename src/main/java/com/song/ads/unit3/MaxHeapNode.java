package com.song.ads.unit3;

/**
 * Created by 001844 on 2018/2/11.
 */
public class MaxHeapNode<T> extends Node<T> {
    private Node<T> parent;

    public MaxHeapNode(T data) {
        super(data);
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
