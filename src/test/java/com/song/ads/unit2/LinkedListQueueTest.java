package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/2/3.
 */
public class LinkedListQueueTest {

    @Test
    public void test() {
        LinkedListQueue<String> queue = new LinkedListQueue();
        //当queue为空的时候，先测试dequeue
        boolean exceptionThrow = false;
        try {
            String t = queue.deQueue();
        } catch (RuntimeException e) {
            exceptionThrow = true;
        }
        Assert.assertTrue(exceptionThrow);

        int size = queue.enQueue("apple");
        Assert.assertTrue(size == 1);
        String str = queue.deQueue();
        Assert.assertTrue(str.equals("apple"));

        size = queue.enQueue("apple");
        size = queue.enQueue("orange");
        size = queue.enQueue("banana");
        size = queue.enQueue("juice");
        Assert.assertTrue(size==4);

        String[] strs = new String[]{"apple", "orange", "banana", "juice"};
        Arrays.toString(strs).equals(queue.display());

        for(int i=0;i<size;i++){
            queue.get(0).equals(queue.deQueue());
        }
    }

}
