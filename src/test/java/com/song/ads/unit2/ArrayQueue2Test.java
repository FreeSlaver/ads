package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/2/3.
 */

public class ArrayQueue2Test {
    @Test
    public void test(){
        ArrayQueue2<String> queue2 = new ArrayQueue2<>(64);
        int size = queue2.enQueue("apple");
        size = queue2.enQueue("orange");
        size = queue2.enQueue("banana");
        size = queue2.enQueue("juice");
        Assert.assertTrue(size==4);

        String[] strs = new String[]{"apple","orange","banana","juice"};
        Arrays.toString(strs).equals(queue2.display());

        queue2.get(0).equals(queue2.deQueue());
    }
}
