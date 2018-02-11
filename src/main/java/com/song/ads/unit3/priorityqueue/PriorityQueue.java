package com.song.ads.unit3.priorityqueue;

/**
 * Created by 001844 on 2018/2/11.
 */
public interface PriorityQueue {
    boolean isEmpty();

    void insert(Integer t);

    Integer findMax();

    Integer removeMax();

}
