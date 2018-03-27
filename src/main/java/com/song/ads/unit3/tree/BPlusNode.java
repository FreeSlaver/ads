package com.song.ads.unit3.tree;

import java.util.List;

public class BPlusNode {
    //if leaf,numberOfRouterValues else numberOfKeyValues
    int n;
    //if leaf routerValues else keyValues
    List<Integer> values;
    //true leaf else non-leaf
    boolean leaf;
    //non-leaf children else none
    //n+1 pointers to the children
    List<BPlusNode> children;

    public BPlusNode() {
    }

    public BPlusNode(int n, List<Integer> values, boolean leaf, List<BPlusNode> children) {
        this.n = n;
        this.values = values;
        this.leaf = leaf;
        this.children = children;
    }

    /*public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<BPlusNode> getChildren() {
        return children;
    }

    public void setChildren(List<BPlusNode> children) {
        this.children = children;
    }*/
}