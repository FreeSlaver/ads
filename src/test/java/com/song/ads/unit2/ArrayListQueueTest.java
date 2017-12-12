package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 00013708 on 2017/9/12.
 */
public class ArrayListQueueTest {

    @Test
    public void test(){
        ArrayListQueue<String> queue = new ArrayListQueue<String>();
        queue.enQueue("a");
        queue.enQueue("b");
        queue.enQueue("c");
        queue.enQueue("d");
        queue.enQueue("e");
        queue.display();

        String str = queue.deQueue();
        Assert.assertTrue(str.equalsIgnoreCase("a"));

        String str2 = queue.deQueue();
        Assert.assertTrue(str2.equalsIgnoreCase("b"));
    }
}
