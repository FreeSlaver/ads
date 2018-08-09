package com.song.ads.unit5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by 001844 on 2018/3/29.
 */
public class BinarySearchTree {

    private BinarySearchTreeNode root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Collection<Integer> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("collection null");
        }
        for (Integer integer : collection) {
            insert(integer);
        }
    }

    public BinarySearchTreeNode search(int item) {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode travelNode = root;
        while (true) {
            int travelNodeData = travelNode.getData();
            if (item < travelNodeData) {
                if (travelNode.getLeft() == null) {
                    System.out.println("not found");
                    return null;
                } else {
                    travelNode = travelNode.getLeft();
                }
            } else if (item > travelNodeData) {
                if (travelNode.getRight() == null) {
                    System.out.println("not found");
                    return null;
                } else {
                    travelNode = travelNode.getRight();
                }
            } else {//相等
                return travelNode;
            }
        }

    }

    /**
     * 不断遍历，直到left或者right为null，也就是叶子节点，然后将上个节点的right或者left设置为此node
     *
     * @param item
     */
    public void insert(int item) {
        BinarySearchTreeNode node = new BinarySearchTreeNode(item);
        if (root == null) {
            root = node;
        } else {
            BinarySearchTreeNode travelNode = root;
            while (true) {
                if (item < travelNode.getData()) {
                    if (travelNode.getLeft() != null) {//
                        travelNode = travelNode.getLeft();
                    } else {
                        travelNode.setLeft(node);
                        break;
                    }
                } else {
                    if (travelNode.getRight() != null) {
                        travelNode = travelNode.getRight();
                    } else {
                        travelNode.setRight(node);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 删除要分很多种情况，1.叶子节点，最容易；2.非叶子节点，
     *
     * @param item
     */
    public void delete(int item) {
        BinarySearchTreeNode foundNode = search(item);
        if (foundNode == null) {
            System.out.println("no item found,no delete");
            return;
        }
        BinarySearchTreeNode leftChild = foundNode.getLeft();
        BinarySearchTreeNode rightChild = foundNode.getRight();
        if (leftChild == null && rightChild == null) {
            foundNode = null;
        } else if (leftChild == null && rightChild != null) {
            foundNode = rightChild;
        } else if (leftChild != null && rightChild == null) {
            foundNode = leftChild;
        } else {//both are not null
            //找出左子树最大的Node
//            foundNode.find

        }
    }

    public BinarySearchTreeNode findMaxNode() {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode travelNode = root;
        while (true) {
            if (travelNode.getRight() != null) {
                travelNode = travelNode.getRight();
            } else {
                return travelNode;
            }
        }
    }
    public BinarySearchTreeNode findSubtreeMaxNode(BinarySearchTreeNode node) {
        if(node==null){
            return null;
        }
        return null;
    }

    public BinarySearchTreeNode findMinNode() {
        if (root == null) {
            return null;
        }
        BinarySearchTreeNode travelNode = root;
        while (true) {
            if (travelNode.getLeft() != null) {
                travelNode = travelNode.getLeft();
            } else {
                return travelNode;
            }
        }
    }

    public BinarySearchTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinarySearchTreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {//如何遍历？
        return super.toString();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(25, 20, 36, 10, 22, 30, 40, 5, 12, 28, 38, 48, 1, 8, 15, 45, 50);
        BinarySearchTree tree = new BinarySearchTree(list);

        BinarySearchTreeNode node = tree.search(10);
        System.out.println(node);
    }
}
