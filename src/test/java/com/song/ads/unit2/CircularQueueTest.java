package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 001844 on 2018/2/3.
 */
public class CircularQueueTest {
    @Test
    public void test(){
        CircularQueue<String> queue = new CircularQueue<>(5);
        //当queue为空的时候，先测试dequeue
        boolean exceptionThrow = false;
        try {
            String t = queue.deQueue();
        } catch (RuntimeException e) {
            exceptionThrow = true;
        }
        Assert.assertTrue(exceptionThrow);

        int size = queue.enQueue("a");
        size = queue.enQueue("b");
        size = queue.enQueue("c");
        size = queue.enQueue("d");
        size = queue.enQueue("e");

        exceptionThrow =false;
        try {
            size = queue.enQueue("f");
        } catch (RuntimeException e) {
            exceptionThrow = true;
        }
        Assert.assertTrue(exceptionThrow);
        Assert.assertTrue(size==5);
        for(int i=0;i<3;i++){
            queue.get(i).equals(queue.deQueue());
        }
        queue.enQueue("g");
        queue.enQueue("h");
        queue.enQueue("i");

        System.out.println(queue.display());
    }

}

