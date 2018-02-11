package com.song.ads.unit3.priorityqueue;

import com.song.ads.unit1.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/2/11.
 */
public class MaxPriorityQueueOrderedLinkedList implements PriorityQueue {

    private Node<Integer> head;

    private Node<Integer> tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(Integer t) {
        Node<Integer> node = new Node(t);
        if (isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        if (t <= head.getData()) {
            node.setNext(head);
            head = node;
        } else if (t >= tail.getData()) {
            tail.setNext(node);
            tail = node;
        } else {
            Node<Integer> travel = head;
            while (true) {
                int tData = travel.getData();
                int tNextData = travel.getNext().getData();
                if (t >= tData && t <= tNextData) {
                    node.setNext(travel.getNext());
                    travel.setNext(node);
                    break;
                } else if (t > tNextData) {
                    travel = travel.getNext();
                }
            }
        }
    }

    @Override
    public Integer findMax() {
        return isEmpty() ? null : tail.getData();
    }

    @Override
    public Integer removeMax() {
        if (isEmpty()) {
            return null;
        }
        Integer result = tail.getData();
        if (tail.equals(head)) {
            tail = null;
            head = null;
        }
        //找到tail的前一个元素，
        Node<Integer> travel = head;
        while (true) {
            if (travel.getNext().equals(tail)) {
                travel.setNext(null);
                tail = travel;
                break;
            }else{
                travel = travel.getNext();
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
