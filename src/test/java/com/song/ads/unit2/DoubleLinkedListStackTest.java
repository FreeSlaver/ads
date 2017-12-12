package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 00013708 on 2017/9/1.
 */
public class DoubleLinkedListStackTest {

    @Test
    public void test() {
        DoubleLinkedListStack<String> stack = new DoubleLinkedListStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        stack.display();

        String top = stack.pop();
        Assert.assertTrue(top.equals("e"));

        stack.display();
        DoubleLinkedListStack<Integer> stack2 = new DoubleLinkedListStack<Integer>();

        for (int i = 0; i < 200; i++) {
            stack2.push(i);
        }
        stack2.display();
    }
}
