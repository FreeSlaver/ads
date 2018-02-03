package com.song.ads.unit2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 001844 on 2018/1/25.
 * 以后要先写测试用例啊，我擦，发现开源软件对这个要求很高啊
 * 怎么测？
 * 测试添加，添加之后，尾部的最后一个元素就是刚添加的元素
 * 测试删除，删除之后，得到的元素是刚刚数组中第一个元素
 * 测试display，得到的应该是[1,4,5]这种，所以不应该一行行的答应出来
 * 或者直接测试得到的结果集？错，应该是对接口测试，对服务，方法测试
 */
public class ArrayQueueTest {

    @Test
    public void test(){
        ArrayQueue<String> queue = new ArrayQueue<String>();
        int size = queue.enQueue("hello");
        Assert.assertTrue(size==1);
        size = queue.enQueue("world");
        Assert.assertTrue(size==2);

        String[] strs = new String[]{"hello","world"};
        Assert.assertTrue(Arrays.toString(strs).equals(queue.display()));

        String str = queue.deQueue();
        Assert.assertTrue(str.equals("hello"));
        str = queue.deQueue();
        Assert.assertTrue(str.equals("world"));

    }

}
