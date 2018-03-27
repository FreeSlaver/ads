package com.song.ads.unit3.tree;

/**
 * Created by 001844 on 2018/3/27.
 * 红黑树
 * 性质：
 * 1. 每个节点要么红要么黑
 * 2. 所有叶子节点是黑色
 * 3. 节点是红色，所有子节点是黑色
 * 4.
 */
public class RedBlackTree {
    private RedBlackNode root;




    public RedBlackNode getRoot() {
        return root;
    }

    public void setRoot(RedBlackNode root) {
        this.root = root;
    }
}

class RedBlackNode {
    private Object data;
    private String color;
    private RedBlackNode left, right, parent;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RedBlackNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }
}
