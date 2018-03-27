package com.song.ads.unit3.tree;

import com.song.ads.unit3.Node;


/**
 * Created by 001844 on 2018/2/7.
 */
public class BinaryTreeLinkedListRepresentation {
    private Node<String> root;

    public BinaryTreeLinkedListRepresentation() {
    }


    public void add(String t) {
        if (t == null || t.length() == 0) {
            return;
        }
        root = addRecursive(t, root);
    }

    private Node<String> addRecursive(String t, Node<String> current) {
        Node<String> node = new Node<String>(t);
        if (current == null) {
            return node;
        }
        String leftData = current.getLeftChild().getData();
        if (t.compareTo(leftData) <= 0) {
            return addRecursive(t, current.getLeftChild());
        } else {
            return addRecursive(t, current.getRightChild());
        }
    }

    /**
     * 删除如何操作了?
     * 1.被删除的节点是Leaf，直接置为null
     * 2.被删除的节点只有一个child，将此原节点的引用指向此child
     * 3.被删除的节点有2个child，但sibling为空，将此节点的父节点的左右child指向此节点的2个child；
     * 此节点有2个child，而且sibling不为空，那么就要将右child和sibling进行比较大小，小的话置为sibling的left child，大置为right child。
     *
     * @param t
     */
    public void delete(String t) {
        Node<String> node = find(t);
        Node<String> leftChild = node.getLeftChild();
        Node<String> rightChild = node.getRightChild();
        if (leftChild == null && rightChild == null) {
            node = null;
        } else if (leftChild != null && rightChild != null) {
            deleteHasTwoChild(t);
        } else if (leftChild != null) {
            node = leftChild;
        } else if (rightChild != null) {
            node = rightChild;
        }
    }

    private void deleteHasTwoChild(String t) {
        Node<String> node = find(t);
        Node<String> leftChild = node.getLeftChild();
        Node<String> rightChild = node.getRightChild();
        //这里要是知道parent就好很多了，所以可以在Node中再添加一个private Node parent;
        //这里要重新遍历得到parent
        Node<String> parent = findParent(t);
        Node<String> left = parent.getLeftChild();
        Node<String> right = parent.getRightChild();
        Node<String> sibling = null;
        if (t.equals(left.getData())) {
            sibling = right;
        } else {
            sibling = left;
        }
        if (sibling == null) {
            parent.setLeftChild(leftChild);
            parent.setRightChild(rightChild);
        } else {
            if (rightChild.getData().compareTo(sibling.getData()) < 0) {
                parent.setLeftChild(leftChild);

            }
        }
    }




    /**
     * 首先找到origin这个node，然后替换掉关系
     * origin 原来的值
     * str 更新后的值
     */
    public boolean update(String origin, String str) {
        Node<String> node = find(origin);
        if (node == null) {
            return false;
        } else {
            /*Node<String> newNode = new Node<String>(str);
            newNode.setLeftChild(node.getLeftChild());
            newNode.setRightChi ld(node.getRightChild());*/
            node.setData(str);
            return true;
        }
    }


    public Node<String> find(String t) {
        return find(t, root);
    }

    private Node<String> find(String t, Node<String> travelNode) {
        while (true) {
            if (travelNode == null) {
                return null;
            }
            String data = travelNode.getData();
            Node<String> leftChild = travelNode.getLeftChild();
            Node<String> rightChild = travelNode.getRightChild();

            if (data.equals(t)) {
                return travelNode;
            } else if (t.compareTo(data) < 0) {
                return find(t, leftChild);
            } else {
                return find(t, rightChild);
            }
        }
    }

    private Node<String> findParent(String t) {
        return findParent(t, root);
    }

    private Node<String> findParent(String t, Node<String> parentNode) {
        while (true) {
            if (parentNode == null) {
                return null;
            }
//            String data = parentNode.getData();
            Node<String> leftChild = parentNode.getLeftChild();
            Node<String> rightChild = parentNode.getRightChild();
            if (leftChild == null && rightChild == null) {
                return null;
            }
            if (leftChild != null) {
                if (t.compareTo(leftChild.getData()) < 0) {
                    return findParent(t, parentNode.getLeftChild());
                } else if (t.equals(leftChild.getData())) {
                    return parentNode;
                }
            } else if (rightChild != null) {
                if (t.compareTo(rightChild.getData()) > 0) {
                    return findParent(t, parentNode.getRightChild());
                } else if (t.equals(rightChild.getData())) {
                    return parentNode;
                }
            } else if (t.equals(leftChild.getData()) || t.equals(rightChild.getData())) {
                return parentNode;
            } else {
                return null;
            }
        }
    }


    public String inOrderTraversal() {

        return null;
    }


    public String preOrderTraversal() {


        return null;
    }


    public String postOrderTraversal() {

        return null;
    }

    public Node<String> getRoot() {
        return root;
    }

    public void setRoot(Node<String> root) {
        this.root = root;
    }
}