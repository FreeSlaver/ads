package com.song.ads.unit3;

import java.util.Comparator;

/**
 * Created by 001844 on 2018/2/7.
 */
public class Node<T> implements Comparator<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> leftChild, Node<T> rightSibling) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightSibling;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
