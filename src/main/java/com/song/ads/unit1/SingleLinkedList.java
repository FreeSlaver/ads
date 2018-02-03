package com.song.ads.unit1;

/**
 * Created by 00013708 on 2017/8/22.
 */
public class SingleLinkedList<T> implements LinkedList<T> {

    private Node<T> head;

    public void addBegin(T t) {
        Node<T> node = new Node<T>(t);
        node.setNext(head);
        head = node;
    }

    public void addEnd(T t) {
        Node<T> node = new Node<T>(t);
        node.setNext(null);
        if (head == null) {
            head = node;
        } else {
            Node<T> travelNode = head;
            //一直遍历，直到travelNode是tail
            //tail有什么特性了？就是它的next是null
            while (travelNode.getNext() != null) {
                travelNode = travelNode.getNext();
            }
            //得到tail，tail的next设置为node
            //但是这里有个引用的问题啊。应该没问题
            travelNode.setNext(node);
        }
    }

    /**
     * 首先有index，那么肯定有一个i，用来和index比较
     * 需要考虑的场景是：
     * 1.head==null
     * 2.index小于0或者index超出了size
     * 得到目的travelNode
     * 妈的，想了老子这么久才搞出来
     *
     * @param t
     * @param index
     */

    public void add(T t, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addBegin(t);
            return;
        }
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node<T> prevNode = null;
        Node<T> travelNode = head;

        while (travelNode != null) {
            if (i == index) {
                break;
            } else {
                i++;
                prevNode = travelNode;
                travelNode = travelNode.getNext();
            }
        }
        if (i != index) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> node = new Node<T>(t);
            node.setNext(travelNode);
            prevNode.setNext(node);
        }
    }


    /**
     * 删除指定位置的元素
     * 添加和删除其实是一样的
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
        }
        Node<T> prevNode = null;
        Node<T> travelNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = travelNode;
            travelNode = travelNode.getNext();
        }
        T data = travelNode.getData();
        prevNode.setNext(travelNode.getNext());
        travelNode = null;
        return data;
    }

    /**
     * 从头开始遍历，删除指定的数据的Node，返回Node所在的下标
     *
     * @param t
     * @return
     */
    public int remove(T t) {
        if (head == null) {
            throw new IllegalArgumentException("empty list");
        }
        T headData = head.getData();
        if (headData.equals(t)) {
            head = head.getNext();
            return 0;
        }

        Node<T> prevNode = head;
        Node<T> travelNode = head.getNext();
        int i = 1;
        while(travelNode!=null){
            T data = travelNode.getData();
            if(t.equals(data)){
                break;
            }else{
                i++;
                prevNode = travelNode;
                travelNode = travelNode.getNext();
            }
        }
        if(travelNode==null){//说明遍历到最后了,也没找到
            throw new IllegalArgumentException("not found");
        }
        prevNode.setNext(travelNode.getNext());
        travelNode = null;

        return i;
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node<T> travelNode = head;
        while (travelNode != null && travelNode.getData() != null) {
            T data = travelNode.getData();
            System.out.println(data.toString());
            travelNode = travelNode.getNext();
        }
    }


    /**
     * 妈的，一个链表都不会写。
     * 怎么删除一个元素？最简单的，一个个遍历，然后equals，
     * 相等后，删除。
     * 将前面一个node的next换成下下个
     * 将后面一个node的？不用换.
     * 那个ArrayList是用数组存储的，LinkedList是随机，内存有空间就行
     *
     * @param t
     */
    /*public void remove(T t) {
        //用来遍历的
       *//* Node<T> travelNode = head;
        while (travelNode.hasNext()){
            T data = travelNode.getData();
            Node nextNode = travelNode.getNext();
            Node nextNextNode = nextNode.getNext();
            if(data.equals(t)){
                //将前面一个Node的next指向下一个。
                travelNode.setNext(nextNextNode);
            }
            travelNode = travelNode.getNext();
        }*//*
        //傻逼式写法
        T headData = head.getData();
        Node<T> nextNode = head.getNext();
        if (headData.equals(t)) {
            head = nextNode;
            return;
        }

        T nextData = nextNode.getData();
        if (nextData.equals(t)) {//把nextData移除掉
            head.setNext(nextNode.getNext());//把head的下一个元素这种为nextData的下一个元素
//            nextNode.setData(null);
//            nextNode.setNext(null);//?这一步需要吗？
            nextNode = null;//将nextNode置为null，就是移除
        }

        T tailData = tail.getData();
        if (tailData.equals(t)) {

        }
    }*/

    @Override
    public T get(int index) {
        return null;
    }
}
