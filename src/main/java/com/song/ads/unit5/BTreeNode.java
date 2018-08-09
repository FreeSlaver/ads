package com.song.ads.unit5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 001844 on 2018/3/29.
 */
public class BTreeNode {

    private List<Integer> data;
    private BTreeNode parent;
    private List<BTreeNode> children;
    private boolean leaf = true;//刚开始默认都是leaf

    public BTreeNode(int item) {
        this.data = new ArrayList<>();
        data.add(item);
    }

    public BTreeNode(List<Integer> data, BTreeNode parent, List<BTreeNode> children, boolean leaf) {
        this.data = data;
        this.parent = parent;
        this.children = children;
        this.leaf = leaf;
    }

    public BTreeNode(List<Integer> left) {
        this.data = left;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public BTreeNode getParent() {
        return parent;
    }

    public void setParent(BTreeNode parent) {
        this.parent = parent;
    }

    public List<BTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<BTreeNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
