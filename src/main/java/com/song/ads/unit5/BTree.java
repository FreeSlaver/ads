package com.song.ads.unit5;

import java.util.*;

/**
 * Created by 001844 on 2018/3/29.
 */
public class BTree {

    private final int order;//order应该也是degree

    private BTreeNode root;

    public BTree(int order) {
        this.order = order;
    }

    public BTree(int order, Collection<Integer> collection) {
        this.order = order;
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("collection null");
        }
        for (Integer integer : collection) {
            insert(integer);
        }
    }

    /**
     * B+ Tree和B Tree的区别应该就是非叶子节点
     * 先得到一个节点，然后拿item和此节点上的值A不断比对，如果item比A要大，继续向右，直到遍历结束，然年取children的最后一个不断进行比，
     * 如果item比A要小，就去同index的children中找，不断比对，直到children为空或者children比较完。
     *
     * @param item
     * @return
     */
    public BTreeNode search(int item) {
        BTreeNode travelNode = root;
        while (true) {
            if (travelNode == null) {
                System.out.println("not found" + item);
                return null;
            }
            List<Integer> data = travelNode.getData();
            boolean isLeaf = travelNode.isLeaf();
            List<BTreeNode> children = travelNode.getChildren();

            if (isLeaf) {
                for (int i = 0; i < data.size(); i++) {
                    int temp = data.get(i);
                    if (item == temp) {
                        return travelNode;
                    }
                }
            } else {
                for (int i = 0; i < data.size(); i++) {
                    int temp = data.get(i);
                    if (item == temp) {
                        return travelNode;
                    } else if (item < temp) {
                        travelNode = children.get(i);//要判断travelNode是否为空
                        break;
                    }
                    if (i == data.size() - 1) {
                        travelNode = children.get(data.size() - 1);
                        break;
                    }
                }
            }
        }
    }


    public void insert(int item) {
        if (root == null) {
            root = new BTreeNode(item);
            return;
        }
//        BTreeNode travel = root;
        add(root, item);
    }

    public void delete(int item) {//删除，肯定也有合并的操作，因为添加有切割的操作
        BTreeNode node = search(item);
        node.getData().remove(item);
    }

    //刚好3个，将中间的作为Parent，
    //这个root还需要进行重定向啊
    //原来的node关系其实没有变，原来这个node怎么处理？

    /**
     * 把原Node的中间值midNum填充到parent中，原Node干掉，
     * 将原Node的parent和新生成的2个Node建立关系。
     * 如果parent是null，就根据midNum重新生成parent，且root要指向此parent
     *
     * @param node
     * @param item
     */
    private void split(BTreeNode node, int item) {
        BTreeNode parent = node.getParent();
        List<Integer> data = node.getData();
        List<Integer> dataCopy = new ArrayList<>(data);
        dataCopy.add(item);
        Collections.sort(dataCopy);

        int size = dataCopy.size();
        int midIndex = size / 2;
        int midNum = dataCopy.get(midIndex);

        List<Integer> left = dataCopy.subList(0, midIndex);
        BTreeNode leftNode = new BTreeNode(left);
        List<Integer> right = dataCopy.subList(midIndex + 1, size);
        BTreeNode rightNode = new BTreeNode(right);

        if (parent == null) {
            parent = add(parent, midNum);
            root = parent;
        }
        leftNode.setParent(parent);
        rightNode.setParent(parent);


        List<BTreeNode> children = parent.getChildren();
        if (children == null || children.isEmpty()) {
            children = new ArrayList<>();
        } else {
            children.remove(node);
            node = null;
        }
        children.add(leftNode);
        children.add(rightNode);
        parent.setChildren(children);
        parent.setLeaf(false);
    }

    private BTreeNode add(BTreeNode node, int item) {
        if (node == null) {
            node = new BTreeNode(item);
            return node;
        }
        List<Integer> data = node.getData();
        boolean isLeaf = node.isLeaf();
        List<BTreeNode> children = node.getChildren();
        boolean hasSpace = hasSpace(node);
        if (isLeaf && hasSpace) {
            data.add(item);
            Collections.sort(data);
            return node;
        } else if (isLeaf && !hasSpace) {//是叶子，但没空间
            split(node, item);
            return node;
        } else {//非叶子，不管有没空间
            /**
             * 首先将item和一个个的值进行比较，看是否小，是，在children中添加一个
             * 直接在childern中添加不就完了？关键是在那个childern中添加，而且这个chiren是否有值
             */
            if(children==null||children.isEmpty()){
                children = new ArrayList<>();
                children.add(new BTreeNode(item));
                node.setChildren(children);
                return node;
            }
            for (int i = 0; i < data.size(); i++) {
                int temp = data.get(i);
                if (item <= temp) {
                    add(children.get(i), item);
                    break;
                } else {
                    //判断是否遍历到最后了
                    if (i == data.size() - 1) {
                        add(children.get(i), item);
                        break;
                    }
                }
            }


            return node;
        }
    }

    public int getOrder() {
        return order;
    }

    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    //妈的，肯定能够改进的
    private boolean hasSpace(BTreeNode node) {
        if (node == null) {
            return false;
        }
        List<Integer> data = node.getData();
        if (data == null) {
            return false;
        } else if (data.size() == order - 1) {//满了
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(3, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(bTree);
    }
}
