package com.song.ads.unit1;

import org.junit.Test;

/**
 * Created by 00013708 on 2017/9/4.
 */
public class DoubleLinkedListTest implements LinkedListTest {
    @Test
    public void addBeginTest() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
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
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
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
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.add("apple",0);

        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        //在中间添加
        list.add("git",3);

        list.display();
        //在末尾添加
        list.add("hub",5);

        list.display();
    }

    @Test
    public void removeIndexTest() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
        list.addEnd("apple");
        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");
        list.display();
        System.out.println("1--------------");

        String rm = list.remove(0);


        rm = list.remove(2);

        rm = list.remove(3);

        list.display();
    }

    @Test
    public void removeObjectTest() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();
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
