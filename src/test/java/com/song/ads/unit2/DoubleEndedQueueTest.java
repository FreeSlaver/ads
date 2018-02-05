package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/2/5.
 */
public class DoubleEndedQueueTest {

    @Test
    public void test(){
        DoubleEndedQueue<String> queue = new DoubleEndedQueue();
        queue.enQueueFront("a");
        queue.enQueueFront("b");
        queue.enQueueFront("c");
        queue.enQueueFront("d");
        queue.enQueueFront("e");

        queue.enQueueRear("f");
        String[] strs = new String[]{"e","d","c","b","a","f"};
        Assert.assertTrue(Arrays.toString(strs).equals(queue.display()));

        String str = queue.deQueueFront();
        Assert.assertTrue(str.equals("e"));
        str = queue.deQueueRear();
        Assert.assertTrue(str.equals("f"));
    }

}
