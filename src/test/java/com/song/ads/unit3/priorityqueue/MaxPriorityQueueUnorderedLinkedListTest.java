package com.song.ads.unit3.priorityqueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 001844 on 2018/2/11.
 */
public class MaxPriorityQueueUnorderedLinkedListTest {

    @Test
    public void test() {
        MaxPriorityQueueUnorderedLinkedList queue = new MaxPriorityQueueUnorderedLinkedList();
        queue.insert(3);
        queue.insert(2);
        queue.insert(10);
        queue.insert(5);
        queue.insert(9);
        queue.insert(8);
        queue.insert(10);

        Assert.assertTrue(queue.findMax() == 10);
        Assert.assertTrue(queue.removeMax() == 10);

        List<Integer> list = Arrays.asList(3, 2,  5, 9, 8,10);
        Assert.assertTrue(Arrays.toString(list.toArray()).equals(queue.toString()));
    }
}
