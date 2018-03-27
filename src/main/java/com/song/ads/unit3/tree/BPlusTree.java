package com.song.ads.unit3.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by 001844 on 2018/3/26.
 * b+ 树
 */
public class BPlusTree {

    static final int DEGREE = 4;
    BPlusNode root;

    /**
     * 如果root为空，那么设置为root；
     * root为非空，对t的值设置为多少了？4？如果是mysql的innodb的话，可以根据索引字段的大小大概估计出t的大小。
     * 4Kb/12byte=341，341是2的多少次方？8次方，不对。
     * 我们就按照PDF中的来，叶子节点最多存4个，非叶子节点存3个。
     * 如果root非空，插入的要和root比较大小，并且判断root是否
     * <p>
     * 不对，插入第一个元素，设置为root，
     * 插入第二个元素，判断root是否为空，插入的元素和root比较大小，判断root是否是leaf。是，且比root小，放在
     * 不对，麻痹的，草，
     * <p>
     * 如果遍历的节点是leaf，先判断是否满了，如果满了，就split分成2个，然后将后面一个的第一个丢到上面设置为routers
     * 如果routers再满了，就再分。反正高度是3，一行最多是3，也就是DEGREE是4
     *
     * @param k 31,41,47,10,50,53,59,61,63
     */
    public void insert(int k) {
        if (root == null) {
            BPlusNode node = new BPlusNode();
            node.n = 1;
            node.leaf = true;
            node.values = Arrays.asList(k);
            this.root = node;
        }
        BPlusNode x = root;
        while (!x.leaf) {
            int i = 1;

        }
        int i = 1;
        //遍历最终得到叶子节点
        /**
         * 不管满不满，先将值插入到这个list中，然后sort，
         * sort完之后，如果大于等于4，分成2个list，然后将后一个list的第一个值作为router丢上去
         */
        List<Integer> values =  x.values;
        values.add(k);
        Collections.sort(values);
        int size = values.size();
        if(size>=4){//假设size是4，没问题，假设size是5
            List<Integer> frontPart = values.subList(0,size/2);
            List<Integer> lastPart = values.subList(size/2,size);
            //将lastPart的第一个元素丢到上一层，作为routers

        }


    }
    public void insert2(int k){
        if (root == null) {
            BPlusNode node = new BPlusNode();
            node.n = 1;
            node.leaf = true;
            node.values = Arrays.asList(k);
            this.root = node;
        }

    }

    public void delete(int k) {

    }

    public void search(int k) {

    }

    public BPlusNode getRoot() {
        return root;
    }

    public void setRoot(BPlusNode root) {
        this.root = root;
    }

}


