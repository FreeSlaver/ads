package com.song.ads.unit3.priorityqueue;


/**
 * Created by 001844 on 2018/2/11.
 * using unordered linked list
 */
public class MaxPriorityQueueUnorderedLinkedList implements PriorityQueue {

    private Node head;

    private Node tail;

    private Node max;

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Integer e) {
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
            tail = node;
            max = node;
        } else {
            tail.setNext(node);

        }

    }

    public Integer findMax() {
        if (isEmpty()) {
            return 0;
        } else {
            return max.getData();
        }
    }

    //delete Max;
    //首先找到最大的节点的前一个节点和后一个节点，然后将前一个节点setNext为后一个节点
    public Integer removeMax() {
        /*Node<T> secondMax = findSecondMax();
        max = secondMax;*/
        if (isEmpty()) {
            return null;
        }
        Node travelNode = head;
        Node maxNextNode = max.getNext();
        Node maxPreviousNode = null;
        while (true) {
            if (travelNode.getNext() == null) {//说明是tail

            }
     /*       if(travelNode.getNext()!=null&&travelNode.getData().equals(max.getData())){
                travelNode.setNext(maxNextNode);
            }*/


        }


    }
}
