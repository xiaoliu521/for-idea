package org.example.alg;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xianr
 * @date 2023-10-25
 * @Description TODO
 */
public class TestQueue {
    public static void main(String[] args) throws InterruptedException {


        ConcurrentLinkedQueue<Object> objects = new ConcurrentLinkedQueue<>();
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(2);
        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);
        arrayBlockingQueue.offer(3);
        System.out.println(arrayBlockingQueue);

    }
}
