package com.song.ads.other;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by 001844 on 2018/3/7.
 */
public class WaitNotifyQueue<T> {

    private java.util.Queue<T> queue;

    private int capcity;

    public WaitNotifyQueue(int capcity) {
        this.capcity = capcity;
        this.queue = new ArrayBlockingQueue<T>(capcity);
    }

    public synchronized void put(T e) throws InterruptedException {
        while (capcity == queue.size()) {
            wait();
        }

        queue.add(e);
        notify();
    }

    public synchronized T take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        T t = queue.poll();
        notify();
        return t;
    }
}
