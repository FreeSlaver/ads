package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 00013708 on 2017/9/1.
 */
public class ArrayStackTest {

    @Test
    public void test() {
        ArrayStack<String> stack = new ArrayStack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        String top = stack.pop();
        Assert.assertTrue(top.equals("e"));

        stack.display();
        ArrayStack<Integer> stack2 = new ArrayStack<Integer>();;
        for (int i = 0; i < 200; i++) {
            stack2.push(i);
        }
        stack2.display();
    }
}
