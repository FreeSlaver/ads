package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 00013708 on 2017/9/1.
 */
public class LinkedListStackTest {

    @Test
    public void test() {
        LinkedListStack<String> stack = new LinkedListStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        String top = stack.pop();
        Assert.assertTrue(top.equals("e"));

        stack.display();
        LinkedListStack<Integer> stack2 = new LinkedListStack<Integer>();

        for (int i = 0; i < 200; i++) {
            stack2.push(i);
        }
        stack2.display();
    }
}
