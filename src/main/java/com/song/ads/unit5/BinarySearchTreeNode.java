package com.song.ads.unit5;

import com.alibaba.fastjson.JSON;

/**
 * Created by 001844 on 2018/3/29.
 */
public class BinarySearchTreeNode {

    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public BinarySearchTreeNode(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode(int data, BinarySearchTreeNode left, BinarySearchTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode left) {
        this.left = left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
