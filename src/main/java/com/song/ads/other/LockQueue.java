package com.song.ads.other;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 001844 on 2018/3/7.
 */
public class LockQueue<T> {
    private java.util.Queue<T> queue;

    private int capacity;

    private Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public LockQueue(int capacity) {
        this.capacity = capacity;
        queue = new ArrayBlockingQueue<T>(capacity);
    }

    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            while (capacity == queue.size()) {
                notFull.await();//等待notFull这个条件满足
            }
            queue.add(t);
            notEmpty.signal();//通知notEmpty这个条件
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            T t = queue.poll();
            return t;
        } finally {
            lock.unlock();
        }
    }
}
