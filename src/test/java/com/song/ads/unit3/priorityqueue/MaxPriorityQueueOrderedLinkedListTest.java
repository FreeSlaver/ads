package com.song.ads.unit3.priorityqueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/2/11.
 */
public class MaxPriorityQueueOrderedLinkedListTest {

    @Test
    public void test(){
        MaxPriorityQueueOrderedLinkedList queue = new MaxPriorityQueueOrderedLinkedList();
        queue.insert(5);
        queue.insert(2);
        queue.insert(1);
        queue.insert(10);
        queue.insert(7);
        queue.insert(4);
        queue.insert(10);

        Assert.assertTrue(queue.findMax()==10);
        Assert.assertTrue(queue.removeMax()==10);

        List<Integer> list = Arrays.asList(1,2,4,5,7,10);
        Assert.assertTrue(Arrays.toString(list.toArray()).equals(queue.toString()));
    }

}
