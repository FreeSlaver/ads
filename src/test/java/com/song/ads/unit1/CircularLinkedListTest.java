package com.song.ads.unit1;

import org.junit.Test;

/**
 * Created by 00013708 on 2017/8/23.
 */
public class CircularLinkedListTest implements LinkedListTest {

    @Test
    public void addBeginTest() {
        LinkedList<String> list = new CircularLinkedList<String>();
        list.addBegin("apple");

        list.addBegin("banana");
        list.addBegin("juice");
        list.addBegin("pear");
        list.addBegin("orange");
        list.addBegin("grape");

        list.display();
    }

    @Test
    public void addEndTest() {
        LinkedList<String> list = new CircularLinkedList<String>();
        list.addEnd("apple");

        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");

        list.display();
    }

    @Test
    public void addTest() {
        LinkedList<String> list = new CircularLinkedList<String>();
        list.add("apple",0);

        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        //在中间添加
        list.add("git",0);

        //在末尾添加
        list.add("hub",6);

        list.display();
    }

    @Test
    public void removeIndexTest() {
        CircularLinkedList<String> list = new CircularLinkedList<String>();
        list.addEnd("apple");
        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");
        list.display();
        System.out.println("1--------------");

        String rm = list.remove(0);
        String head = list.getHead().getData();
        String tail = list.getTail().getData();
        String tailNext = list.getTail().getNext().getData();
        System.out.println("2--------------rm:"+rm+",head:"+head+",tail:"+tail+",tailNext:"+tailNext);

        rm = list.remove(4);
        head = list.getHead().getData();
        tail = list.getTail().getData();
        tailNext = list.getTail().getNext().getData();
        System.out.println("3--------------rm:"+rm+",head:"+head+",tail:"+tail+",tailNext:"+tailNext);

        rm = list.remove(2);
        head = list.getHead().getData();
        tail = list.getTail().getData();
        tailNext = list.getTail().getNext().getData();
        System.out.println("4--------------rm:"+rm+",head:"+head+",tail:"+tail+",tailNext:"+tailNext);
    }

    @Test
    public void removeObjectTest() {
        LinkedList<String> list = new CircularLinkedList<String>();
        list.addEnd("apple");

        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");

        list.display();
        System.out.println("1--------------");

        list.remove("apple");
        list.display();
        System.out.println("2--------------");

        list.remove("pear");
        list.display();
        System.out.println("3--------------");

        list.remove("grape");
        list.display();
        System.out.println("4--------------");
    }
}
