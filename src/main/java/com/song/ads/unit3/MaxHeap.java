package com.song.ads.unit3;

/**
 * Created by 001844 on 2018/2/11.
 */
public class MaxHeap {
    private Node<Integer> root;

    public void insert(Integer i) {
        Node<Integer> node = new Node<Integer>(i);
        if (root == null) {
            root = node;
        }
        Node<Integer> travel = root;
//        Step 1: Insert the newNode as last leaf from left to right.
        while (true) {
            Node<Integer> leftChild = travel.getLeftChild();
            Node<Integer> rightChild = travel.getRightChild();
            if (leftChild == null) {
                travel.setLeftChild(node);
                break;
            } else if (rightChild == null) {
                travel.setRightChild(node);
                break;
            } else if (isFull(leftChild)) {
                //这个地方有个问题
                travel = travel.getRightChild();
            } else {
                travel = travel.getLeftChild();
            }
        }
        //Step 2: Compare newNode value with its Parent node.
        while (true) {
            if (i > travel.getData()) {
                travel.setData(i);
                node.setData(travel.getData());
            }
        }

    }

    private boolean isFull(Node<Integer> node) {
        if (node == null) {
            throw new IllegalArgumentException("node null");
        }
        return node.getLeftChild() != null && node.getRightChild() != null ? true : false;
    }

    /**
     * 将root和last leaf交换，删除掉last leaf
     * root和左右子节点比较，
     */
    public void delete() {
        Node<Integer> node = findLastLeafParent();
        if (node.getLeftChild() != null) {

        }
    }

    private Node<Integer> findLastLeafParent() {
        if (root == null) {
            return null;
        }
        Node<Integer> travel = root;
        while (true) {
            Node<Integer> leftChild = travel.getLeftChild();
            Node<Integer> rightChild = travel.getRightChild();
            if (leftChild == null) {
                return leftChild;
            } else if (rightChild == null) {
                return leftChild;
            } else {
                travel = travel.getLeftChild();
            }
        }
    }

    public Integer findMax() {
        return root == null ? null : root.getData();
    }
}
