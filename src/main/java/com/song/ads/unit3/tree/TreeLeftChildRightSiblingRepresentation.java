package com.song.ads.unit3.tree;

import java.util.List;

/**
 * Created by 001844 on 2018/2/7.
 */
public class TreeLeftChildRightSiblingRepresentation {

    public TreeLeftChildRightSiblingRepresentation() {

    }
    public TreeLeftChildRightSiblingRepresentation(List<String> list) {

    }


    public static void main(String[] args) {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");
        Node<String> G = new Node<>("G");
        Node<String> H = new Node<>("H");
        Node<String> I = new Node<>("I");
        Node<String> J = new Node<>("J");
        Node<String> K = new Node<>("K");

        A.setLeftChild(B);
        A.setRightSibling(null);

        B.setRightSibling(D);
        B.setRightSibling(C);

        C.setLeftChild(G);
        C.setRightSibling(null);

        D.setLeftChild(null);
        D.setRightSibling(E);

        E.setLeftChild(I);
        E.setRightSibling(F);

        F.setLeftChild(null);
        F.setRightSibling(null);

        G.setLeftChild(K);
        G.setRightSibling(H);

        H.setLeftChild(null);
        H.setRightSibling(null);

        I.setLeftChild(null);
        I.setRightSibling(J);

    }
}

class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightSibling;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> leftChild, Node<T> rightSibling) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightSibling = rightSibling;
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

    public Node<T> getRightSibling() {
        return rightSibling;
    }

    public void setRightSibling(Node<T> rightSibling) {
        this.rightSibling = rightSibling;
    }
}