package com.song.ads.unit3.priorityqueue;


import com.song.ads.unit1.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/2/11.
 * using unordered linked list
 */
public class MaxPriorityQueueUnorderedLinkedList implements PriorityQueue {

    private Node<Integer> head;

    private Node<Integer> tail;

    private Node<Integer> maxNode;

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Integer e) {
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
            tail = node;
            maxNode = node;
        } else {
            tail.setNext(node);
            tail = node;
            if (e > maxNode.getData()) {
                maxNode = node;
            }
        }
    }

    public Integer findMax() {
        if (isEmpty()) {
            return null;
        } else {
            return maxNode.getData();
        }
    }

    //delete Max;
    //首先找到最大的节点的前一个节点和后一个节点，然后将前一个节点setNext为后一个节点
    public Integer removeMax() {
        if (isEmpty()) {
            return null;
        }
        Integer result = maxNode.getData();
        //1.找到maxNode前面的元素
        Node<Integer> travel = head;
        while (true) {
            if (travel == null) {
                break;
            }
            if (travel.getNext().equals(maxNode)) {
                travel.setNext(maxNode.getNext());
                break;
            } else {
                travel = travel.getNext();
            }
        }
        //2.遍历得到最大的Node，将maxNode指向它
        Node<Integer> travel2 = head;
        maxNode = head;
        while (true) {
            if (travel2 == null) {
                break;
            }
            if (maxNode.getData() < travel2.getData()) {
                maxNode = travel2;
            } else {
                travel2 = travel2.getNext();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        Node<Integer> travel = head;
        while (true) {
            if (travel == null) {
                break;
            }
            list.add(travel.getData());
            travel = travel.getNext();
        }
        return Arrays.toString(list.toArray());
    }
}
