package com.song.ads.unit1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 00013708 on 2017/8/22.
 */
public class SingleLinkedListTest implements LinkedListTest{

    @Test
    public void addBeginTest() {
        LinkedList<String> list = new SingleLinkedList<String>();
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
        LinkedList<String> list = new SingleLinkedList<String>();
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
        LinkedList<String> list = new SingleLinkedList<String>();
        //测试空的list
        try {
            list.add("pikachu", -9);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }
        try {
            list.add("pikachu", 10);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }
        //测试空的list，在头部添加
        list.add("pikachu", 0);

        //测试在list size以内添加
        list.addEnd("apple");
        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");

        list.add("pitaya", 4);

        //测试在list的size以外添加
        try {
            list.add("pikachu", 100);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }

        list.display();
    }

    @Test
    public void removeIndexTest() {
        LinkedList<String> list = new SingleLinkedList<String>();
        list.addEnd("apple");
        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");

        try {
            list.remove(-9);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }
        try {
            list.remove(10);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }

        String rmed = list.remove(3);
        System.out.println(rmed + " be moved");
        list.display();

    }

    @Test
    public void removeObjectTest() {
        LinkedList<String> list = new SingleLinkedList<String>();
        try {
            list.remove("apple");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }


        list.addEnd("apple");
        list.addEnd("banana");
        list.addEnd("juice");
        list.addEnd("pear");
        list.addEnd("orange");
        list.addEnd("grape");


        int i = list.remove("apple");
        System.out.println(i);
        int rmIndex = list.remove("pear");
        System.out.println(rmIndex);

        int j = list.remove("grape");
        System.out.println(j);

        try {
            int x = list.remove("helloworld");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(e != null);
        }
        list.display();
    }
}
